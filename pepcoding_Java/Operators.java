 public class Operators {
    public static void main(String[] args) {
        
        // Binary operators -> +, -, *, /,% -> two operands present

        // Unary operators-> ++, -- -> one operand present

        int a=10;
        int b=0;

    //    b= a++; // post increment -> 1st use the value and then change it

          b= ++a; // pre increment -> 1st change the value and then use it
        System.out.println(a);
        System.out.println(b);

        // Relational operators -> >,<,==, !=,>=,<=

        // Logical operators-> &&, ||, !(logical not)
        System.out.println(!(a<b)); // false but due to ! is True

        // Bitwise operators-> &, |, ^ (binary xor), ~ (binary one's complement), <<(binary left shift), >> (binary right shift)
        System.out.println(~ 101); // output will be in decimal

        // Assignment operators -> =, +=,-=,/=, *=
    } 
}
