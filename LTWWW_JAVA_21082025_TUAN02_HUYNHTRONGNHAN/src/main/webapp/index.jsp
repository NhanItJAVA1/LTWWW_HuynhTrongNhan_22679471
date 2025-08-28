<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="uploadFiles" method="post" enctype="multipart/form-data">
  <h2>Upload multi-files</h2>
  <div class="file-row">File 1: <input type="file" name="file1"></div>
  <div class="file-row">File 2: <input type="file" name="file2"></div>
  <input type="submit" value="Upload">
  <input type="reset" value="Reset">

  <h2>File Upload to Database (multipart/form-data)</h2>
  <form action="uploadDB" method="post" enctype="multipart/form-data">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName"><br><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName"><br><br>

    <label for="portraitPhoto">Portrait Photo:</label>
    <input type="file" id="portraitPhoto" name="photo"><br><br>

    <input type="submit" value="Save">
  </form>

</form>
<%--<a href="uploadFiles">Hello Servlet</a>--%>
</body>
</html>