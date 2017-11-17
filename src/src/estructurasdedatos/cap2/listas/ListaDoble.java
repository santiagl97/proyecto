/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap2.listas;

import estructurasdedatos.utiles.nodos.NodoDoble;

/**
 *
 * @author santiago londoño rojas
 */
public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;

    //CREAR LISTA
    public void Crearlista() {
        this.cabeza = null;
        this.cola = null;
    }

    //verificar si la lista esta vacia
    public boolean Vacia() {
        return cabeza == null;
    }
    // insertar desde el princioio

    public void Insertarfin(int dato) {
        NodoDoble nodo1 = new NodoDoble();
        nodo1.setDato(dato);
        if (this.cabeza == null) {
            this.cabeza = nodo1;
            this.cola = nodo1;
        } else {
            NodoDoble aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo1);
            nodo1.setAnterior(aux);
        }
    }

    // insertar el ffinal de la lista
    public void Insertarini(int dato) {
        NodoDoble nodo2 = new NodoDoble();
        nodo2.setDato(dato);
        if (Vacia()) {
            this.cabeza = nodo2;
            this.cola = nodo2;
        } else {
            nodo2.setSiguiente(cabeza);
            cabeza.setAnterior(nodo2);
        }
    }

    //imprimir
    public void imprimir() {
        if (!Vacia()) {
            NodoDoble aux = cabeza;
            while (aux != null) {
                System.out.print("[" + aux.getDato() + "]");
                aux = aux.getSiguiente();
            }
            System.out.println("null");
        } else {
        }
    }
}
