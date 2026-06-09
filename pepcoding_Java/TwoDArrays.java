import java.util.Scanner;

public class TwoDArrays {

    public static void print(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void MatrixMul(int[][] arr1, int[][] arr2){
        if(arr1[0].length != arr2.length || arr1==null || arr2==null){
            System.out.println("Invalid");
            return;
        }

        int[][] arr = new int[arr1.length][arr2[0].length];
        for(int i=0; i<arr1.length; i++){
            int col=0;
            int j=0;
            while(col< arr2[0].length){
                arr[i][col] += arr1[i][j] * arr2[j][col];
                j++;
                if(j== arr2.length){
                    j=0;
                    col++;
                }
            }
        }
        print(arr);
    }

    public static void WaveTraversal(int[][] arr){
        int n= arr.length;
        int m= arr[0].length;

        for(int i=0; i<m; i++){
            if(i%2==0){
                for(int j=0; j<n; j++){
                    System.out.print(arr[j][i] + " ");
                }
            }
            else{
                for(int j=n-1; j>=0; j--){
                    System.out.print(arr[j][i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void SpiralTraversal(int[][] arr){
        int n= arr.length;
        int m= arr[0].length;
        int minr = 0;
        int minc = 0;
        int maxr = arr.length-1;
        int maxc = arr[0].length-1;
        int tne = n*m;
        int cnt=0;

        while (cnt<tne) {
            // left wall
            for(int i=minr, j=minc; i<=maxr && cnt<tne; i++){
                System.out.print(arr[i][j]+ " ");
                cnt++;
            }
            minc++;

            // bottom wall
            for(int i=maxr, j=minc; j<=maxc && cnt<tne; j++){
                System.out.print(arr[i][j]+ " ");
                cnt++;
            }
            maxr--;

            // right wall
            for(int i=maxr, j=maxc; i>=minr && cnt<tne; i--){
                System.out.print(arr[i][j]+ " ");
                cnt++;
            }
            maxc--;

            // top wall
            for(int i=minr, j=minc; i<=maxr && cnt<tne; i++){
                System.out.print(arr[i][j]+ " ");
                cnt++;
            }
            minr++;
        }
    }

    public static void ExitPoint(int[][] a){
        int n= a.length;
        int m= a[0].length;
        int dir=0; // 0-e, 1-s, 2-w, 3-n
        int i=0;
        int j=0;

        while(i<n && j<m && i>=0 && j>=0){
            dir = (dir+a[i][j]%4);

            if(dir==0){ // east
                j++;
            }
            else if(dir==1){ // south
                i++;
            }
            else if(dir==2){ // west
                j--;
            }
            else if(dir==3){ // north
                i--;
            }
        }
        if(i==n){
            i--;
        }
        if(j==m){
            j--;
        }
        if(i==-1){
            i++;
        }
        if(j==-1){
            j++;
        }

        System.out.println("("+ i + "," + j+ ")");
    }

    public static void RotateBy90(int[][] arr) {
        int n= arr.length;

        // transpose
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){ // we have started from j=i since some elements get transposed twice so we only traverse in upper triangle 
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++){
            int li=0;
            int ri= n-1;

            while(li<ri){
                int temp= arr[i][li];
                arr[i][li]= arr[i][ri];
                arr[i][ri]= temp;

                li++;
                ri--;
            }
        }
        print(arr);
    }

    public static void ShellRotate(int[][] arr, int s, int r){
        //M1 (not best approach) (O(n*r))
        // int minr = 0 + (s-1);
        // int minc = 0 + (s-1);
        // int maxr = arr.length-1 - (s-1);
        // int maxc = arr[0].length-1 - (s-1);
        // int size = 2 * (maxr - minr + maxc - minc);
        // r = r % size;   // avoid extra rotations

        // while (r>0) {
        //     int prev = arr[minr][minc];

        //     // left wall (top → bottom)
        // for (int i = minr + 1; i <= maxr; i++) {
        //     int temp = arr[i][minc];
        //     arr[i][minc] = prev;
        //     prev = temp;
        // }

        // // bottom wall (left → right)
        // for (int j = minc + 1; j <= maxc; j++) {
        //     int temp = arr[maxr][j];
        //     arr[maxr][j] = prev;
        //     prev = temp;
        // }

        // // right wall (bottom → top)
        // for (int i = maxr - 1; i >= minr; i--) {
        //     int temp = arr[i][maxc];
        //     arr[i][maxc] = prev;
        //     prev = temp;
        // }

        // // top wall (right → left)
        // for (int j = maxc - 1; j >= minc; j--) {
        //     int temp = arr[minr][j];
        //     arr[minr][j] = prev;
        //     prev = temp;
        // }
        //     r--;
        // }
        // print(arr);

        //M2 (O(n))

        int[] oned= fillOnedFromShell(arr, s);
        rotate(oned,r);
        fillShellFromOned(arr, s, oned);
        print(arr);
    }
    public static void rotate(int[] nums, int k) {
        if(k<0){
            k= k+nums.length;
        }
        k= k%nums.length;

        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    public static void reverse(int[] arr, int li, int ri){
        while(li<ri){
            int temp= arr[li];
            arr[li]= arr[ri];
            arr[ri]= temp;

            li++;
            ri--;
        }
    }
    public static int[] fillOnedFromShell(int[][] arr, int s){
        int minr = s-1;
        int minc= s-1;
        int maxr= arr.length-s;
        int maxc= arr[0].length-s;
        int size= 2*(maxr-minr+maxc-minc);
        int[] oned = new int[size];
        int idx=0;

        // lw
        for(int i=minr, j=minc; i<=maxr; i++){
            oned[idx]= arr[i][j];
            idx++;
        }
        //bw
        for(int i=maxr, j=minc+1; j<=maxc; j++){
            oned[idx]= arr[i][j];
            idx++;
        }
        //rw
        for(int i=maxr-1, j=maxc; i>=minr; i--){
            oned[idx]= arr[i][j];
            idx++;
        }
        //tw
        for(int i=minr, j=maxc-1; j>minc; i++){
            oned[idx]= arr[i][j];
            idx++;
        }
        return oned;
    }
    public static void fillShellFromOned(int[][] arr, int s, int[] oned){
        int minr = s-1;
        int minc= s-1;
        int maxr= arr.length-s;
        int maxc= arr[0].length-s;
        int idx=0;

        // lw
        for(int i=minr, j=minc; i<=maxr; i++){
            arr[i][j]= oned[idx];
            idx++;
        }
        //bw
        for(int i=maxr, j=minc+1; j<=maxc; j++){
            arr[i][j]= oned[idx];
            idx++;
        }
        //rw
        for(int i=maxr-1, j=maxc; i>=minr; i--){
            arr[i][j]= oned[idx];
            idx++;
        }
        //tw
        for(int i=minr, j=maxc-1; j>minc; i++){
            arr[i][j]= oned[idx];
            idx++;
        }
    }

    public static void diagonalTraverse(int[][] arr){
        int n= arr.length;

        // for(int i=0; i<n; i++){
        //     int j=i;
        //     while(j<n){
        //         System.out.print(arr[i][j]+ " ");
        //         j++;
        //     }
        //     System.out.println();
        // }

        for(int g=0; g<n; g++){
            for(int i=0,j=g; j<n;j++){
                System.out.println(arr[i][j]); // in this we are moving diagonally
            }
        }
    }

    public static int saddlePoint(int[][] arr){
        int row=0; 

        while(row<arr.length){
            int col=0;
            int min= arr[row][0];

            for(int j=1; j<arr[0].length; j++){
                if(min>arr[row][j]){
                    min= arr[row][j];
                    col=j;
                }
            }

            boolean isSaddle = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][col] > min) {
                    isSaddle = false;
                    break;
                }
            }

            if(isSaddle){
                return min;
            }

            row++;
        }
        return -1;
    }

    public static void Search(int[][] arr, int x){
        int i=0;
        int j=arr[0].length-1;

        while(i<arr.length && j>=0){
            if(x==arr[i][j]){
                System.out.println(i+ "," + j);
            }
            else if(x<arr[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("Not Found");
    }
    public static void main(String args[]){
        // INTRODUCTION
        // int[][] arr;
        // arr = new int[3][4]; // first bracket is no. of rows and second one is columns 

        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int m= scn.nextInt();
        // int p= scn.nextInt();
        // int q= scn.nextInt();

        // Taking Input 
        int[][] arr1= new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr1[i][j]= scn.nextInt();
            }
        }

        //Printing the 2D array
        // for(int i=0; i<arr.length; i++){
        //     for(int j=0; j<arr[i].length; j++){
        //         System.out.print(arr[i][j]+ " ");
        //     }
        //     System.out.println(); // so that abstract view(in matrix form) of 2D array can be obtained
        // }

        // int[][] arr2= new int[p][q];
        // for(int i=0; i<p; i++){
        //     for(int j=0; j<q; j++){
        //         arr2[i][j]= scn.nextInt();
        //     }
        // }

        //MatrixMul(arr1, arr2);

        //WaveTraversal(arr1);

        //ExitPoint(arr1);

        //ShellRotate(arr1, 1, 1);

        //diagonalTraverse(arr1);

        int point= saddlePoint(arr1);
        System.out.println(point);
    }
}
