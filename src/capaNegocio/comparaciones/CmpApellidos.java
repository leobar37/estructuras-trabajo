/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio.comparaciones;

import ListasAux.Evaluar;
import capaNegocio.Alumno;


public class CmpApellidos implements Evaluar{
      @Override
    public int evaluar(Object dato, Object dato2) {
        Alumno alumno1 = (Alumno) dato;
       Alumno alumno2 = (Alumno) dato2;
      
        int compare = alumno1.getApellidos().compareTo(alumno2.getApellidos());
       if(compare < 0){
           return -1;
       }else{
           return 1;
       }
       
    }
}
