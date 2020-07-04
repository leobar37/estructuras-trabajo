/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import ListasAux.ListaEnlazada;
import capaDatos.ListaCuotas;
import static capaNegocio.Pago.getMesesDePago;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Cuota implements Serializable {

    private String codMatricula;
    private int idCuota;
    private Date fecha;
    private float monto;
    private boolean estado = false;
    private float mora=0;
    public int getIdCuota() {
        return idCuota;
    }

    public float getMora() {
        return mora;
    }

    public void setMora(float mora) {
        this.mora = this.mora + mora;
        monto = monto +mora;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Cuota(String codMatricula, int idCuota, Date fecha, float monto) {
        this.codMatricula = codMatricula;
        this.idCuota = idCuota;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Cuota(Date fecha, float monto) {
        this.fecha = fecha;
        this.monto = monto;

    }

    public void setEstado(boolean est) {
        estado = est;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }

    public boolean isEstado() {
        return estado;
    }

    /*reporte de pagos
    1.se puede modificar la mora de acuerdo a los dias
    2.implementar interfaz de mora configuracion
    3.mora aplicada por dia de tardanza (1 : 0.3)
     */

 /*algoritmo 1
    1.acceder a la cuota 
    2.aumentarle a la mora 
    3.aumentar el monto de cuota
     */
 /*algoritmo 2 
    1.recorre todos los alumnos matriculados
    2.por cada iteracion sacar los pagos 
    3.consultar las cuotas 
    4.por cada cuota consultar si la fecha del sistema es mayor
     a la fecha que de pago de la cuota 
     si este se cumple el estudiante esta en deuda 
    5.aplica lista ordena para ordenar los pagos 
    retono: alumnos con deuda monto con deuda dias de deuda
    
     */
    //algoritmo 2
    public static ListaEnlazada PagosVecidos() {
        ListaEnlazada listaMat = ReportesMatricula.mostrarAlumnosMatriculados();
        ListaEnlazada listaFiltrada = new ListaEnlazada();
        //quien es el que debe |cuato debe | dias de atraso| 
        String auxReporteSr[] = new String[4];
        for (int i = 0; i < listaMat.tamaño(); i++) {
            Alumno objAlumno = (Alumno) listaMat.Buscar(i);
            ListaEnlazada listaPagos = ListaCuotas.cuotasxAlumno(objAlumno.getDni());

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
                float deudadTotal = cont * objCuota.getMonto();
                auxReporteSr[0] = objAlumno.getNombre();
                auxReporteSr[1] = objAlumno.getDni();
                auxReporteSr[2] = ""+ deudadTotal;
                auxReporteSr[3] = ""+cont;
                listaFiltrada.agregar(auxReporteSr);
                auxReporteSr = new String[4];
            }

        }
        return listaFiltrada;

    }

    //verifica si cuota esta vencida
    public static int cuotaVencida(Cuota co) {
        int diasAtraso = 0;
        Date objHoraSistema = Alternos.Alternos.obtenerFechaSistema();
        if (co.getFecha().compareTo(objHoraSistema) == -1 && co.isEstado() == false) {
            java.util.List<Date> listaFecha = ReportesMatricula.getIntervaloFechas(co.getFecha(), objHoraSistema, Calendar.DAY_OF_MONTH);
            diasAtraso = listaFecha.size();

        }
        return diasAtraso;
    }
    

    /*
    //se deben configurar previamente las moras
    public static String aplicacarMora(float mora,Date fecha) {
        String retorno = null;
        //feccha  de la cuota
        Calendar c1 = Calendar.getInstance();
        c1.setTime(fecha);
        //fecha del sistema
        java.util.Date fechaActual = Alternos.Alternos.obtenerFechaSistema();
        //System.out.println(""+fechaActual);
        //fecha a comparar 
        Calendar c2 = Calendar.getInstance();
        c2.setTime(fechaActual);
        int result = c1.compareTo(c2);
        System.out.println("" + result);
        if (result > 0) {
            monto = monto + mora;
            estado = false;
            int m1 = c1.get(Calendar.MONTH);
            int m2 = c2.get(Calendar.MONTH);
            int d1 = c1.get(Calendar.DAY_OF_MONTH);
            int d2 = c2.get(Calendar.DAY_OF_MONTH);
            int difMese = m1-m2;
            int difDias = d1-d2;
            //c1 fecha que doy
            //c2 fecha del sistema           
            //RESULTADO
                int  dias;
                //diferencia               
               if(difMese>0){
                   System.out.println(""+difMese);
                int cantDias =Alternos.Alternos.numeroDeDiasMes(m1);
                  // System.out.println(""+cantDias);
                int aux = cantDias - d2;
                dias = d1+aux;            
               }else{
                   dias = difDias;
               }          
            retorno = ""+dias;
            //System.out.println("atradado por meses"+dias);
        }
       return retorno;
    }
     */
    /**
     * ** obtener una cuota*****
     */
    public static Cuota ObtenerCuota(int id, String codMatricula) {
        ListaEnlazada lista = ListaCuotas.consultar();
        for (int i = 0; i < lista.tamaño(); i++) {
            Cuota objcuota = (Cuota) lista.Buscar(i);

            if (objcuota.getCodMatricula().equalsIgnoreCase(codMatricula)) {
                if (objcuota.getIdCuota() == id) {
                    return objcuota;
                }
            }
        }
        return null;
    }
    //***********************generar las cuotas de pago 

    public static void generarPagos(java.util.Date fecha, int meses, String codMatricula, float monto) {
        java.util.List<Date> lista = getMesesDePago(fecha, meses + 1);
        Cuota objCuota = new Cuota(codMatricula, 0, fecha, 50);
        objCuota.setEstado(true);
        ListaCuotas.adicionar(objCuota);
        for (int i = 1; i < lista.size(); i++) {
            java.util.Date aux = lista.get(i);
            Cuota obj = new Cuota(codMatricula, i, aux, monto);

            ListaCuotas.adicionar(obj);
        }

    }

    public static java.util.List<Date> getMesesDePago(java.util.Date fecha, int meses) {
        int cont = 0;
        java.util.List<Date> retorno = new java.util.ArrayList<Date>();
        Calendar fechaArranque = Calendar.getInstance();
        fechaArranque.setTime(fecha);

        boolean ver = true;
        while (ver) {
            retorno.add(fechaArranque.getTime());
            fechaArranque.add(Calendar.MONTH, 1);
            cont++;
            if (cont == meses) {
                ver = false;
            }
        }
        return retorno;
    }

    //**************pagar cuota******************//
    public static void pagarCuota(int id, String dni) {
        Matricula objMatricula = ReportesMatricula.ObtenerMatriculaActivo(dni);
        int pos = ListaCuotas.ObtenerCuotaPos(id, objMatricula.getIdMatricula());
        if (pos == -1) {
            return;
        }
        Cuota cuota = (Cuota) ListaCuotas.consultar().Buscar(pos);
        if (cuota.isEstado()) {
            cuota.setEstado(false);
        } else {
            cuota.setEstado(true);
        }
        ListaCuotas.consultar().Modificar(cuota, pos);

    }

}
