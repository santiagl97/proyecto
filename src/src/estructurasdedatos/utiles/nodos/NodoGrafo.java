/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.utiles.nodos;

/**
 *
 * @author Santiago
 */
public class NodoGrafo {
    public int vertice;
        public int pesoArista;
        public NodoGrafo siguiente;

        public NodoGrafo(int v, int a) {
            this.vertice = v;
            this.pesoArista = a;
            this.siguiente = null;
}


}
