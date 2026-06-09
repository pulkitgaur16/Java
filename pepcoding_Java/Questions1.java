import java.util.Scanner;

public class Questions1 {
    public static void main(String[] args) {
        // Ques 1
        // M1

    /*    Scanner scn= new Scanner(System.in);
        int t= scn.nextInt();

        for(int i=1;i<=t;i++){
            int n= scn.nextInt();
             int s=2;
            int p=1;
            if (n==1) {
               System.out.println("Neither prime nor composite"); 
            } 
            else {
                while (n%s !=0) {
                   s++;
                   p++;}
                
                if (p==(n-1)) {
                System.out.println("It is prime");
                } 
                else {
                System.out.println("Not prime");
                }    
            }  

            // M2 (Not valid for 1)

            int count = 0;
            for(int div=2; div*div <= n; div++){
                if (n%div ==0) {
                   count++;
                   break; 
                }
            }

            if (count==0) {
                System.out.println("Prime");
            } else {
                System.out.println("Not Prime");
            }
        } */

        // Ques 2

       /* Scanner scn= new Scanner(System.in);
        int low = scn.nextInt(); //Greater than 2
        int high= scn.nextInt(); //Greater than 2

        
        
        for(int n=low; n <= high; n++){
            int div=2;
            int count = 0;
            while (div<=n) {
                if (n%div==0){
                    count++; 
                    }
                div++;
            }
            if (count==1) {
                System.out.println(n);
            }
        } */

        //Ques 3

    /*    Scanner scn= new Scanner(System.in);
        int n = scn.nextInt(); // 1<n<40
        int a=0;
        int b=1;

        for(int i=1; i<=(n); i++){
            System.out.println(a);
            int c=a+b;
            a= b;
            b= c;

        } */

        // Ques 4 *

       /* Scanner scn= new Scanner(System.in);
        int n = scn.nextInt(); // 1<=n< 10^9
        int d=1;

        while (n/10 !=0) {
            n=(n/10);
            d++;
        }
        System.out.println(d);  */

        // Ques 5 *

    /*    Scanner scn= new Scanner(System.in);
        int n = scn.nextInt(); // 1<=n< 10^9
        int d=0;
        int temp= n;

        while (temp !=0) {
            temp=(temp/10);
            d++;
        }
        int div = (int) Math.pow(10,d-1);

        while (n != 0) {
           System.out.println(n/div);
           n=n%div;
           div= div/10; 
        }  */

        // Ques 6

    /*    Scanner scn= new Scanner(System.in);
        int n = scn.nextInt(); // 1<=n< 10^9

        while (n != 0) {
           System.out.println(n%10);
           n=n/10;
        } */

        //Ques 7 *

    /*    Scanner scn= new Scanner(System.in);
        int n = scn.nextInt(); 
        int c=0;
        int inv= 0;


        while (n !=0) {
            c++;
            int r= n%10;
            inv= inv + (c* (int)Math.pow(10,r-1));
            n=n/10;
            
        }
        System.out.println(inv); */

        // Ques 8 **

        // Scanner scn= new Scanner(System.in);
        // int n = scn.nextInt(); //  1<=n<10^9
        // int k = scn.nextInt(); // 10^-9<k <10^9
        // int t=0;
        // int temp= n;

        // while (temp !=0) {
        //     temp=(temp/10);
        //     t++;
        // }

        // k=k%t; // for large values of k
        // if (k<0) {
        //     k=k+t;    
        // }

        // while (k>0) {
        //     int d= n%10;
        //     n = (n-d)/10 + (d* (int)Math.pow(10,t-1));
        //     k=k-1;
        // }

        // if (k<0) {
        //     while (k<0) {
        //         int l= n/(int)Math.pow(10,t-1);
        //         n= (n-(l*(int)Math.pow(10,t-1)))*10 + l;
        //         k=k+1;
        //     }    
        // } 
        // System.out.println(n); 

        // Ques 9 **
        //M1 (Hard & time inefficient, done by me)

    /*    Scanner scn= new Scanner(System.in);
        int n1 = scn.nextInt(); //  1<=n<10^9
        int n2 = scn.nextInt(); //  1<=n<10^9
        int i1=2;
        int i2=2;
        int a= 1;
        int b=1;

        while (n1!=1 || n2!=1) {
           while (i1<=n1 || i2<=n2) {
            while (n1%i1==0 || n2%i2==0) {
                if (n1%i1==0 && n2%i2==0){
                    if (i1==i2) {
                        n1=n1/i1;
                        n2=n2/i1;
                        b=b*i1;
                        a=a*i1;
                        
                    }
                    else{
                        n1=n1/i1;
                        n2=n2/i2;
                        b=b*i1*i2;
                    }
                }
                else if (n1%i1==0 || n2%i2==0) {
                    if (n1%i1==0) {
                       n1=n1/i1;
                       b=b*i1;

                    }
                    else if (n2%i2==0) {
                       n2=n2/i2;
                       b=b*i2;
                    }

                }
                
            }
            i1++;
            i2++;
            
           } 
        }
        System.out.println(a);
        System.out.println(b);  */

        //M2 (Easy and time efficient)

    /*    Scanner scn= new Scanner(System.in);
        int n1 = scn.nextInt(); //  1<=n<10^9
        int n2 = scn.nextInt(); //  1<=n<10^9

        int on1= n1;
        int on2=n2;

        while (n1%n2!=0) {
            int rem = n1%n2;
            n1=n2;
            n2=rem;
        }

        int gcd = n2;
        int lcm= (on1*on2)/gcd;

        System.out.println(gcd);
        System.out.println(lcm);  */

        // Ques 10
        
    /*    Scanner scn= new Scanner(System.in);
        int n = scn.nextInt(); //  1<=n<10^9

        for(int i=2; i*i<=n;i++){
            while (n%i==0) {
                n=n/i;
                System.out.println(i);
            }
        }
        System.out.println(n);  */

        // Ques 11

    /*    Scanner scn= new Scanner(System.in);
        int a = scn.nextInt(); //  1<=n<10^9
        int b = scn.nextInt(); //  1<=n<10^9
        int c = scn.nextInt(); //  1<=n<10^9
        int a1= (int)Math.pow(a,2);
        int b1= (int)Math.pow(b,2);
        int c1= (int)Math.pow(c,2);

        if (a1+b1==c1) {
            System.out.println("True");
            
        }
        else if (c1+b1==a1) {
            System.out.println("True");    
        }
        else if (c1+a1==b1) {
            System.out.println("True");    
        }
        else{
            System.out.println("False");
        }  */

        // Ques 12 (by seeing the pattern we find only perfect square bulbs will glow)

    /*    Scanner scn= new Scanner(System.in);
        int n = scn.nextInt(); //  2<=n<10^9
        System.out.println("b1");
        
        for(int i=2;i*i<=n;i++){
            System.out.println("b"+i*i);
        }  */

         
    }
}
