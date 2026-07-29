<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>
<body>
    <%
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Pulkit@2006";
        String sql = "SELECT * FROM student WHERE marks>80";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        rs.next();
    %>

    Rollno : <%= rs.getString("rollno")%> <br>
    Name: <%= rs.getString("name")%> <br>
    Marks: <%= rs.getString("marks")%> <br>
</body>
</html>
