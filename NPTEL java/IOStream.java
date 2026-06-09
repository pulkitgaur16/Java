import java.io.*;

public class IOStream {
    public static void main(String args[]){

        // DataInput Stream class
        // double principalAmount=0.0;
        // int noOfYears=0;

        // try {
        //     DataInputStream in= new DataInputStream(System.in); //System.in tells that there is we are taking stamdard input like from keyboard
        //     String tempString;
        //     System.out.print("Enter Principal Amount: ");
        //     System.out.flush();
        //     tempString = in.readLine();
        //     principalAmount= Float.valueOf(tempString);
        // } catch (Exception e) {
        //     System.out.println("Error");
        // }

        // copying file into another file using byte stream classes

        FileInputStream fin= null;
        FileOutputStream fot= null;

        int byteRead;

        try {
            fin = new FileInputStream("C:/Users/pulki/Documents/Coding/Java/file1.txt");
            fot= new FileOutputStream("C:/Users/pulki/Documents/Coding/Java/file2.txt");

            while((byteRead= fin.read()) != -1){
                fot.write(byteRead);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }


    }
}
