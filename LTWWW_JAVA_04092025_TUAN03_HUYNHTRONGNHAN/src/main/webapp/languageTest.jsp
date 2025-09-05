<%--
  Created by IntelliJ IDEA.
  User: nhant
  Date: 9/5/2025
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Dang nhap</title>
</head>
<body>
<c:set var="languageCode" value="${param.radLanguageCode}"></c:set>
<c:if test="${not empty languageCode}">
    <fmt:setLocale value="${languageCode}" scope="session"/>
</c:if>
<fmt:setBundle basename="lang" scope="session"/>
<form action="#" method="post">
    <fieldset>
        <legend>Chon ngon ngu</legend>
        <label>
            <input type="radio" name="lang" value="vi" checked> Tieng Viet
        </label>
        <label>
            <input type="radio" name="lang" value="en"> Tieng Anh
        </label>
        <button type="submit">Chon</button>
    </fieldset>
    <br>
    <fieldset>
        <label for="username">Ten dang nhap</label>
        <input type="text" id="username" name="username"><br><br>

        <label for="password">Mat khau</label>
        <input type="password" id="password" name="password"><br><br>

        <button type="submit">Dang nhap</button>
    </fieldset>
</form>
</body>
</html>
