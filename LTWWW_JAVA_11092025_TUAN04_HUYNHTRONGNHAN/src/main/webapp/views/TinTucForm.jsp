<%--
  Created by IntelliJ IDEA.
  User: nhant
  Date: 9/17/2025
  Time: 2:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/news.css">

<html><head><title>Thêm tin tức</title></head><body>
<h2>Thêm tin tức</h2>
<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/themtintuc" method="post">
  Tiêu đề: <input type="text" name="tieuDe" value="${param.tieuDe}"/><br/>
  Nội dung: <textarea name="noiDung" rows="5" cols="50">${param.noiDung}</textarea><br/>
  Liên kết: <input type="text" name="lienKet" value="${param.lienKet}"/><br/>
  Danh mục:
  <select name="maDM">
    <c:forEach var="d" items="${danhmucList}">
      <option value="${d.maDM}">${d.tenDanhMuc}</option>
    </c:forEach>
  </select><br/><br/>
  <button type="submit">Thêm</button>
</form>

<p><a href="${pageContext.request.contextPath}/danhmuc">Quay lại</a></p>
</body>
<%@ include file="/views/footer.jsp" %>
</html>

