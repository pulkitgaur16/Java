import java.util.*;

public class Strings {

    public static void permutations(String str){
        int n= str.length();
        int f= factorial(n);

        for(int i=0; i<f; i++){
            StringBuilder sb= new StringBuilder(str);
            int temp=i;
            for(int div=n; div>=1; div--){
                int q= temp/div;
                int r= temp%div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp=q;
            }
            System.out.println();
        }
    }

    public static int factorial(int n){
        int val=1;

        for(int i=2; i<=n; i++){
            val *= i;
        }
        return val;
    }
    public static void main(String arg[]){
        // Scanner scn = new Scanner(System.in);
        // String s1= scn.next(); // next reads till there is no space b/w input
        // String s2= scn.nextLine(); // while scn.nextLine() reads the whole line
        // System.out.println(s1);

        //String s= "abcdef";
        //s.charAt(0) = 'z'; // won't work
        // System.out.println(s.substring(1,3));
        // System.out.println(s.substring(1));

        // for(int i=0; i<s.length(); i++){
        //     for (int j=i+1; j<=s.length();j++){
        //         System.out.println(s.substring(i, j));
        //     }        
        // }

        // String s1= "hello";
        // s1+= ' ';
        // s1+= 'w';
        // s1+= 'o';
        // s1+= 10;
        // System.out.println(s1);

        // System.out.println("hello" + 10 + 20);
        // System.out.println(10+20+"hello");

        // String s= "abc,def,ghi,jkl mno";
        // String[] parts = s.split(",");
        // for(int i=0; i<parts.length; i++){
        //     System.out.println(parts[i]);
        // }

        // Understanding Memory
        //Interning
        // * it states that if the same string is there in intern pool 
        // of the memory then java will not create new string but provide 
        // the address of the same old string.
        // * it is used to optimize space
        // * it can be avoided via new String
        String s1= "hello";
        String s2= "hello"; // so here interning will be present
        String s3= new String("hello"); // now a new shell of this string will be created
        // but it will also point to the same character array as that of 
        // s1,s2 shell point to

        // equals and ==
        // * for comparison never use == (it compares only address)
        // s1==s2 returns true
        // s1==s3 returns false
        // so use .equals() (compares first address and then checks character by character)
        // s1.equals(s2) returns true
        // s1.equals(s3) returns true

        // Immutability
        // * cannot change strings
        // * reference is mutable, instance is not
        s1= "bye"; // it will not change hello, inspite a new space is allocated for 'bye' 
        // where s1 will point , hello is still at the same address only reference is changed
        //* because of this performance becomes slow
        String s="";
        int n=100;
        for(int i=0; i<=n; i++){
            s+=i; // this loop looks like to run n times but in actual it 
            // will run for n^2 because each time you try to add i in s
            // it copies its characters to new location and then add i
            // so in actual n(n+1)/2 times this will happen
        }

        // StringBuilder
        // StringBuilder sb= new StringBuilder("hello");
        // System.out.println(sb);

        // char ch=sb.charAt(0); // get
        // System.out.println(ch);

        // sb.setCharAt(0, 'd'); // update
        // System.out.println(sb);

        // sb.insert(2,'t'); // insert
        // System.out.println(sb);

        // sb.deleteCharAt(2); // remove
        // System.out.println(sb);

        // sb.append('g'); // append
        // System.out.println(sb);

        // System.out.println(sb.length());

        // for(int i=0; i<n; i++){
        //     sb.append(i);
        // }

        // ArrayLists
        // * arrays are of fixed size but arraylist has variable size
        ArrayList<Integer> list= new ArrayList<>();
        //add
        list.add(10);
        list.add(20);
        System.out.println(list + "->" + list.size());

        list.add(1,1000); // add at index
        System.out.println(list + "->" + list.size());

        int val= list.get(1);
        System.out.println(val);

        list.set(1,2000);
        System.out.println(list+ "->" + list.size());

        list.remove(1);
        System.out.println(list+ "->" + list.size());
    }
}
