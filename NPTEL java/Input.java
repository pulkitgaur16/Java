import java.io.*;

public class Input {
    public static void main(String str[]) throws IOException{
        Float principalAmount= new Float(0);
        Float rateOfInterest= new Float(0);
        int numberOfYears= 0;

        DataInputStream in = new DataInputStream(System.in);
        String tempString;
        System.out.println("Principal Amount: ");
        System.out.flush();
        tempString= in.readLine();
        principalAmount= Float.valueOf(tempString);

    }
}
