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

<html><head><title>Danh sách tin</title></head><body>
<h2>Tin tức</h2>
<!-- show categories (simple links) -->
<c:set var="current" value="${currentMaDM}" />
<p>Chọn danh mục:
  <a href="${pageContext.request.contextPath}/danhmuc?maDM=1">Công nghệ</a> |
  <a href="${pageContext.request.contextPath}/danhmuc?maDM=2">Thể thao</a> |
  <a href="${pageContext.request.contextPath}/danhmuc?maDM=3">Kinh tế</a>
</p>

<c:if test="${empty list}">
  <p>Không có tin tức trong danh mục này.</p>
</c:if>

<c:forEach var="t" items="${list}">
  <div style="border-bottom:1px solid #ccc;padding:8px 0;">
    <h3>${t.tieuDe}</h3>
    <p>${t.noiDungTT}</p>
    <a href="${t.lienKet}" target="_blank">${t.lienKet}</a>
  </div>
</c:forEach>

<p><a href="${pageContext.request.contextPath}/themtintuc">Thêm tin mới</a> |
  <a href="${pageContext.request.contextPath}/quanly">Quản lý tin</a></p>
</body>
<%@ include file="/views/footer.jsp" %>
</html>

