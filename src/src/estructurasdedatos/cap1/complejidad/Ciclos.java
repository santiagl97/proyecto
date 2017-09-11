/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.cap1.complejidad;

import java.util.Scanner;

/**
 *
 * @author tusk
 */
public class Ciclos {
    
public Ciclos () {}

public void numerospares1hasta100 (){
    int x,sum=0,cont=0;
    for(x=1;x<=100;x++){
        if(x%2==0){
            sum=sum+x;
            cont=cont+1;
        }
    }
    System.out.println(cont);
    System.out.println(sum);
    
}

public void numerosimpares1hasta100 (){
    int x,sum=0,cont=0;
    for(x=1;x<=100;x++){
        if(0!=x%2){
            sum=sum+x;
            cont=cont+1;
        }
    }
    System.out.println(cont);
    System.out.println(sum);
    
}

public void mostrar1hasta100 (){
    int x;
    for(x=100;x>=1;x--){
        System.out.println(x);
        }
    }

public void numeroasteriscos(){
    int num1, x;
    System.out.println("introduzca un numero: ");
    Scanner a= new Scanner (System.in);   
    num1=a.nextInt();
    
    for(x=0; x<num1; x++){
        System.out.println("*");
    }
    
}

}
