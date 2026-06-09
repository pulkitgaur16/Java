class BaseClass{
    public int x=10;
    private int y= 10;
    protected int z= 10;
    int a=10; // Default

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x=x;
    }

    private int getY(){
        return y;
    }

    private void setY(int y){
        this.y=y;
    }

    protected int getZ(){
        return z;
    }

    protected void setZ(int z){
        this.z=z;
    }
}
public class AccessModifiers extends BaseClass {
    public static void main(String str[]){
        BaseClass rr= new BaseClass();
        rr.z=0;
        AccessModifiers subClassObj= new AccessModifiers();
        System.out.println("Value of x is: " + subClassObj.x);
        subClassObj.setX(2);
        System.out.println("Value of x is: " + subClassObj.x);

        //System.out.println("Value of y is: " + subClassObj.y); -> will give compilation error

        System.out.println("Value of z is: " + subClassObj.z);
        subClassObj.setZ(20);
        System.out.println("Value of z is: " + subClassObj.z);
    }
}
