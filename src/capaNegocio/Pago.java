package capaNegocio;

import capaDatos.listaMatricula;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pago implements Serializable {

    private float montoTotal;

    private int nroCuotas;//en meses
    private boolean estado;//true = al dia false= debe
    private float cuenta = 0;
    private Date fechaPago;

    public Pago(float montoTotal, int nroCuotas) {
        this.montoTotal = montoTotal;
        this.nroCuotas = nroCuotas;
        this.estado = true;
    }


    public float Montocuota() {
        float cuota = this.montoTotal / nroCuotas;
        return cuota;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public int getNroCuotas() {
        return nroCuotas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public float getCuenta() {
        return cuenta;
    }

    public void setCuenta(float cuenta) {
        this.cuenta = this.cuenta + cuenta;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    ///******generar los pagos******************//
    public void generarPagos(String dni) {
       Cuota.generarPagos(fechaPago, nroCuotas, dni, Montocuota());
    }
    //***Generar rango de fecha a pagar************//

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
//generar las cuotas del alumno

    //obtener pago dado un alumno 
    public static Pago obtenerPago(String codAlumno) {
        Matricula objMatricula = ReportesMatricula.ObtenerMatriculaActivo(codAlumno);
        if (objMatricula.getPagoAlumno() == null) {
            return null;
        }
        return objMatricula.getPagoAlumno();
    }
/******************agregar pago****************/
   public static float agregarPago(String dni,float monto){
        Matricula objMatricula = ReportesMatricula.ObtenerMatriculaActivo(dni);
       int pos = listaMatricula.buscarPosicion(objMatricula.getIdMatricula());
       if(pos == -1)return -1;
          Matricula obMatricula= (Matricula) listaMatricula.consultar().Buscar(pos);
          obMatricula.getPagoAlumno().setCuenta(monto);     
          listaMatricula.consultar().Modificar(obMatricula, pos);
          return  obMatricula.getPagoAlumno().getCuenta();
   } 
    
    
}
