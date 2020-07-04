/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasAux;

public class ListaOrdenana extends ListaEnlazada {

    Evaluar comp;

    public ListaOrdenana(Evaluar eva) {
        super();
        comp = eva;
    }

    /*evluar da -1 cunando es menos y 1*/
    public void insertarOrden(Object dato) {
        Nodo nuevo = new Nodo(dato);
        int res = 0;
        //  System.out.println("esxa"+res);
        if (primero == null) {
            nuevo.setReferencia(primero);
            primero = nuevo;
            // System.out.println("Es nulo");
//            System.out.println("sss"+primero.getDato());
        } else {
            res = comp.evaluar(dato, primero.getDato());
            // System.out.println(""+res);
            if (res == -1) {
                nuevo.setReferencia(primero);
                primero = nuevo;
            } else {
                int auxres = 0;
                Nodo anterior, actual;
                anterior = actual = primero;
                auxres = comp.evaluar(dato, actual.getDato());
                while ((actual.getReferencia() != null) && (auxres == 1)) {
                    anterior = actual;
                    actual = actual.getReferencia();
                    auxres = comp.evaluar(dato, actual.getDato());
                }
                if (auxres == 1) {
                    anterior = actual;
                }
                nuevo.setReferencia(anterior.getReferencia());
                anterior.setReferencia(nuevo);

            }
        }

    }

    public ListaEnlazada ObtenerOrden() {
        ListaEnlazada objEnlazada = new ListaEnlazada();
        Nodo aux = primero;
        while (aux != null) {
            objEnlazada.agregar(aux.getDato());
            //System.out.println(""+((Alumno)aux.getDato()).getEdad());
            aux = aux.getReferencia();

        }
        return objEnlazada;
    }
/*
    public static void main(String[] args) {
       // ListaOrdenana lista = new ListaOrdenana();
        Alumno obj1 = new Alumno(10, "roberto");
        Alumno obj2 = new Alumno(50, "josleo");
        Alumno obj3 = new Alumno(40, "barboza");
        Alumno obj4 = new Alumno(100, "montero");
        lista.insertarOrden(obj1);
        lista.insertarOrden(obj2);
        lista.insertarOrden(obj3);
        lista.insertarOrden(obj4);
        ListaEnlazada listaE = lista.ObtenerOrden();
        for (int i = 0; i < listaE.tamaño(); i++) {
            Alumno objAlumno = (Alumno) listaE.Buscar(i);
            System.out.println("" + objAlumno.getEdad());
        }

    }
*/
}
