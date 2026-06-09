import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class revision {

    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList{
        // Create two reference variables that can point to Node objects.
        Node head;
        Node tail;
        // head and tail are only references to point to node objects
        int size;

        void addLast(int val){
            Node temp= new Node();
            temp.data= val;
            temp.next= null;
            if(size==0){
                head=tail=temp;
            }
            else{
                tail.next= temp; // The current last node now points to the new node.
                tail = temp; // Move tail forward to the new last node.
            }
            size++;
        }
    }

    // Celebrity problem (elimination approach)

    public static void Celebrity(int[][] arr){
        Stack<Integer> st= new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while(st.size()>1){
            int i= st.pop();
            int j= st.pop();
            if(arr[i][j]==1){
                st.push(j);
            }
            else{
                st.push(i);
            }
        }

        int value= st.pop();
        for (int i = 0; i < arr.length; i++) {
            if(i!=value){
                if(arr[i][value] ==0 || arr[value][i]==1){
                    System.out.println("None"); // value can't be a celebrity
                    return ;
                }
            }
        }
        System.out.print(value);
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int solve(int a, int b, char opr){
        int solve =0;
        if(opr=='+'){
            solve= a+b; 
        }
        else if(opr=='-'){
            solve= a-b; 
        }
        else if(opr=='*'){
            solve= a*b; 
        }
        else if(opr=='/'){
            solve= a/b; 
        }
        return solve;
    }

    public static int precedence(char optor){ 
        if (optor== '+') {
            return 1;
        } 
        else if(optor== '-'){
            return 1;
        }
        else if(optor== '*'){
            return 2;
        }
        else {
            return 2;
        }
    }
    public static void main(String args[]){

        //Infix conversion

        // Scanner scn = new Scanner(System.in);
        // String st= scn.nextLine();

        // Stack<Character> optors= new Stack<>();
        // Stack<String> prefix= new Stack<>();
        // Stack<String> postfix= new Stack<>();

        // for(int i=0; i<st.length(); i++){
        //     char ch= st.charAt(i);

        //     if (ch=='(') {
        //         optors.push(ch);
        //     } 
        //     else if(Character.isDigit(ch) ) {
        //         prefix.push(String.valueOf(ch));
        //         postfix.push(String.valueOf(ch));
        //     }
        //     else if(ch==')' ) {
        //         while (optors.peek() != '(') {
        //             char optor= optors.pop();
        //             String v2= prefix.pop();
        //             String v1= prefix.pop();

        //             prefix.push(optor+v1+v2);

        //             v2= postfix.pop();
        //             v1= postfix.pop();
        //             postfix.push(v1+v2+optor);
        //         }

        //         optors.pop();
        //     }
        //     else if(ch=='+' || ch=='-'|| ch=='*'|| ch=='/' ) {
        //         // ch is wanting higher priority operators to solve first 
        //         while (optors.size()>0 && optors.peek()!='(' && precedence(ch)<= precedence(optors.peek())) {
        //             char optor= optors.pop();
        //             String v2= prefix.pop();
        //             String v1= prefix.pop();

        //             prefix.push(optor+v1+v2);

        //             v2= postfix.pop();
        //             v1= postfix.pop();
        //             postfix.push(v1+v2+optor);
        //         }

        //         optors.push(ch);
        //     }
        // }
        // while (optors.size()!=0) {
        //     char optor= optors.pop();
        //     String v2= prefix.pop();
        //     String v1= prefix.pop();
        //     prefix.push(optor+v1+v2);

        //     v2= postfix.pop();
        //     v1= postfix.pop();
        //     postfix.push(v1+v2+optor);
        // }
        // System.out.println(postfix.peek());
        // System.out.println(prefix.peek());

        // Infix evaluation

        // Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();

        // Stack<Integer> operands = new Stack<>();
        // Stack<Character> operators = new Stack<>();
        // int ans=0;

        // for (int i = 0; i < str.length(); i++) {
        //     char ch = str.charAt(i);

        //     if(Character.isDigit(ch)){
        //         operands.push(ch-'0');
        //     }
        //     else{
        //         if(ch == '+' || ch == '-' || ch == '('){
        //             operators.push(ch);
        //         }
        //         else if(ch=='/' || ch=='*'){
        //             while(operators.size()>0 && operands.size()>0 &&
        //                 (operands.peek()=='/'||operands.peek()=='*') && ch!='('){
        //                 int d= operands.pop();
        //                 ans= solve(operands.peek(),d,operators.peek());
        //                 operands.pop();
        //                 operands.push(ans);
        //                 operators.pop();
        //             }
        //             operators.push(ch);
        //         }
        //         else if(ch==')'){
        //             while(operators.peek()!= '('){
        //                 int d= operands.pop();
        //                 ans= solve(operands.peek(),d,operators.peek());
        //                 operands.pop();
        //                 operands.push(ans);
        //                 operators.pop();
        //             }
        //             operators.pop();
        //         }
        //         if(i==str.length()-1){
        //             while(operators.size()>0){
        //                 int d= operands.pop();
        //                 ans= solve(operands.peek(),d,operators.peek());
        //                 operands.pop();
        //                 operands.push(ans);
        //                 operators.pop();
        //             }
        //         }
        //     }
        // }
        // System.out.print(operands.peek());

        // Sliding window maximum (exceeded time limit)
        // must check it's correct solution (not below, it have time error) in stacks.java or leetcode 239

        // Scanner scn = new Scanner(System.in);
        // int n= scn.nextInt();
        // int k= scn.nextInt();

        // int[] arr= new int[n];
        // for(int i=0; i<n; i++){
        //     arr[i]= scn.nextInt();
        // }

        // int[] Sliding_max = new int[n-k+1];

        // Stack<Integer> st = new Stack<>();

        // for (int i = 0; i <= n-k; i++) {
        //     st.push(arr[i]);
        //     int j= i+1;
        //     while (j < k+i) {
        //         if(st.peek() < arr[j]){
        //             st.pop();
        //             st.push(arr[j]);
        //         }
        //         j++;
        //     }
        //     Sliding_max[i] = st.peek();
        //     st.pop();
        // }
        // System.out.print(Arrays.toString(Sliding_max));

        // Stock span

        // Scanner scn = new Scanner(System.in);
        // int n= scn.nextInt();
        // int count=1;
        // int realCount= 1;

        // int[] arr= new int[n];
        // for(int i=0; i<n; i++){
        //     arr[i]= scn.nextInt();
        // }

        // Stack<Integer> st = new Stack<>();
        // int[] span = new int[n];
        // span[0]=1;
        // st.push(arr[0]);

        // for (int i = 1; i < span.length; i++) {
        //     if (!st.isEmpty() && st.peek()<arr[i]) {
        //         while (st.size()>0 && st.peek()<arr[i]) {
        //             st.pop();
        //             count++;
        //             realCount++;
        //         }
                
        //         if (st.size()==0) {
        //             span[i] = count;
        //         }
        //         else if(st.size()>0){
        //             span[i] = realCount;
        //         }
        //         realCount=1;
        //         st.push(arr[i]);
        //     }
        //     else{
        //         st.push(arr[i]);
        //         span[i] = 1;
        //     }
        // }
        // System.out.print(Arrays.toString(span)); // M1 of printing arrays
        //printArray(span); // M2, created a function

        // NGE on right (O(n))

        // Scanner scn = new Scanner(System.in);
        // int n= scn.nextInt();

        // int[] arr= new int[n];
        // for(int i=0; i<n; i++){
        //     arr[i]= scn.nextInt();
        // }

        // Stack<Integer> st = new Stack<>();
        // int[] nge = new int[n];
        // nge[n-1] = -1;
        // st.push(arr[n-1]);

        // for (int i = n-2; i>=0; i--) {
        //     while (st.size()>0 && arr[i]> st.peek()) {
        //         st.pop();
        //     }
        //     if (st.size()==0) {
        //         nge[i] = -1;
        //     }
        //     else{
        //         nge[i] = st.peek();
        //     }
        //     st.push(arr[i]);
        // }
        // printArray(nge);

        //Duplicate brackets

        // Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();

        // Stack<Character> st = new Stack<>();

        // for (int i = 0; i < str.length(); i++) {
        //     char ch = str.charAt(i);
        //     if (ch== '(' || ch == ')') {
        //         st.push(ch);
        //     }
        // }
        // while (!st.isEmpty()) {
        //     if (st.peek() == ')') {
        //         while (st.peek() != '(') {
        //             st.pop();
        //         }
        //         st.pop();
        //     }
        //     else{
        //         st.pop();
        //         if (!st.isEmpty()) {
        //             System.out.print("true");
        //             return;
        //         }
        //     }
        // }
        // System.out.println("false");


        // Scanner scn = new Scanner(System.in);
        // int n= scn.nextInt();
        
        // int[] arr= new int[n];

        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = scn.nextInt();
        // }

        // int max= arr[0];
        // for (int i = 0; i < arr.length; i++) {
        //     if (max<arr[i]) {
        //         max= arr[i];
        //     }
        // }
        // int d= max-1;

        // for (int i = 0; i < max; i++) {
        //     for (int j = 0; j < n; j++){
        //         if (arr[j]-d >0) {
        //             System.out.print("*\t");
        //         }
        //         else{
        //             System.out.print("\t");
        //         }
                
        //     }
        //     d--;
        //     System.out.println();
        // }

        // Scanner scn = new Scanner(System.in);
        // int n1= scn.nextInt();
        // int n2= scn.nextInt();
        // int b= scn.nextInt();
        // String prod= "";
        // int Product = 0;
        // int carry=0;
        // int p= 0;

        // if(n1<n2){
        //     int temp= n1;
        //     n1= n2;
        //     n2 = temp;
        // }

        // while (n2 != 0) {
        //     int temp = n1;
        //     int d2= n2%10;
        //     n2= n2/10;

        //     while (temp != 0 || carry != 0) {
        //         int d1= temp%10;
        //         temp= temp/10;
        //         int d= d1*d2 + carry;
        //         int r=0;

        //         if (d>=b) {
        //             r= d%b;
        //             int q= d/b;
        //             carry=q;
                    
        //         } else {
        //             r= d;
        //             carry=0;
        //         }
        //         prod= r + prod;
        //     }
        //     carry=0;
        //     int prod1 = Integer.parseInt(prod)*(int)Math.pow(10,p);
        //     p++;
        //     Product= Product + prod1;
        //     prod = "";
        // }
        // System.out.println(Product);

        // Scanner scn = new Scanner(System.in);
        // int n1= scn.nextInt();
        // int n2= scn.nextInt();
        // int b= scn.nextInt();
        // String Sum= "" ;
        // int carry=0;

        // while (n1 != 0 || n2 != 0 || carry != 0) {
        //     int sum = (n1%10) + (n2%10) + carry;
        //     n1 = n1/10;
        //     n2 = n2/10;
        //     int dig=0;
        //     if (sum>=b) {
        //         dig= sum-b;
        //         carry=1;
        //     }
        //     else{
        //         dig= sum;
        //         carry=0;
        //     }
        //     Sum= dig + Sum; 
        // }
        // System.out.println(Sum);

        // Scanner scn = new Scanner(System.in);
        // int n= scn.nextInt();
        // int b = scn.nextInt();
        // int p=0;
        // int Nb= 0;

        // while(n != 0) {
        //     int rem = n%10;
        //     Nb= (rem* (int)Math.pow(b,p) + Nb);
        //     p++;
        //     n= n/10;
        // }
        // System.out.println(Nb);

        // class Function{

        //     public static int digitFreq(int n, int d){
        //     int rv=0;
        //     int temp =n;
        //     int count=0;

        //     while (temp > 0) {
        //         temp= temp/10;
        //         count++;
        //     }

        //     for (int i = 0; i < count ; i++) {
        //         String num = String.valueOf(n);
        //         if (num.charAt(i)== (char)(d+'0')) {
        //             rv++;
        //         }
        //     }
        //     return rv;
        //    }
        // }
        // Scanner scn = new Scanner(System.in);
        // int n= scn.nextInt();
        // int d= scn.nextInt();
         
        // int freq= Function.digitFreq(n, d);
        // System.out.println(freq);
        

        // LCM
        // Scanner scn = new Scanner(System.in);
        // int num1= scn.nextInt();
        // int num2= scn.nextInt();
        // int LCM=1;
        // int n1= num1;
        // int n2= num2;

        // for (int i = 2; i <= (n1>n2 ? n1: n2); i++) {
        //     if (num1%i==0 && num2%i==0) {
        //         LCM= LCM*i;
        //         num1= num1/i;
        //         num2= num2/i;
        //     } else {
        //         if(num1%i==0){
        //         LCM= LCM*i;
        //         num1= num1/i;           
        //     }
        //     if(num2%i==0){
        //         LCM= LCM*i;  
        //         num2= num2/i;         
        //     }
        //     }
        // }
        // System.out.println(LCM);


        //Rotate a number
        // Scanner scn = new Scanner(System.in);
        // int n= scn.nextInt();
        // int k= scn.nextInt();
        // int N=0;
        // int d= 0;

        // int temp= n;

        // while(temp> 0){ 
        //     d++;
        //     temp= temp/10;
        // }

        // k = k % d;
        // if (k < 0) {
        //     k = k + d;
        // }

        // int div = (int) Math.pow(10, k);
        
        // int q = n / div;    
        // int r = n % div;   

        // int mult = (int) Math.pow(10, d - k);
        
        // N = (r * mult) + q; 
        // System.out.printf("%0" + d + "d\n", N); // Print the number using exactly d digits, add zeros on the left if required ; \n is to insert new line

    }
}