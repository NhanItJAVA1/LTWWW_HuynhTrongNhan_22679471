<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="iuh.fit.Models.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result Submit</title>
</head>
<body>

<%
    Student student = (Student) request.getAttribute("student");
    student =(Student) request.getAttribute("student");
    out.println("First name: " + student.getFirstName()
            + "<br/> Last name: " + student.getLastName()
            + "<br/> Email: " + student.getEmail()
            + "<br/> Gender: " + student.getGender()
            + "<br/> Birthday: " + student.getDatePfBirth()
    );
%>

<h2>Submitted Information</h2>
<p><strong>First name:</strong> <%= student.getFirstName() %></p>
<p><strong>Last name:</strong> <%= student.getLastName() %></p>
<p><strong>Email:</strong> <%= student.getEmail() %></p>
<p><strong>Gender:</strong> <%= student.getGender() %></p>
<p><strong>Birthday:</strong> <%= student.getDatePfBirth() %></p>

</body>
</html>

