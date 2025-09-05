<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- File: view/success.jsp -->
<%@ page import="iuh.fit.Models.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Registration Success</title></head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<h2>Registration Successful!</h2>
<p>Name: <%= user.getFirstName() + " " + user.getLastName() %></p>
<p>Email: <%= user.getEmail() %></p>
<p>Birthday: <%= user.getBirthday() %></p>
<p>Gender: <%= user.getGender() %></p>



<a href="views/loginForm.jsp">Back to Register</a>
</body>
</html>

