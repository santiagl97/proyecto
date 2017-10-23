/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap2.listas;

import estructurasdedatos.utiles.nodos.NodoSimple;

/**
 *
 * @author santiago londoño rojas
 */
public class ListaSimple {

    private NodoSimple cabeza;
    private NodoSimple cola;

    public void CrearLista() { //  creo una lista con cabeza y cola ,inicializados en null  

        this.cabeza = null;
        this.cola = null;

    }

    public void InserDardato(int dato) { // se crea el nuevo nodo  
        NodoSimple nnodo = new NodoSimple(); // se le asigna el valor del  dato, luego  
        nnodo.crearNuevoNodo();   // hacemos un condicional que nos diga si la lista esta vacia o hay que hacer enlaces 
        nnodo.setdato(dato);

        if (this.cabeza == null && this.cola == null) {
            this.cabeza = nnodo;
            this.cola = nnodo;

        } else {
            cola.setdato(dato);
            this.cola = nnodo;

        }

    }

    public void listar() {
        // se verifica que la lista no este vacia 
        if (!(this.cabeza == null && this.cola == null)) {

            // creamos el nodo que nos va a recorres la lista nodo 
            // por nodo imprimedo el valor que hay en cada nodo 
            NodoSimple aux = cabeza;
            // ciclo por el cual el nodo recorre la lista hasta que la cola tenga el valor de null
            int i = 0;
            while (aux != null) {
                System.out.println("el dato :" + "[" + aux.getdato() + "]" + " " + "esta en la posicion"
                        + "(" + i + ")" + "de la lista");

                aux = aux.getsiguiente();
                i++;
            }
        }

    }

    public int borrar(int dato) {
        if (dato == cabeza.getdato()) {
            this.cabeza = cabeza.getsiguiente();
        } else {

            NodoSimple aux = cabeza;

            while (aux.getsiguiente().getdato() != dato) {

                aux = aux.getsiguiente();

            }
            NodoSimple auxsig = aux.getsiguiente().getsiguiente();
            aux.setsiguiente(auxsig);

        }

        return 0;

    }

    public void ActualizarDato(int dato) {

        if (dato == cabeza.getdato()) {
            this.cabeza = cabeza.getsiguiente();
        } else {

            NodoSimple aux = cabeza;

            while (aux.getsiguiente().getdato() != dato) {

                aux = aux.getsiguiente();

            }
            {
            }

        }

    }
}
