/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio.comparaciones;

import ListasAux.Evaluar;

/**
 *
 * @author Leobar37
 */
public class EvaluarNumeroFloat implements Evaluar{

    @Override
    public int evaluar(Object dato, Object dato2) {
       float numero = (float) dato;
       float numero2 = (float) dato;
        
        if(numero < numero2){
            return -1;
        }else{
            return 1;
        }
        
    }
    
}
