/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos;

import ListasAux.ListaEnlazada;
import capaNegocio.Calificacion;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author gonza
 */
public class listaCalificaciones {
    public static String nameLista = "ListaCalificacion";

    private static ListasAux.ListaEnlazada lista = new ListaEnlazada();
   
    public static void obtenerLista(){
        lista = ArchivoBaseDate.ObtenerLista(nameLista);
    }
    public static void GuardarLista(){
        ArchivoBaseDate.GuardarLita(lista, nameLista);
    }
    public static void adicionar(Object c) {
        lista.agregar(c);
    }

    public static ListasAux.ListaEnlazada consultar() {
        return lista;
    }

    public static int buscarID(String dniAlumno) {
        for (int i = 0; i < lista.tamaño(); i++) {
            Calificacion cali = (Calificacion) lista.Buscar(i);
            if (cali.getIdAlumno().equalsIgnoreCase(dniAlumno)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean ValidacionDni(String dniAlumno,int  mes) {
        int cont=0;
        for (int i = 0; i < lista.tamaño(); i++) {
            Calificacion cali = (Calificacion) lista.Buscar(i);
            if (cali.getIdAlumno().equalsIgnoreCase(dniAlumno) && cali.getMes()==mes) {
               cont++;
            }
        }
        if(cont <3){
             return true;
        }else{
            return false;
        }
       
    }
       /*  retorna true cuando si se puede ingresar la not:
    si este tien menos de tres notas
    false: cuando completo las tres notas del mes
      */
    public static boolean ValidarCalificacionMes(String dniAlumno){
      Calendar sistema = new GregorianCalendar();
      int  mes = sistema.get(Calendar.MONTH)+1;
     boolean validacion = ValidacionDni(dniAlumno, mes);
     return validacion;
    }
    public static int obtenerPosicion(String codigo) {

        for (int i = 0; i < lista.tamaño(); i++) {
            Calificacion cali = (Calificacion) lista.Buscar(i);
            if (cali.getIdAlumno().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;

    }
}
