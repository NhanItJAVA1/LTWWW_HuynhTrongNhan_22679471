<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="form.css">">
<head>
    <title>Title</title>
</head>
<body>
<div class="form-container">
    <h2>Student Registration Form</h2>
    <form action="registration-form" name="formDangKy" method="get">
        <table>
            <tr>
                <td>First name:</td>
                <td><input type="text" name="firstName" maxlength="30" pattern="[A-Za-z]+" required></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="lastName" maxlength="30" pattern="[A-Za-z]+" required></td>
            </tr>
            <tr>
                <td>Date of birth:</td>
                <td><input type="date" name="birthdate" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Mobile number:</td>
                <td><input type="text" name="phoneNumber" pattern="[0-9]{10}" maxlength="10" required></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male" required> Male
                    <input type="radio" name="gender" value="Female"> Female
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><textarea rows="3" cols="30" name="address" ></textarea></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input name="city" type="text" maxlength="30" pattern="[A-Za-z]+" required></td>
            </tr>
            <tr>
                <td>Pin code:</td>
                <td><input name="pinCode" type="text" pattern="[0-9]{6}" maxlength="6" required></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input name="state" type="text" maxlength="30" pattern="[A-Za-z]+" required></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input name="country" type="text" value="India" readonly></td>
            </tr>
            <tr>
                <td>Hobbies:</td>
                <td>
                    <input type="checkbox" name="chkHobbies" value="Drawing"> Drawing
                    <input type="checkbox" name="chkHobbies" value="Singing"> Singing
                    <input type="checkbox" name="chkHobbies" value="Dancing"> Dancing
                    <input type="checkbox" name="chkHobbies" value="Sketching"> Sketching
                    <input type="checkbox" name="chkHobbies" value="Others"> Others
                    <input type="text" name="otherHobby">
                </td>
            </tr>
        </table>
        <h3>Qualification</h3>
        <table border="1">
            <tr>
                <th>Sl.No.</th>
                <th>Examination</th>
                <th>Board</th>
                <th>Percentage</th>
                <th>Year of Passing</th>
            </tr>
            <tr>
                <td>1</td>
                <td>Class X</td>
                <td><input type="text"></td>
                <td><input type="text" maxlength="5"></td>
                <td><input type="text" maxlength="4"></td>
            </tr>
            <tr>
                <td>2</td>
                <td>Class XII</td>
                <td><input type="text"></td>
                <td><input type="text" maxlength="5"></td>
                <td><input type="text" maxlength="4"></td>
            </tr>
            <tr>
                <td>3</td>
                <td>Graduation</td>
                <td><input type="text"></td>
                <td><input type="text" maxlength="5"></td>
                <td><input type="text" maxlength="4"></td>
            </tr>
            <tr>
                <td>4</td>
                <td>Masters</td>
                <td><input type="text"></td>
                <td><input type="text" maxlength="5"></td>
                <td><input type="text" maxlength="4"></td>
            </tr>
        </table>
        <br>
        <label>Courses applied for:</label>
        <input type="radio" name="course" value="BCA"> BCA
        <input type="radio" name="course" value="B.Com"> B.Com
        <input type="radio" name="course" value="B.Sc"> B.Sc
        <input type="radio" name="course" value="B.A"> B.A
        <br><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</div>
</body>
</html>
