package ListasAux;

import capaNegocio.Alumno;


public class ListaEnlazada {

    /*     _                 _                      _                      _____   _____ 
 | |__    _     _    | |       ___     ___  | |__     __ _   _ __  |___ /  |___  |
 | '_ \  | | | |    |   |      / _ \   / _ \ | '_ \   / _` | | '__|   |_ \     / / 
 | |_) | | |_| |  |   |___  | (_) | |  __/ | |_) | | (_| | | |     ___) |   / /  
 |_.__/   \__,|    |_____|  \___/   \___| |_.__/   \__,_| |_|    |____/   /_/   
          |___/ 
     */
    protected Nodo primero;
    private int cantidad;

    public ListaEnlazada() {
        primero = null;
        cantidad = 0;
    }
    //inserta al final de la lista  

    public void insertarFinal(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setReferencia(primero);
        primero = nuevo;
        cantidad++;
    }
    //   

    public void agregar(Object dato) {
        Nodo nuevoF = new Nodo(dato);
        nuevoF.referencia = null;
        if (primero == null) {
            primero = nuevoF;
            cantidad++;
            return;
        }
        Nodo aux;
        for (aux = primero; aux.getReferencia() != null; aux = aux.getReferencia()) {
        }
        aux.setReferencia(nuevoF);
        cantidad++;
    }

    public int tamaño() {
        return cantidad;
    }

    public Object Buscar(int pos) {
        Nodo aux = null;
        if (pos == 0) {
            aux = primero;
            return aux.dato;
        } else {
            aux = primero;
            if (pos > 0 && (pos <= cantidad)) {
                for (int i = 0; i < pos; i++) {
                    aux = aux.getReferencia();
                }
            }

            return aux.dato;
        }
    }

    //dado el objeto retorna su posicion
    public int BucarPos(Object dato) {
        for (int i = 0; i < cantidad; i++) {
            Object com = Buscar(i);
            if (com == dato) {
                return i;
            }
        }
        return -1;
    }

    //dado el objecto lo elimina
    public void EliminarO(Object dato) {
        Nodo anterior, actual;
        boolean encontrado = false;
        actual = primero;
        anterior = null;
        while (actual != null && !encontrado) {
            encontrado = actual.getDato() == dato;
            if (!encontrado) {
                anterior = actual;
                actual = actual.referencia;
            }
        }
        if (actual != null) {
            if (actual == primero) {
                primero = actual.getReferencia();
                cantidad--;
            } else {
                anterior.setReferencia(actual.getReferencia());
                cantidad--;
            }

        }

    }

    //elimina dada la posicion
    public void Eliminar(int pos) {
        Nodo actual, anterior;
        actual = primero;
        anterior = null;
        if (pos == 0) {
            primero = actual.referencia;
            cantidad--;
        } else {

            if (pos > 0 && pos <= cantidad) {
                for (int i = 0; i < pos; i++) {
                    anterior = actual;
                    actual = actual.referencia;
                }
                if (pos == cantidad) {
                    anterior = actual;
                    anterior = null;
                } else {
                    anterior.setReferencia(actual.getReferencia());
                }
                cantidad--;
            }

        }
    }

    public void Modificar(Object dato, int pos) {
        Nodo nuevo = new Nodo(dato);
        Nodo aux = null;
        if (pos == 0) {
            Eliminar(pos);
            nuevo.setReferencia(primero);
            primero = nuevo;
            cantidad++;
        } else {
            // Eliminar(pos);
            aux = primero;
            Nodo anterior, actual;
            actual = primero;
            anterior = null;
            if (pos > 0 && (pos <= cantidad)) {
                for (int i = 0; i < pos; i++) {
                    anterior = actual;
                    actual = actual.referencia;
                }
                if (pos == cantidad) {
                    anterior = actual;
                }
                nuevo.setReferencia(actual.referencia);
                actual.setReferencia(nuevo);

                //actual = nuevo;
                //actual =anterior;
                //nuevo.setReferencia(anterior);
                //actual.setReferencia(nuevo);
                //nuevo.setReferencia(actual.referencia);
                Eliminar(pos);
                cantidad++;

            }

        }

    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Alumno ob1 = new Alumno("1", "elmer");
        Alumno ob2 = new Alumno("2", "joselo");
        Alumno ob3 = new Alumno("3", "leon");
        Alumno ob4 = new Alumno("4", "barboza");
        Alumno ob5 = new Alumno("5", "alberto");
        lista.agregar(ob1);
        lista.agregar(ob2);
        lista.agregar(ob3);
        lista.agregar(ob4);
        lista.Modificar(ob5, 1);
        for (int i = 0; i < lista.cantidad; i++) {
            Alumno obj = (Alumno) lista.Buscar(i);
            System.out.println("" + obj.getNombre());
        }

    }

}
