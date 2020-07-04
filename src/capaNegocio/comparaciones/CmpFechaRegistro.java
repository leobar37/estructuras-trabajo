
package capaNegocio.comparaciones;

import ListasAux.Evaluar;
import capaNegocio.Alumno;


public class CmpFechaRegistro implements Evaluar{
    
    
    @Override
    public int evaluar(Object dato, Object dato2) {
       Alumno alumno1 = (Alumno) dato;
       Alumno alumno2 = (Alumno) dato2;
       
       int compara = alumno1.getFechaRegistro().compareTo(alumno2.getFechaRegistro());
         if(compara < 0){
           return -1;
       }else{
           return 1;
       }
       
    }
}
