/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import ListasAux.ListaEnlazada;
import ListasAux.ListaOrdenana;
import capaDatos.listaMatricula;
import capaNegocio.comparaciones.CmpApellidos;
import capaNegocio.comparaciones.CmpFechaRegistro;
import capaNegocio.comparaciones.EvaluarEdad;
import capaNegocio.comparaciones.cmpCadenas;
import capaNegocio.comparaciones.cmpFecha;
import java.util.Calendar;
import java.util.Date;
import org.jfree.data.category.DefaultCategoryDataset;

public class ReporteAlumno {

    public static java.util.List<Date> getIntervaloFechasComunes() {
        java.util.List<Date> listaFechas = new java.util.ArrayList<Date>();
        ListaEnlazada lista = Alumno.consultar();
        //  ListaEnlazada aux = new ListaEnlazada();
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            Date datPer = objAlumno.getFechaNacimiento();
            if (listaFechas.size() == 0) {
                listaFechas.add(datPer);
            } else {
                boolean verificacion = true;
                for (int j = 0; j < listaFechas.size(); j++) {
                    Date fechaaux = listaFechas.get(j);
                    if (fechaaux.compareTo(datPer) == 0) {
                        verificacion = false;
                    }
                }
                if (verificacion) {
                    listaFechas.add(datPer);
                }
            }
        }
        return listaFechas;
    }

    public static ListaEnlazada AlumnoxFecha(Date fecha) {
        ListaEnlazada lista = Alumno.consultar();
        ListaEnlazada listaFil = new ListaEnlazada();
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            if (objAlumno.getFechaNacimiento().compareTo(fecha) == 0) {
                listaFil.agregar(objAlumno);
            }
        }
        return listaFil;
    }

    /*
   //////////////Datos para grafica de edadess////////////// 
     */
    public static DefaultCategoryDataset ReporteGraficoEdades() {
        java.util.List<Date> listaFechas = getIntervaloFechasComunes();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (int i = 0; i < listaFechas.size(); i++) {
            Date datoFecha = listaFechas.get(i);
            Date fechaStandar = Alternos.Alternos.formatoFecha(datoFecha);
            int cantidad = AlumnoxFecha(fechaStandar).tamaño();
            //System.out.println("" + cantidad);
            datos.addValue(cantidad, "obj", fechaStandar);
        }
        return datos;
    }

    /**
     * ***************************ordenar por
     * edad***********************************
     */
    public static ListaEnlazada OrdenPorEdad(ListaEnlazada lista) {

        ListaOrdenana listaOrden = new ListaOrdenana(new EvaluarEdad());
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            listaOrden.insertarOrden(objAlumno);

        }

        return listaOrden.ObtenerOrden();
    }
    //fecha de nacimiento

    public static ListaEnlazada OrdenarxFechaNacimiento(ListaEnlazada lista) {
        ListaOrdenana listaOrden = new ListaOrdenana(new cmpFecha());
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            listaOrden.insertarOrden(objAlumno);

        }

        return listaOrden.ObtenerOrden();
    }

    public static ListaEnlazada OrdenarxNombre(ListaEnlazada lista) {
        ListaOrdenana listaOrden = new ListaOrdenana(new cmpCadenas());
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            listaOrden.insertarOrden(objAlumno);

        }

        return listaOrden.ObtenerOrden();
    }

    public static ListaEnlazada OrdenarxApellido(ListaEnlazada lista) {
        ListaOrdenana listaOrden = new ListaOrdenana(new CmpApellidos());
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            listaOrden.insertarOrden(objAlumno);

        }

        return listaOrden.ObtenerOrden();
    }

    public static ListaEnlazada ordenarxFechaRegistro(ListaEnlazada lista) {
        ListaOrdenana listaOrden = new ListaOrdenana(new CmpFechaRegistro());
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            listaOrden.insertarOrden(objAlumno);

        }

        return listaOrden.ObtenerOrden();
    }

    //retorno 0 = mujeres 1=varones
    public static int[] retornoXGenero(ListaEnlazada lista) {
        int retorno[] = new int[2];
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            System.out.println(""+objAlumno.getSexo());
                if (objAlumno.getSexo().equalsIgnoreCase("masculiino")) {
                    retorno[1]++;
                } else {
                    retorno[0]++;
                }
          
        }

        return retorno;
    }

}
