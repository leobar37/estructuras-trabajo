/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos;

import ListasAux.ListaEnlazada;
import capaNegocio.Cuota;
import capaNegocio.Matricula;
import capaNegocio.ReportesMatricula;

public class ListaCuotas {

    public static String nameLista = "ListaCuota";

    private static ListasAux.ListaEnlazada lista = new ListaEnlazada();

    public static void obtenerLista() {
        lista = ArchivoBaseDate.ObtenerLista(nameLista);
    }

    public static void GuardarLista() {
        ArchivoBaseDate.GuardarLita(lista, nameLista);
    }

    public static void adicionar(Object c) {
        lista.agregar(c);
    }

    public static ListasAux.ListaEnlazada consultar() {
        return lista;
    }
   public static Cuota retornaCuota(int idCuota){
       for (int i = 0; i < lista.tamaño(); i++) {
           Cuota objCuota = (Cuota) lista.Buscar(i);
           if(objCuota.getIdCuota() == idCuota)return objCuota;
       }
       return null;
   }
    ///**************obtener cuotas dado un estudiante 
    /*obtiene las cuotas dado un estudiante*/
    public static ListaEnlazada ObtenerCuotas(String codMatricula) {   
        ListaEnlazada retorno = new ListaEnlazada();
        ListaEnlazada lista = ListaCuotas.consultar();
        for (int i = 0; i < lista.tamaño(); i++) {
            Cuota objcuota = (Cuota) lista.Buscar(i);
            if (objcuota.getCodMatricula().equalsIgnoreCase(codMatricula)) {
                retorno.agregar(objcuota);
            }
        }
        return retorno;
    }
    //obtner cuotas por alumno
    public static ListaEnlazada cuotasxAlumno(String dni){
        Matricula  objma =ReportesMatricula.ObtenerMatriculaActivo(dni);
        ListaEnlazada lista = ObtenerCuotas(objma.getIdMatricula());
        return lista;       
    }
    public static int ObtenerCuotaPos(int id,String codMatricula) {
        ListaEnlazada lista = ListaCuotas.consultar();
        for (int i = 0; i < lista.tamaño(); i++) {
            Cuota objcuota = (Cuota) lista.Buscar(i);            
            if(objcuota.getCodMatricula().equalsIgnoreCase(codMatricula)){
               if (objcuota.getIdCuota() == id) {
                return i;
                }   
            }
        }
        return -1;
    }
}
