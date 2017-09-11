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
public class Condicionales { //metodos
    
    public Condicionales () {}
    
    public void numerosahastab () {
        int num1, num2, x;
        
        System.out.println("intruduzca primer numero: ");
        Scanner n= new Scanner (System.in);   
        num1=n.nextInt();
        
        System.out.println("introduzca segundo numero: ");
        num2=n.nextInt();
        
        if (num1>num2) {
            System.out.println("los valores introducidos no son correctos");
            
        } else {
            
            for(x=num1; x<=num2; x++){
                System.out.println(x);
            }
        }
        
     }
        
   public void numerosparesahastab (){ 
       int num1, num2, x;
       System.out.println("introduzca primer numero: ");
       Scanner p= new Scanner (System.in);
       num1=p.nextInt();
       
       System.out.println("introduzca segundo numero: ");
       num2=p.nextInt();    
            
       if(num1>num2){
           System.out.println("los valores introducidos no son correctos");
             } else {
           for(x=num1;x<num2;x++){
               if(x%2==0){
                   System.out.println(x);
               }
           }
       }
   }
   
   public void multiplicacionahastab(){
       int num1,num2,x, sum=0;
       System.out.println("introduzca primer numero: ");
       Scanner m= new Scanner (System.in);
       num1=m.nextInt();
       
       System.out.println("introduzca segundo numero: ");
       num2=m.nextInt();    
            
       if(num1>num2){
           System.out.println("los valores introducidos no son correctos");
       }else {
           sum=1;
           for(x=num1; x<=num2;x++){
               sum=sum*x;
           }
       }
       System.out.println(sum);
   }
   
 }
