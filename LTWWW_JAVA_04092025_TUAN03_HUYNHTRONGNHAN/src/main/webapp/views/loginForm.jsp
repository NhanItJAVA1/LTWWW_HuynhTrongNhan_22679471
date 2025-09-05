<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- File: views/loginForm.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="login.css">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="form-container">
    <h2>User Registration Form</h2>
    <form action="${pageContext.request.contextPath}/login-form" method="post">
        <div class="form-group">
            <input type="text" name="firstName" placeholder="First Name" required>
            <input type="text" name="lastName" placeholder="Last Name" required>
        </div>
        <div class="form-group">
            <input type="email" name="email" placeholder="Your Email" required>
        </div>
        <div class="form-group">
            <input type="email" name="reEmail" placeholder="Re-enter Email" required>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="New Password" required>
        </div>
        <div class="form-group">
            <label>Birthday</label><br>
            <input type="date" name="date">
        </div>
        <div class="form-group gender">
            <label><input type="radio" name="gender" value="female"> Female</label>
            <label><input type="radio" name="gender" value="male"> Male</label>
        </div>
        <div class="form-group">
            <button type="submit">Sign Up</button>
        </div>
    </form>
</div>
</body>
</html>

