import java.util.*;
public class algoritmosAgenda{
   static Scanner leer = new Scanner(System.in);
   static int contPersonasArreglo = 0;// contPersonasVisible = 1;
   static controlPersonas[] acceder = new controlPersonas[99];
   
   public static void main(String[]Args){
   int opc = 0;
   
   do{
      opc  = menuValidado();
      switch(opc){
         //case 0:
           // System.out.println("Se ha alcanzado el espacio maximo de almacenamiento");
         case 1:
            altaPersona();
         break;
         
         case 2:
            buscarPersona();
         break;
         
         case 3:
            eliminarPersona();
         break;
         
         case 4:
            modificarPersona();
         break;
      }//Switch Case   
   }while(opc > 0 && opc < 5);
      
   }//main
   
static int menuValidado(){
      int contE=0, opc=0;//contE entradas no validas
      String auxOpc;
   /*if(contPersonasArreglo == tope){
      opc = 0;
   }//if*/
   //else{
      do{
         System.out.println("\n\n~~~ M E N U ~~~\n");
         System.out.println("[1] Alta ");
         System.out.println("[2] Buscar ");
         System.out.println("[3] Eliminar ");
         System.out.println("[4] Modificar ");
         System.out.print("Opción: ");
            auxOpc=leer.nextLine();
         if(auxOpc.length()!=1)
            contE++;
         else
         if(Character.isDigit(auxOpc.charAt(0))){
            opc=Integer.parseInt(auxOpc);//pasar a int opc
         if(opc>0 && opc<5)
            contE=0;
               else
             contE++;//++
          }//if isDigit
               else
                  contE++;
         if(contE!=0)
            System.out.printf("\n¡ERROR! Ingrese una opcion valida: \n");                 
         }while(contE!=0);        
      //}//else
      return opc;
   }//menuValidado
   
private static void altaPersona(){
String auxNombre, auxEmail, auxCumple;
String auxId = " ";
int auxiliarAltas;
double auxNumero;
boolean flagA = true;
   //contPersonasVisible++;
   System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.- ALTA -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
   System.out.println("Para dar de alta a un nuevo usuario complete los siguientes datos: ");
   
   do{
   System.out.print("\nIngrese el ID con el que trabajará: "); 
      auxId = leer.nextLine();
         for(int x=0; x<contPersonasArreglo; x++)
         if(acceder[x].getId().equals(auxId)){
            System.out.println("Error! ése ID ya ha sido ingresado anteriormente. Intente con otro");
            flagA = false;
            break;
          }//if
          else
            flagA = true;
    }while(flagA == false);    
   System.out.print("\nNombre: ");
      auxNombre = leer.nextLine();
   System.out.print("\nTeléfono: ");
      auxNumero = leer.nextDouble();// este numero no está validado jejejejejjje
      leer.nextLine();//limpiando buffer
   System.out.print("\nDirección electrónica: ");
      auxEmail = leer.nextLine();
   System.out.print("\nFecha de cumpleaños: ");
      auxCumple = leer.nextLine();
      
   acceder[contPersonasArreglo] = new controlPersonas(auxId, auxNombre, auxNumero, auxEmail, auxCumple);
   contPersonasArreglo++;
   System.out.println("[0] = " + acceder[0].getId()); //borrar
}//altaPersona

private static void buscarPersona(){
   int auxBusquedaID;
   String auxId; 
      System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.- BUSCAR -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
      System.out.print(" A continuacion, Ingrese el ID de la persona que desea buscar: ");
         auxId = leer.nextLine();
   System.out.println("test: ID = " + acceder[0].getId() + " Ingresado: " + auxId); //borrar
      auxBusquedaID = funcionBuscar(auxId); 
      if (auxBusquedaID == -1){
            System.out.println("\nERROR! No se ha encontrado ningún registro con ese ID");
      }//coincidencia encontrada
      else{
         System.out.println("Registro encontrado con éxito");
         imprimir(auxBusquedaID);
      }//Coincidencia NO encontrada
      
      }//buscarPersona

private static int funcionBuscar(String auxId){
   boolean flag = false;
   int auxPosicionX = 0;
   for(int x=0; x<contPersonasArreglo; x++)
         if(acceder[x].getId().equals(auxId)){
            auxPosicionX = x;
            flag = true;
            //leer.nextLine();//limpiando buffer
            break;
         }//if coincidencia encontrada
         else if(flag == false && x == contPersonasArreglo-1){
            auxPosicionX = -1;
            //leer.nextLine();//limpiando buffer
         }//else coincidencia NO encontrada
   return auxPosicionX;
}//funcionBuscar

private static void eliminarPersona(){
   String idEliminar;
   int idEliminarVerificado;
   System.out.print("Ingrese el ID de la persona que desea buscar: ");
      idEliminar = leer.nextLine();
   idEliminarVerificado = funcionBuscar(idEliminar); 
   if(idEliminarVerificado != -1){
      System.out.println("Registro encontrado con éxito");
      imprimir(idEliminarVerificado);
      System.out.print("¿\nEstá completamente seguro de que desea eliminar el registro?\n [1].- Si\n[2].- No\nOpción:");
         int opcEliminar = leer.nextInt();
         leer.nextLine();//limpiando Buffer
      if(opcEliminar == 1){
         acceder[idEliminarVerificado] = new controlPersonas("null", "null", 0, "null", "null");
         System.out.println("El registro se ha eliminado con éxito");
      }//if
      else
         System.out.println("Operación cancelada");      
   }//Coincidencia encontrada
   else{
      System.out.println("\nERROR! No se ha encontrado ningún registro con ese ID");
   }//Coincidencia NO encontrada
}//eliminarPersona

private static void modificarPersona(){
String auxIdModificar;
String nombreNuevo, direccionNueva, fechaNueva;
double numeroNuevo;
int auxIdModificarVerificado, auxOpcModificar=0;
   System.out.print("Ingrese el ID del usuario a modificar: ");
      auxIdModificar = leer.nextLine();
      auxIdModificarVerificado = funcionBuscar(auxIdModificar);
   if (auxIdModificarVerificado == -1){
         System.out.println("\nERROR! No se ha encontrado ningún registro con ese ID");
   }//coincidencia NO encontrada
   else{
      System.out.println("Registro encontrado con éxito");
      do{
         imprimir(auxIdModificarVerificado);
         System.out.print("Ingrese el campo que desea modificar");
            auxOpcModificar=leer.nextInt();
            leer.nextLine();//Buffer
         switch(auxOpcModificar){
            case 1:
               System.out.print("Ingrese el nuevo nombre: ");
                  nombreNuevo = leer.nextLine();
                  acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), nombreNuevo, acceder[auxIdModificarVerificado].getNumero(), acceder[auxIdModificarVerificado].getEmail(), acceder[auxIdModificarVerificado].getCumple());
            break;
                        
            case 2:
               System.out.print("Ingrese el nuevo teléfono: ");
                  numeroNuevo = leer.nextDouble();
                  acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), acceder[auxIdModificarVerificado].getNombre(), numeroNuevo, acceder[auxIdModificarVerificado].getEmail(), acceder[auxIdModificarVerificado].getCumple());
                  leer.nextLine();//Limpiando Buffer
            break;
            
