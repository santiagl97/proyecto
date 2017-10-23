/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap4.arboles;

import estructurasdedatos.utiles.nodos.NodoArbolB;

/**
 *
 * @author santiago londoño rojas
 */
public class ArbolB {

    private NodoArbolB raiz;

    public boolean esVacia() {
        return raiz == null;
    }

    public void insertar(int nodito) {
        if (esVacia()) {
            NodoArbolB nuevonodo = new NodoArbolB();
            nuevonodo.dato = nodito;
            nuevonodo.hijoderecho = new ArbolB();
            nuevonodo.hijoizquierdo = new ArbolB();
            raiz = nuevonodo;
        } else {
            if (nodito > raiz.dato) {
                raiz.hijoderecho.insertar(nodito);
            }
            if (nodito < raiz.dato) {
                raiz.hijoizquierdo.insertar(nodito);
            }
        }
    }

    public void orden() {
        if (!esVacia()) {
            raiz.hijoizquierdo.orden();
            System.out.print(raiz.dato + ",");
            raiz.hijoderecho.orden();
        }
    }

    public void preorden() {
        if (!esVacia()) {
            System.out.print(raiz.dato + ",");
            raiz.hijoizquierdo.preorden();
            raiz.hijoderecho.preorden();
        }
    }

    public void postorden() {
        if (!esVacia()) {
            raiz.hijoizquierdo.postorden();
            raiz.hijoderecho.postorden();
            System.out.print(raiz.dato + ",");
        }
    }

}
