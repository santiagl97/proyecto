/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap5.grafos;

import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Grafo {
    private NodoGrafo[] nodo;
    private Aristas[] aris;
    private int nroAristas;
    private int nroNodos;

    public NodoGrafo[] getNodo() {
        return nodo;
    }

    public Aristas[] getAris() {
        return aris;
    }

    public int getNroAristas() {
        return nroAristas;
    }
    
    public int getNroNodos() {
        return nroNodos;
    }
    
    public Grafo(Aristas[] aris){
        this.aris=aris;
        this.nroNodos = calcularNroNodos(aris);
        this.nodo = new NodoGrafo[this.nroNodos];
        for (int n = 0; n < this.nroNodos; n++) {
            this.nodo[n] = new NodoGrafo();
        }
        
        this.nroAristas = aris.length;
        for (int addArista = 0; addArista < this.nroAristas; addArista++) {
            this.nodo[aris[addArista].getInicio()].getAris().add(aris[addArista]);
            this.nodo[aris[addArista].getFin()].getAris().add(aris[addArista]);
        }
        
    }
    
    public int calcularNroNodos(Aristas[] arista){
        int nroNodos=0;
        for(Aristas a : arista){
            if(a.getFin() > nroNodos){
                nroNodos = a.getFin();
            }
            if(a.getInicio() > nroNodos){
                nroNodos=a.getInicio();
            }     
        }
        nroNodos++;
        return nroNodos;
    }
    
    // CALCULAMOS LA DISTANCIA MAS CORTA A TRAVES DEL ALGORITMO DIJKSTRA
    public void distanciaCortaDijkstra(){
        this.nodo[0].setDistancia(0);
        int sgteNodo = 0;
        
        //Visitamos cada nodo, en orden de distancia
        for (int i = 0; i < this.nodo.length; i++) {
            //Bucle alrededor de las aristas que estan unidos al nodo actual
            ArrayList<Aristas> nodosConectados = this.nodo[sgteNodo].getAris();
            for (int  arisUnida = 0;  arisUnida < nodosConectados.size();  arisUnida++) {
                //Determinamos el vecino unido al nodo actual
                int vecino = nodosConectados.get(arisUnida).vecinos(sgteNodo);
                
                //Si el vecino no es visitado
                if(!this.nodo[vecino].isVisitado()){
                    //Calcula la distancia para el vecino
                    int distance = this.nodo[sgteNodo].getDistancia() + nodosConectados.get(arisUnida).getPeso();
                    
                    if(distance < nodo[vecino].getDistancia()){
                        nodo[vecino].setDistancia(distance);
                    }
                }
            }
            
            nodo[sgteNodo].setVisitado(true);
            sgteNodo = getCortaDistancia();          
        }
    }
    
    public int getCortaDistancia(){
        int indexNodo = 0;
        int distancia= Integer.MAX_VALUE;
        
        for (int i = 0; i < this.nodo.length; i++) {
            int obtDist = this.nodo[i].getDistancia();
            if(!this.nodo[i].isVisitado() && obtDist < distancia){
                distancia = obtDist;
                indexNodo =i;
            }
        }
        return indexNodo;
    }
    
    
    @Override
    public String toString() {
        String salida = "Nro de Nodos= " + this.nroNodos;
        salida += "\nNro de Aristas= " + this.nroAristas + "\n";
        for (int i = 0; i < this.nodo.length; i++) {
            salida+= ("La distancia mas corta desde el nodo 0 a el nodo " + i + " es " + nodo[i].getDistancia() + "\n");
        }
        
        return salida;
    }
}


    

