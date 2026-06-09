import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {
        
        // Ques 1

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<=100
        String c= "*";

        for(int i=1;i<=n;i++){
            System.out.println(c);
            c=c+"\t*";
        }  */

        // Ques 2

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<=100

        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*\t");
            }
            System.out.println();
        } */

        // Ques 3

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<=100

        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if (j<=i-1) {
                   System.out.print("\t");  
                } 
                else if (j<=n) {
                   System.out.print("*\t"); 
                }
            }
            System.out.println();
        } */

        // Ques 4
        // M1

    /*   Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<=100

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if (j<=i-1) {
                   System.out.print("\t");  
                } 
                else if (j<=n) {
                   System.out.print("*\t"); 
                }
            }
            System.out.println();
        } */

        // M2

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<=100

        int sp =0;
        int st=n;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            for(int j=1;j<=st;j++){
                System.out.print("*\t");
            }
            st--;
            sp++;
            System.out.println();
        } */

        // Ques 5
        // M1

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<=100
        int sp=(n-1)/2;
        int st=1;

        for(int i=1;i<=n;i=i+2){
            if (i<n) {
                
               for(int j=1;j<=sp;j++){
                System.out.print("\t");
               }
               for(int j=1;j<=st;j++){
                System.out.print("*\t");
               }
               st=st+2;
               sp--;
               System.out.println(); 
            }
            else if(i==n){
                int sp1=0;
                int st1=n;
                for(int k=1;k<=n;k++){
                    for(int j=1;j<=sp1;j++){
                        System.out.print("\t");
                    }
                    for(int j=1;j<=st1;j++){
                        System.out.print("*\t");
                    }
                    st1=st1-2;
                    sp1++;
                    System.out.println();
                }
            }
        } */

        // M2

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<100, n is odd always

        int sp=n/2;
        int st=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            for(int j=1;j<=st;j++){
                System.out.print("*\t");
            }

            if (i<=n/2) {
                sp--;
                st+=2;
            } 
            else {
                sp++;
                st-=2;
            }
            System.out.println();
        } */

        // Ques 6 **

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<100, n is odd always

        int st=n/2 + 1;
        int sp=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=st;j++){
                System.out.print("*\t");
            }
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            for(int j=1;j<=st;j++){
                System.out.print("*\t");
            }

            if (i<=n/2) {
                st--;
                sp+=2;
            } 
            else {
                st++;
                sp-=2;
            }
            System.out.println();
        }  */
          
        // Ques 7

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<100
        int sp=0;

        for(int i=1;i<=n;i++){

            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }

            System.out.print("*");
            System.out.println();
            
            sp++;
        } */

        // Ques 8

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); // 1<=n<100
        
        for(int i=5;i>=1;i--){
            for(int j=1;j<=n;j++){
                if (i==j) {
                    System.out.print("*");
                    break;
                    
                } 
                else if(j<i) {
                    System.out.print("\t");
                }
            }
            System.out.println()
        } */

        // Ques 9 **

    /*    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // 1<=n<100

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (i == j || i + j == n + 1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        } */

        // Ques 10 **
        //M1

    /*    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // 1<=n<100
        int i=n/2 +1;
        
        while (i>=1) {
            if (i>1) {
               for(int j=1;j<=n;j++){
                    if (i==j|| i+j==n+1) {
                        System.out.print("*\t");
                    }
                    else{
                        System.out.print("\t");
                    }
                }
                System.out.println();
                i--; 
            } 
            else {
                for(i=1;i<=n/2 +1;i++){
                    for(int j=1;j<=n;j++){
                        if (i==j|| i+j==n+1) {
                            System.out.print("*\t");
                        }
                        else{
                            System.out.print("\t");
                        }
                    }
                    System.out.println();
                }
                break;
            } 
        } */
       
        // M2

    /*    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // 1<=n<100
        int os=n/2;
        int is=-1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= os; j++){
                System.out.print("\t");
            }
            System.out.print("*\t");

            for(int j = 1; j <= is; j++){
                System.out.print("\t");
            }
            if(i>1 && i<n){
                System.out.print("*");
            }

            if (i<=n/2) {
                os--;
                is+=2;
            } else {
                os++;
                is-=2;
            }
            System.out.println();
        } */

        // Ques 11

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();
        int p=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(p+"\t");
                p++;
            }
            System.out.println();
        } */

        // Ques 12

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();
        int a=0;
        int b=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(a+"\t");
                int c=a+b;
                a=b;
                b=c;
            }
            System.out.println();
        } */

        // Ques 13

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt(); 
        
        for(int i=0;i<=n;i++){
            int icj=1;
            for(int j=0;j<=i;j++){
                System.out.print(icj + "\t");
                int icjp1 = icj * (i-j)/(j+1); // formula from permutation and combination
                icj= icjp1;
            }
            System.out.println();
        } */

        // Ques 14

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();  

        for(int i=1;i<=10;i++){
            System.out.println(n + " * " + i + "  = " + n*i);
        } */

        // Ques 15 **

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();

        int sp= n/2;
        int r=1;
        int val=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }

            int c=val;
            for(int j=1;j<=r;j++){
                System.out.print(c + "\t");
                
                if (j<=r/2) {
                    c++;
                } else {
                    c--;
                }
            }
            if (i<=n/2) {
                sp--;
                r+=2;
                val++;
            } else {
                sp++;
                r-=2;
                val--;
            }
            System.out.println();
        } */

        // Ques 16

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int sp= 2*n-3;
        int val=1;

        for(int i=1;i<=n;i++){
            int c=0;
            for(int j=1;j<=val;j++){
                c++;
                System.out.print(c + "\t");
            }

            for(int j=1; j<=sp;j++){
                System.out.print("\t");
            }
            
            if (i==n) {
                c--;
                val--;
            }

            for(int j=1; j<=val;j++){
                System.out.print(c +"\t");
                c--;
            }

            sp-=2;
            val++;
            System.out.println();
        } */

        // Ques 17

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int st=1;
        int sp=n/2;

        for(int i=1;i<=n;i++){
            if (i==n/2 +1) {
                sp=0;
                st=n;
            }

            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }

            for(int j=1;j<=st;j++){
                System.out.print("*\t");
            }

            if (i==n/2+1) {
                sp=n/2;
                st=n/2 +1;
            }

            if (i<=n/2) {
                st++;
            } else {
                st--;
            }
            System.out.println();
        } */

        // Ques 18,19,20 left

        // Ques 20

        // Scanner scn =new Scanner(System.in);
        // int n = scn.nextInt();
        
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if (j==1 || j==n) {
        //             System.out.print("*\t");
        //         }
        //         else if (i>n/2 && (i==j || i+j == n+1)) {
        //             System.out.print("*\t");
        //         }
        //         else{
        //             System.out.print("\t");
        //         }
        //     }
        //     System.out.println();
        // }
        // Note: Condition of diagonal is i==j || i+j == n+1 

        // Ques 19

        Scanner scn =new Scanner(System.in);
        int n = scn.nextInt(); 
        int mid= n/2 +1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (
            i == mid ||                     // horizontal middle
            j == mid ||                     // vertical middle
            (i == n && j >= mid) ||          // top arm
            (i == 1 && j <= mid) ||          // bottom arm
            (j == n && i <= mid) ||          // left arm
            (j == 1 && i >= mid)             // right arm
        )   {
                System.out.print("*\t");
            } 
            else {
                System.out.print("\t");
            }

            }
            System.out.println();
        }
    }
}
