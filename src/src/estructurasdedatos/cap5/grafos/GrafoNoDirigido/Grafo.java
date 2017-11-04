/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap5.grafos.GrafoNoDirigido;

import java.util.List;

/**
 *
 * @author Santiago londoño rojas
 */
public class Grafo {
 
    List <Vertice> Listavertices;
    List<ArcoNoDirigido> matrizdeadyascencia;
    
    public void insertarVertice(String dato){
        Vertice vertice = new Vertice();
        vertice.setDato(dato);
    }
    
    public void insertarArco(Vertice v1, Vertice v2){
        ArcoNoDirigido Nuevoarco = new ArcoNoDirigido();
        Nuevoarco.setV1(v1);
        Nuevoarco.setV2(v2);
        matrizdeadyascencia.add(Nuevoarco);
        
        
        
     
    }
    
    
}