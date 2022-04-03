//Brian Osvaldo Vega Rodriguez 19290965
import java.util.*;
public class metodoBiseccionV3{

      static Scanner leer = new Scanner(System.in);

   public static void main(String[]args){
      int contX = 5, contArreglo = 5;
      int iteraciones = 1, filtro = 1;
      int polinomio[] = new int[contX+1];
      double funcionSustituidaX1 = 0, funcionSustituidaX2 = 0, nuevaFuncion = 0, anterior = 0, ea = 0, va = 0;
      double intervaloInicial, intervaloFinal, medio;
      
      System.out.println("~.~ Metodo de biseccion para polinomios de 5to grado ~.~");
      while(contX != 0){
         System.out.print("\nIngrese el coeficiente para x^"+contX+": ");
         polinomio[contX] = leer.nextInt();
         contX--;      
      }//while
      System.out.print("\nIngrese el termino independiente: ");
         polinomio[contX] = leer.nextInt();
         
      System.out.println("\nIngrese el valor del Intervalo para X: ");
      System.out.print("\nValor inicial: ");
         intervaloInicial = leer.nextDouble();
      System.out.print("\nValor final: ");
         intervaloFinal = leer.nextDouble();
      
      contX = 5;
      while(contX != 0){
      funcionSustituidaX1 = polinomio[contX] * elevar(intervaloInicial, contX);
      funcionSustituidaX2 = polinomio[contX] * elevar(intervaloFinal, contX);
         contX--;      
      }//while
      
      if(funcionSustituidaX1 * funcionSustituidaX2 < 0){//paso1
         do{
            System.out.println("Interacion ["+(iteraciones)+"]: ");
            medio = (intervaloInicial + intervaloFinal) / 2;
            if(medio == 0){//raiz encontrada
               System.out.println("La raíz está en: "+medio);
               filtro = 0;
               break;
            }//if medio
               contX = 5;
               while(contX != 0){
               nuevaFuncion = polinomio[contX] * elevar(medio, contX);
               funcionSustituidaX1 = polinomio[contX] * elevar(intervaloInicial, contX);
               funcionSustituidaX2 = polinomio[contX] * elevar(intervaloFinal, contX);
                  contX--;      
               }//while
               System.out.println("f(x1) = " + funcionSustituidaX1 + "x1 = " + intervaloInicial);  
               System.out.println("f(x2) = " + funcionSustituidaX2 + "x2 = " + intervaloFinal);
               System.out.println("f(xm)  = " + medio + " xm = " + nuevaFuncion);
                  anterior = ea;
                  ea = medio;
                  ea = ((ea - va) / ea) * 100;
               System.out.println("error aproximado (ea) = "+ ea);
               if(funcionSustituidaX1 * nuevaFuncion >  0){
                    intervaloInicial = medio;   funcionSustituidaX1 = nuevaFuncion;
               }
               else 
                   if(funcionSustituidaX1 * nuevaFuncion <  0)
   			          if(funcionSustituidaX1 * nuevaFuncion == 0){
                          System.out.println("raiz = " + medio);
                           filtro = 0;
                        }//if
           iteraciones++;
           }while(filtro == 1);
           }//If intervalo validado
           else
           		System.out.println("¡¡ ERROR !! el intervalo proporcionado no es correcto ");
   }//main
       public static double elevar(double i, int potencia){
        double aux = i;
            if(potencia == 0)
                return 1;
            while(potencia != 1){
                i = i * aux;
                potencia--;
            }
        return i;
    }
}//class