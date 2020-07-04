/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import ListasAux.ListaEnlazada;
import capaDatos.listaMatricula;
import java.util.Calendar;
import java.util.Date;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Leobar37
 */
public class ReportesMatricula {

    public static int AlumnosMatriculados = 1;
    public static int AlumnosNoMatriculados = 2;
    public static int ReGrupo = 3;

    //un alumno no puede tener so matriculas en ejecucion
    //falso= tiene una matricula activada
    //true = se puede matricular
    public static boolean verificarMatricula(String codAlumno) {
        // System.out.println("parametro" + codAlumno);
        ListaEnlazada lista = ReportesMatricula.RetornarMatriculas(codAlumno);
        for (int i = 0; i < lista.tamaño(); i++) {
            Matricula objMatricula = (Matricula) lista.Buscar(i);
            if (objMatricula.getMatriculaEstado() == Matricula.activo) {
                return false;
            }
        }
        return true;

    }

    public static ListasAux.ListaEnlazada mostrarAlumnosPorGrupo(int codGrupo) {
        ListasAux.ListaEnlazada listaMatrcula = Matricula.consultar();
        ListasAux.ListaEnlazada listaFiltrada = new ListasAux.ListaEnlazada();
        Matricula matri;
        for (int i = 0; i < listaMatrcula.tamaño(); i++) {
            matri = (Matricula) listaMatrcula.Buscar(i);
            if (matri.getCodGrupo() == codGrupo && matri.getMatriculaEstado() == Matricula.activo) {
                Alumno objAlumno = Alumno.ObtnerAlumno(matri.getDniAlumno());
                listaFiltrada.agregar(objAlumno);
            }
        }
        return listaFiltrada;
    }
    //mostrar alumnos matriculados

    //muestra alumnos no matriculados
    public static ListasAux.ListaEnlazada mostrarAlumnosNoMatriculados() {
        ListasAux.ListaEnlazada listaAlumno = Alumno.consultar();
        ListasAux.ListaEnlazada listaFilAlumno = new ListasAux.ListaEnlazada();
        Alumno objAlumno;
        for (int i = 0; i < listaAlumno.tamaño(); i++) {
            objAlumno = (Alumno) listaAlumno.Buscar(i);
            Alumno auxAlumno = Matricula.obtenerAlumnoMatriculado(objAlumno.getDni());
            //Alumno objAlumno = Alumno.ObtnerAlumno(matri.getDniAlumno());
            if (auxAlumno == null) {
                listaFilAlumno.agregar(objAlumno);
                //System.out.println("econtro alumnos");
            }
        }
        return listaFilAlumno;
    }
    //alumnos no matriculados por fecha

    /*   
  reporte de intervalo de fechas  
     */
    //intervalo de fechas 
    //la variable a define el avance del intervalo de fechas
    public static java.util.List<Date> getIntervaloFechas(java.util.Date fecha_inicio, java.util.Date fecha_fin, int a) {
        Calendar fechaInicio = Calendar.getInstance();//convertir la fechas a calendar por que es mas comodo manejar fechas
        fechaInicio.setTime(fecha_inicio);
        Calendar fechaFin = Calendar.getInstance();
        fechaFin.setTime(fecha_fin);
        java.util.List<Date> listaFechas = new java.util.ArrayList<Date>();
        while (!fechaInicio.after(fechaFin)) {
            listaFechas.add(fechaInicio.getTime());
            fechaInicio.add(a, 1);
        }

        return listaFechas;
    }

//retorna una lista de alumnos de acuerdo al rango de fecha y de acuerdo al tipo de consulta (Matriculados y no Matriculados)      
    public static ListaEnlazada MatriculasEnIntervaloTiempo(Date fecha_inicio, Date fecha_fin, int a, int tipoConsulta) {

        ListaEnlazada listaResult = new ListaEnlazada();
        ListaEnlazada lista = new ListaEnlazada();
        lista = Matricula.consultar();
        java.util.List<Date> listFechas = new java.util.ArrayList<Date>();
        //randgo de fechas
        listFechas = getIntervaloFechas(fecha_inicio, fecha_fin, a);
        if (tipoConsulta == 1) {
            for (int i = 0; i < listFechas.size(); i++) {
                Date tiempo = listFechas.get(i);
                String fechaActual = Alternos.Alternos.convertirFecha(tiempo);
                for (int j = 0; j < lista.tamaño(); j++) {
                    Matricula objMatricula = (Matricula) lista.Buscar(j);
                    if (objMatricula.getFechaMatricula() != null) {
                        Date fechaCom = objMatricula.getFechaMatricula();
                        String fec = Alternos.Alternos.convertirFecha(fechaCom);
                        if (fechaActual.equalsIgnoreCase(fec)) {
                            listaResult.agregar(objMatricula);
                        }
                    }
                }
            }
        } else {
            //lista = 
            for (int i = 0; i < listFechas.size(); i++) {
                Date tiempo = listFechas.get(i);

                String fechaActual = Alternos.Alternos.convertirFecha(tiempo);

                for (int j = 0; j < lista.tamaño(); j++) {
                    Alumno objAlumno = (Alumno) lista.Buscar(j);
                    if (objAlumno.getFechaRegistro() != null) {
                        Date fechaCom = objAlumno.getFechaRegistro();
                        String fec = Alternos.Alternos.convertirFecha(fechaCom);
                        if (fechaActual.equalsIgnoreCase(fec)) {
                            listaResult.agregar(objAlumno);
                        }
                    }
                }
            }
        }

        return listaResult;
    }
    //----------------Resultado grafico de alumnos matriculados y no matriculado-------------------------------------

