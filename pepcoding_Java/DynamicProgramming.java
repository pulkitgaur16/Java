import java.util.HashMap;
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
    // Always while solving with this method use these 3 steps
    // -> Storage and meaning
    // -> Direction
    // -> Travel and solve
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

    public static int MinCostPath(int[][] cost){
        int n= cost.length;
        int m = cost[0].length;

        Integer[][] dp = new Integer[n][m];
        dp[n-1][m-1] = cost[n-1][m-1];

        for(int i=n-1; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j=m-1; j>=0; j--){
                if(dp[i][j] == null){
                    if(j<m-1){
                        min = dp[i][j+1];
                    }
                    if(i<n-1){
                        if(min>dp[i+1][j]){
                            min = dp[i+1][j];
                        }
                    }

                    dp[i][j] = min + cost[i][j];
                }
            }
        }

        return dp[0][0];
    }

    public static int GoldMine(int[][] gold){
        int n = gold.length;
        int m = gold[0].length;

        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            dp[i][0] = gold[i][0];
            for(int j=0; j<m; j++){
                if(i>0 && j<m-1){
                    dp[i-1][j+1] = Math.max(dp[i-1][j+1], dp[i][j] + gold[i-1][j+1]);
                }
                if(j<m-1){
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + gold[i][j+1]);
                }
                if(i<n-1 && j<m-1){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + gold[i+1][j+1]);
                }
            }
        }

        int max=0;

        int col = m-1;
        for(int i=0; i<n; i++){
            if(dp[i][col] > max){
                max = dp[i][col];
            }
        }

        return max;
    }

    public static boolean TargetSum(int[] nums, int target){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0; i<dp.length; i++){
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    dp[i][j] = true;
                }
                else{
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }else{
                        int val = nums[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val] == true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }

                if(j == target && dp[i][j] == true){
                    return true;
                }
            }
        }

        return false;
    }

    public static int maxSum(int[] nums){
        int inc = nums[0];
        int exc = 0;

        for(int i=1; i<nums.length; i++){
            int ninc = exc + nums[i];
            int nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }

        int max = Math.max(inc, exc);

        return max;
    }

    public static int minPaintCost(int[][] PaintCosts){
        int n = PaintCosts.length;
        int k = PaintCosts[0].length;

        int[][] dp = new int[n][k];

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for(int j=0; j<k; j++){
            dp[0][j] = PaintCosts[0][j];

            if(dp[0][j] <= least){
                sleast = least;
                least = dp[0][j];
            }
            else if(dp[0][j] <= sleast){
                sleast = dp[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < dp.length; j++) {
                if(least == dp[i-1][j]){
                    dp[i][j] = sleast + PaintCosts[i][j]; 
                }
                else{
                    dp[i][j] = least + PaintCosts[i][j];
                }

                if(dp[i][j] <= nleast){
                nsleast = nleast;
                nleast = dp[i][j];
                }
                else if(dp[i][j] <= nsleast){
                    nsleast = dp[i][j];
                }
            }

            least = nleast;
            sleast = nsleast;
        }

        return least;
    }

    public static int partitions(int n, int k){
        if(n==0 || k==0 || n<k){
            return 0;
        }

        int[][] dp = new int[k+1][n+1];

        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                if(i>j){
                    dp[i][j] = 0;
                }
                else if(i==1 || (i==j)){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = (i*dp[i][j-1]) + dp[i-1][j-1];
                }
            }
        }

        return dp[k][n];
    }

    public static int BestTimeToBuySell(int[] arr, int transFee){
        int obsp = -arr[0];
        int ossp = 0;

        for(int i=1; i<arr.length; i++){
            int nbsp = 0;
            int nssp = 0;

            if(ossp - arr[i] > obsp){
                nbsp = ossp - arr[i];
            }
            else{
                nbsp = obsp;
            }

            if(obsp + arr[i] - transFee > ossp){
                nssp = obsp + arr[i] - transFee;
            }
            else{
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
        }

        return ossp;
    }

    public static int HighwayBillboard(int m, int n, int[] pos, int[] rev, int t){ // space - O(n), time- O(n^2)
        int[] dp = new int[n];
        dp[0] = rev[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = rev[i];
            int maxPrevRev = 0;
            
            for(int j=i-1; j>=0; j--){
                if(pos[j] + t < pos[i]){
                    
                    if(dp[j] > maxPrevRev){
                        maxPrevRev = dp[j];
                    }
                }
            }

            dp[i] += maxPrevRev;
        }

        int maxr = 0;
        for(int i=0; i<n; i++){
            if(dp[i] > maxr){
                maxr = dp[i];
            }
        }

        return maxr;
    } 

    public static int HighwaybillBoard(int m, int[] x, int[] rev, int t){ // space - O(m) , time - O(m)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<x.length; i++){
            map.put(x[i], rev[i]);
        }

        int[] dp = new int[m+1];
        dp[0] = 0;

        for(int i=1; i<=m; i++){
            if(map.containsKey(i) == false){
                dp[i] = dp[i-1];
            }
            else{
                int boardNotInstalled = dp[i-1];
                int boardInstalled = rev[i];
                if(i >= t+1){
                    boardInstalled += dp[i-t-1];
                }

                dp[i] = Math.max(boardInstalled, boardNotInstalled);
            }
        }

        return dp[m];
    }
}
