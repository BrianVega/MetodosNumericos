import java.util.*;
public class gaussJordan{
   static Scanner leer = new Scanner(System.in);
   public static void main(String[]Args){
      int vertical = 10, horizontal = 10;
      int matriz[][] = new int[vertical][horizontal];
      
      System.out.println("Ingrese el sistema de ecuaciones [10x10] ");
      
      for(int v=0; v<vertical; v++){
         System.out.println();
         for(int h=0; h<horizontal; h++){
            System.out.print("columna "+ (v+1) +": - x" + (h+1) + ": ");
               matriz[v][h] = leer.nextInt();
         }//for horizontal
      }//for vertical
   }//main
}//gauss-jordan Class