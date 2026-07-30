<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display</title>
</head>
<body>
    <%--${label} --%>
    <%--<c:out value="Hello World" /> --%>
    <%--<c:out value="${label}" /> --%>
    <%-- <c:import url="https://www.google.com/"></c:import> --%>
    <%-- <c:set ></c:set> --%>
    <%-- these are JSP comments we have to use these only for commenting on .jsp files --%>

    <c:out value="${student.name}" />
</body>
</html>
