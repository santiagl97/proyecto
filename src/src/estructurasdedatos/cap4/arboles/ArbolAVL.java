/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap4.arboles;

import estructurasdedatos.utiles.nodos.NodoArbolAVL;

/**
 *
 * @author santiago londoño rojas
 */
public class ArbolAVL {
        private NodoArbolAVL raiz;
    
    public ArbolAVL(){
        this.raiz = null;
    }
    
    
    public NodoArbolAVL obtRaiz() {
        return raiz;
    }
    
    
    public NodoArbolAVL Buscar(int d, NodoArbolAVL n){  //metodo de buscar
        if(getRaiz()==null){
            return null;
        }else
            if(n.getDato()==d){
                return n;
            }else
                if(n.getDato()<d){
                    return Buscar(d,n.getHijoDer());
                }else{
                    return Buscar(d,n.getHijoIzq());
                }      
    }
    
    

public int Fe(NodoArbolAVL d){
    if(d==null){
        return -1;
    }else{
        return d.getFe();
    }
}

    
    public NodoArbolAVL insertarN(NodoArbolAVL nuevo, NodoArbolAVL subArbol) {
        NodoArbolAVL padre = subArbol;
        System.out.print(" Dato = " + nuevo.getDato());

        if (subArbol == null) {
            System.out.println("Creando Hijo = ");
            subArbol = nuevo;
            return subArbol;
        } else {
            System.out.println("  //  SubArbol = " + subArbol.getDato());
        }
        if (nuevo.getDato() < subArbol.getDato()) {
            System.out.println("");
            System.out.println("-------- Dato Menor Que Raiz ------- ");
            if (subArbol.getHijoIzq()== null) {
                subArbol.setHijoIzq(nuevo);
            } else {
                subArbol.setHijoIzq(insertarN(nuevo, subArbol.getHijoIzq()));
                if ((Fe(subArbol.getHijoIzq()) - Fe(subArbol.getHijoDer()) == 2)) {
                    if (nuevo.getDato() < subArbol.getHijoIzq().getDato()) {
                        padre = rotarII(subArbol);
                    } else {
                        padre = rotarID(subArbol);
                    }
                }
            }
            return subArbol;
        } else 
            if (nuevo.getDato() > subArbol.getDato()) {
            if (subArbol.getHijoDer()== null) {
                subArbol.setHijoDer(nuevo);
            } else {
                subArbol.setHijoDer(insertarN(nuevo, subArbol.getHijoDer()));
                if ((Fe(subArbol.getHijoDer()) - Fe(subArbol.getHijoIzq()) == 2)) {
                    if (nuevo.getDato() > subArbol.getHijoDer().getDato()) {
                        padre = rotarDD(subArbol);

                    } else {
                        padre = rotarDI(subArbol);
                    }
                }
            }
            return subArbol;

        } else {
            System.out.println("El Nodo ya Existe");
        }
        if ((subArbol.getHijoIzq()== null) && (subArbol.getHijoDer()!= null)) {
            subArbol.setFe(subArbol.getHijoDer().getFe() + 1);
        } else 
            if ((subArbol.getHijoDer()== null) && (subArbol.getHijoIzq()!= null)) {
            subArbol.setFe(subArbol.getHijoIzq().getFe() + 1);
        } else {
            subArbol.setFe(Math.max(Fe(subArbol.getHijoIzq()), Fe(subArbol.getHijoDer())) + 1);
        }
        return padre;
    }

    public void insertar(int i) {
        NodoArbolAVL aux = new NodoArbolAVL(i);
        if (this.getRaiz() == null) {
            this.setRaiz(aux);
            System.out.println("Raiz Creada");
        } else {
            this.setRaiz(insertarN(aux, this.getRaiz()));
        }
    }
    
    public void Orden(NodoArbolAVL n) {
        if (n != null) {
            Orden(n.getHijoIzq());
            System.out.print(n.getDato() + "\\");
            Orden(n.getHijoDer());
        }
    }
    
    
    public boolean eliminar(int dato) {
        NodoArbolAVL temp = null;
        NodoArbolAVL aux = (Buscar(dato, raiz));
        if (Buscar(dato, raiz) != null) {
            if ((aux.getHijoIzq()== null) && (aux.getHijoDer()== null)) {
                aux = null;
            } else {
                if ((aux.getHijoIzq()!= null) && (aux.getHijoDer()!= null)) {
                    if (aux == raiz) {
                        temp = aux.getHijoIzq();
                        aux = aux.getHijoDer();
                        while (aux.getHijoIzq()!= null) {
                            aux = aux.getHijoIzq();
                        }
                        aux.setHijoIzq(temp);
                    } else {
                        if (aux == raiz) {
                            if (aux.getHijoIzq()!= null) {
                                aux = aux.getHijoDer();
                            } else {
                                aux = aux.getHijoDer();
                            }
                        } else {
                            if (aux.getHijoIzq()!= null) {
                                aux = aux.getHijoIzq();
                            } else {
                                aux = aux.getHijoIzq();
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
    
 
    
    public NodoArbolAVL rotarII(NodoArbolAVL n) {
        NodoArbolAVL aux = n.getHijoIzq();
        n.setHijoIzq(aux.getHijoDer());
        aux.setHijoDer(n);
        n.setFe(Math.max(Fe(n.getHijoIzq()), Fe(n.getHijoDer())) + 1);
        aux.setFe(Math.max(Fe(aux.getHijoIzq()), Fe(aux.getHijoDer())) + 1);
        return aux;
    }

    public NodoArbolAVL rotarDD(NodoArbolAVL n) {
        NodoArbolAVL aux = n.getHijoDer();
        n.setHijoDer(aux.getHijoIzq());
        aux.setHijoIzq(n);
        n.setFe(Math.max(Fe(n.getHijoIzq()), Fe(n.getHijoDer())) + 1);
        aux.setFe(Math.max(Fe(aux.getHijoIzq()), Fe(aux.getHijoDer())) + 1);
        return aux;
    }

    public NodoArbolAVL rotarID(NodoArbolAVL n) {
        NodoArbolAVL aux;
        n.setHijoIzq(rotarDD(n.getHijoDer()));
        aux = rotarII(n);
        return aux;
    }

    public NodoArbolAVL rotarDI(NodoArbolAVL n) {
        NodoArbolAVL aux;
        n.setHijoDer(rotarII(n.getHijoDer()));
        aux = rotarDD(n);
        return aux;
    }

        
    /**
     * @return the raiz
     */
    public NodoArbolAVL getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoArbolAVL raiz) {
        this.raiz = raiz;
    }
}