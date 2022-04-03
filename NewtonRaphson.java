
package newtonraphson;

import java.util.Scanner;



public class NewtonRaphson {
    public static void main(String[] args) {
        double x0,root,givenError,error;
        boolean flag=true;
        int i=1;
        Scanner sc = new Scanner(System.in);

        //System.out.print("Enter value for x0 : ");
        x0 = 1;

        givenError=x0;
            System.out.println("\n\n|Iteración  |            Raíz          | Error aproximado ");
            System.out.println("----------------------------------------------------------");
                                                                           
        while(flag){
            root = x0 - (F(x0)/Fprime_X(x0));
            error = Math.abs((root-x0)/root)*100;
                                                            
            System.out.println(("|\t"+i++) +"\t\t\t|"+ root +"\t\t\t|\t\t"+ error);
            x0 = root;

            if(givenError>error)
            {
                    flag=false;
            }
        }
    }
            
    public static double F(double x){
        return Math.pow(x,3)-(2*Math.pow(x,2))+(4*Math.pow(10, 4));
    }
    
                
    public static double Fprime_X(double x){
        return 3*Math.pow(x,2)-0.33*x;
    }
    
    
}