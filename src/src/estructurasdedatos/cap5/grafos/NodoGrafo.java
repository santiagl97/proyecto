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
public class NodoGrafo {
    private int distancia = Integer.MAX_VALUE;
    private boolean visitado = false;
    private ArrayList<Aristas> aris = new ArrayList<Aristas>();

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public ArrayList<Aristas> getAris() {
        return aris;
    }

    public void setAris(ArrayList<Aristas> aris) {
        this.aris = aris;
    }
            
    
}
