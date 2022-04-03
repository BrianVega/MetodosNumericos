//Brian Osvaldo Vega Rodríguez 19290965w
import java.util.*;
public class primeraSegundaDerivada19290965{
   static Scanner leer = new Scanner(System.in);     
   static float x0=0, x1=0, x2=0, x3=0, x4=0, y0=0, y1=0, y2=0, y3=0, y4=0, d1=0, d2=0, hConstante=0;
   public static void main(String[]Args){
  int opc;
   System.out.println("99 SW Prog. de diferenciación para h constante");
   System.out.print("incremento h: ");
   hConstante = leer.nextInt();
   for(int x=0; x<5; x++){
      System.out.print("\nx"+x+": ");
      switch(x){
         case 0:
            x0 = leer.nextFloat();
            System.out.print("Y: "); 
            y0 = leer.nextFloat(); 
         break;
         case 1:
            x1 = leer.nextFloat();
            System.out.print("Y: "); 
            y1 = leer.nextFloat(); 
         break;
         case 2:
            x2 = leer.nextFloat();
            System.out.print("Y: "); 
            y2 = leer.nextFloat(); 
         break;
         case 3:
            x3 = leer.nextFloat();
            System.out.print("Y: "); 
            y3 = leer.nextFloat(); 
         break;
         case 4:
            x4 = leer.nextFloat();
            System.out.print("Y: "); 
            y4 = leer.nextFloat(); 
         break;
      }//switchCase

   }//for X  
   System.out.println("Valor de X para las derivadas ");
   System.out.println("x0: "+x0);
   System.out.println("x1: "+x1);
   System.out.println("x2: "+x2);
   System.out.println("x3: "+x3);
   System.out.println("x4: "+x4); 
   System.out.print("Opcion: ");
      opc = leer.nextInt();    
   funciones(opc);
   }//main
   
   static void funciones(int opc){           
         switch(opc){
            case 1:
                  d1 = (-(y2) + 4 * (y1) - 3 * (y0)) / 2 * hConstante;
                  d2 = (-(y3) + 4 * (y2) - 5 * (y1) + 2 * (y0)) / (hConstante * hConstante);
            break;
            case 2:
                  d1 = (-(y3) + 4 * (y2) - 3 * (y1)) / 2 * hConstante;
                  d2 = (-(y4) + 4 * (y3) - 5 * (y2) + 2 * (y1)) / (hConstante * hConstante);
            break;
            case 3:
                  d1 = (-(y4) + 8 * (y3) - 8 * y1 + y0) / (12 * hConstante);
                  d2 = (-(y4) + 16 * (y3) - 30 * (y2) + 16 * (y1) - y0) / (12 * (hConstante * hConstante));
            break;
            case 4:
                  d1 = (3 * (y3) - 4 * (y2) + y1) / (2 * hConstante); 
                  d2 = (2 * y3 - 5 * (y2) + 4 * (y1) - y0) / (hConstante*hConstante);
            break;
            case 5:
                  d1 = (3 * (y4) - 4 * (y3) + y2) / (2 * hConstante); 
                  d2 = (2 * y4 - 5 * (y3) + 4 * (y2) - y1) / (hConstante*hConstante);
            break;
         }//switch opc  
         System.out.println(".-.-.-.-.-.-.-. R E S U L T A D O S .-.-.-.-.-.-.-.-.-.");
         System.out.println("Primera derivada: " + d1);
         System.out.println("Segunda derivada: " + d2);
         }//funciones 
}//class