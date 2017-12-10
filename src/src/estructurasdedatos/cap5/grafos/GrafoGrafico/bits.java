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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class bits implements Serializable {
    

    //private String ruta_archivo = "e:/temporal/archivo.xaviselacome";
      


    public void escribir(String ruta_archivo)
    {
        
        try {
            //Objeto a guardar en archivo *.DAT
            VentanaPrincipal clase = new VentanaPrincipal();
            //Se crea un Stream para guardar archivo
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(ruta_archivo+".xaviselacome"));
            //Se escribe el objeto en archivo
            file.writeObject(clase);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void leer(String ruta_archivo)
    {
        try {
            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(ruta_archivo ));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            VentanaPrincipal clase = (VentanaPrincipal) file.readObject();
            //se cierra archivo
            file.close();
            //Se utilizan metodos de la clase asi como variables guardados en el objeto
            //System.out.println("El objeto se llama:" +  clase.getNombreObjeto() );
            //String res = String.valueOf(clase.Suma(234, 12)) ;
            //System.out.println("La suma de 3 + 12 es igual a : " + res);
        } catch (ClassNotFoundException ex) {
             System.out.println(ex);
        } catch (IOException ex) {
             System.out.println(ex);
       }
    }

}