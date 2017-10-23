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
public class NodoDoble {
    
    NodoDoble anterior;
    NodoDoble siguiente;
    int dato;
    
    public int getDato (){
     return dato;
     
     }
    
    public void setDato (int dato){
    
    this.dato=  dato;
    
    }
    
    public  NodoDoble getSiguiente (){
        return siguiente;
    }
    
    public void setSiguiente (NodoDoble siguiente){
    
    this.siguiente= siguiente;
            
    }
    public NodoDoble getAnterior (){
    
        return anterior;
    }
    
    public void setAnterior(NodoDoble anterior){
    
    this.anterior= anterior;
    
    }
    
    public void CrearNuevoNodoDoble (){
    
    this.siguiente= null;
    this.anterior=null;
    this.dato=0;    
    
    }
    
}