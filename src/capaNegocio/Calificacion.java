/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import ListasAux.ListaEnlazada;
import capaDatos.listaCalificaciones;
import java.io.Serializable;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author gonza
 */
public class Calificacion implements Serializable{
   
    private String tipo;
    private int mes;
    private float nota;
    private String idAlumno;
    private String nivel;
   
    public String getTipo() {
        return tipo;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

  


    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
    public static ListasAux.ListaEnlazada consultarTodo (){
    return listaCalificaciones.consultar();
    }
   //eliminar grupo
    public static void eliminarCaficacion(String codigoGrupo){
        int pos = listaCalificaciones.obtenerPosicion(codigoGrupo);
        System.out.println("pocision"+pos);
        listaCalificaciones.consultar().Eliminar(pos);
        
    }
    //modificar
    public static void ModificarCalificacion(Calificacion objCalificacion, String codigoCalificacion){
              int pos = listaCalificaciones.obtenerPosicion(codigoCalificacion);  
             listaCalificaciones.consultar().Modificar(objCalificacion, pos);
    }
    
    
        
    //obtener promedios por mes, de cada grupo
    public  static  float[] promediospormes(int mes, String id){
    ListasAux.ListaEnlazada listaCalificaciones;
    listaCalificaciones= Calificacion.consultarTodo();
    Calificacion cali;
    float notas[]=new float[4];
    notas[0]=0;//middle
    notas[1]=0;//project
    notas[2]=0;//finally
    notas[3]=0;//promedio
    
    for(int i=0; i<listaCalificaciones.tamaño(); i++){
         cali=(Calificacion) listaCalificaciones.Buscar(i);
         if(cali.getMes()==mes&&cali.getIdAlumno().equalsIgnoreCase(id)&&cali.getTipo().equalsIgnoreCase("Middle exam")){
         notas[0]=cali.getNota();
         }else
             if(cali.getMes()==mes&&cali.getIdAlumno().equalsIgnoreCase(id)&&cali.getTipo().equalsIgnoreCase("project")){
         notas[1]=cali.getNota();
       }else
             if(cali.getMes()==mes&&cali.getIdAlumno().equalsIgnoreCase(id)&&cali.getTipo().equalsIgnoreCase("finally exam")){
         notas[2]=cali.getNota();
    }
}
    
    notas[3]=(notas[0]+notas[1]+notas[2])/3; 
    return notas;
    }
    
    //obtener promedios por nivel, de alumnos
    public static float promediosPornivel(String idAlumno, String nivel){
    ListasAux.ListaEnlazada listaCalificaciones;
    listaCalificaciones= Calificacion.consultarTodo();
    Calificacion cali;
      float notas=0;
      int cont=0;
      float promedio=0;
    for(int i=0; i< listaCalificaciones.tamaño(); i++){
      
    cali=(Calificacion) listaCalificaciones.Buscar(i);
    if(cali.getIdAlumno().equalsIgnoreCase(idAlumno)&& cali.getNivel().equalsIgnoreCase(nivel)){
    notas=notas+cali.getNota();
    cont++;
    }

    }
    promedio= notas/cont;
    return promedio;
    }
    
        
    //obtener promedios dado dos parametros de meses
    public static ListasAux.ListaEnlazada[] promediosEnIntervaloMeses(String idAlumno, int mesI, int mesF){
    ListasAux.ListaEnlazada listaCalificaciones;
    listaCalificaciones= Calificacion.consultarTodo();
    ListasAux.ListaEnlazada listaFiltMiddle = new ListasAux.ListaEnlazada();
    ListasAux.ListaEnlazada listaFiltProject=new ListasAux.ListaEnlazada();;
    ListasAux.ListaEnlazada listaFiltFinally=new ListasAux.ListaEnlazada();
    ListasAux.ListaEnlazada listas[]=new ListasAux.ListaEnlazada[3];
    
    
    Calificacion cali;
     for(int i=0; i<listaCalificaciones.tamaño(); i++){
         cali=(Calificacion) listaCalificaciones.Buscar(i);
         if(cali.getMes()>=mesI && cali.getMes()<=mesF&& cali.getTipo().equalsIgnoreCase("Middle exam")&&cali.getIdAlumno().equalsIgnoreCase(idAlumno)){
         listaFiltMiddle.agregar(cali);
    }else
         if(cali.getMes()>=mesI&& cali.getMes()<=mesF&& cali.getTipo().equalsIgnoreCase("Project")&&cali.getIdAlumno().equalsIgnoreCase(idAlumno)){
         listaFiltProject.agregar(cali);
     }else
         if(cali.getMes()>=mesI&& cali.getMes()<=mesF&& cali.getTipo().equalsIgnoreCase("Finally exam")&&cali.getIdAlumno().equalsIgnoreCase(idAlumno)){
         listaFiltFinally.agregar(cali);
     }
    }
     listas[0]= listaFiltMiddle;
     listas[1]= listaFiltProject;
     listas[2]= listaFiltFinally;
    return listas;
    }
     
     public static int validaciondecalifcacion(String nivel, String tipo, int mes, String idAlumno){
      ListasAux.ListaEnlazada listaCalificaciones;
      listaCalificaciones= Calificacion.consultarTodo();
      int rpta=0;
      
      Calificacion cali;
     for(int i=0; i<listaCalificaciones.tamaño(); i++){
         cali=(Calificacion) listaCalificaciones.Buscar(i);
         
         if(cali.getNivel().equalsIgnoreCase(nivel)&&cali.getTipo().equalsIgnoreCase(tipo)&&cali.getMes()==mes&& cali.getIdAlumno().equalsIgnoreCase(idAlumno)){
             rpta=1;
         }
     }
     return rpta;
     }

     //obtener mes en letras
     public static String obtenerMesEnLetras(int mes){
    String mesL = "";
        switch (mes) {
            case 0:
                mesL="Enero";
                break;
            case 1:
                mesL="Febrero";
                break;
            case 2:
                mesL="Marzo";
                break;
            case 3:
                mesL="Abril";
                break;
            case 4:
                mesL="Mayo";
                break;
            case 5:
                mesL="Junio";
                break;
            case 6:
                mesL="Julio";
                break;
            case 7:
                mesL="Agosto";
                break;
            case 8:
                mesL="Septiembre";
                break;
            case 9:
                mesL="Octubre";
                break;
            case 10:
                mesL="Noviembre";
                break;
            case 11:
                mesL="Diciembre";
                ;
                break;
            default:
                break;
        }
    return mesL;
    }
     
     
     //generar graficos estadisticos
     
     public static void generarbarras(JDialog dialog,JDialog presente,float promedio[], String mes[], int cantidad){

         DefaultCategoryDataset ds= new DefaultCategoryDataset();
         for(int i=0; i<cantidad; i++){
         ds.addValue(promedio[i], mes[i], "Promedio");
         JFreeChart jf= ChartFactory.createBarChart3D("Progreso académico del alumno", "Mes", "Promedio", ds, PlotOrientation.VERTICAL, true, true, true);
         
         /*
         ChartFrame f= new ChartFrame("Promedios", jf);
         f.setSize(500, 900);
         f.setLocation(1200, 100);
         f.setVisible(true);
         }*/
              
             ChartPanel paneIngreso = new ChartPanel(jf);
             presente.getContentPane().add(paneIngreso);
             presente.setLocation(1200,100);
             presente.setSize(500,900);
             presente.setVisible(true);
         } 
     
     }
     
     
     // obtener promediomayotymenor
     public static float[] promedioMayoryMenor(float promedios[]){
        float  datos[]=promedios;
        float mayor = 0;
        float menor=1000;
        float resultados[]= new float[2];
         for(int i=0; i<datos.length; i++){
         float dato=datos[i];
         if(dato>mayor)
         mayor=dato;
         
         if(dato != 0){
           if(dato<menor){
         menor=dato;
         }  
         }
         
         
     resultados[0]=mayor;
     resultados[1]=menor;
     
     }
     return resultados;
     }
     
     
     //obtener notas de alumnos de cierto nivel
     
     public static ListasAux.ListaEnlazada[] notasAlumnosGrupo(int mes, String nivel){
     ListasAux.ListaEnlazada listaCalificaciones= Calificacion.consultarTodo();
        ListaEnlazada notasMiddle = new ListasAux.ListaEnlazada();
        ListaEnlazada notasProject = new ListasAux.ListaEnlazada();
        ListaEnlazada notasFinally = new ListasAux.ListaEnlazada();
     ListaEnlazada resultados[]=new ListaEnlazada[3];
     
     for(int i=0; i<listaCalificaciones.tamaño(); i++){
     Calificacion cal=(Calificacion) listaCalificaciones.Buscar(i);
     if(cal.getMes()==mes&&cal.getNivel().equalsIgnoreCase(nivel)&& cal.getTipo().equalsIgnoreCase("Middle exam")){
     notasMiddle.agregar(cal);
     }else
         if(cal.getMes()==mes&&cal.getNivel().equalsIgnoreCase(nivel)&& cal.getTipo().equalsIgnoreCase("Project")){
          notasProject.agregar(cal);
         }else
         if(cal.getMes()==mes&&cal.getNivel().equalsIgnoreCase(nivel)&& cal.getTipo().equalsIgnoreCase("Finally exam")){
        notasFinally.agregar(cal);
         }
     }
     resultados[0]= notasMiddle;
     resultados[1]= notasProject;
     resultados[2]= notasFinally;
     return resultados;
}
    public static Object[] mayorNota(int mes,String nivel,String tipo){
    float mayor=0;
    float menor=21;
    ListaEnlazada listaM=new ListaEnlazada();
    ListaEnlazada listaMenos = new ListaEnlazada();
    ListaEnlazada lista=listaCalificaciones.consultar();
        for (int i = 0; i < lista.tamaño(); i++) {
            Calificacion obj=(Calificacion)lista.Buscar(i);
            if (obj.getMes()==mes && obj.getNivel().equalsIgnoreCase(nivel) && obj.getTipo().equalsIgnoreCase(tipo)) {
                if (obj.getNota()>mayor) {
                    mayor=obj.getNota();
            }
            
        }
        }
        for (int j = 0; j < lista.tamaño(); j++) {
                Calificacion obj=(Calificacion)lista.Buscar(j);
                if (obj.getMes()==mes && obj.getNivel().equalsIgnoreCase(nivel) && obj.getTipo().equalsIgnoreCase(tipo)) {
                if (obj.getNota()==mayor) {
                    listaM.agregar(obj);
                }
           }
                
            }
        for (int i = 0; i < lista.tamaño(); i++) {
            Calificacion obj=(Calificacion)lista.Buscar(i);
            if (obj.getMes()==mes && obj.getNivel().equalsIgnoreCase(nivel) && obj.getTipo().equalsIgnoreCase(tipo)) {
                if (obj.getNota()<menor) {
                    menor=obj.getNota();
            }
            
        }
        }
        for (int j = 0; j < lista.tamaño(); j++) {
                Calificacion obj=(Calificacion)lista.Buscar(j);
                if (obj.getMes()==mes && obj.getNivel().equalsIgnoreCase(nivel) && obj.getTipo().equalsIgnoreCase(tipo)) {
                if (obj.getNota()==menor) {
                    listaMenos.agregar(obj);
                }
           }
                
            }
        Object listas[] = new Object[2];
        listas[0] =listaM;
        listas[1] =listaMenos;
        
        return listas;
        }
}