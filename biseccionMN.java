import java.util.*;
public class biseccionMN{
   static Scanner leer = new Scanner(System.in);
   public static void main(String[]args){
      String caracteresValidos[] = {"(",")","+","-","/","*","^"};
      int num, contIteraciones = 1;
      boolean boolEntradaValida = false;;
      String polinomio[] = new String[99], auxPolinomio, polinomioCadena = " ";
      String auxPolinomioCadena = " ";
      
      System.out.println("~~~~~~ Resolucion de polinomios mediante el metodo de biseccion ~~~~~~");
      System.out.println("Ingrese a continuación su polinomio, apoyandose tanto de paréntesis [()]\n como de signos [+ , - , / , *]\n o potencias [^]");
      for(int x=0; x<= contIteraciones; x++)
         if(polinomio[x] == "^" && polinomio[x+1] == "1"){
                     System.out.print("Entrada finalizada");
            break;
         }//IF
         else{
            if(contIteraciones > 1){
               for(int i=0; i<= contIteraciones; i++)
                  auxPolinomioCadena = polinomio[i];
                  polinomioCadena = polinomioCadena + auxPolinomioCadena;
               System.out.println("El polinomio hasta  ahora se encuentra formado por: " + polinomio[contIteraciones-1] + " +x^5");
            }
            System.out.println("Polinomio: ");      
            auxPolinomio = leer.nextLine();
            do{
            for(int n=0; n<caracteresValidos.length; n++)
1
1
               )){
                  System.out.println("Entrada no válida, ingresela de nuevo, recuerde los caracteres permitidos\n [(, ), +, -, /, *, ^");
                     auxPolinomio = leer.nextLine();
                     boolEntradaValida = false;
               }
               else{
                  boolEntradaValida = true;
                  polinomio[contIteraciones-1] = auxPolinomio;
                  contIteraciones++;
                  break;
               }
           }while(boolEntradaValida != true);
         }//else
   }//main
}//class