    public static DefaultCategoryDataset reporteMatriculas(int tipoLista, Date fechainicio, Date fechaFin, int a) {
        //lista de fechas en el eje x
        /*sacar los alumnos matriculadors mes por mes 
          dado un rango de fecha     
         */
        java.util.List<Date> listaFechas = getIntervaloFechas(fechainicio, fechaFin, a);
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        if (a == Calendar.MONTH) {
            //recorrer el rango de fechas
            for (int i = 0; i < listaFechas.size(); i++) {
                //primera fecha 
                double barra = 0;
                /*Proposito: recorrer todos los dias de ese mes*/
                Date objDate1 = listaFechas.get(i);
                Calendar objCalendar = Calendar.getInstance();
                objCalendar.setTime(objDate1);
                objCalendar.add(Calendar.MONTH, 1);
                java.util.List<Date> listaFechasDias = getIntervaloFechas(objDate1, objCalendar.getTime(), Calendar.DAY_OF_MONTH);
                for (int j = 0; j < listaFechasDias.size(); j++) {
                    Date objDate = listaFechasDias.get(j);
                    Date fechaStandar = Alternos.Alternos.formatoFecha(objDate);
                    int cantidad = MatriculasxFechaYboMatriculados(fechaStandar, tipoLista).tamaño();
                    if (cantidad > 0) {
                        barra = barra + cantidad;
                    }
                }

                objDataset.addValue(barra, "Matriculados", Alternos.Alternos.RetornarMes(objDate1));

            }
        } else {
            if (a == Calendar.DAY_OF_MONTH) {
                for (int i = 0; i < listaFechas.size(); i++) {
                    Date objDate = listaFechas.get(i);
                    // String fecha = Alternos.Alternos.convertirFecha(objDate);             
                    Date fechaStandar = Alternos.Alternos.formatoFecha(objDate);
                    int cantidad = MatriculasxFechaYboMatriculados(fechaStandar, tipoLista).tamaño();
                    if (cantidad > 0) {
                        objDataset.addValue(cantidad, "Matriculados", Alternos.Alternos.convertirFecha(fechaStandar));
                    }
                }
            } else {
                if (a == Calendar.WEEK_OF_MONTH) {
                    //recorrer el rango de fechas
                    for (int i = 0; i < listaFechas.size(); i++) {
                        //primera fecha 
                        double barra = 0;
                        /*Proposito: recorrer todos los dias de ese mes*/
                        Date objDate1 = listaFechas.get(i);
                        Calendar objCalendar = Calendar.getInstance();
                        objCalendar.setTime(objDate1);
                        objCalendar.add(Calendar.WEEK_OF_MONTH, 1);
                        java.util.List<Date> listaFechasDias = getIntervaloFechas(objDate1, objCalendar.getTime(), Calendar.DAY_OF_MONTH);
                        for (int j = 0; j < listaFechasDias.size(); j++) {
                            Date objDate = listaFechasDias.get(j);
                            Date fechaStandar = Alternos.Alternos.formatoFecha(objDate);
                            int cantidad = MatriculasxFechaYboMatriculados(fechaStandar, tipoLista).tamaño();
                            if (cantidad > 0) {
                                barra = barra + cantidad;
                            }
                        }
                        //

                        if (barra > 0) {
                            objDataset.addValue(barra, "Matriculados", "Semana: " + (i + 1));
                        }

                    }

                } else {
                    if (a == ReGrupo) {
                        /*
                        
                        1.extraer fechas
                        2.extraer grupos 
                        3.extraes Matriculas
                        4.recorrer fechas
                        5.  
                         */
                        listaFechas = getIntervaloFechas(fechainicio, fechaFin, Calendar.DAY_OF_MONTH);
                        System.out.println("tamaño:      " + listaFechas.size());
                        ListaEnlazada listaGrupos = Grupo.consultarTodo();
                        System.out.println("Grupos leidos");
                        for (int i = 0; i < listaGrupos.tamaño(); i++) {
                            //1.

                            Grupo objGrupo = (Grupo) listaGrupos.Buscar(i);
                            //2.iteracion I
                            int tamLista = 0;
                            for (int j = 0; j < listaFechas.size(); j++) {
                                //iteracion J

                                Date objDate1 = listaFechas.get(j);
                                Date fechaStandar = Alternos.Alternos.formatoFecha(objDate1);
                                tamLista = tamLista + AlumnosMatxGrupoFecha(fechaStandar, objGrupo.getIdGrupo()).tamaño();
                                //System.out.println(""+tamLista);

                            }

                            if (tamLista > 0) {
                                objDataset.addValue(tamLista, "Grupos", "Grupo Nro: " + objGrupo.getIdGrupo());
                            }

                        }

                    }
                }
            }
        }

        return objDataset;
    }

