import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Stacks {

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int operation(int v1, int v2, char optor){ 
        if (optor== '+') {
            return v1+v2;
        } 
        else if(optor== '-'){
            return v1-v2;
        }
        else if(optor== '*'){
            return v1*v2;
        }
        else {
            return v1/v2;
        }
    } 
    public static void main(String[] args) {
        
        // INTRODUCTION

        // Stacks uses LIFO method i.e. Last in First Out

    /*    Stack<Integer> st= new Stack<>(); // declaration and defining of stack

        st.push(10);
        st.push(86);
        System.out.println(st);        

        st.push(40);
        System.out.println(st);
        
        System.out.println(st.pop());
        System.out.println(st.peek() + "  "+ st.size()); */  

        // Questions 
        // ques 1 **

    /*    Scanner scn = new Scanner(System.in);
        String str= scn.nextLine();

        Stack<Character> st= new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if (ch== ')') {
                if (st.peek()== '(') {
                    System.out.println(true);
                    return;
                } else {
                    while (st.peek() !='(') {
                        st.pop();
                    }
                    st.pop();
                }
                
            } 
            else {
                st.push(ch);                
            }
        }
        System.out.println(false);  */

        // ques 2 **

        //M1

    /*    Scanner scn = new Scanner(System.in);
        String str= scn.nextLine();

        Stack<Character> st= new Stack<>();

        for(int i=0; i<str.length();i++){
            char ch= str.charAt(i);

            if (ch==')' || ch=='}' || ch==']') {

                    if (ch==')') {
                        boolean val= handleClosing(st,'(');
                        if (val== false) {
                            System.out.println(false);
                            return;
                        }
                    }
                    else if (ch=='}') {
                        boolean val= handleClosing(st,'{');
                        if (val== false) {
                            System.out.println(false);
                            return;
                        }
                    }
                    else if (ch==']') {
                        boolean val= handleClosing(st,'[');
                        if (val== false) {
                            System.out.println(false);
                            return;
                        }
                    }
            } 
            else {
                st.push(ch); 
            }
        } 
        System.out.println(st.empty()); */

        // M2

    /*    Scanner scn = new Scanner(System.in);
        String s= scn.nextLine();

        // Declare a stack to store the opening brackets
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
          
            // Check if the character is an opening bracket
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
                
            else{
              
                // If it's a closing bracket, check if the stack is non-empty
                // and if the top of the stack is a matching opening bracket
                if (!st.empty() && 
                    ((st.peek() == '(' && s.charAt(i) == ')') ||
                     (st.peek() == '{' && s.charAt(i) == '}') ||
                     (st.peek() == '[' && s.charAt(i) == ']'))) {
                    st.pop(); 
                }
                else if (!st.empty()) {
                    continue;
                }
                 else {
                  
                    // Unmatched closing bracket
                     System.out.println(false);
                     return;
                 }
            }
        }

        System.out.println(st.empty());
        return; */
    

/*    public static boolean handleClosing(Stack<Character> st, char c){
        if (!st.empty() && st.peek() == 'c') {
        st.pop();
        return st.empty();
    } else {
        while (!st.empty() && st.peek() != '(') { // st.peek() is true even if empty
            st.pop();
        }
        if (!st.empty() && st.peek() == '(') {
            st.pop();
        } else {
            return false;
        }
    }
    return true;

    } */

        // ques 3 **

        // M1 (O(n^2))

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];
        for(int i=0; i<arr.length;i++){
            arr[i]= scn.nextInt();
        }

        int j=0;
        int k=1;
        int[] NewArr= new int[n];

        for (int i = 0; i < arr.length; i++) {
            while (k < arr.length && arr[j] > arr[k]) {
                k++;
            } 
            
            if (k<arr.length) {
                NewArr[i]= arr[k];
            } 
            else {
                NewArr[i]=-1;
            }
            if (j<n-1) {
                j++;
                k=j+1;
            } 
            else {
                break;
            }
           
        }

        String str= "";
        for (int i = NewArr.length-1; i>= 0; i--) {
            str=  NewArr[i] +" " + str ;
        }
        System.out.print("["+ str + "]"); */

        // ques 2(variation) -> next smaller element on right

        //M1 (O(n))

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]= scn.nextInt();
        }

        int[] nse= new int[n];

        Stack<Integer> st= new Stack<>();
        st.push(0);

        for (int i = 1; i < nse.length; i++) {
            while (st.size()>0 && arr[i]<arr[st.peek()]) {
                int pos= st.peek();
                nse[pos]= arr[i];
                st.pop();
            }
            st.push(i);
        }

        while (st.size()>0) {
            int pos=st.peek();
            nse[pos]= -1;
            st.pop();
        }

        printArray(nse);  */

        // M2(O(n))

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]= scn.nextInt();
        }

        int[] nse= new int[n];

        Stack<Integer> st= new Stack<>();
        st.push(arr[n-1]);

        nse[n-1]=-1;

        for(int i= n-2; i>=0; i--){
            while (st.size()>0 && arr[i]<= st.peek()) {
                st.pop();
            }
            if (st.size()==0) {
                nse[i]=-1;
            } 
            else {
                nse[i]= st.peek();
            }

            st.push(arr[i]);
        }
        printArray(nse); */

        // ques 3 **

    /*    Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]= scn.nextInt();
        }

        int[] pge= new int[n];

        Stack<Integer> st= new Stack<>();
        st.push(0);
        pge[0]=1;
        int index=1;
        

        for (int i = 1; i <n; i++) {
            
                
                    int c=1; // gap of first greater element on left 
                    while(st.size()>0 && arr[i]>arr[st.peek()]){
                       
                       c++;
                       index++;
                       st.pop();
                    }
                    if (st.empty()) {
                        pge[i]= index;
                    } else {
                        pge[i]=c;
                    }
                    st.push(i);
                    
                
                
           
        }
        printArray(pge); */

        // ques 4 **

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];
        for(int i=0; i<n;i++){
            arr[i]= scn.nextInt();
        }

        int[] rb= new int[n];
        Stack<Integer> st= new Stack<>();
        st.push(arr.length-1);

        rb[arr.length-1]= arr.length;
        
        for(int i=n-2; i>=0; i--){
            
            while (st.size()>0 && arr[i]<=arr[st.peek()]) {
                st.pop();
            }
            if (st.size()==0) {
                rb[i]= arr.length;
            } else {
                rb[i]= st.peek();
            }

            st.push(i);
        }
        int[] lb= new int[n];
        st= new Stack<>();
        st.push(0);

        lb[0]= -1;
        
        for(int i=1; i<n; i++){
            
            while (st.size()>0 && arr[i]<=arr[st.peek()]) {
                st.pop();
            }
            if (st.size()==0) {
                lb[i]= -1;
            } else {
                lb[i]= st.peek();
            }

            st.push(i);
        }

        int maxArea=0;
        for(int i=0; i<n;i++){
            int w= rb[i]- lb[i]-1;
            int area= arr[i]*w;

            if (area>maxArea) {
                maxArea= area;
            }
        }
        System.out.println(maxArea); */

        // M2
