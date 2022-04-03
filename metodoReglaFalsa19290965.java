//Brian Osvaldo Vega Rodriguez 19290965
import java.util.*;
public class metodoReglaFalsa19290965{
   static Scanner leer = new Scanner(System.in);
   public static void main(String Args[]){
   double a,b, funcion, funcionA, funcionB, funcionC, c = 0;
   int potencia5, potencia4, potencia3, potencia2, potencia1, terminoIndependiente, it=0;
      
      System.out.println("A continuacion, ingrese los coeficientes de su polinomio de hasta quinto grado: ");
      System.out.print("Coeficiente elevado a la 5: ");
         potencia5 = leer.nextInt();
      System.out.print("Coeficiente elevado a la 4: ");
         potencia4 = leer.nextInt();
      System.out.print("Coeficiente elevado a la 3: ");
         potencia3 = leer.nextInt();
      System.out.print("Coeficiente elevado a la 2: ");
         potencia2 = leer.nextInt();
      System.out.print("Coeficiente elevado a la 1: ");
         potencia1 = leer.nextInt();
      System.out.print("Termino independiente:  ");
         terminoIndependiente = leer.nextInt();
      System.out.println(".*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.*-.");
      System.out.println("Ingrese los limites de la función");
      System.out.print("punto inicial: ");
         a = leer.nextDouble();
      System.out.print("punto final: ");
         b = leer.nextDouble();
         
      funcionA = (potencia5 * elevar(a,5)) + (potencia4 * elevar(a,4)) + (potencia3 * elevar(a,3)) + (potencia2 * elevar(a,2)) + (potencia1 * a) + terminoIndependiente;
      funcionB = (potencia5 * elevar(b,5)) + (potencia4 * elevar(b,4)) + (potencia3 * elevar(b,3)) + (potencia2 * elevar(b,2)) + (potencia1 * b) + terminoIndependiente;     
       
      if(funcionA * funcionB > 0){
         System.out.println("ERROR, no se cumple la condicion f(a) * f(b) < 0 ");
         return;
      }//if
      while(1 > 0){
         c = ((funcionB * a) - (funcionA * b)) / (funcionB - funcionA);
      funcionC = (potencia5 * elevar(c,5)) + (potencia4 * elevar(c,4)) + (potencia3 * elevar(c,3)) + (potencia2 * elevar(c,2)) + (potencia1 * c) + terminoIndependiente;     
         if(funcionC <= 1e-10){
            System.out.println("Raiz aproximada: " + c);
            //System.out.println("Vlor de la funcion en la raiz: " + funcionC);
            return;
         }//if
         if(funcionA * funcionC < 0){
            b = c;
         }else{
            a = c;
         }//else
         it++;
      System.out.println("Iteracion: " + it);
      System.out.println("resultados; " + c);
      }//while

   }//main
   
    public static double elevar(double num, int potencia){
        double a = num;
        if(potencia == 0){
            return 1;
        }
        while(potencia != 1){
            num = num * a;
            potencia--;
        }
        return num;
    }
}//class