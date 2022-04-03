/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package MetodosNumericos19290965;
import java.util.Scanner;

/**
 *
 * @author Brian
 */

public class NewtonRaphson19290965{
    static Scanner leer = new Scanner(System.in);
    static String polinomio, derivadaPolinomio;
    static boolean flag;
    static double potencia5, potencia4, potencia3, potencia2, potencia1, terminoIndependiente, xInicial;
    static double criterioParo, ea, ua, i, auxUa;
    public static void main(String[]Args){
        datos();
           polinomio = String.valueOf(potencia5 + potencia4 + potencia3 + potencia2 + potencia1 + terminoIndependiente);
        derivadaPolinomio();
        impresiones();
    }//main
    
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
    
    public static void impresiones(){
        System.out.println("|Iteración  |            Raíz          | Error aproximado ");
        System.out.println("----------------------------------------------------------");
        errorAproximado();
        funciones();

    }//impresiones
    
    static void errorAproximado(){
        ea = ((ua - auxUa) / ua) * 100;
    }//error Aproximado
    
    static void derivadaPolinomio(){
        derivadaPolinomio = String.valueOf(potencia5 * 5) + "x^4";
        derivadaPolinomio = derivadaPolinomio + String.valueOf(potencia4 * 4) + "x^3";
        derivadaPolinomio = derivadaPolinomio + String.valueOf(potencia3 * 3) + "x^2";
        derivadaPolinomio = derivadaPolinomio + String.valueOf(potencia2 * 2) + "x";
        derivadaPolinomio = derivadaPolinomio + String.valueOf(potencia1);
    }//derivadaPolinomio
    
    public static double funciones(){
        int conti=0;
    double auxDerF = 1;
        ea = ua;
     while (auxDerF * auxDerF/Integer.parseInt(derivadaPolinomio) > 1) {
        auxDerF = auxDerF - ((auxDerF * auxDerF - Integer.parseInt(derivadaPolinomio)) / (2 * auxDerF));
            conti++;
        System.out.println(("|\t"+conti) +"\t\t\t|"+ ua +"\t\t\t|\t\t"+ ea);
            ua = auxDerF;
        if ((auxDerF * auxDerF) / Integer.parseInt(derivadaPolinomio) == 1)
     break;
     }//while
     System.out.println("");
     if (Math.abs(Integer.parseInt(derivadaPolinomio)) > ea) {
        System.out.println("No hay solucion");
        auxDerF = 0;
     } 
        return auxDerF;
    }//funciones
         public static void datos(){
      //Menu reutilizable polinomios 5to grado
      System.out.println("~-~-~-~-~-~-~- 13 Newton Raphson ~-~-~-~-~-~-~-");
            System.out.println("A continuacion, rellene los campos solicitados");
            System.out.println("Coeficientes del polinomio de hasta 5to grado");
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
            System.out.print("\nValor inicial (x_0): ");
               xInicial = leer.nextInt();
            System.out.print("Criterio de paro: ");
               criterioParo = leer.nextInt();
    }//datos
}//class