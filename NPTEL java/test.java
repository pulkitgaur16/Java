import MyPack.Hello;

public class test extends Hello {
     public static void main(String str[]){
    //     Hello h= new Hello();
    //     h.show();
    //     h.show1(); // this is not applicable for protected members
        test t= new test();
        t.test1();

    }
    
        public void test1(){
            show();   // this is applicable for protected members and methods
        }
        // i.e. in the subclass in different package or file we can access protected members only through inheritance not by creating
        // objects or directly calling the method.
    }

