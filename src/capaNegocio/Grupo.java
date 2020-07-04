/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import ListasAux.ListaEnlazada;

import capaDatos.listaGrupos;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author gonza
 */
public class Grupo implements Serializable {
   
    private int idGrupo;
    private String programa; //niños, adolecentes, adultos
    private String nivel; //niños(kinder, pre kids, kids, children), adolecentes(adolecentes), adultos(A1, A2, B1, B2, C1, C2)
    private String modalidad; //niños(regular), adolecentes(regular, intensivo), adultos(regular, regular FS, intensivo, intensivo FS)
    private String horario;
    private Date fechaInicio;
    private Date fechaFin;
    
    private String libro;
    private float precioTotal;

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public static ListaEnlazada consultarTodo() {
        return listaGrupos.consultar();
    }
    //eliminar grupo

    public static void eliminarGrupo(int codigoGrupo) {
        int pos = listaGrupos.obtenerPosicion(codigoGrupo);

        listaGrupos.consultar().Eliminar(pos);

    }

    //modificar
    public static void ModificarGrupo(Grupo objGrupo, int codigoGrupo) {
        int pos = listaGrupos.obtenerPosicion(codigoGrupo);
        listaGrupos.consultar().Modificar(objGrupo, pos);
    }

    public static Grupo BuscarGrupo(int codPrograma) {
        int pos = listaGrupos.obtenerPosicion(codPrograma);
        if (pos == -1) {
            return null;
        }
        return (Grupo) listaGrupos.consultar().Buscar(pos);
    }
    //generar el codigo de grupo

    public static int generarIdGrupo() {
        Grupo us = null;
        if (listaGrupos.consultar().tamaño() == 0) {
            return 0;
        }
        us = (Grupo) listaGrupos.consultar().Buscar(listaGrupos.consultar().tamaño() - 1);
        if (us != null) {
            return us.getIdGrupo();
        }
        return 0;
    }

    //obtener nivel a partir de idGrupo
    public static String obteniendoNivel(int idGrupo) {
        System.out.println("idGrupo"+idGrupo);
        ListasAux.ListaEnlazada listaGrupos;
        listaGrupos = Calificacion.consultarTodo();
        Grupo grup;
        String nivel = null;
        for (int i = 0; i < listaGrupos.tamaño(); i++) {

            grup = (Grupo) listaGrupos.Buscar(i);
            if (grup.getIdGrupo() == idGrupo) {
                nivel = grup.getNivel();
            }
        }
        return nivel;
    }

    //obtener programa a partir de idGrupo
    public static String obteniendoPrograma(int idGrupo) {
        System.out.println("id Grupo"+idGrupo);
        ListasAux.ListaEnlazada listaGrupos;
        listaGrupos = Calificacion.consultarTodo();
        Grupo grup;
        String grupo = null;
        for (int i = 0; i < listaGrupos.tamaño(); i++) {

            grup = (Grupo) listaGrupos.Buscar(i);
            if (grup.getIdGrupo() == idGrupo) {
                grupo = grup.getPrograma();
            }
        }
        return grupo;
    }
}
