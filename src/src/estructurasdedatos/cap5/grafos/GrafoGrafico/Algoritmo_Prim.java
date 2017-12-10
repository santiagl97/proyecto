/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap5.grafos.GrafoGrafico;

/**
 *
 * @author Santiago
 */
import java.awt.Color;
import java.io.Serializable;

public class Algoritmo_Prim implements Serializable{
    
    private int cumulado;
   private int aristaMenor;
   private int  fin;
   private boolean estaNodo=false;
   private boolean aumentaTamano;
   private int nodoApuntado;  
   private int nodoApuntador;
   private int tamano;
   private int arsitaMayor;
   private  Arboles arboles;
   private int tope;
   private  int  nodoOrigen;
   
   
   
   public Algoritmo_Prim(Arboles arbol , int top ,int aristaMayor ){
       this.cumulado = 0;
       this.aristaMenor = 0;
       this.fin = 0;
       this.estaNodo=false;
       this.aumentaTamano = false;
       this.nodoApuntado = 0;  
       this.nodoApuntador = 0;
       this.tamano = 1;
       this. arsitaMayor=aristaMayor;
       this.arboles = arbol;
       this.tope = top;
   }

    public int getCumulado() {
        return cumulado;
    }
  
   
  public void prim(){
      this.nodoOrigen= ingresarNodoOrigen("Ingrese Nodo Origen..","nodo Origen No existe",tope);
       PrincipalWindow.paint(PrincipalWindow.getGraphics());
       R_repaint(tope,arboles);
       arboles.crearEnArbol(tope);
       arboles.setEnArbol(0, nodoOrigen);
       //algoritmo de Prim ---->>
       do{
           this.aristaMenor = this.arsitaMayor;
           this.fin=2;
            for (int j = 0; j < tamano; j++) {
                for (int k = 0; k < tope; k++){
                    if(arboles.getmAdyacencia(k, arboles.getEnArbol(j))==1){
                        for (int h = 0; h < tamano; h++) {
                             if(arboles.getEnArbol(h)==k ){
                                 this.estaNodo=true; 
                                 break;
                             }
                        }
                        if(estaNodo==false){
                            if(arboles.getmCoeficiente(k, arboles.getEnArbol(j))<=aristaMenor && arboles.getmCoeficiente(k, arboles.getEnArbol(j))>0 ){
                                 aristaMenor=arboles.getmCoeficiente(k, arboles.getEnArbol(j));
                                 this.nodoApuntado=k;
                                 this.aumentaTamano=true;
                                 this.nodoApuntador=arboles.getEnArbol(j);
                                 this.fin=1;
                            }
                        }
                        this.estaNodo=false;
                    }
                }
            }//fin  for (int j = 0; j < tamano; j++)              
         if(aumentaTamano==true){
                    Pintar.pintarCamino(PrincipalWindow.getGraphics(),arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador),arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado),Color.red); 
                    Pintar.clickSobreNodo(PrincipalWindow.getGraphics(),arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador), null,Color. red);
                    Pintar.clickSobreNodo(PrincipalWindow.getGraphics(),arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado), null, Color.red);                                  
                    arboles.setEnArbol(tamano, nodoApuntado);
                    this.tamano++;
                    this.aumentaTamano=false;
                    this.cumulado += this.aristaMenor;
         }
        }while(fin<2);
   }
    
}    

