/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import ListasAux.ListaEnlazada;
import capaDatos.listaAlumno;
import capaDatos.listaMatricula;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Matricula implements Serializable {

    public final static int anuladoxPago = 1;
    public final static int dadoBaja = 2;
    public final static int retirado = 3;
    public final static int activo = 4;
    public final static int terminado = 5;
    private String idMatricula;
    private Pago pagoAlumno;
    private int codGrupo = -1;
    private String DniAlumno;
    private Date fechaMatricula;
    private int matriculaEstado;

    public Matricula(int codGrupo, String numS) {
        this.codGrupo = codGrupo;
        this.idMatricula = numS;
    }

    public int getMatriculaEstado() {
        return matriculaEstado;
    }

    public void setMatriculaEstado(int matriculaEstado) {
        this.matriculaEstado = matriculaEstado;
    }

    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getDniAlumno() {
        return DniAlumno;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public void setDniAlumno(String DniAlumno) {
        this.DniAlumno = DniAlumno;
    }

    public Pago getPagoAlumno() {
        return pagoAlumno;
    }

    public void setPagoAlumno(Pago pagoAlumno) {
        this.pagoAlumno = pagoAlumno;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    public static ListasAux.ListaEnlazada consultar() {
        return listaMatricula.consultar();
    }

    /*
    public static int generarIdMatricula() {
        Matricula us = null;
        if (listaMatricula.consultar().tamaño() == 0) {
            return 0;
        }
        us = (Matricula) listaMatricula.consultar().Buscar(listaMatricula.consultar().tamaño() - 1);
        if (us != null) {
            return us.getCodGrupo();
        }
        return 0;
    }
     */
 /*gesionar matricula:
     los metodos no tienes validadacion ante una posicion nula 
    --(comprobar en el FRM sugerencia metodo 3)
     */
    //modificar matricula
    public static void modificarMatricula(String codAlumno, Object alumno) {
        int pos = listaMatricula.buscarPosicion(codAlumno);
        listaMatricula.consultar().Modificar(alumno, pos);
    }

    //eliminar una matricula
    public static void eliminarMatricula(String codAlumno) {
        int pos = listaMatricula.buscarPosicion(codAlumno);
        listaMatricula.consultar().Eliminar(pos);
    }

    //retornar una matricula
    public static Matricula obtenerMatricula(String codMatricula) {
        // System.out.println("parametro" + codAlumno);
        int pos = listaMatricula.buscarPosicion(codMatricula);
        // System.out.println("" + pos);
        Matricula mat = null;
        if (pos != -1) {
            mat = (Matricula) listaMatricula.consultar().Buscar(pos);
            return mat;
        }
        return mat;

    }


    public static Alumno obtenerAlumnoMatriculado(String codAlumno) {
        int pos = listaMatricula.buscarPosicion(codAlumno);

        Matricula mat = null;
        Alumno objAlumno = null;
        if (pos != -1) {
            mat = (Matricula) listaMatricula.consultar().Buscar(pos);
            objAlumno = listaAlumno.buscaxDniAumno(mat.getDniAlumno());
            return objAlumno;
        }
        return objAlumno;

    }

    public static boolean VerificarSerieMatricula(String ma) {
        for (int i = 0; i < listaMatricula.consultar().tamaño(); i++) {
            Matricula objMatricula = (Matricula) listaMatricula.consultar().Buscar(i);
            if (objMatricula.getIdMatricula().equals(ma)) {
                return false;
            }

        }
        return true;
    }

    public static String GenerarNumeroMatricula() {
        String ma = "MA";

        ma = NumeroAleatorios(4, ma);
        //verificar serie = false (hay uno igual)
        while (!VerificarSerieMatricula(ma)) {

            ma = NumeroAleatorios(4, ma);
        }
        return ma;
    }

    private static String NumeroAleatorios(int ref, String ma) {
        for (int i = 0; i < ref; i++) {
            int ramdon = (int) (Math.random() * 9 + 1);
            ma = ma + ramdon;
        }
        return ma;
    }

}
