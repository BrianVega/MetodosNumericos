//Brian Osvaldo Vega Rodríguez - 19290965 - 4B
import java.util.Scanner;
public class Sw11ProgramaIncrementos19290965{
    static Scanner leer = new Scanner(System.in);
    static boolean flag = false;
    static int  factorDivision, flaux = 1;
    static double xInicial, errorAproximado=0, auxErrorAproximado=0, deltaX, valorFuncionX = 0, potencia5, potencia4, potencia3, potencia2, potencia1, terminoIndependiente; //variables reutilizable polinomios 5to grado
       public static void main(String args[]){
            
            datos();        
            do{
                valorFuncionX = (potencia5 * potencia(xInicial,5) + potencia4 * potencia(xInicial,4) + potencia3 * potencia(xInicial,3) + potencia2 * potencia(xInicial,2) + potencia1 * xInicial + terminoIndependiente);
                   System.out.println("f(x): "+valorFuncionX);
                   System.out.println("Delta X:"+deltaX);
                   System.out.println("X: "+xInicial);
                
                   auxErrorAproximado = errorAproximado;
                   errorAproximado = xInicial;
                   errorAproximado = (errorAproximado - (auxErrorAproximado/errorAproximado) * 100);
                   System.out.println("Error aproximado: "+errorAproximado);
                   System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
                if(errorAproximado < 1 && errorAproximado > -1){
                        System.out.println("\nRaiz: "+xInicial);
                        flaux = 0;
                }// if ea

                if(valorFuncionX < 0)
                        xInicial =  xInicial + deltaX;
                else if(valorFuncionX == 0){
                        System.out.println("Raiz: "+ xInicial + " f(x): "+ valorFuncionX);
                           auxErrorAproximado = errorAproximado;
                           errorAproximado = xInicial;
                           errorAproximado = ((errorAproximado - auxErrorAproximado)/errorAproximado) * 100;
                        System.out.println("Error aproximado = " + errorAproximado);
                           flaux = 0;
                }else{
                        xInicial = xInicial - deltaX;
                        deltaX = deltaX / factorDivision;
                }//else
        }while(flaux != 0);     
    }//main method
    public static double potencia(double numero, int potencia){ 
        double aux = numero;
        if(potencia == 0){
                return 1;
        }
        while(potencia != 1){
            numero = numero * aux;
            potencia--;
        }//while
        return numero;
    }//potencia - elevar potencias
    public static void datos(){
      //Menu reutilizable polinomios 5to grado
      System.out.println("~-~-~-~-~-~-~- 11 SW Programa de incrementos ~-~-~-~-~-~-~-");
            System.out.println("A continuacion, rellene los campos solicitados: ");
            System.out.println("Coeficientes del polinomio de hasta 5to grado: ");
            System.out.print("Coeficiente elevado a la 5: ");
               potencia5 = leer.nextDouble();
            System.out.print("Coeficiente elevado a la 4: ");
               potencia4 = leer.nextDouble();
            System.out.print("Coeficiente elevado a la 3: ");
               potencia3 = leer.nextDouble();
            System.out.print("Coeficiente elevado a la 2: ");
               potencia2 = leer.nextDouble();
            System.out.print("Coeficiente elevado a la 1: ");
               potencia1 = leer.nextDouble();
            System.out.print("Termino independiente:  ");
              terminoIndependiente = leer.nextDouble();
            System.out.print("\nAproximacion inicial (x_0): ");
               xInicial = leer.nextInt();
            System.out.print("Valor del factor de división (q): ");
               factorDivision = leer.nextInt();
               
            do{
               System.out.print("Incremento inicial (DeltaX > 2): ");
                  deltaX = leer.nextInt();
               if(deltaX > 2)
                  flag = true;
               else
                  System.out.println("\nERROR, valor de Delta X debe ser mayor a 2 ");
            }while(flag = false);
    }//datos
}//class