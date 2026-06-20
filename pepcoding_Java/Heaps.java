import java.util.*;
import java.io.*;

public class Heaps {
    // Priority Queue (PQ)
    // ** similar to queue; add(), remove(), peek()
    // ** it removes/gets the higher priority element first
    // ** we can choose whether to give greater value more priority or to smaller value more priority
    // ** by default smaller value gets more priority
    
    // Heap (The Implementation): This is how we make PQ efficient. 
    // A heap is a specific tree-based data structure that allows us to 
    // find and remove the highest-priority element in O(log n) time.

    // In Java, there is no Heap class in the standard library (java.util).
    // Instead, Java provides the PriorityQueue class, which is 
    // implemented under the hood using a binary heap (specifically, a 
    // min-heap by default).

    // Min-Heap (Smallest element first)
    // Max-Heap (Largest element first)

    public static class MedianPriorityQueue{
        PriorityQueue<Integer> left; // for smaller half of data
        PriorityQueue<Integer> right; // for greater half of data

        public MedianPriorityQueue(){
            left= new PriorityQueue<>(Collections.reverseOrder());
            right= new PriorityQueue<>();
        }

        void add(int num){

            if(left.isEmpty() || num<=left.peek()){
                left.add(num);
            }
            else{
                right.add(num);
            }

            if(left.size()>right.size()+1){
                right.add(left.remove());
            }
            else if(right.size()>left.size()){
                left.add(right.remove());
            }
        }

        int peek(){
            if(this.size()==0){
                System.out.println("Underflow");
                return -1;
            }

            return left.peek();
        }

        int size(){
            return (left.size()+right.size());
        }

        int remove(){
            if(this.size()==0){
                System.out.println("Underflow");
                return -1;
            }

            int val = left.remove();

            if(right.size() > left.size()){
                left.add(right.remove());
            }

            return val;
        }
    }

    public static int[] KSortedArray(int[] arr, int k){

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int idx = 0;
        
        for(int i=0; i<arr.length; i++){
            if(i<k+1){
                pq.add(arr[i]);
            }
            else{
                arr[idx++] = pq.remove();
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            arr[idx++] = pq.remove();
        }

        return arr;
    }

    public static void main(String[] args){
        PriorityQueue<Integer> pq= new PriorityQueue<>(); // for Min-Heap
        //PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); // for Max-Heap
        int[] ranks = {22,99,3,11,88,4,1};
        for(int val: ranks){ // O(nlogn)
            pq.add(val);
        }

        while(pq.size()>0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
