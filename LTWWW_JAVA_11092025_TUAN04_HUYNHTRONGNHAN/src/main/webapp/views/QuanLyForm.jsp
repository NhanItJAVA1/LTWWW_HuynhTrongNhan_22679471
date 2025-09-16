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
<html><head><title>Quản lý tin</title></head><body>
<h2>Quản lý tin</h2>
<table border="1">
  <tr><th>ID</th><th>Tiêu đề</th><th>DM</th><th>Action</th></tr>
  <c:forEach var="n" items="${allNews}">
    <tr>
      <td>${n.maTT}</td>
      <td>${n.tieuDe}</td>
      <td>${n.danhMuc.tenDanhMuc}</td>

      <td>
        <form action="${pageContext.request.contextPath}/quanly" method="post" style="display:inline">
          <input type="hidden" name="action" value="delete"/>
          <input type="hidden" name="maTT" value="${n.maTT}"/>
          <button type="submit" onclick="return confirm('Xóa tin này?')">Xóa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/danhmuc">Về trang tin</a></p>
</body>
<%@ include file="/views/footer.jsp" %>
</html>

