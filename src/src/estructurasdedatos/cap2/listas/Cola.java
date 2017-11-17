/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap2.listas;

import estructurasdedatos.utiles.nodos.NodoObjeto;

/**
 *
 * @author santiago londoño rojas
 */
public class Cola {
    //atributos
    
    private NodoObjeto primero;
    private NodoObjeto ultimo;
    
    public boolean Vacia(){
        return primero == null;
    }
    
    public void crearCola(){
        this.primero = null;
        this.ultimo = null;
    }
    //hace la cola
    public void enColar (int dato){
        NodoObjeto nodol = new NodoObjeto();
        nodol.setDato(dato);
        if(Vacia()){
            this.primero =nodol;
            this.ultimo =nodol;
        }else {
            NodoObjeto aux=primero;
            while(aux.getSiguiente() != null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(aux);
        }
    }
   //atender
    
    public void desencolar(){
        if(Vacia()){
            this.primero.getSiguiente();
        }else{
            System.out.println("cola vacia");
        }
    }
    
    //imprimir
    public void imprimir(){
        NodoObjeto aux = primero;
        int i=l;
        while (aux != null){
            System.out.println(i + "." + "[" + aux.getDato() + "]" + "->" + " ");
            aux = aux.getSiguiente();
            i++;
        }
        System.out.println("null");
    }
    
    //tamaño cola
    public int tamaño(){
        NodoObjeto aux = primero;
        int contador = 0;
        while(aux != null){
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }
    
}
