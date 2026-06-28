package JDBC;
import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/college";
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

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            //Statement statement = connection.createStatement();
            //String query = String.format("UPDATE student SET rollno = %d WHERE rollno= %d", 105, 150);
            //String query = "DELETE FROM student where rollno = 105";

            String query = "INSERT INTO student(rollno, name) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 104);
            preparedStatement.setString(2, "Ram");

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Data inserted Successfully!");
            }
            else{
                System.out.println("Data Not inserted!");
            }
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