            case 3:
               System.out.print("Ingrese el nuevo Email: ");
                  direccionNueva = leer.nextLine();
                  acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), acceder[auxIdModificarVerificado].getNombre(), acceder[auxIdModificarVerificado].getNumero(), direccionNueva, acceder[auxIdModificarVerificado].getCumple());
            break;
            
            case 4:
               System.out.print("Ingrese la nueva fecha de cumpleaños: ");
                  fechaNueva = leer.nextLine();
                  acceder[auxIdModificarVerificado] = new controlPersonas(acceder[auxIdModificarVerificado].getId(), acceder[auxIdModificarVerificado].getNombre(), acceder[auxIdModificarVerificado].getNumero(), acceder[auxIdModificarVerificado].getEmail(), fechaNueva);
            break;
            
         }//switch
      
      }while(auxOpcModificar < 1 && auxOpcModificar > 4);
   }//Coincidencia encontrada

}//modificarPersona


private static void imprimir(int x){
   System.out.println("\n[#] - ID: " + acceder[x].getId());
   System.out.println("[1] - Nombre: " + acceder[x].getNombre());
   System.out.println("[2] - Teléfono: " + acceder[x].getNumero());
   System.out.println("[3] - Email: " + acceder[x].getEmail());
   System.out.println("[4] - Cumpleaños " + acceder[x].getCumple());
}//imprimir
   
   
}//class