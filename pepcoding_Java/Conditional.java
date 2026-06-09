public class Conditional{
    public static void main(String[] args) {
        int x=10;
        int y=10;

        //if (x%2==0) {
        //    System.out.println(x+" is even");
        //}
        //else{
        //    System.out.println(x + " is odd");
        //}
        
        if (x>y) {
            System.out.println(x + " is greater than " + y);
        }
        else if (y>x) { //we can use only if also but else if is better
            System.out.println(y + " is greater than " + x);
        }
        else{
            System.out.println(x + " is equal to " + y);
        }
        
    }
}
