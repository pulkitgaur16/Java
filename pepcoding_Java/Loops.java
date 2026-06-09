import java.util.Scanner;

public class Loops { // for multi line comment "/* */"
    public static void main(String[] args) {
       /* int i=1; // INITIALISATION
        
        while (i<=9) { // EVALUATION
            System.out.println(i);
            i=i+1; // or i++; // INCREMENT
        }
        System.out.println("Done"); 
        

        for(int i=0;i<=9;i++){
            System.out.println(i);
        }*/

        Scanner scn = new Scanner(System.in);
        String name = scn.nextLine();
        int n= Integer.parseInt(scn.nextLine());
        
        System.out.println("Hello "+ name);
        for(int i=0;i<=n;i++){
            System.out.println(i);
        }
    }
}
