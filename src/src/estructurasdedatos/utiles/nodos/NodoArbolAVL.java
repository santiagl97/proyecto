/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.utiles.nodos;

/**
 *
 * @santiago londoño rojas
 */
public class NodoArbolAVL {
     private NodoArbolAVL hijoIzq; 
    private NodoArbolAVL hijoDer;
    private int dato;
    private int fe;
    
    public NodoArbolAVL(int dato){
        this.hijoIzq = null;
        this.hijoDer = null;
        this.dato = dato;
        this.fe = 0;
    }

    /**
     * @return the hijoIzq
     */
    public NodoArbolAVL getHijoIzq() {
        return hijoIzq;
    }

    /**
     * @param hijoIzq the hijoIzq to set
     */
    public void setHijoIzq(NodoArbolAVL hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    /**
     * @return the hijoDer
     */
    public NodoArbolAVL getHijoDer() {
        return hijoDer;
    }

    /**
     * @param hijoDer the hijoDer to set
     */
    public void setHijoDer(NodoArbolAVL hijoDer) {
        this.hijoDer = hijoDer;
    }

    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return the fe
     */
    public int getFe() {
        return fe;
    }

    /**
     * @param fe the fe to set
     */
    public void setFe(int fe) {
        this.fe = fe;
    }
    
}
