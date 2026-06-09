import java.util.*;

public class Queues {
    public static void main(String args[]){
        // INTRODUCTION
        
        // Queues implement FIFO i.e. First in First Out
        // add- add, remove- remove, top- peek
        // remove and peek will give first element that is First IN

    //    Queue<Integer> que= new ArrayDeque<>();

        // Queue is an interface function i.e. it will only have declaration, which 
        // is implemented by Dequeue interface which then implemented by
        // ArrayDequeue class which then fills the body of the interface.
        
    /*    que.add(10);
        System.out.println(que);
        que.add(20);
        System.out.println(que);
        que.add(30);
        System.out.println(que);

        System.out.println(que.remove());
        System.out.println(que.peek());
        System.out.println(que); */

        // Ques 1
        
        DQueue que= new DQueue(5);
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6);
        que.add(7);
        System.out.println(que.peek());
        System.out.println(que.remove());
        que.display();
        System.out.println(que.remove());
        System.out.println(que.peek());
        que.add(8);
        que.add(9);
        que.add(10);
        que.add(11);
        que.add(12);
        que.add(13);
        que.display();
        
    }

    // Ques 1 **
    public static class NQueue{
        int[] data;
        int front=0;
        int size=0;

        NQueue(int cap){
            data= new int[cap];       
        }

        int size(){
            return size;
        }

        void add(int val){
            if(size()== data.length){
                System.out.println("Queue overflow");
            }
            else{
                int rear= (front + size) % data.length;
                data[rear]= val;
                size++;
            }
        }

        int peek(){
            if (size>0) {
               return data[front];
            }
            else{
                System.out.println("Queue underflow");
                return -1;
            }
        }
        int remove(){
            if (size==0) {
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                int val= data[front];
                front= (front+1) % data.length;
                size--;
                return val;
            }
        }
        void display(){
            for(int i=0; i< size; i++){
                int idx= (front +i)% data.length;
                System.out.print(data[idx]+ " ");
            }
            System.out.println();
        }
    }

    // Ques 2 *
    public static class DQueue{
        int[] data;
        int front=0;
        int size=0;

        DQueue(int cap){
            data= new int[cap];       
        }

        int size(){
            return size;
        }

        void add(int val){
            if(size()== data.length){
                int[] arr= new int[data.length*2];
                for(int i=0; i<data.length;i++){
                    int idx= (front+i)% data.length; // else you will get zero in output at some indexes
                    arr[i]= data[idx];
                }
                data= arr;
                front=0;
                int rear= (front + size) % data.length;
                data[rear]= val;
                size++;
            }
            else{
                int rear= (front + size) % data.length;
                data[rear]= val;
                size++;
            }
        }

        int peek(){
            if (size>0) {
               return data[front];
            }
            else{
                System.out.println("Queue underflow");
                return -1;
            }
        }
        int remove(){
            if (size==0) {
                System.out.println("Queue underflow");
                return -1;
            }
            else{
                int val= data[front];
                front= (front+1) % data.length;
                size--;
                return val;
            }
        }
        void display(){
            for(int i=0; i< size; i++){
                int idx= (front +i)% data.length;
                System.out.print(data[idx]+ " ");
            }
            System.out.println();
        }
    }
}
