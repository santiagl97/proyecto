/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap5.grafos;

/**
 *
 * @author Santiago
 */
public class Aristas {
    
 private int inicio;
    private int fin;
    private int peso;

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Aristas(int inicio, int fin, int peso) {
        this.inicio = inicio;
        this.fin = fin;
        this.peso = peso;
    }
    
   public int vecinos(int index){
       if(this.inicio == index){
           return this.fin;
       }else{
           return this.inicio;
       }
   }
}
    
    
    
