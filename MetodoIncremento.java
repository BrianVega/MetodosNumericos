import java.util.Scanner;
//Alvaro Kevin Jiménez Quintero - Ing en Sistemas Computacionales - 4 A
public class MetodoIncremento{
    static Scanner leer = new Scanner(System.in);

    public static void main(String args[]){
            int  q;// Declaramos la variables de los coeficinetes
            double x1, ea=0,keeper=0,deltaX, c1, c2, c3, c4, c5,ut, vfx1 = 0; //Las variables de X
            boolean p1=true, f1 = false;

        
            System.out.println("Bienvenido al método de Bisección");
            System.out.println("Ingrese los coeficientes del polinomio:");
            System.out.println("C(x)^5 | C = ");
            c5 = leer.nextDouble();
            System.out.println("C(x)^4 | C = ");
            c4 = leer.nextDouble();
            System.out.println("C(x)^3 | C = ");
            c3 = leer.nextDouble();
            System.out.println("C(x)^2 | C = ");
            c2 = leer.nextDouble();
            System.out.println("C(x) | C = ");
            c1 = leer.nextDouble();
            System.out.println("Ingrese el valor del ultimo termino del polinomio");
            ut = leer.nextDouble();

            System.out.println("Ingrese la aproximacion inicial en X: ");//Adquirimos la posición inicial de X
            x1 = leer.nextInt();


            System.out.println("Ingrese el valor de q: ");//Solicitamos el valor de q
            q  = leer.nextInt();

            //Solicitamos delta x el cual será el aumento, tiene que ser mayor que 2, así que validamos
            do{
                    System.out.println("Ingrese el aumento tambien llamado delta X, recuerde que debe ser mayor a 2: ");//Adquirimos delta X, el aumento
                    deltaX = leer.nextInt();
                    if(deltaX > 2){
                            f1 = true;
                    }
            }while(f1 = false);

        do{

                vfx1 = (c5*potencia(x1,5)+c4*potencia(x1,4)+c3*potencia(x1,3)+c2*potencia(x1,2)+c1*x1+ut); //Sacamos el valor de la función con x1

                System.out.println("Delta X = "+deltaX);
                System.out.println("Valor de X = "+x1);
                System.out.println("Valor de la función en X = "+vfx1);
                //Error aproximado
                keeper = ea;
                ea = x1;
                ea = (ea - keeper/ea) * 100d;
                System.out.println("Error aproximado = "+ea);
                if(ea < 1 && ea > -1){
                        System.out.println("Raiz super pequeña positiva encontrada en: "+x1);
                        p1 = false;
                }

                if(vfx1 < 0){
                        x1 =  x1 + deltaX;
                }else if(vfx1 == 0){
                        System.out.println("Raiz encontrada en: "+x1+" valor de funcion en x: "+vfx1);
                        keeper = ea;
                        ea = x1;
                        ea = ((ea - keeper)/ea) * 100;
                        System.out.println("Error aproximado = "+ea);
                        p1 = false;
                }else{
                        x1 = x1 - deltaX;
                        deltaX = deltaX/q;
        
                }
        }while(p1);     
    }


    public static double potencia(double n, int poten){ //Eleva numeros a una potencia y lo retorna
        double a = n;
        if(poten == 0){
                return 1;
        }
        while(poten != 1){
            n = n * a;
            poten--;
        }
        return n;
    }
}