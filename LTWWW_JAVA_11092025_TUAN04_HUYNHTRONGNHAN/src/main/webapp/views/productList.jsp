<%--
  Created by IntelliJ IDEA.
  User: nhant
  Date: 9/16/2025
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
<div class="container">
  <h2>Danh sách sản phẩm</h2>
  <div class="product-grid">
    <c:forEach var="p" items="${products}">
      <div class="card">
        <div class="title">${p.name}</div>
        <div class="meta">ID: ${p.id}</div>
        <div class="price">${p.price} USD</div>
        <div style="margin-top:auto">
          <a class="btn" href="${pageContext.request.contextPath}/cart?action=add&id=${p.id}">Add to Cart</a>
        </div>
      </div>
    </c:forEach>
  </div>
  <a class="btn ghost" href="${pageContext.request.contextPath}/cart">Xem giỏ hàng</a>
</div>


