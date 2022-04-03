import java.util.*;
public class MathLib{
   static Scanner leer  = new Scanner(System.in);
   static double valorX, resultado, auxValorX, auxValorX2;
   static int criterioErrorIng;
   public static void main(String[]Args){
   
   // do{
      int opcValidada;
      opcValidada = menuValidado();//ejecutar menú
      switch(opcValidada){
      
         case 1:
            System.out.println("~~~~~~~~~ Raiz Cuadrada ~~~~~~~~~");
            datosEntrada();
            raices();     
            break;
         
         case 2:
            String degRad;
            int degRadValidado;
            do{
               System.out.println("~~~~~~~~~ Seno ~~~~~~~~~");
               System.out.println("Seleccione una opcion para operar el sen(X)");
               System.out.println("[1] - Grados");
               System.out.println("[2] - Radianes");
               System.out.print("Opcion: ");
               degRad = leer.nextLine();
            }while(degRad.charAt(0) != '1' && degRad.charAt(0) != '2');      
            degRadValidado = Integer.parseInt(degRad);
            System.out.println("Llene los campos siguientes para hacer el calculo:\n");
            switch(degRadValidado){
               case 1: 
                  System.out.print("valor de X del sen(X) en grados: ");
                  valorX = leer.nextDouble();
                  System.out.print("criterio de error a trabajar: ");
                  criterioErrorIng = leer.nextInt();
                  valorX = valorX * 3.1416 / 180;
                  funcionSeno();
                  break;
               case 2: 
                  System.out.print("valor de X del sen(X) en radianes: ");
                  valorX = leer.nextDouble();
                  System.out.print("criterio de error a trabajar: ");
                  criterioErrorIng = leer.nextInt();
                  funcionSeno();
                  break;
            }//switch degRadValidado
         
         
         case 3:
            String degRadCos;
            int degRadValidadoCos;
            do{
               System.out.println("~~~~~~~~~ Coseno ~~~~~~~~~");
               System.out.println("Seleccione una opcion para operar el cos(X)");
               System.out.println("[1] - Grados");
               System.out.println("[2] - Radianes");
               System.out.print("Opcion: ");
               degRadCos = leer.nextLine();
            }while(degRadCos.charAt(0) != '1' && degRadCos.charAt(0) != '2');      
            degRadValidadoCos = Integer.parseInt(degRadCos);
            System.out.println("Llene los campos siguientes para hacer el calculo:\n");
            switch(degRadValidadoCos){
               case 1: 
                  System.out.print("valor de X del cos(X) en grados: ");
                  valorX = leer.nextDouble();
                  System.out.print("criterio de error a trabajar: ");
                  criterioErrorIng = leer.nextInt();
                  valorX = valorX * 3.1416 / 180;
                  funcionCoseno();
                  break;
               case 2: 
                  System.out.print("valor de X del sen(X) en radianes: ");
                  valorX = leer.nextDouble();
                  System.out.print("criterio de error a trabajar: ");
                  criterioErrorIng = leer.nextInt();
                  funcionCoseno();
                  break;
            }//switch degRadValidado         
            break;
         /*case 4:
         System.out.println("~~~~~~~~~ Tangente ~~~~~~~~~");
         datosEntrada();         
         break;*/
         case 5:
            System.out.println("~~~~~~~~~ Logaritmo natural ~~~~~~~~~");
            double ln;      
            datosEntrada();
            if(valorX < 1)
               logaritmoNat1();
            else
               logaritmoNat2();
            break;
         
         
         case 6:
            System.out.println("~~~~~~~~~ Euler ~~~~~~~~~");
            datosEntrada();
            funcionEuler();         
            break;
         
         case 7:
            System.out.println("~~~~~~~~~ Programa finalizado ~~~~~~~~~");   
            System.exit(0);      
            break;
      
      }//switch
   //}while(opcValidada < 7 && opcValidada > 0);   
   }//main
   
   public static void funcionEuler(){
      double euler = 0, iteracionesE, auxIteracionesE;
      int auxEuler = 100;
      for(int x=0; x<=auxEuler; x++){
         auxIteracionesE = euler;
         iteracionesE = potencia(valorX, x)/factor(x);
         euler = euler + iteracionesE;
         System.out.println("Valor de e(X):  " + euler);
         if(checar(euler, auxIteracionesE, criterioError()))
            break;
      }//for x
      System.out.println("Valor final de e(X): " + euler);
      
      
   }//funcionEuler
   
   
   public static void logaritmoNat2(){
      double ln2=0, iteraciones2=0, auxIteraciones2;
      int auxln2 = 100;
      
      for(int x=0; x<=auxln2; x++){
         auxIteraciones2 = iteraciones2;
         iteraciones2 = (1/((2*x)+1)) * potencia((valorX-1)/(valorX+1), (2 * x)+1);
         ln2 = ln2 + iteraciones2;
         System.out.println("Valor de ln (x): " + ln2);
         if(checar(ln2, auxIteraciones2, criterioError()));
         break;
      }//for x
      ln2 = ln2 * 2;
      System.out.println("El valor final de ln(x) es:  " + ln2);
   }//logaritmoNat1
   
   
   
   
   public static void logaritmoNat1(){
      double ln=0, iteraciones=0, auxIteraciones;
      int auxln = 100;
      
      for(int x=0; x<=auxln; x++){
         auxIteraciones = iteraciones;
         iteraciones = (potencia(-1, x + 1) / x) * potencia(valorX, x);
         ln = ln + iteraciones;
         System.out.println("Valor de ln (x): " + ln);
         if(checar(ln, auxIteraciones, criterioError()));
         break;
      }//for x
      System.out.println("El valor final de ln(x) es:  " + ln);
   }//logaritmoNat1
   
   
   
