import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Recursion { // we can't declare a top-level class as static in java

// three stages of high level thinking in recursion
// 1) know the expectation of function
// 2) establish faith
// 3) know the relation b/w expectation and faith

    public static void printDecreasing(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n==0){
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void printDecInc(int n){
        printDecreasing(n);
        printIncreasing(n);
    }

    public static int Factorial(int n){
        if(n==0){
            return 1;
        }

        Factorial(n-1);
        return (n*Factorial(n-1));
    }

    public static int Power(int x, int n){

        // M1 (O(n))
        // if(n==0){
        //     return 1;
        // }

        // Power(x, n-1);
        // return (x*Power(x,n-1));

        // M2(O(logn))
        if(n==0){
            return 1;
        }

        int xpnb2 = Power(x,n/2);
        int xn= xpnb2 * xpnb2;

        if(n%2==1){
            xn= xn*x;
        }
        
        return xn;
    }
    
    public static void printZigZag(int n){
        if(n==0){ // base case
            return;
        }

        System.out.print(n+ " "); // pre
        printZigZag(n-1); // left call
        System.out.print(n+ " "); // In
        printZigZag(n-1); // right call
        System.out.print(n+ " "); // post
    }
    
    public static void HanoiTower(int n, int t1id, int t2id, int t3id){
        if(n==0){
            return;
        }

        HanoiTower(n-1, t1id, t3id, t2id);
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");
        HanoiTower(n-1, t3id, t2id, t1id);
    }
    public static class Fibonacci{
        int n;
        int FibSeq(int n){
            if(n==0){
                return 0;
            }
            else if(n==1){
                return 1;
            }
            else{
                return (FibSeq(n-1)+ FibSeq(n-2));
            }
        }
    }

    public static void displayArr(int[] arr, int n){
        if(n==-1){
            return;
        }

        displayArr(arr, n-1);
        if(n<arr.length){
            System.out.println(arr[n]);
        }
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }

        int misa= maxOfArray(arr, idx+1); // max in smaller array
        if(misa>arr[idx]){
            return misa;
        }
        else{
            return arr[idx];
        }
    }

    public static int FirstIndex(int[] arr, int idx, int x){
        if(idx==arr.length){
            return -1;
        }

        if(arr[idx]== x){
            return idx;
        }
        else{
            int fiisa= FirstIndex(arr, idx+1, x); // first index in smaller array
            return fiisa;
        }
    }

    public static int LastIndex(int[] arr, int idx, int x){
        if(idx==arr.length){ // base case
            return -1;
        }

        int liisa= LastIndex(arr, idx+1, x);
        if(liisa!=-1){
            return liisa;
        }
        if(arr[idx]== x){
            return idx;
        }
        else{
            return liisa;
        }
    }

    //M1
    public static ArrayList<Integer> AIndices(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = AIndices(arr, idx + 1, x);

        if (arr[idx] == x) {
            ans.add(0, idx); // keep indices in ascending order
        }

        return ans;
    }
    //M2
    public static int[] AllIndices(int[] arr, int x, int idx, int fsf){ // fsf- found so far
        // when moving from start to end we will count the occurences of the element
        // when moving from end to start we will fill the array
        if(idx== arr.length){
            return new int[fsf];
        }

        if(arr[idx]==x){
            int[] iarr= AllIndices(arr, x, idx+1, fsf+1);
            iarr[fsf]= idx;
            return iarr;
        }
        else{
            int[] iarr= AllIndices(arr, x, idx+1, fsf);
            return iarr;
        }
    }

    // Subsequence - 2^n
    // Substring - n(n+1)/2 , they are continuous
    // both are in order
    // ex- abc: _ _ _ , ab, ac, a, bc, c, b, abc -> they are subsequence
    // abc: a, ab, abc, b, bc, c -> they are Substring

    public static ArrayList<String> gss(String str){ 
        if(str.length()==0){
            ArrayList<String> bres= new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch= str.charAt(0);
        String ros= str.substring(1); // ros- rest of the string
        ArrayList<String> rres= gss(ros); // rres- recursion result

        ArrayList<String> mres= new ArrayList<>(); // mres- my result
        for(String rstr: rres){
            mres.add("" + rstr);
            mres.add(ch + rstr);
        }
        return mres;
    }

    public static ArrayList<String> getStairPaths(int n){
        if(n==0){
            ArrayList<String> bpath= new ArrayList<>();
            bpath.add("");
            return bpath; 
        }
        else if(n<0){
            ArrayList<String> bpath= new ArrayList<>();
            return bpath;
        }

        ArrayList<String> paths1= getStairPaths(n-1);
        ArrayList<String> paths2= getStairPaths(n-2);
        ArrayList<String> paths3= getStairPaths(n-3);
        ArrayList<String> paths= new ArrayList<>();

        for(String path: paths1){
            paths.add(1+path);
        }
        for(String path: paths2){
            paths.add(2+path);
        }
        for(String path: paths3){
            paths.add(3+path);
        }

        return paths;
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> bpath= new ArrayList<>();
            bpath.add("");
            return bpath; 
        }

        ArrayList<String> rpaths= new ArrayList<>();
        ArrayList<String> cpaths= new ArrayList<>();

        if(sr<dr){
            rpaths= getMazePaths(sr+1, sc, dr, dc);
        }
        if(sc<dc){
            cpaths= getMazePaths(sr, sc+1, dr, dc);
        }
        ArrayList<String> paths= new ArrayList<>();

        for(String rpath: rpaths){
            paths.add("v" + rpath);
        }
        for(String cpath: cpaths){
            paths.add("h" + cpath);
        }

        return paths;
    }

    public static ArrayList<String> getMazePathswJumps(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> bpath= new ArrayList<>();
            bpath.add("");
            return bpath; 
        }

        ArrayList<String> paths= new ArrayList<>();

        for(int i=1; i<=dr-sr; i++){
            ArrayList<String> rpaths= getMazePathswJumps(sr+i, sc, dr, dc);
            for(String path : rpaths){
                paths.add("v"+i+ path);
            }
        }

        for(int i=1; i<=dc-sc; i++){
            ArrayList<String> cpaths= getMazePathswJumps(sr, sc+i, dr, dc);
            for(String path : cpaths){
                paths.add("h"+i+ path);
            }
        }

        for(int i=1; i<=dc-sc && i<=dr-sr; i++){
            ArrayList<String> dpaths= getMazePathswJumps(sr+i, sc+i, dr, dc);
            for(String path : dpaths){
                paths.add("d"+i+ path);
            }
        }
        return paths;
    }

    public static void printss(String ques, String ans){ // storing the subsequence in ArrayList and then printing will take a lot of memory which is inefficient
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch= ques.charAt(0);
        String roq= ques.substring(1);

        printss(roq, ans+ "");
        printss(roq, ans+ ch);
    }

    public static void printStairPaths(int n, String path){
        if(n==0){
            System.out.println(path);
            return;
        }
        if(n<0){
            return;
        }

        for(int i=1; i<=3; i++){
            printStairPaths(n-i, path+i);
        }
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String path){
        if(sr==dr && sc==dc){
            System.out.println(path);
            return;
        }

        if(sr<dr){
            printMazePaths(sr+1, sc, dr, dc, path+"v");
        }
        if(sc<dc){
            printMazePaths(sr, sc+1, dr, dc, path+"h");
        }
    }

    public static void printMazePathswJumps(int sr, int sc, int dr, int dc, String path){
        if(sr==dr && sc==dc){
            System.out.println(path);
            return;
        }

        for(int i=1; i<=dr-sr; i++){
            printMazePathswJumps(sr+i, sc, dr, dc, path+"v"+i);
        }
        for(int i=1; i<=dc-sc; i++){
            printMazePathswJumps(sr, sc+i, dr, dc, path+"h"+i);
        }
        for(int i=1; i<=dr-sr && i<=dc-sc; i++){
            printMazePathswJumps(sr+i, sc+i, dr, dc, path+"d"+i);
        }
    }

    public static void permutations (String ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<ques.length(); i++){
            char ch= ques.charAt(i);
            String roq= ques.substring(0, i) + ques.substring(i + 1); // good one
            permutations(roq, ans+ch);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Fibonacci seq= new Fibonacci();
        // seq.n= scn.nextInt();

        // for (int i = 0; i <=seq.n; i++) {
        //     System.out.print(seq.FibSeq(i)+ " ");
        // }

        // int x= scn.nextInt();
        int n= scn.nextInt();
        // printDecreasing(n);
        //printDecInc(n);
        // int fact= Factorial(n);
        // System.out.println(fact);

        // int pow= Power(x,n);
        // System.out.println(pow);

        // int t1d= scn.nextInt();
        // int t2d= scn.nextInt();
        // int t3d= scn.nextInt();
        // HanoiTower(n, t1d, t2d, t3d); 

        // int[] arr= new int[n];
        // for(int i=0; i<n; i++){
        //     arr[i] = scn.nextInt();
        // } 
        // displayArr(arr, n);

        //System.out.println(AIndices(arr, 0, 5));

        //printStairPaths(n, "");

        //printMazePaths(1, 1, 3, 3, "");
        //printMazePathswJumps(1, 1, 3, 3, "");

        permutations("abc", "");
    }
}
