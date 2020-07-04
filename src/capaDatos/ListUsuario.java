package capaDatos;

import ListasAux.ListaEnlazada;

import capaNegocio.Usuario;

public class ListUsuario {

    public static final String name = "DateUsuario";
    private static ListaEnlazada lista = new ListaEnlazada();

    public static void adicionar(Object c) {
        lista.agregar(c);
    }
    public static void clenlazada(){
        lista = ArchivoBaseDate.ObtenerLista(name);
        
    }
    public static ListaEnlazada consultar() {
        return lista;
    }

    public static boolean verficarUsuario(Usuario us) {
        int pos = lista.BucarPos(us);
        return (pos != - 1);
    }
    public static int verficarUsuarioC(Usuario us) {
          ListaEnlazada lista = ListUsuario.consultar();
        for (int i = 0; i < lista.tamaño(); i++) {
             Usuario objUsuario = (Usuario) lista.Buscar(i);
             if(objUsuario.getUsuario().equals(us.getUsuario()) && objUsuario.getContraseña().equals(us.getContraseña()))return i;         
        }
        return -1;
    }
    //para saber a cada momento que usuario esta en el sistema

    public static int buscarPosUsuario(Usuario us) {
        int pos = lista.BucarPos(us);
        return pos;
    }

    public static void modificar(Object c, int pos) {
        lista.Modificar(c, pos);

    }
    public static int buscarXcodigo(int codigo){
       ListaEnlazada lista = ListUsuario.consultar(); 
        for (int i = 0; i < lista.tamaño(); i++) {
            Usuario us = (Usuario) lista.Buscar(i);
            if(us.getCodigo() == codigo)return i;
             
        }
        return -1;
    }
    
}
