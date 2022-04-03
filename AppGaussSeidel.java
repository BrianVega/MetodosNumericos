//Brian Osvaldo Vega Rodríguez - 19290965
//package MetodosNumericos19290965

import java.util.Scanner;

public class GaussSeidel19290965 {
    static Scanner leer = new Scanner(System.in);
    static double eAux = 0;
    private static double[][] matriz;
    private static int filas, columnas, maxIteraciones;
    private static double[] matrizIncognitas;
    private static double error;

    public static void main(String[] args) {
        System.out.println("~-~-~-~-~-~-~- 16 Gauss-Seidel ~-~-~-~-~-~-~-");
        System.out.print("Cantidad de filas: ");
            filas = leer.nextInt();
        System.out.print("Cantidad de columnas: ");
            columnas = leer.nextInt();
           matrizIncognitas = new double[columnas];
           matriz = new double[filas][columnas + 1];
        System.out.print("\nCriterio de paro [%]: ");
           error = Math.abs(leer.nextDouble());
        System.out.print("Cantidad máxima de iteraciones: ");
           maxIteraciones = leer.nextInt();
        System.out.println("\nIngrese los valores iniciales de las incógnitas (En caso de no ingresar, se tomará por defecto el 0):");
        for (int i = 0; i < columnas; i++){
            System.out.print("x" + (i + 1) + ": ");
               matrizIncognitas[i] = leer.nextDouble();
        }//for i
        for (int i = 0; i < filas; i++){
            System.out.println("\n-----------------------------------------------------");
            System.out.println("\nFila " + (i + 1) + " ");
            for (int j = 0; j < columnas; j++){
                System.out.print("x" + (j + 1) + " = ");//coeficientes
                  matriz[i][j] = leer.nextDouble();
            }//for j
            System.out.print("Resultado" + (i + 1) + " = ");
                  matriz[i][columnas] = leer.nextDouble();
            System.out.println("\n-----------------------------------------------------");
        }//for i

         funciones();//metodo
         impresiones(); // imprimir valores finales
    }//main

    public static void funciones() {
        double [] valoresAnteriores = new double[columnas];
        int cont = 1;

        System.out.print("| Iteración\t\t\t");
        for (int f = 1; f <= columnas; f++) {
            System.out.print("| x" + f + "\t\t\t");
        }//forf        
        System.out.print("| Error aproximado\t|\n");
        
        do {
            System.out.print(cont + "\t\t\t\t");
            for (int g = 0; g < columnas; g++) {
                System.out.print(String.format("%.3f", matrizIncognitas[g]) + "\t\t");
            }//forg
               System.out.print(String.format("%.3f", eAux));
               cont++;
               ///////////Checar tabulacion otra vez
            eAux = 0;
            for (int h = 0; h < filas; h++){
                valoresAnteriores[h] = matrizIncognitas[h]; // Valores anteriores
            }//forh
            
               //Diagonales
            for (int i = 0; i < filas; i++) {
                matrizIncognitas[i] = matriz[i][matrizIncognitas.length];
                for (int j = 0; j < columnas; j++) {
                    if (j == i) {
                        continue;
                        //break;
                    }//if
                    matrizIncognitas[i] = matrizIncognitas[i] - (matriz[i][j] * matrizIncognitas[j]);
                }//forj

                matrizIncognitas[i] = matrizIncognitas[i] / matriz[i][/*j*/i];

                eAux += Math.abs(Math.abs(matrizIncognitas[i]) - Math.abs(valoresAnteriores[i]));//Formula errorr
            }//for i matriz
            System.out.println();
        } while (eAux > error);

        System.out.print(cont + "\t\t\t\t");
        for (int g = 0; g < columnas; g++) {
            System.out.print(String.format("%.3f", matrizIncognitas[g]) + "\t\t");//renglon final
        }//forg
        
        System.out.println(String.format("%.3f", eAux));
        System.out.println("\n-----------------------------------------------------");

    }//funciones

    public static void impresiones() {
        System.out.println("--------------------- Resultados ---------------------");
        for (int i = 0; i < columnas; i++) {
            System.out.println("Variable " + (i + 1) + ": " + String.format("%.3f", matrizIncognitas[i]));
        }//fori
            System.out.println("Error aproximado alcanzado: " + eAux);
    }//impresiones
}//class