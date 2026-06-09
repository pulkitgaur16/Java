public class LinkedLists {

    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head; // first node address
        Node tail; // last node address
        int size; // size of the Linked list

        void addLast(int val){
            Node temp= new Node();
            temp.data= val;
            temp.next= null;

            if (size==0) {
                head= tail= temp;
            } else {
                tail.next=temp;
                tail=temp;
            }
            size++;
        }

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head; //pointing the temp node to head node as its next node

            head = temp; // head reference is now pointing to temp

            if (size == 0) {
                tail = temp;
            }
            size++;
        }
        
// here i do not need to write public with the size method since i have to 
// access it only in the same program or under same package but if i have
// to use this class and this method in some other package then i have to
// use public
        int size(){ 
            return size;
        }

        void display(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp= temp.next;
            }
            System.out.println();
        }

        int removeFirst(){
            if (size==0) {
              System.out.println("List is empty");  
              return -1;
            } 
            else {
                Node val= head;
                if (size==1) {
                    head= null;
                    tail= null;
                    size--;
                    return val.data;
                }
                else{
                    head= head.next;
                    size--;
                    return val.data;
                }
            }
        }

        int removeLast(){
            if (size==0) {
                System.out.println("List is empty");
                return -1;
            } 
            else if(size==1) {
                Node temp= head;
                head= null;
                tail= null;
                size--;
                return temp.data;
            }
            else{
                Node node= new Node();

                Node temp= head;
                for(int i=0; i<size-2;i++){
                    temp=temp.next;
                }
                node= temp.next;
                tail=temp;
                temp.next=null;
                size--;
                return node.data;
            }
        }

        void removeAt(int idx){
            if(idx<0 || idx>=size){
                System.out.println("invalid arguments");
            }
            else if(idx==0){
                removeFirst();
            }
            else if(idx==size-1){
                removeLast();
            }
            else{

                Node temp= head;
                for(int i=0; i<idx-1;i++){
                    temp=temp.next;
                }
                temp.next= temp.next.next;
                size--;
            }
        }

        int getFirst(){
            if (size==0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }
        int getLast(){
            if (size==0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }
        int getAt(int index){
            if (size==0) {
                System.out.println("List is empty");
                return -1;
            } 
            else {
                Node temp= head;
                int i=0;
                while (i<index) {
                    temp= temp.next;
                    i++;
                }
                return temp.data;
            }
        }
        void addAt(int val, int idx){
            if(idx==0){
                addFirst(val);
            }
            else if(idx== size){
                addLast(val);
            }
            else if(idx<0 || idx>size){
                System.out.println("Invalid arguments");
            }
            else{
                Node node= new Node();
                node.data=val;

                Node temp= head;
                for(int i=0;i<idx-1;i++){
                    temp=temp.next;
                }
                node.next= temp.next;
                temp.next=node;

                size++;
            }
        }
        private Node getNodeAt(int idx){
            Node temp= head;
            for(int i=0;i<idx;i++){
                temp= temp.next;
            }
            return temp;
        }
        public void reverseDI(){
            int li= 0;
            int ri= size-1;

            while(li<ri){
                Node left= getNodeAt(li);
                Node right= getNodeAt(ri);

                int temp= left.data;
                left.data= right.data;
                right.data= temp;

                li++;
                ri--;
            }
        }
        public void reversePI(){
            Node prev=null;
            Node temp=head;
            while(temp != null){
                Node next = temp.next;
                temp.next= prev;
                prev=temp;
                temp=next;
            }
            Node newT = head;
            head=tail;
            tail=newT;
        }
        int getElementFromLast(int k){
            int slow=0;
            int fast=k;
            while(getNodeAt(fast) != tail){
                slow++;
                fast++;
            }
            return getAt(slow);
        }
        // Display reverse linked list without changing the actual one
        //Using Recursion
        private void displayReverseHelper(Node node){
            if(node==null){
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }

        public void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }
        //Reverse Linked list Pointer-Recursive
        private void reversePRHelper(Node node){
            if(node==null){
                return;
            }
            reversePRHelper(node.next);
            Node prev = node;
            if(node==tail ){
                return;
            }
            else{
                prev=prev.next;
                prev.next=node;
            }
            if(node==head){
                node.next=null;
            }
        }
        public void reversePR(){
            reversePRHelper(head);
            Node temp=head;
            head=tail;
            tail=temp;
        }
        //Reverse Linked list Data-Recursive
        // **Remember this approach
        private void reverseDRHelper(Node right, int floor){
            if(right==null){
                return;
            }
            reverseDRHelper(right.next, floor+1);

            if(floor>=size/2){
                int temp= right.data;
                right.data= rleft.data;
                rleft.data=temp;

                rleft=rleft.next;
            }
        }

        Node rleft;
        public void reverseDR(){
            rleft= head;
            reverseDRHelper(head,0);
        }
        // Palindrome Linked list
        private boolean IsPalindromeHelper(Node right, int floor){
            if(right==null){
                return true;
            }
            boolean rres= IsPalindromeHelper(right.next, floor+1);

            if(floor>=size/2){
                if(pleft.data!=right.data) {
                    return false;
                }
                else if(rres==false){
                    return false;
                }
                else{
                    pleft=pleft.next;
                    return true;
                } 
            }
            return true;
        }

        Node pleft;
        public void isPalindrome(){
            pleft=head;
            IsPalindromeHelper(head, 0);
        }

        // Add two Linked Lists
        public static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
        if (one == null && two == null) {
            return 0;
        }

        int data = 0;

        if (pv1 > pv2) {
            int oc = addListHelper(one.next, pv1 - 1, two, pv2, res);
            data = one.data + oc;
        } 
        else if (pv1 < pv2) {
            int oc = addListHelper(one, pv1, two.next, pv2 - 1, res);
            data = two.data + oc;
        } 
        else {
            int oc = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
            data = one.data + two.data + oc;
        }

        int nd = data % 10;
        int nc = data / 10;

        res.addFirst(nd);
        return nc;
        }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList res = new LinkedList();
    
        int oc = addListHelper(one.head, one.size, two.head, two.size, res);
        if (oc > 0) {
            res.addFirst(oc);
        }

        return res;
    }

}


    public static void testList(LinkedList list){}
    public static void main( String args[]) {
    // INTRODUCTION

    // Arrays require continuous space available in the memory to 
    // store data, if continuous space is not available we can't create
    // a array; for that reason Linked Lists came into use.

    // Linked Lists is an optimal way of storing data when there is a 
    // fragmented (not continuous) space available in the memory.

    // Arrays use 4 bytes to store a single value while LL uses 8 bytes
    // to store a single value ; 4 bytes for data and other 4 bytes
    // for storing address (pointer) of next node.

    // Each element in a LL consists of data and address of next 
    // element and is combinedly known as Node. 

    // Note: In the last node the address data is null.

        LinkedList list= new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        // list.addLast(4);
        // list.addLast(5);
        // list.addFirst(6);
        // System.out.println(list.size());
        // list.display();
        // list.removeFirst();
        // list.display();
        // System.out.println(list.removeFirst());
        // list.addFirst(1);
        // list.display();
        // System.out.println(list.getFirst());
        // System.out.println(list.getLast());
        // System.out.println(list.getAt(1));

        list.addAt(0, 0);
        list.addAt(4,4);
        list.addAt(5,1);
        list.display();
        System.out.println(list.removeLast());
        list.display();
        list.removeAt(2);
        list.display();
        list.reverseDI();
        list.display();
    }
    
}