    //dado un grupo  y la fecha retornar Matriculas 
    public static ListaEnlazada AlumnosMatxGrupoFecha(Date objDate, int grupo) {

        ListaEnlazada matriculados = Matricula.consultar();

        ListaEnlazada listaFil = new ListaEnlazada();
        for (int i = 0; i < matriculados.tamaño(); i++) {
            Matricula objMatricula = (Matricula) matriculados.Buscar(i);

            if (objMatricula.getCodGrupo() == grupo) {

                if (objMatricula.getFechaMatricula().compareTo(objDate) == 0) {

                    listaFil.agregar(objMatricula);
                }

            }
        }
        return listaFil;
    }
    //retorna un cuantos matriculados y no matriculados de acuerdo a un rango de fecha

    public static int[] retornaMatyNoMatxRango(Date inicio, Date fin) {
        java.util.List<Date> listaFechas = getIntervaloFechas(inicio, fin, Calendar.DAY_OF_MONTH);
        int matriculados = 0;
        int noMatriculado = 0;
        //int mujeres = 
        for (int i = 0; i < listaFechas.size(); i++) {
            Date objDate = listaFechas.get(i);
            Date fechaStandar = Alternos.Alternos.formatoFecha(objDate);
            ListaEnlazada m = MatriculasxFechaYboMatriculados(fechaStandar, ReportesMatricula.AlumnosMatriculados);
            ListaEnlazada n = MatriculasxFechaYboMatriculados(fechaStandar, ReportesMatricula.AlumnosNoMatriculados);
            //int matriarr[] =ReporteAlumno.retornoXGenero(m);
            //int noMatriarr[] =ReporteAlumno.retornoXGenero(n);
             matriculados = matriculados+m.tamaño();
             noMatriculado =noMatriculado +n.tamaño();
                     
          
        }
        int arr[] = {matriculados, noMatriculado};
        return arr;
    }

    //reporte grafico de alumnos matriculados y no matriculados
    public static ListaEnlazada MatriculasxFechaYboMatriculados(Date fecha, int tipo) {
        ListaEnlazada lista = null;
        ListaEnlazada listaFil = new ListaEnlazada();
        if (tipo == 1) {
            lista = listaMatricula.consultar();
             //lista = ReportesMatricula.mostrarAlumnosMatriculados();
            for (int i = 0; i < lista.tamaño(); i++) {
                Matricula objMatricula = (Matricula) lista.Buscar(i);
                if (objMatricula.getFechaMatricula().compareTo(fecha) == 0){
                    
                    Alumno objAlumno=   Matricula.obtenerAlumnoMatriculado(objMatricula.getIdMatricula());
                  
                    listaFil.agregar(objAlumno);                   
                }
            }
        } else {
            if (tipo == 2) {
                lista = ReportesMatricula.mostrarAlumnosNoMatriculados();
                System.out.println("");
                for (int i = 0; i < lista.tamaño(); i++) {
                    Alumno objAlumno = (Alumno) lista.Buscar(i);
                    //    System.out.println("fecha de registro" + objAlumno.getFechaRegistro());
                    if (objAlumno.getFechaRegistro() == null) {
                     
                
                    } else {
                        if (objAlumno.getFechaRegistro().compareTo(fecha) == 0) {
                            // System.out.println("verdadero");
                                          listaFil.agregar(objAlumno);
                        }
                    }

                }
            }
        }
        return listaFil;
    }

