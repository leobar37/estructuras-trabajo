/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos;

import ListasAux.ListaEnlazada;
import capaNegocio.Alumno;

/**
 *
 * @author Leobar37
 */
public class listaAlumno {
    
    public static String nameLista = "ListaAlumno";
    private static ListasAux.ListaEnlazada lista = new ListaEnlazada();
    
    public static void adicionar (Object c){
        lista.agregar(c);
    }
    public static void llenarlista(){
        lista = ArchivoBaseDate.ObtenerLista(nameLista);
    }
    public static  void guardarLista(){
        ArchivoBaseDate.GuardarLita(lista, nameLista);
    }
    public static ListaEnlazada consultar(){
        return lista;
    }
    public static int buscaxDniPos(String dni){
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            if(objAlumno.getDni().equals(dni))return i;
        }
        return  -1;
    }  
       public static Alumno buscaxDniAumno(String dni){
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            if(objAlumno.getDni().equals(dni))
                return objAlumno;
        }
        return  null;
    }
       

 
}
