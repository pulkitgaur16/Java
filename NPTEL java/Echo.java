import java.util.Scanner;

public class Echo {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        for(int i=0;i<args.length;i++){
            System.out.println(args[i] + " ");
        }
        System.exit(0);
    }
}
