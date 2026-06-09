import java.util.*;
import java.util.Arrays;

public class SortingAlgo {

    // Bubble Sort (O(n^2))
    public static void bubbleSort(int[] arr){
        for(int itr=1; itr<=arr.length-1; itr++){
            for(int j=0; j<arr.length-itr; j++){
                if(isSmaller(arr, j+1,j)){
                    swap(arr, j+1, j);
                }
            }
        }
    }

    //Selection Sort
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1;i++){
            int min= i;
            for(int j=i+1; j<arr.length;j++){
                if(isSmaller(arr, j, min)){
                    min=j;
                }
            }
            swap(arr, i, min);
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=i-1; j>=0;j--){
                if(isGreater(arr, j, j+1)){
                    swap(arr, j, j+1);
                }
                else{
                    break;
                }
            }
        }
    }

    // Merge sort
    public static int[] mergeSort(int[] arr, int lo, int hi){
        if(lo==hi){
            int[] ba= new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo+hi)/2;
        int[] fsh = mergeSort(arr, lo, mid);
        int[] ssh = mergeSort(arr, mid+1, hi);
        int[] fsa = mergeTwoSortedArrays(fsh, ssh);
        return fsa;
    }

    // Partitioning an array
    public static int partition(int[] arr, int pivot, int lo, int hi){
        // three regions
        // 0 to j-1 <= pivot
        // j to i-1 > pivot
        // i to end -> unknown
        int i=lo;
        int j=lo;

        while (i <= hi) {
        if (arr[i] <= pivot) {
            swap(arr, i, j);
            i++;
            j++;
        } else {
            i++;
        }
        }

        return j-1;
    }  

    // Quick Sort
    public static void quickSort(int[] arr, int lo, int hi){
        if(lo>=hi){
            return;
        }

        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);
        quickSort(arr, lo, pi-1);
        quickSort(arr, pi+1, hi);
    }

    // Quick Select
    public static int quickSelect(int[] arr, int lo, int hi, int k){
        if (lo > hi) return -1;

        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);

        if(k>pi){
            return quickSelect(arr, pi+1, hi, k);
        }
        else if(k<pi){
            return quickSelect(arr, lo, pi-1, k);
        }
        else{
            return arr[pi];
        }
    }

    // Stable sort : if two or more values are equal then they are sorted in the same order as they are in previously

    // Count Sort (use this when there are higher no. of inputs but range is less)
    public static void countSort(int[] arr, int min, int max){ // also maintain stable sorting
        int range = max-min+1;
        int[] farr= new int[range];

        for(int i=0; i<arr.length; i++){
            int idx = arr[i]-min;
            farr[idx]++;
        }

        // Converting farr into prefix sum array
        for(int i=1; i<farr.length; i++){
            farr[i] = farr[i]+ farr[i-1];
        }

        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0;i--){
            int val= arr[i];
            int pos= farr[val-min];
            int idx= pos-1;
            ans[idx] = val;
            farr[val-min]--;
        }

        for(int i=0; i<arr.length; i++){
            arr[i]= ans[i];
        }
    }

    public static void radixSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int val: arr){
            if(max<val){
                max=val;
            }
        }

        int exp=1;
        while(exp<=max){
            RadixcountSort(arr, exp);
            exp = exp*10;
        }
    }

    public static void RadixcountSort(int[] arr, int exp){
        int[] farr= new int[10];

        for(int i=0; i<arr.length; i++){
            farr[arr[i]/exp %10]++;
        }

        // Converting farr into prefix sum array
        for(int i=1; i<farr.length; i++){
            farr[i] = farr[i]+ farr[i-1];
        }

        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0;i--){
            int val= arr[i];
            int pos= farr[val/exp %10];
            int idx= pos-1;
            ans[idx] = val;
            farr[val/exp % 10]--;
        }

        for(int i=0; i<arr.length; i++){
            arr[i]= ans[i];
        }
    }

    public static void sort012(int[] arr){
        int[] farr= new int[3];
        for(int i=0; i<arr.length;i++){
            farr[arr[i]]++;
        }

        for(int i=1; i<farr.length;i++){
            farr[i]= farr[i] + farr[i-1];
        }

        int[] ans= new int[arr.length];
        for(int i= arr.length-1; i>=0; i--){
            int pos= farr[arr[i]];
            int idx= pos-1;
            ans[idx] = arr[i];
            farr[arr[i]]--;
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = ans[i];
        }
    }

    public static int[] mergeTwoSortedArrays(int[] nums1, int nums2[]){
        int[] arr= new int[nums1.length+ nums2.length];
        int i=0;
        int j=0;
        int k=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                arr[k]= nums1[i];
                k++;
                i++;
            }
            else{
                arr[k]= nums2[j];
                k++;
                j++;
            }
        }
        while(i<nums1.length){
            arr[k]= nums1[i];
            k++;
            i++;
        }
        while(j<nums2.length){
            arr[k]= nums2[j];
            k++;
            j++;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }

    public static boolean isGreater(int[] arr, int i, int j){
        System.out.println("Comaparing " + arr[i] + " and " + arr[j]);
        if(arr[i] > arr[j]){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isSmaller(int[] arr, int i, int j){
        System.out.println("Comaparing " + arr[i] + " and " + arr[j]);
        if(arr[i] < arr[j]){
            return true;
        }
        else{
            return false;
        }
    }

    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void targetSumPair(int[] arr, int target){
        Arrays.sort(arr);

        int li=0;
        int ri=arr.length-1;
        while (li<ri) {
            if(arr[li]+arr[ri]<target){
                li++;
            }
            else if(arr[li]+arr[ri]>target){
                ri--;
            }
            else{
                System.out.println(arr[li] + ", "+ arr[ri]);
                li++;
                ri--;
            }
        }
    }
    
    public static int findPivot(int[] arr){
        int lo=0;
        int hi= arr.length-1;

        while(lo<hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<arr[hi]){
                hi=mid;
            }
            else{
                lo= mid+1;
            }
        }
        return arr[hi];
    }

    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        //bubbleSort(arr);
        //selectionSort(arr);
        //print(arr);
        // int[] sortedArr= mergeSort(arr, 0, 4);
        // for(int i=0; i<sortedArr.length; i++){
        //     System.out.print(sortedArr[i] + " ");
        // }

        // int k= 3;
        // int thirdSmallest = quickSelect(arr, 0, n-1, k-1);
        // System.out.println(thirdSmallest);

        // radixSort(arr);
        // print(arr);

        sort012(arr);
        print(arr);
    }
}