    public static ListaEnlazada mostrarAlumnosMatriculados() {
        ListaEnlazada listaMatrcula = Matricula.consultar();
        ListaEnlazada listaFiltrada = new ListasAux.ListaEnlazada();
        Matricula matri;
        for (int i = 0; i < listaMatrcula.tamaño(); i++) {
            matri = (Matricula) listaMatrcula.Buscar(i);
            Alumno objAlumno = Alumno.ObtnerAlumno(matri.getDniAlumno());
            listaFiltrada.agregar(objAlumno);

        }
        return listaFiltrada;
    }

    //metodos para el reporte de matriculas 1 y 2
    public static ListaEnlazada RetornarMatriculas(String dniAlumno) {
        ListaEnlazada lista = Matricula.consultar();
        ListaEnlazada listaFil = new ListaEnlazada();
        for (int i = 0; i < lista.tamaño(); i++) {

            Matricula objMatricula = (Matricula) lista.Buscar(i);
            if (objMatricula.getDniAlumno().equals(dniAlumno)) {

                listaFil.agregar(objMatricula);
            }
        }
        return listaFil;
    }
    //dar de baja Matricula == 2

    public static boolean CambiarEstadoMatricula(String CodMatricula, int m) {
        int pos = listaMatricula.buscarPosicion(CodMatricula);
        if (pos == -1) {
            return false;
        } else {
            Matricula objMatricula = (Matricula) listaMatricula.consultar().Buscar(pos);

            objMatricula.setMatriculaEstado(m);
            listaMatricula.consultar().Modificar(objMatricula, pos);
            return true;

        }
    }
    
       /*
    1.verifica que tenga una matricula en ejecucion
    2. si la encuentra saca dni alumno y busca alumno por dni (Clase alumno)
    */ 
  public static Alumno ObtenerAlumnoActivo(String dniAlumno){
      ListaEnlazada listaMatriculas = Matricula.consultar();
      for (int i = 0; i < listaMatriculas.tamaño(); i++) {
          Matricula objMatricula = (Matricula) listaMatriculas.Buscar(i);
          if(objMatricula.getDniAlumno().equalsIgnoreCase(dniAlumno) &&objMatricula.getMatriculaEstado() == Matricula.activo){
              Alumno objAlumno = Alumno.ObtnerAlumno(objMatricula.getDniAlumno());
              return  objAlumno;
              
          }
          
      }
      return null;
  }
      
  public static Matricula ObtenerMatriculaActivo(String dniAlumno){
      ListaEnlazada listaMatriculas = Matricula.consultar();
      for (int i = 0; i < listaMatriculas.tamaño(); i++) {
          Matricula objMatricula = (Matricula) listaMatriculas.Buscar(i);
          if(objMatricula.getDniAlumno().equalsIgnoreCase(dniAlumno) &&objMatricula.getMatriculaEstado() == Matricula.activo){
            
              return  objMatricula;
              
          }
          
      }
      return null;
  }
 

}

/*
    public static DefaultCategoryDataset reporteNoMatriculas(Date fechainicio, Date fechaFin, int a) {
        //lista de fechas en el eje x
        java.util.List<Date> listaFechas = getIntervaloFechas(fechainicio, fechaFin, a);
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();

        for (int i = 0; i < listaFechas.size(); i++) {
            Date objDate = listaFechas.get(i);
            Date fechaStandar = Alternos.Alternos.formatoFecha(objDate);
            int cantidad = MatriculasxFecha(fechaStandar).tamaño();
            if (cantidad > 0) {
                objDataset.addValue(cantidad, "Matriculados", Alternos.Alternos.convertirFecha(fechaStandar));
            }
        }

        return objDataset;
    }
 */
