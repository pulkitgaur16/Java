package JDBC;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/xyz_company";
    private static final String username = "root";
    private static final String password = "Pulkit@2006";
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // try {
        //     Connection connection = DriverManager.getConnection(url, username, password);
            //Statement statement = connection.createStatement();
            // String query = "INSERT INTO Info(id, name, salary) VALUES(?, ?, ?)";
            // PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Scanner scn = new Scanner(System.in);
            // while(true){
            //     System.out.print("Enter id: ");
            //     int id = scn.nextInt();
            //     System.out.print("Enter name: ");
            //     String name = scn.next();
            //     System.out.print("Enter salary: ");
            //     int salary = scn.nextInt();
            //     //String query = String.format("INSERT INTO Info(id, name, salary) VALUES(%d, '%s', %d)", id, name, salary);
            //     //statement.addBatch(query);
            //     preparedStatement.setInt(1, id);
            //     preparedStatement.setString(2, name);
            //     preparedStatement.setInt(3, salary);
            //     preparedStatement.addBatch();
            //     System.out.print("Enter more data(Y/N): ");
            //     String choice = scn.next();
                
            //     if(choice.toUpperCase().equals("N")){
            //         break;
            //     }
            // }
            
            //String query = "DELETE FROM student where rollno = 105";

            // ? - placeholder

           //String query = "INSERT INTO student(rollno, name) VALUES(?, ?)"; // insertion
            //String query = "SELECT marks FROM student WHERE rollno = ?"; // retrieve
            //String query = "UPDATE student SET marks = ? WHERE rollno = ?"; // update
            //String query = "DELETE FROM student WHERE rollno = ?";
            //PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setInt(1, 104);
            // preparedStatement.setString(2, "Ram");
            //preparedStatement.setInt(1, 104);
            // preparedStatement.setInt(1, 75);
            // preparedStatement.setInt(2, 105);

            // int[] arr = preparedStatement.executeBatch();
            // for(int i=0; i<arr.length; i++){
            //     if(arr[i] == 0){
            //         System.out.println("Query: " + (i+1) + " not executed successfully!!");
            //     }
            // }


            // int rowsAffected = statement.executeUpdate(query);
            // if(rowsAffected>0){
            //     System.out.println("Data updated Successfully!");
            // }
            // else{
            //     System.out.println("Data Not updated!");
            // }

            // ResultSet resultSet = preparedStatement.executeQuery();
            // if(resultSet.next()){
            //     int marks = resultSet.getInt("marks");
            //     System.out.println("Marks: "+ marks);
            // }
            // else{
            //     System.out.println("Marks not found");
            // }
            // while(resultSet.next()){
            //     int id = resultSet.getInt("rollno");
            //     String name = resultSet.getString("name");
                // int marks = resultSet.getInt("marks");
                // String grade = resultSet.getString("grade");
                // String city = resultSet.getString("city");

                // System.out.println("ID: " + id);
                // System.out.println("NAME: " + name);
                // System.out.println("MARKS: " + marks);
                // System.out.println("GRADE: " + grade);
                // System.out.println("CITY: " + city);

            //}
        // } catch (SQLException e) {
        //     System.out.println(e.getMessage());
        // }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String debit_query = "UPDATE Info SET salary = salary - ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(debit_query);
            preparedStatement.setInt(1, 500);
            preparedStatement.setInt(2, 5);
            preparedStatement.executeUpdate();
            // if(debit>0){
            //     System.out.println("Debited Successfully!!");
            // }
            // else{
            //     System.out.println("Transaction failed");
            // }

            String credit_query = "UPDATE Info SET salary = salary + ? WHERE id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(credit_query);
            preparedStatement1.setInt(1, 500);
            preparedStatement1.setInt(2, 2);
            preparedStatement1.executeUpdate();

            if(isSufficient(connection, 5, 55000)){
                connection.commit();
                System.out.println("Transaction successful");
            }
            else{
                connection.rollback();
                System.out.println("Transaction failed");
            }
            // if(credit>0){
            //     System.out.println("Credited Successfully!!");
            // }
            // else{
            //     System.out.println("Transaction failed");
            // }

            preparedStatement.close();
            preparedStatement1.close();
            connection.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isSufficient(Connection connection, int acc_number, int amount){
        try{
            String query = "SELECT salary FROM Info WHERE acc_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, acc_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int current_salary = resultSet.getInt("salary");
                if(amount > current_salary){
                    return false;
                }
                else{
                    return true;
                }
            }
            resultSet.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }
}
