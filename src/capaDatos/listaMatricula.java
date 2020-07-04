/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos;

import ListasAux.ListaEnlazada;
import capaNegocio.Matricula;

/**
 *
 * @author Leobar37
 */
public class listaMatricula {
     public static final String nameLista = "ListaMatricula";
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
    
    public static int buscarPosicion(String codMatricula){    
        for (int i = 0; i < lista.tamaño(); i++) {
            Matricula objAMatricula = (Matricula) lista.Buscar(i);
          
            if(codMatricula.equals(objAMatricula.getIdMatricula())){
            
                return i;
            }  
        }
       return -1;
    }
    
    
}
