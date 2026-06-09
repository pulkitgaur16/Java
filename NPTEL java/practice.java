import java.util.Scanner;

public class practice {
    public static void main(String args[]){
        // Scanner scn= new Scanner(System.in);
        // int n= scn.nextInt();

        // int st=n;
        // int sp= n-2;

        // for(int i=1;i<=n;i++){
        //     if(i==n || i==1){
        //         for(int j=1;j<=n;j++){
        //             System.out.print('*');
        //         }
        //         System.out.println();
        //     }
        //     else{
        //         for(int j=1;j<=sp;j++){
        //             System.out.print(" ");
        //         }
        //         System.out.print('*');
        //         sp--;
        //         System.out.println();
        //     }
        // }

        Scanner scn= new Scanner(System.in);
        int t= scn.nextInt();
        int arr[]= new int[t];
        for (int i = 0; i < t; i++) {
            arr[i]= scn.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            int count=0;
            if (arr[i]<=1) {
                System.out.println("not prime");
            }
            for(int j=2;j<= (int)(Math.pow(arr[i], 0.5));j++ ){
                if (arr[i]%j==0) {
                    count++;
                    System.out.println("not prime");
                    break;
                }
            }
            if (count==0) {
                System.out.println("prime");
            }
        }
    }
}
