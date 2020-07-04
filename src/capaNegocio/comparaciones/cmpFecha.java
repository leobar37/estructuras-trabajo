/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio.comparaciones;

import capaNegocio.*;
import ListasAux.Evaluar;

public class cmpFecha implements Evaluar{

    @Override
    public int evaluar(Object dato, Object dato2) {
       Alumno alumno1 = (Alumno) dato;
       Alumno alumno2 = (Alumno) dato2;
       
       int compara = alumno1.getFechaNacimiento().compareTo(alumno2.getFechaNacimiento());
         if(compara < 0){
           return -1;
       }else{
           return 1;
       }
       
    }
    
}
