import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class OOPS {
    //Class consists of functions(methods) and data members encapsulated together
    //Any block of code inside a class that performs any operation is
    //called a Method in Java.
    //Every "Function" written in a class is actually a method.

    public static class Person{
        int age;
        String name;

        void saysHi(){
            System.out.println(name+ "[" + age + "] says hi");
        }

        // if we forget, java provides our class a default constructor.
        // Constructor is the special method that is called when the class 
        // object is formed and has the same name as class.

        // here Person() is a constructor (default)
        Person(){
            // constructor
        }

        // parametrized constructor
        Person(int age, String name){
            this.age= age;
            this.name= name;
        }
        // 1) Space allocation
        // 2) Parsing (Analysing all the data members of the class)
        // 3) Constructor run

        // Note-> if we make a parametrized constructor then if we want to
        // run a default constructor we have to make a default constructor 
        // otherwise there will be a compiler error i.e. default constructor
        // will run by its own if and only if there is no other defined 
        // Parametrized constructor.
    }
    public static void main(String[] args) {
        Person p1=  new Person(); 
// with 'p1' a reference is created in the stack and then with 'new' a 
// heap of space is allocated in the memory for the instance (object) .

// Objects are the data structures in the memory where the data of the
// instance is stored .

// here age and name are the properties of the class Person while p1, p2,
// p3 are the references that points to an instance i.e. they are like 
// pointers .

        p1.age=10;
        p1.name="A";
        //p1.saysHi(); // runs in the context p1 is pointing to

        Person p2=  new Person();
        p2.age=20;
        p2.name="B";
        //p2.saysHi();

        Person p3[] = new Person[3];//Person(30, "C");
        p3[0]= new Person(19,"Pulkit");
        //p3.saysHi();

    //    Person p3= p1; // reference p1 is copied to p3 and will point to the same instance .
// now changes in instances of p3 will be changes in instances of p1

        // p3.age=30; 
        // p3.name="C";
        // p1.saysHi();
        // p3.saysHi();

        // p1.saysHi();
        // p2.saysHi();
        // swap1(p1,p2);
        // p1.saysHi();
        // p2.saysHi();
        // no swap happened because once the function is called the  
        // copies of the references p1 & p2 forms and swapped but these copies 
        // disappears as soon as function is ended.

        // p1.saysHi();
        // p2.saysHi();
        // swap2(p1,p2);
        // p1.saysHi();
        // p2.saysHi();
        // now swap happened since we have directly swapped the values of
        // properties age and name .

        // p1.saysHi();
        // p2.saysHi();
        // swap3(p1,p2);
        // p1.saysHi();
        // p2.saysHi();

// p1 and p2 are the reference of objects (age, name) that refer to the 
// object or instances.  

// So for the above code we have 3 references but 2 instances 

        // ques 1

        DynamicStack st= new DynamicStack();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);

        st.display();
        System.out.println(st.top());
        System.out.println(st.pop());
        st.display();
        System.out.println(st.min());
    }

    public static void swap1 (Person p1, Person p2){
        Person temp= p1;
        p1=p2;
        p2=temp;
    }

    public static void swap2 (Person p1, Person p2){
        int age= p1.age;
        p1.age= p2.age;
        p2.age= age;

        String name= p1.name;
        p1.name= p2.name;
        p2.name= name;
    }

    public static void swap3 (Person p1, Person p2){
        p1= new Person();

        int age= p1.age;
        p1.age= p2.age;
        p2.age= age;

        p2 = new Person();

        String name= p1.name;
        p1.name= p2.name;
        p2.name= name;
    }

    public static class CustomStack {
    int top;
    int[] data;
        
        public CustomStack(int n){
            data= new int[n];
            top=-1;
        }

        int size(){
           return top+1;
        }

        void display(){
            for(int i=top; i>=0;i--){
                System.out.print(data[i] + " ");
            }
        }

        void push(int val){
            
            if(top!= data.length-1){
                top++;
                data[top]= val;
            }
            else{
                System.out.println("Stack overflow");
            }
        }

        int pop(){
            if (top>=0) {
                int val= data[top];
                top--;
                return val;
            }
            else{
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int top(){
            if (top>=0) {
                return data[top];
            }
            else{
                System.out.println("Stack underflow");
                return -1;
            }
        }
    }

    // ques 2

    public static class DynamicStack{
        int top;
        ArrayList<Integer> data= new ArrayList<Integer>();
        
        public DynamicStack(){
            top=-1;
        }

        int size(){
           return data.size();
        }

        void display(){
            for(int i=data.size()-1; i>=0;i--){
                System.out.println(data.get(i));
            }
        }

        void push(int val){
            top++;
            data.add(val);
        }

        int pop(){
            if (data.size()>0) {
                int val= data.get(top);
                data.remove(top);
                top--;
                return val;
            }
            else{
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int top(){
            if (data.size()>0) {
                return data.get(top);
            }
            else{
                System.out.println("Stack underflow");
                return -1;
            }
        }

        // for ques 3
        int min(){
            if (data.size()>0) {
               int min= data.get(0);
               for(int i=1;i<data.size();i++){
                if (min>data.get(i)) {
                    min= data.get(i);
                }
               }
               return min;
            }
            else{
                System.out.println("Stack underflow");
                return -1;
            }
        }
    }

    // ques 4

    public static class MinStack{
        Stack<Integer> data;
        int min;

        public MinStack(){
            data= new Stack<>();
        }
        int size(){
            return data.size();
        }
        void push(int val){
            if (data.size()==0) {
                data.push(val);
                min= val;
            }
            else if(min<=val){
                data.push(val);
            }
            else{
                data.push(val+val-min);// detection, storing a fake smaller value
                min=val;// original value stored in min
            }
        }
        int pop(){
            if(size()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            else{
                int val =data.pop();
                
                if (val>min) {
                    return val;
                }
                else{ // we have done this because now we are not storing value of min, so if 
                    // the peek and min value are equal and we pop, then min value should change 
                    int min1= min;
                    min= min + min -val;
                    return min1;
                }
            }
        }
        int top(){
            if(size()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            else if( data.peek()>=min){
                return data.peek();
            }
            else{
                return min;
            }
        }
        int min(){
            if(size()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            else{
                return min;
            }
        }
    }
}
