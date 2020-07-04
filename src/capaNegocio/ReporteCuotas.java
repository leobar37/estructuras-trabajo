
package capaNegocio;

import ListasAux.ListaEnlazada;
import capaDatos.ListaCuotas;
import capaDatos.listaMatricula;
import static capaNegocio.Cuota.cuotaVencida;

public class ReporteCuotas {
 //lista de 
  public static void aplicarMora(int desde,int hasta,float mora){
      ListaEnlazada lista = ReporteCuotas.MatriculasPagosVecidos();
      for (int i = 0; i < lista.tamaño(); i++) {
          Matricula objMatricula = (Matricula) lista.Buscar(i);         
          ReporteCuotas.aplicaMoraCuotas(desde, hasta, mora,objMatricula.getIdMatricula());         
      }
  
  }
   public static void DesabilitarPago(String serie){
     Matricula objMatricula = Matricula.obtenerMatricula(serie);
     objMatricula.setMatriculaEstado(Matricula.anuladoxPago);
     int pos =listaMatricula.buscarPosicion(objMatricula.getIdMatricula());
     listaMatricula.consultar().Modificar(objMatricula,pos);   
  }
  //consultar si la matricula tiene deuda o en un intervalo de tiempo
   
  public static void aplicaMoraCuotas(int desde,int hasta,float mora,String serie){
      ListaEnlazada lista = ListaCuotas.ObtenerCuotas(serie);
      for (int i = 0; i < lista.tamaño(); i++) {
          Cuota objCuota = (Cuota) lista.Buscar(i);
          int dias = Cuota.cuotaVencida(objCuota);
          if((dias >= desde && dias <= hasta)){
                int pos = ListaCuotas.ObtenerCuotaPos(objCuota.getIdCuota(), serie);
                objCuota.setMora(mora);
                ListaCuotas.consultar().Modificar(objCuota, pos);
          }          
      }
      
  } 
      public static ListaEnlazada MatriculasPagosVecidos() {
        ListaEnlazada listaMat = Matricula.consultar();
        ListaEnlazada listaFiltrada = new ListaEnlazada();
        //quien es el que debe |cuato debe | dias de atraso| 
 
        for (int i = 0; i < listaMat.tamaño(); i++) {
            Matricula objMatricula = (Matricula) listaMat.Buscar(i);
            ListaEnlazada listaPagos = ListaCuotas.ObtenerCuotas(objMatricula.getIdMatricula());

            int cont = 0;
            Cuota objCuota = null;
            for (int j = 0; j < listaPagos.tamaño(); j++) {

                objCuota = (Cuota) listaPagos.Buscar(j);
                int r = cuotaVencida(objCuota);
                if (r > 0) {
                 cont++;
                }
            }
            if (cont > 0) {
                  listaFiltrada.agregar(objMatricula);
            }

        }
        return listaFiltrada;

    }  
}
