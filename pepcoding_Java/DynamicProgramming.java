import java.util.Scanner;

public class DynamicProgramming {
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int fibn = Fib(n);
        // System.out.println(fibn);

        int cp = countPaths(n, new int[n+1]); 
        System.out.println(cp);
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

    public static int countPaths(int n, int[] qb){
        if(n == 0) return 1;
        else if(n < 0) return 0;
        if(qb[n] != 0) return qb[n];

        int path1 = countPaths(n-1, qb);
        int path2 = countPaths(n-2, qb);
        int path3 = countPaths(n-3, qb);

        int paths = path1 + path2 + path3;

        qb[n] = paths;

        return paths;
    }

    // Below method is DP tabulation
    public static int countPathsTab(int n){
        int[] dp = new int[n+1];

        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }
            else if(i == 2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }

    public static int countPathswithJumps(int n, int[] arr){
        int[] dp = new int[n+1];

        dp[n] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=arr[i]; j++){
                if((i+j)<=n){
                    dp[i] += dp[i+j];
                }
            }
        }

        return dp[0];
    }

    public static int PathWithMinMoves(int n, int[] arr){
        Integer[] dp = new Integer[n+1];

        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] > 0){
                int min = Integer.MAX_VALUE;
                for(int j=1; j<=arr[i] && i+j <= n; j++){
                    if(dp[i+j] != null){
                        min = Math.min(min, dp[i+j]);
                    }
                }

                if(min != Integer.MAX_VALUE){
                    dp[i] = min+1;
                }
            }
        }

        return dp[0];
    }
}
