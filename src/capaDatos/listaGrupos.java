/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos;

import ListasAux.ListaEnlazada;
import capaNegocio.Alumno;
import capaNegocio.Grupo;
import capaNegocio.Matricula;


/**
 *
 * @author gonza
 */
public class listaGrupos {

    public static String nameLista = "ListaGrupo";

    private static ListaEnlazada lista = new ListaEnlazada();
   
    public static void obtenerLista(){
        lista = ArchivoBaseDate.ObtenerLista(nameLista);
    }
    public static void GuardarLista(){
        ArchivoBaseDate.GuardarLita(lista, nameLista);
    }
    public static void adicionar(Object c) {
        lista.agregar(c);
    }

    public static ListaEnlazada consultar() {
        return lista;
    }
/*
    public static int buscarID(String id) {
        for (int i = 0; i < lista.tamaño(); i++) {
            Grupo grup = (Grupo) lista.Buscar(i);
            if (grup.getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
*/
    //retorna un grupo dado el id
    public static Grupo obtnerGrupo(int codigo){
          for (int i = 0; i < lista.tamaño(); i++) {
            Grupo grup = (Grupo) lista.Buscar(i);
            if (grup.getIdGrupo() == codigo) {
                return grup;
            }
        }
        return null;
    }
    
    public static int obtenerPosicion(int codigo) {
        for (int i = 0; i < lista.tamaño(); i++) {
            Grupo grup = (Grupo) lista.Buscar(i);
            if (grup.getIdGrupo() == codigo) {
                return i;
            }
        }
        return -1;
    }
  //retorna cuantos alumnos hay en un dicho grupo
    public static int ObtenerNumeroGrupo(int idGrupo){  
      ListaEnlazada lista = listaMatricula.consultar();
      int cont =0;
        for (int i = 0; i < lista.tamaño(); i++) {
            Matricula objMatricula = (Matricula) lista.Buscar(i);
           if(objMatricula.getCodGrupo()== idGrupo){
               cont++; 
           }    
        }
     return cont;
    }
  //retorna la cantidad de alumnos en un determinado grupo
   public static int[] retornarCantidadAlumnoxGrupo(){
       ListaEnlazada lista = listaGrupos.consultar();
       int retorno[] = new int[lista.tamaño()];     
         for (int i = 0; i < lista.tamaño(); i++) {
          Grupo objGrupo = (Grupo) lista.Buscar(i);
          retorno[i] = ObtenerNumeroGrupo(objGrupo.getIdGrupo());  
       }
     return  retorno;
   }
     
   
}