   public static void funcionCoseno(){
      double Coseno = 0, iteraciones = 0, auxIteraciones;
      int auxCoseno = 0;
      
      do{
         auxIteraciones = iteraciones;
         iteraciones = (potencia(-1, auxCoseno)/factor(2 * Coseno)) * potencia(valorX, 2 * auxCoseno); 
         Coseno = Coseno + iteraciones;
         System.out.println("Valor cos(x): " + Coseno);
         auxCoseno++;
         if(checar(Coseno, auxIteraciones, criterioError()))
            break;      
      }while(Coseno <= 10);//Do-while
      
      
   }//funcionCoseno
   
   public static void funcionSeno(){
      double seno = 0, iteraciones = 0, auxIteraciones;
      int auxSeno = 0;
      
      do{
         auxIteraciones = iteraciones;
         iteraciones = ((potencia(-1, auxSeno)) / (factor(2 * auxSeno + 1))) * (potencia(valorX, (2 * auxSeno) + 1));
         seno = seno + iteraciones;
         System.out.println("Valor sen(X): " + seno);
         auxSeno++;
         if(checar(seno, auxIteraciones, criterioError()))
            break;
      }while(seno < 75);
   
   
   }//funcionSeno      
   
   
   public static void raices(){
      double auxValorX, raizX = criterioErrorIng/2; 
      boolean auxChecar = false;
      do{
         auxValorX = raizX;
         raizX = (auxValorX + (valorX / auxValorX)) / 2;
         System.out.println("valor: " + raizX);
         auxChecar = checar(raizX, auxValorX, criterioError());
         if(auxChecar == true)
            break;
      }while((auxValorX - raizX) != 0);
      System.out.println("Raiz cuadrada de " + valorX + " es: " + raizX);
   }//raices

   public static double criterioError(){
      double criterioErrorVerif;
      criterioErrorVerif = 0.5 * potencia(10, 2 - criterioErrorIng);
      return criterioErrorVerif;
   }//criterioError
   
   public static double potencia(double num, int potencia){
      double aux = num;
      if(potencia == 0)
         return 1;
      while(potencia != 1){
         num = num * aux;
         potencia--;
      }//while potencia
      return num;
   }//potencia
   
   public static boolean checar(double raizX, double auxValorX, double criterioError){
      double auxChecar;
      auxChecar = (raizX - auxValorX) / raizX;
      System.out.println("El error aproximado es: " + auxChecar);
      if(auxChecar == criterioError)
         return true;
      return false;
   }//checar   
   
   
   public static double factor(double num){
      double auxFactorial = 1;
      if(num < 0)
         num = num * -1;
      if(num <= 0)
         return 1;
      while(num > 1){
         auxFactorial = auxFactorial * num;
         num--;
      }//while
      return auxFactorial;
   }//factorial 
   
   static void datosEntrada(){
      System.out.print("Ingrese el valor de X de la funcion: ");      
      valorX = leer.nextFloat();
      System.out.print("\nIngrese el criterio de Error: ");
      criterioErrorIng = leer.nextInt();
   }//datos entrada

   static int menuValidado(){
      int contE=0, opc=0;//contE entradas no validas
      String auxOpc;
      do{
         System.out.println("~.~.~ \nSeries de MacLaurin ~.~.~");
         System.out.println("Seleccione una funcion: \n");
         System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
         System.out.println("Formula de los Babilonios");
         System.out.println("[1] Raiz");
         System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
         System.out.println("Grados o radianes");
         System.out.println("[2] Sen");
         System.out.println("[3] Cos");
         System.out.println("[4] Tan");
         System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
         System.out.println("Numeros reales");
         System.out.println("[5] ln");
         System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
         System.out.println("Reales positivos");
         System.out.println("[6] Euler");
         System.out.println("[7] Salir");
         System.out.print("\n Opcion: ");
         auxOpc=leer.nextLine();
         if(auxOpc.length()!=1)
            contE++;
         else
            if(Character.isDigit(auxOpc.charAt(0))){
               opc=Integer.parseInt(auxOpc);//pasar a int opc
               if(opc>0 && opc<7)
                  contE=0;
               else
                  contE++;//++
            }//if isDigit
            else
               contE++;
         if(contE!=0)
            System.out.printf("\n¡ERROR! Ingrese una opcion valida: \n");                 
      }while(contE!=0);        
      return opc;
      
   }//menuValidado



}//class