//         class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int max=0;
//         int n=heights.length;
//         Stack<Integer>stack=new Stack<>();
//         for (int i=0;i<=n;i++){
//             int height1=(i==n)?0:heights[i];
//             while(!stack.isEmpty()&&heights[stack.peek()]>height1){
//                 int height=heights[stack.pop()];
//                 int width=stack.isEmpty()?i:i-stack.peek()-1;
//                     max=Math.max(max,height*width);
//             }
//             stack.push(i);
//         }
//         return max;
        
//     }
// }

        // ques 5 **

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();

        int[] arr= new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= scn.nextInt();
        }
        int k= scn.nextInt();

        Stack<Integer> st= new Stack<>();
        st.push(0);

        int[] nge= new int[n];

        for(int i=1; i<n; i++){

            while (st.size()>0 && arr[i]> arr[st.peek()]) {
                int push= st.peek();
                nge[push]= i;
                st.pop();
            }
            st.push(i);
        }

        while (st.size()>0) {
            nge[st.peek()]= arr.length;
            st.pop();
        }

        int j=0;
        for(int i=0; i<=n-k; i++){
            if (j<i) {
                j=i;
            }

            while (nge[j]<i+k) {
                j= nge[j];
            }
            System.out.print(arr[j]+ " ");
        } */

        // ques 6 **

    /*    Scanner scn = new Scanner(System.in);
        String st= scn.nextLine();

        Stack<Character> optors= new Stack<>();
        Stack<Integer> opnds= new Stack<>();

        for(int i=0; i<st.length(); i++){
            char ch= st.charAt(i);

            if (ch=='(') {
                optors.push(ch);
            } 
            else if(Character.isDigit(ch) ) {
                opnds.push(ch-'0'); // char to integer conversion
            }
            else if(ch==')' ) {
                while (optors.peek() != '(') {
                    char optor= optors.pop();
                    int v2= opnds.pop();
                    int v1= opnds.pop();

                    int opv= operation(v1, v2, optor);
                    opnds.push(opv);
                }

                optors.pop();
            }
            else if(ch=='+' || ch=='-'|| ch=='*'|| ch=='/' ) {
                // ch is wanting higher priority operators to solve first 
                while (optors.size()>0 && optors.peek()!='(' && precedence(ch)<= precedence(optors.peek())) {
                    char optor= optors.pop();
                    int v2= opnds.pop();
                    int v1= opnds.pop();

                    int opv= operation(v1, v2, optor);
                    opnds.push(opv);
                }

                optors.push(ch);
            }
        }
        while (optors.size()!=0) {
            char optor= optors.pop();
            int v2= opnds.pop();
            int v1= opnds.pop();

            int opv= operation(v1, v2, optor);
            opnds.push(opv);
        }
        System.out.println(opnds.peek());

    } */

    /*// function to check the precedence
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
    }*/

    /*public static int operation(int v1, int v2, char optor){ 
        if (optor== '+') {
            return v1+v2;
        } 
        else if(optor== '-'){
            return v1-v2;
        }
        else if(optor== '*'){
            return v1*v2;
        }
        else {
            return v1/v2;
        }
    } */

        // ques 7  (Infix conversion)

        // computer doesn't understand infix so it converts it to prefix or postfix 

        // prefix -> operands comes after operators
        // postfix -> operators comes after operands

    /*    Scanner scn = new Scanner(System.in);
        String infix = scn.nextLine();

        Stack<String> postfix= new Stack<>();
        Stack<String> prefix= new Stack<>();
        Stack<Character> optors = new Stack<>();

        for(int i=0; i<infix.length(); i++){
            char ch= infix.charAt(i);
            if (ch=='(') {
               optors.push(ch); 
            } 
            else if(Character.isDigit(ch)) {
                //postfix.push(String.valueOf(ch)); // char to string
                postfix.push(ch + ""); // char to string
                prefix.push(String.valueOf(ch));
            }
            else if(ch==')') {
                while (optors.peek()!='(') {
                    process(optors, postfix, prefix);
                }
                optors.pop();
            }
            else if(ch=='+' || ch=='-'|| ch=='*'|| ch=='/') {
                while (optors.size()>0 && optors.peek()!= '(' && precedence(ch)<= precedence(optors.peek())) {
                    process(optors, postfix, prefix);
                }
                optors.push(ch);
            }
        }
        while (optors.size()!=0) {
            process(optors, postfix, prefix);
        }

        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    // function to check the precedence
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

    public static void process( Stack<Character> optors, Stack<String> postfix, Stack<String> prefix){
        char optor= optors.pop();
        String v2= postfix.pop();
        String v2_ = prefix.pop();
        String v1= postfix.pop();
        String v1_ = prefix.pop();

        postfix.push( String.valueOf(v1) + String.valueOf(v2) + String.valueOf(optor));
        prefix.push(String.valueOf(optor) + String.valueOf(v1_) + String.valueOf(v2_));
    } */
        
        // ques 8

    /*    Scanner scn = new Scanner (System.in);
        String post = scn.nextLine();

        Stack<Integer> vs= new Stack<>();
        Stack<String> infix= new Stack<>();
        Stack<String> pre= new Stack<>();

        for(int i=0; i<post.length();i++){
            char ch= post.charAt(i);

            if (Character.isDigit(ch)) {
                vs.push(ch-'0');
                infix.push(ch+ "");
                pre.push(ch+"");
            } 
            else if(ch == '+' || ch=='-' || ch=='*' || ch=='/') {
                int vs2= vs.pop();
                int vs1= vs.pop();
                int val= operation(vs1, vs2, ch);
                vs.push(val);

                String i2= infix.pop();
                String i1= infix.pop();
                infix.push("(" + i1+ ch+ i2+ ")");

                String p2= pre.pop();
                String p1= pre.pop();
                pre.push(""+ ch+ p1 + p2);
            }
        }
        System.out.println(vs.peek());
        System.out.println(infix.peek());
        System.out.println(pre.peek());*/
        
        // ques 9

    /*    Scanner scn = new Scanner (System.in);
        String pre= scn.nextLine();

        Stack<Integer> vs= new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> post= new Stack<>();

        for (int i=pre.length()-1; i>=0; i--){
            char ch= pre.charAt(i);

            if (Character.isDigit(ch)) {
                vs.push(ch-'0');
                infix.push(ch+"");
                post.push(ch+"");
            } 
            else {
                int vs1= vs.pop();
                int vs2= vs.pop();
                int val= operation(vs1, vs2, ch);
                vs.push(val);

                String i1= infix.pop();
                String i2= infix.pop();
                infix.push("(" + i1+ ch+ i2+ ")");

                String p1= post.pop();
                String p2= post.pop();
                post.push(p1+ p2+ ch);
            }
        }
        System.out.println(vs.peek());
        System.out.println(infix.peek());
        System.out.println(post.peek()); */

        // ques 10 **

    /*    Scanner scn= new Scanner (System.in);
        int n = scn.nextInt(); 
        
        int[][] arr= new int[n][n];
        for(int i=0; i<n;i++){ // i is rows
            for(int j=0; j<n;j++){ // j is columns
                arr[i][j]= scn.nextInt(); //input only 0 & 1
            }
        }

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length;i++) {
            st.push(i);
        }

        while (st.size()>=2) {
            int i= st.pop();
            int j= st.pop();

            if (arr[i][j]==1) { // if i knows j
                st.push(j);
            } else { // i don't knows j
                st.push(i);
            }
        }

        int pot= st.pop();
        for(int i=0; i<n;i++){
            if (i !=pot) {
                if (arr[i][pot]==0 || arr[pot][i]==1) {
                    System.out.println("None");
                    return;
                }
            }
        }
        System.out.println(pot);
        System.out.println(arr); */

        // ques 11

    /*    Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();

        int[] arrSt= new int[n];
        for (int i = 0; i < arrSt.length; i++) {
            arrSt[i]= scn.nextInt();
        }

        int[] arrEnd= new int[n];
        for(int i=0; i<n;i++){
            arrEnd[i]= scn.nextInt();
        }
        Arrays.sort(arrSt);
        Arrays.sort(arrEnd);

        Stack<Integer> start= new Stack<>();
        Stack<Integer> end= new Stack<>();

        for(int i=0; i<n;i++){
            int n1= arrSt[i];
            int n2= arrEnd[i];
            start.push(n1);

            if (end.size()>0 && start.peek()<= end.peek()) {
                start.pop();
                end.pop();
                end.push(n2);
            } 
            else {
                end.push(n2);
            }
        }

        String[] newArr= new String[start.size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i]= String.valueOf(start.peek()) + " " + String.valueOf(end.peek());
            start.pop();
            end.pop();
        }

        for(int i= newArr.length-1; i>=0;i--){
            System.out.println(newArr[i]);
        } */

        //ques 12

    /*    Scanner scn = new Scanner(System.in);
        String str= scn.nextLine(); // consists of only d and i

        Stack<Integer> st=  new Stack<>();
        int num=1;
        String n= "";

        for(int j=0; j<str.length();j++){
            char ch= str.charAt(j);

            if (ch=='d') {
                st.push(num);
                num++;
            } 
            else if(ch=='i' || ch==' ') {
                st.push(num);
                num++;
                while (st.size()>0) {
                    int n1= st.pop();
                    n= n+n1;
                }

            }
        }
        st.push(num);
        while (st.size()>0) {
            int n1= st.pop();
            n= n+n1;
        }
        System.out.println(n); */
    }
}