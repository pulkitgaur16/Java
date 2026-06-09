import java.util.Scanner;

public class Functions {
    // Functions helps to avoid repetition
    // DRY= Do Not Repeat Yourself in code
    // Repetition causes maintainance problem

    // Memory diagram of function:-
    // initially only main method stack is there in the memory
    // as soon as function is called a new stack frame of function is created in the memory
    // once executed (return statement), the stack of function created is erased from the memory

    // Note: in java function must be declared inside the class only not inside method (like main)

    public static int getDigitFreq(int n, int d){
        int count=0;

        while (n!=0) {
            int n1=n%10;
            if (n1==d) {
               count++; 
            }
            n=n/10;
        }
        
        return count;
    }

    public static void convert(int n, int b){ // decimal to any base
        String convn=" ";
        while (n!=0) {
            convn= n%b + convn;  
            n=n/b;
        }
        System.out.println(convn);
    } 

    public static int convertToDecimal(int n,int b){
        int p=1;
        int rv=0;
        while (n>0) {
            int dig= n%10;
            n=n/10;

            rv+= dig * p;
            p= p*b;
        }
        return rv;
    }

    public static void convertToAnyBase(int n,int b1, int b2){ // any base to any base
        
        int d=0;
        
        int convD=0;
        while (n!=0) {
            convD= (n%10 *(int) Math.pow(b1,d)) + convD;
            d+=1;
            n=n/10;
        }

        convert(convD, b2);    
    }

    public static int AnyBaseAddition(int n1,int n2, int b){

        // M1 (function should be void)

    /*    int N1= convertToDecimal(n1,b);
        int N2= convertToDecimal(n2, b);

        int Sum= N1+N2;

        convert(Sum, b); */

        // M2 (function should be int)

        int rv=0;
        int c=0;
        int p=1;

        while (n1>0|| n2>0 || c>0) {
            int d1= n1%10;
            int d2= n2%10;
            n1=n1/10;
            n2=n2/10;

            int d= d1+d2+c;
            c= d/b;
            d= d%b;

            rv+= d*p;
            p=p*10;
        }
        return rv;
    }

    public static int AnyBaseSubtraction(int b,int n1, int n2){
        int rv=0;
        int p=1;
        int d1=0;

        while (n1>0|| n2>0) {
            int d=0;
            d1+=n1%10;
            int d2= n2%10;
            n1=n1/10;
            n2=n2/10;
            
            if (d1>=d2) {
               d= d1-d2;
               rv+= d*p;
               p=p*10;
               d1=0;
            } 
            else {
               d1+=b;
               d= d1-d2; 
               rv+= d*p;
               p=p*10;
               d1=-1;
            }
        }
        return rv;
    }

    public static int getProductWithASingleDigit(int b,int n1,int d2){
        int rv=0;

        int c=0;
        int p=1;
        while (n1>0|| c>0) {
            int d1= n1%10;
            n1=n1/10;

            int d= d1*d2+c;
            
            c=d/b;
            d=d%b;

            rv=rv+d*p;
            p*=10;
        }
        return rv;
    }

    public static int getProduct(int b, int n1, int n2){
        int rv=0;
        int p=1;

        while (n2>0) {
            int d2= n2%10;
            n2=n2/10;

            int sprd= getProductWithASingleDigit(b,n1,d2);
            rv= AnyBaseAddition(rv, sprd*p, b);
            p=p*10;
        }
        return rv;
    }
    public static void main(String[] args){

        // Count frequency of digit in n 

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int d= scn.nextInt();
        
        int f= getDigitFreq(n, d);
        System.out.println(f); */

        // Convert from decimal to any base
        
    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int b= scn.nextInt();
        
        convert(n,b); */

        // Convert from any base to any base

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int b1= scn.nextInt();
        int b2= scn.nextInt();
        
        convertToAnyBase(n, b1, b2); */

        // Any base addition

    /*    Scanner scn = new Scanner(System.in);
        int n1= scn.nextInt();
        int n2= scn.nextInt();
        int b= scn.nextInt();

        int Sum= AnyBaseAddition(n1, n2, b);
        System.out.println(Sum); */

        // Any base subtraction

    /*    Scanner scn = new Scanner(System.in);
        int b= scn.nextInt();
        int n1= scn.nextInt(); // n2<=n1<=256
        int n2= scn.nextInt(); // 0<=n2<=256

        int diff= AnyBaseSubtraction(b,n1,n2);
        System.out.println(diff); */

        // Any base multiplication

        Scanner scn = new Scanner(System.in);
        int b= scn.nextInt(); // 2<=b<=10
        int n1= scn.nextInt(); // 0<=n1<=10000
        int n2= scn.nextInt(); // 0<=n2<=10000

        int prod= getProduct(b,n1,n2);
        System.out.println(prod); 
    } 
}
