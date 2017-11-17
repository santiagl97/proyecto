/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap2.arreglos;

/**
 *
 * @author santiago londoño rojas
 */
public class Vector {

    private int tamaño;
    private String[] vector;

    //crear un vector
    public void crearVector(int tam) {
        this.tamaño = tam;
        if (this.vector == null) {
            this.vector = new String[this.tamaño];
        } else {
            System.out.println("No se puede crear vector");
        }

    }

    //insertar 
    public void insertar(int pos, String dato) {
        if (pos < tamaño) {
            vector[pos] = dato;
        } else {
            System.out.println("Posicion No Valida");
        }
    }

    //borrar
    public void borrar(int pos) {
        vector[pos] = "";
    }

    //listar
    public void listar() {
        if (this.vector == null) {
            System.out.println("vector vacio");
        } else {
            for (int i = 0; i < tamaño; i++) {
                System.out.println(i + "." + vector[i]);
            }
        }
    }

}
