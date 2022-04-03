//Brian Osvaldo Vega Rodriguez - 19290965 
import java.util.*;
public class GaussJordan2 {
   static Scanner leer = new Scanner(System.in); 

    public static void main(String args[]) {
        Scanner leer = new Scanner(System.in);
        int aux = 0, pivote = 0;
        float matriz[][];
        System.out.println("~.~.~.~.~.~.~.~.~.~ programa para el método de Gauss-Jordan ~.~.~.~.~.~.~.~.~.~");
        System.out.print("\nCantidad de variables del sistema: ");
        aux = leer.nextInt();
        matriz = new float[aux][aux + 1];
        for (int x = 0; x < aux; x++) {
            System.out.println("");
            for (int y = 0; y < (aux + 1); y++) {
                System.out.print("Columna " + (x+1) + ", x" + (y+1) + " : "); 
                matriz[x][y] = leer.nextFloat();
            }//for y
        }//for x

        for (int i = 0; i < aux; i++) {
            pivote(matriz, pivote, aux);

            System.out.println("\tRenglon " + (i + 1) + " entre el pivote");
            imprimir(matriz, aux);

            System.out.println("");

            System.out.println("\tHaciendo ceros");
            reducir(matriz, pivote, aux);

            imprimir(matriz, aux);
            System.out.println("");
            pivote++;
        }//for a
        System.out.println("\n ~.~.~.~.~.~.~.~.~ R E S U L T A D O S ~.~.~.~.~.~.~.~.~");
        for (int x = 0; x < aux; x++) {
            System.out.println("La variable X" + (x + 1) + " es: " + matriz[x][aux]);
        }//for x
    }//main

    static void imprimir(float matriz[][], int aux) {
        for (int x = 0; x < aux; x++) {
            for (int y = 0; y < (aux + 1); y++) {
                System.out.print(" " + matriz[x][y] + " |");
            }//for y
            System.out.println("");
        }//for x
    }//imrpimir

    static void pivote(float matriz[][], int pivote, int aux) {
        float temp = 0;
        temp = matriz[pivote][pivote];
        for (int y = 0; y < (aux + 1); y++) {

            matriz[pivote][y] = matriz[pivote][y] / temp;
        }//for y
    }//pivot

    static void reducir(float matriz[][], int pivote, int aux) {
        for (int x = 0; x < aux; x++) {
            if (x != pivote) {
                float c = matriz[x][pivote];
                for (int z = 0; z < (aux + 1); z++) {
                    matriz[x][z] = ((-1 * c) * matriz[pivote][z]) + matriz[x][z];
                }//for z
            }//if
        }//for x
    }//reducir
}//class