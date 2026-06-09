public class Errors {
//     Public static void main(string str[]){
//         system.out.print("Can you find errors in me?");
//     } 
// here above there are compile time errors!! Public should be public,
// string should be String and system should be System...

    // class AnotherError{ // to define an abstract method class should be abstract
    //     public void insert( ){
    //         System.out.print("To inset a text");
    //     }

    //     abstract void delete( ){ // abstract method should be defined by abstract class
    //         System.out.print("To delete a text");
    //     }
    // }
    // the above errors are also compile time errors!!

    public static class ExcHandle{
        static int anyFunction(int x, int y){
        // static methods can be declared only in static or top level class    
            try{
                int a= x/y;
                return a;
            }
            catch (ArithmeticException e){
                System.out.println("Division by zero");
            }
            return 0;
        }
    }
    
    public static void main(String str[]){
        // int a,b, result;
        // a=0;
        // b=0;
        // try{
        //     a= Integer.parseInt(str[0]);
        //     b= Integer.parseInt(str[1]);
        //     System.out.println("Value of a and b = " + a +" " + b);
        // }
        // catch(Exception e){
        //     System.out.println("Invalid input");
        // }
        // result = ExcHandle.anyFunction(a,b);
        // System.out.println("\nResult : " + result);   
        
         // the above program has run time errors since it cannot execute for all inputs

         for(int i=0; i<4;i++){
            try{
                switch (i){
                    case 0:
                    int zero= 0;
                    int j= 999/zero; // divide by zero
                    break;

                    case 1:
                    int b[]= null;
                    j= b[0]; // null pointer error
                    break;

                    case 2:
                    int c[]= new int[2];
                    j= c[10]; // array index is out of bound
                    break;

                    case 3:
                    char ch= "Java".charAt(9); // String index is out of bound
                    break;
                }
            }
            catch (Exception e){
                System.out.println("In test case "+ i + "\n");

                //System.out.println(e.getMessage());
                System.out.println(e + "\n");
            }
            finally{
                System.out.println("Exception is handled successfully ");
            }
         }
    }
   
}

// Note: A class can be compiled successfully, if it is syntactically correct,
// even if there is no main class, that is, with main method. 
