import java.util.*;

//import pepcoding_Java.Heaps.Student;

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

    // public static class MedianPriorityQueue{
    //     PriorityQueue<Integer> left; // for smaller half of data
    //     PriorityQueue<Integer> right; // for greater half of data

    //     public MedianPriorityQueue(){
    //         left= new PriorityQueue<>(Collections.reverseOrder());
    //         right= new PriorityQueue<>();
    //     }

    //     void add(int num){

    //         if(left.isEmpty() || num<=left.peek()){
    //             left.add(num);
    //         }
    //         else{
    //             right.add(num);
    //         }

    //         if(left.size()>right.size()+1){
    //             right.add(left.remove());
    //         }
    //         else if(right.size()>left.size()){
    //             left.add(right.remove());
    //         }
    //     }

    //     int peek(){
    //         if(this.size()==0){
    //             System.out.println("Underflow");
    //             return -1;
    //         }

    //         return left.peek();
    //     }

    //     int size(){
    //         return (left.size()+right.size());
    //     }

    //     int remove(){
    //         if(this.size()==0){
    //             System.out.println("Underflow");
    //             return -1;
    //         }

    //         int val = left.remove();

    //         if(right.size() > left.size()){
    //             left.add(right.remove());
    //         }

    //         return val;
    //     }
    // }

    public static class PriorityQueue<T>{
        ArrayList<T> data;
        Comparator<T> comp;

        public PriorityQueue(){
            data = new ArrayList<>();
            comp=null;
        }

        public PriorityQueue(Comparator<T> comp){
            data = new ArrayList<>();
            this.comp = comp;
        }


        // public PriorityQueue(int[] arr){
        //     data= new ArrayList<>();
        //     for(int val: arr){
        //         data.add(val); // if we write this.add(val) it will call add method and hence will call upheapify
        //         // which will take O(nlogn) time 
        //     }

        //     for(int i= data.size()/2 - 1; i>=0; i--){
        //         downheapify(i);  // by this way we have reduced time to O(n)
        //     }
        // }

        private boolean isSmaller(int i, int j){
            if(comp == null){
                T ith = data.get(i);
                T jth = data.get(j);

                if (((Comparable<T>) ith).compareTo(jth) < 0) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                T ith= data.get(i);
                T jth= data.get(j);
                if(comp.compare(ith, jth)<0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }

        public void add(T val){
            data.add(val);
            upheapify(data.size()-1);
        }

        private void upheapify(int i){
            int pi = (i-1)/2;
            if(isSmaller(i, pi)){
                swap(i, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j){
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public T remove(){
            if(this.size()==0){
                System.out.println("Underflow");
                return null;
            }

            swap(0, data.size()-1);
            T val= data.remove(data.size()-1);
            downheapify(0);
            return val;
        }

        private void downheapify(int pi){
            int mini = pi;

            int li= 2*pi+1;
            if(li<data.size() && isSmaller(li, mini)){
                mini=li;
            }

            int ri= 2*pi+2;
            if(ri<data.size() && isSmaller(ri, mini)){
                mini=ri;
            }

            if(mini != pi){
                swap(pi, mini);
                downheapify(mini);
            }
        }
        
        public T peek(){
            if(this.size()==0){
                System.out.println("Underflow");
                return null;
            }

            return data.get(0);
        }
        public int size(){
            return data.size();
        }
    }

    public static class Pair implements Comparable<Pair> {
        int li;
        int di;
        int val;

        Pair(int li, int di, int val){
            this.li= li;
            this.di= di;
            this.val= val;
        }

        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }

    public static class Student implements Comparable<Student>{
        int rno;
        int ht;
        int wt;

        Student(int rno, int ht, int wt){
            this.rno = rno;
            this.ht = ht;
            this.wt = wt;
        }

        public int compareTo(Student o){
            // return this.ht - o.ht;
            return o.rno - this.rno;
        }

        public String toString(){
            return "rno = " + this.rno + ", Ht = " + this.ht + ", Wt = " + this.wt;
        }
    }

    // Comparator interface is used for comparing on more than one parameter

    static class StudentHtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2){
            return s1.ht - s2.ht;
        }
    }

    static class StudentWtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2){
            return s1.wt - s2.wt;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv=  new ArrayList<>();

        PriorityQueue<Pair> pq= new PriorityQueue<>();
        for(int i=0; i<lists.size(); i++){
            Pair p= new Pair(i,0, lists.get(i).get(0));
            pq.add(p);
        }

        while(pq.size()>0){
            Pair p= pq.remove();
            rv.add(p.val);
            p.di++;

            if(p.di< lists.get(p.li).size()){
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return rv;
    }

    // public static int[] KSortedArray(int[] arr, int k){

    //     PriorityQueue<Integer> pq= new PriorityQueue<>();
    //     int idx = 0;
        
    //     for(int i=0; i<arr.length; i++){
    //         if(i<k+1){
    //             pq.add(arr[i]);
    //         }
    //         else{
    //             arr[idx++] = pq.remove();
    //             pq.add(arr[i]);
    //         }
    //     }

    //     while (!pq.isEmpty()) {
    //         arr[idx++] = pq.remove();
    //     }

    //     return arr;
    // }

    public static void main(String[] args){
        //PriorityQueue<Integer> pq= new PriorityQueue<>(); // for Min-Heap
        //PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); // for Max-Heap
        // int[] ranks = {22,99,3,11,88,4,1};
        // for(int val: ranks){ // O(nlogn)
        //     pq.add(val);
        // }

        // while(pq.size()>0){
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }

        PriorityQueue<Student> pq= new PriorityQueue<>(new StudentWtComparator());

        pq.add(new Student(10, 180, 85));
        pq.add(new Student(2, 185, 85));
        pq.add(new Student(12, 170, 84));
        pq.add(new Student(18, 179, 88));
        pq.add(new Student(7, 182, 82));
        
        while(pq.size()>0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
