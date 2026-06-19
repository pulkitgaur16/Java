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
