import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Arrays {

    public static int Span(int n,int[] arr){
        int max=arr[0];
        int min=arr[0];

        for(int i=1; i<arr.length;i++){
            if (arr[i]>max) {
            max= arr[i];
            }
            else if(arr[i]<min) {
            min= arr[i];
            }
        }
        return (max-min);
    }

    public static int Subtraction(int n1, int n2){
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
               d1+=10;
               d= d1-d2; 
               rv+= d*p;
               p=p*10;
               d1=-1;
            }
        }
        return rv;
    }

    public static void RotateHelper(int[] arr, int i, int j){

        while(i<j){
            int temp= arr[i];
            arr[i]= arr[j];
            arr[j]= temp;

            i++;
            j--;
        }
    }

    public static void RotateArray(int[] arr, int k){
        k=k % arr.length;
        if(k<0){
            k=k+arr.length;
        }

        int n= arr.length-1;
        RotateHelper(arr, 0, n-k);
        RotateHelper(arr, n-k+1, n);
        RotateHelper(arr, 0, n);
    }

    public static int[] Inverse(int[] arr){
        int[] nums= new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int val= arr[i];
            nums[val]= i;
        }

        return nums;
    }

    public static void SubSets(int[] arr){
        int limit = (int) Math.pow(2, arr.length);

        for(int i=0; i<limit; i++){
            // convert i to binary and use 0's and 1's
            String set= "";
            int temp=i;

            for(int j=arr.length-1; j>=0; j--){
                int r= temp%2;
                temp=temp/2;

                if(r==0){
                    set= "-" + set;
                }
                else{
                    set= arr[j] + "\t" + set;
                }
            }
            System.out.println(set); 
        }
    }

    // Linear search: check element by element, very slow, high time complexity for large inputs

    //Binary Search: can be applied to sorted array only
    // searches by removing half inputs each time , time complexity O(logn)
    public static int BinarySearch (int[] arr, int data){
        int lo= 0;
        int hi= arr.length-1;
        while(lo<=hi){
            int mid= (lo+hi)/2;

            if(arr[mid]>data){
                hi=mid-1;
            }
            else if(arr[mid]<data){
                lo=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    public static void CeilFloor(int[] arr, int d){
        int ceil=0;
        int floor=0;
        int lo=0;
        int hi=arr.length-1;

        while(lo<=hi){
            int mid= (lo+hi)/2;

            if(arr[mid]>d){
                hi=mid-1;
                if(arr[hi]<d){
                    ceil=arr[mid];
                }
            }
            else if(arr[mid]<d){
                lo=mid+1;
                if(arr[lo]>d){
                    floor= arr[mid];
                }
            }
            else{
                ceil=d;
                floor=d;
                break;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
    public static void main(String[] args) {

        // INTRODUCTION

    /*    int[] arr; // declaration of array
        arr = new int[3]; // space allocation for array in heap consecutively

        arr[0]= 1; // assigning values
        // 
        
        // Performance: traversing to different elements in array takes
        //  same time since in java we directly passes the address of the elements */

        // Java is strictly pass-by-value
        // + Primitive Types When a primitive type (like int, boolean, 
        // or double) is passed to a method, a copy of the actual value 
        // is made. Changes to the parameter within the method do not 
        // affect the original variable in the calling method.

        // + Objects For objects (non-primitive types), the variable 
        // itself is a reference (an address or "pointer" to the object 
        // in memory).
        // When an object is passed to a method, the value of this 
        // reference is copied. This means both the original variable 
        // and the method parameter point to the same object in the 
        // memory heap.

        // Note: when we assign a array to another array a shalow copy
        // is formed i.e. directly address of array is passed to another 

        // Span of array

        // Scanner scn= new Scanner(System.in);
        // int n= scn.nextInt();

        // int[] arr= new int[n];

        // for(int m=0; m<arr.length;m++){
        //     arr[m]= scn.nextInt();
        // }

        // int span= Span(n, arr);
        // System.out.println(span); 

        // Finding element in array

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];

        for(int m=0; m<arr.length;m++){
            arr[m]= scn.nextInt();
        }

        int d= scn.nextInt();
        int count=0;

        for(int i=0;i<n;i++){
            if (arr[i]==d) {
                count++;
                System.out.println(i);
            }
        }
        if (count==0) {
            System.out.println("-1");
        } */

        // bar chart

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];

        for(int m=0; m<arr.length;m++){
            arr[m]= scn.nextInt();
        }
        System.out.println();

        int max= arr[0];
        for(int i=1; i<arr.length;i++){
            if (arr[i]>max) {
            max= arr[i];
            }
        }
        int MAX= max;
        for(int j=1;j<=MAX;j++){
            for(int i=0;i<n;i++){
                if (max- arr[i]<=0) {
                    System.out.print("*  ");
                } 
                else {
                    System.out.print("   ");
                }
            }
            max--;
            System.out.println();
        } */

        // Sum of arrays

    /*    Scanner scn= new Scanner(System.in);
        int n1= scn.nextInt();
        int n2= scn.nextInt();

        int[] arr= new int[n1];
        int[] arry= new int[n2];
        int p=1;
        int a=0;
        int A=0;

        for(int m=0; m<arr.length;m++){
            arr[m]= scn.nextInt();
            a+= arr[m]*p;
            p=p*10;
        }
        
        p=1;
        for(int m=0; m<arry.length;m++){
            arry[m]= scn.nextInt();
            A+= arry[m]*p;
            p=p*10;
        }

        int Sum= a+A;

        int[] NewArr= new int[n1>n2 ? n1: n2];

        int i=0;

        while(Sum!=0){
            NewArr[i]= Sum%10;
            Sum=Sum/10;
            i++;
        }
        
        for(int j=0; j<NewArr.length;j++){
            System.out.println(NewArr[j]);
        } */
        
        // Difference of arrays

    /*    Scanner scn= new Scanner(System.in);
        int n1= scn.nextInt();
        int n2= scn.nextInt();

        int[] arr= new int[n1];
        int[] arry= new int[n2];
        int p=1;
        int a=0;
        int A=0;

        for(int m=0; m<arr.length;m++){
            arr[m]= scn.nextInt();
            a+= arr[m]*p;
            p=p*10;
        }
        
        p=1;
        for(int m=0; m<arry.length;m++){
            arry[m]= scn.nextInt();
            A+= arry[m]*p;
            p=p*10;
        }

        int diff= Subtraction(A, a);

        int[] NewArr= new int[n1>n2 ? n1: n2];

        int i=0;

        while(diff!=0){
            NewArr[i]= diff%10;
            diff=diff/10;
            i++;
        }
        
        for(int j=0; j<NewArr.length;j++){
            System.out.println(NewArr[j]);
        } */

        // Variable sized 2D array

    /*    // Create a 2D array with 3 rows
        int[][] jaggedArray = new int[3][];

        // Assign different column sizes to each row
        jaggedArray[0] = new int[] {1, 2};
        jaggedArray[1] = new int[] {3, 4, 5};
        jaggedArray[2] = new int[] {6};

        // Print the jagged array
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println(); // New line after each row
        } */
        
        // Creating column sizes with for loop

        // int rows = 4;
        // int[][] jaggedArray = new int[rows][];

        // // Assign column sizes using a for loop
        // for (int i = 0; i < rows; i++) {
        //     jaggedArray[i] = new int[i + 1]; // Column size increases with i

        //     // Optional: fill values in the inner array
        //     for (int j = 0; j < jaggedArray[i].length; j++) {
        //         jaggedArray[i][j] = (i + 1) * (j + 1); // Just a sample formula
        //     }
        // }

        // // Print the jagged array
        // for (int i = 0; i < jaggedArray.length; i++) {
        //     for (int j = 0; j < jaggedArray[i].length; j++) {
        //         System.out.print(jaggedArray[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scn.nextInt();
        }

        CeilFloor(arr,5);
    }    
}
