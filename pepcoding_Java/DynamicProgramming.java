import java.util.Scanner;

public class DynamicProgramming {
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fibn = Fib(n);
        System.out.println(fibn);
    }

    // Time Complexity = O(2^n)
    public static int Fib(int n){
        if(n == 0 || n == 1){
            return n;
        }

        int fibn1 = Fib(n-1);
        int fibn2 = Fib(n-2);

        int fibn = fibn1 + fibn2;

        return fibn;
    }

    // removed duplicate calculation of same number's fibonacci no. 
    // below method is DP memorization
    // Time complexity = O(n)
    public static int FibMemorized(int n, int[] qb){
        if(n == 0 || n == 1){
            return n;
        }
        if(qb[n] != 0){
            return qb[n];
        }

        int fibn1 = FibMemorized(n-1, qb);
        int fibn2 = FibMemorized(n-2, qb);
        int fibn = fibn1 + fibn2;

        qb[n] = fibn;

        return fibn;
    }
}
