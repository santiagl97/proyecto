/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap2.arreglos;

/**
 *
 * @author santiago
 */
public class Matriz {
    //en esta parte van los atributos
    private int fila;
    private int columna; 
    private int [][] matriz;
    
    public void crearMatriz(int c, int f) {
    
    this.fila= f;
    this.columna= c;
    this.matriz= new int [f][c];
    
}
    public void Insertar (int c, int f, int dato){
        
        this.fila=f;
        this.columna=c;
        this.matriz [f][c]=dato;
    }
    public void Borrar (int c, int f, int dato){
        this.fila=f;
        this.columna=c;
        this.matriz[f][c]=0;
    }
    
    public void BuscarDato (int dato){
        for (int f=0; f<matriz.length; f++){
            for(int c=0; c<matriz.length; c++){
                if (this.matriz[f][c]==dato){
                    System.out.println("el dato se encuentra "+ f+","+c);
                }
                
            }
    }
}
}