<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body bgcolor="cyan">
    <!-- whatever is inside percentage tag will be considered java code -->
    <!-- JSP by default provides request object and PrintWriter object -->
    <%
        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));

        int k= i+j;

        out.println("result is: "+ k);
    %> 
    
</body>
</html>