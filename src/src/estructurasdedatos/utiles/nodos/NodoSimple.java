/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.utiles.nodos;

/**
 *
 * @author santiago londoño rojas
 */
public class NodoSimple {

    private NodoSimple siguiente;
    int dato;

    public NodoSimple getsiguiente() {

        return siguiente;

    }

    public void setsiguiente(NodoSimple siguiente) {

        this.siguiente = siguiente;

    }

    public int getdato() {
        return dato;
    }

    public void setdato(int dato) {
        this.dato = dato;

    }

    public void crearNuevoNodo() {

        this.siguiente = null;
        this.dato = 0;

    }

}
