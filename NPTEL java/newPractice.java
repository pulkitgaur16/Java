import java.util.Scanner;

public class newPractice {
    public static void main(String args[]){
        Scanner scn= new Scanner(System.in);
        String n= scn.nextLine();
        int d= scn.nextInt();

        int count=0;

        for (int i = 0; i < n.length(); i++) {
            int d1= n.charAt(i)-'0';

            if (d1==d) {
                count++;
            }
        }
        System.out.print(count);
    }
}
