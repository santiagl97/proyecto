/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap3.mapas;

/**
 *
 * @author santiago londoño rojas
 */
public class Diccionario<c, v> {

    Mapa<c, v> primero = new Mapa<>(); //instancio-creo nuevo mapa 

    public boolean Vacio() {
        return primero.getClave() == null;
    }

    public void agregar(c clave, v valor) {
        Mapa<c, v> nuevo = new Mapa<>(clave, valor);
        if (Vacio()) {
            this.primero.setClave(clave);
            this.primero.setValor(valor);
        } else {
            Mapa<c, v> aux = this.primero;
            while (aux.getSiguiente() != null) {
                if (aux.getClave() == clave) {

                    aux.setValor(valor);
                } else {
                    aux = aux.getSiguiente();
                }

            }
            aux.setSiguiente(nuevo);
        }
    }

    public void listar() {
        if (!Vacio()) {
            Mapa<c, v> aux = this.primero;
            while (aux != null) {
                System.out.println(aux.getClave() + ":" + aux.getValor());
                aux = aux.getSiguiente();
            }

        } else {
            System.out.println("no hay nada para mostrar");
        }
    }

    public void valorporclave(c clave) {

        if (primero.getClave() == clave) {
            System.out.println(primero.getClave() + ":" + primero.getValor());
        } else {
            Mapa<c, v> aux = this.primero;
            while (aux != null) {
                if (aux.getClave() == clave) {
                    System.out.println(aux.getClave() + ":" + aux.getValor());
                }
                aux = aux.getSiguiente();
            }
        }
    }

    public void eliminar(c clave) {
        if (primero.getClave() == clave) {
            primero = primero.getSiguiente();
        } else {
            Mapa<c, v> aux = this.primero;

            while (aux.getSiguiente().getClave() != clave) {
                aux = aux.getSiguiente();
            }
            Mapa<c, v> sigte = aux.getSiguiente().getSiguiente();
            aux.setSiguiente(sigte);
        }
    }

}
