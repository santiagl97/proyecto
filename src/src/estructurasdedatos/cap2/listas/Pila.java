/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap2.listas;

import estructurasdedatos.cap1.tiposdedatos.Persona;
import estructurasdedatos.utiles.nodos.NodoPila;

/**
 *
 * @author santiago londoño rojas
 */
public class Pila {
      
public Persona dato;
    public NodoPila tope;
    public NodoPila fondo;

    /**
     * @return the dato
     */
    public Persona getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Persona dato) {
        this.dato = dato;
    }

    public Pila() {
        dato = null;

    }

    public boolean esVacia() {
        return tope == null;
    }

    // String nombre, String cedula,String telefono, String direccion
    
    public void apilar(String nombre, String telefono, String cedula, String direccion) {

        NodoPila nuevo = new NodoPila();
        Persona newper = new Persona();
        newper.setCedula(cedula);
        newper.setNombre(nombre);
        newper.setTelefono(telefono);
        newper.setDireccion(direccion);
        
        nuevo.setDato(newper);
        if (esVacia()) {
            tope = nuevo;
        } else {
            nuevo.setSiguiente(tope);
            tope = nuevo;
        }

    }

    public void listar() {
        if (!(tope == null)) {
            NodoPila aux = tope;
            System.out.println("DATOS DE LA PILA ");
            while (aux != null) {

                System.out.println("[" + aux.getDato().getNombre() + " " + aux.getDato().getTelefono() + " "
                        + aux.getDato().getCedula() + " " + aux.getDato().getDireccion() + " " + "]");

                aux = aux.getSiguiente();
            }
        }

    }

    public void desapilar() {
        if (esVacia()) {
            System.out.println("Pila Vacia ");
        } else {
            System.out.println("eliminado" + "[" + tope.getDato().getNombre() + " " + tope.getDato().getTelefono() + " "
                    + tope.getDato().getCedula() + " " + tope.getDato().getDireccion() + " " + "]");

            tope = tope.siguiente;

        }
    }

}

