/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap5.grafos;

import java.util.Arrays;

/**
 *
 * @author Santiago londoño rojas
 */
public class Floyd {
    
private double[][] grafo;
    
    public Floyd(int n){
        this.grafo = new double[n][n];
        iniciar();
    }
    
    public void iniciar(){
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if(i == j){
                    grafo[i][j] = 0;
                }else{
               grafo[i][j] = Double.POSITIVE_INFINITY;
            }
            }
            
        }
    }
    private boolean negativeCycle;
    public double[][] floywarshall(){
        double[][] distancia;
        int n = this.grafo.length;
        distancia = Arrays.copyOf(this.grafo, n);
        
        for(int k=0; k < n; k++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distancia[i][j] = Math.min(distancia[i][j], distancia[i][k] + distancia[k][j]);
                }
            }
            
            if(distancia[k][k] < 0.0){
                this.negativeCycle=true;
            }
        }
        return distancia;
    } 
}
