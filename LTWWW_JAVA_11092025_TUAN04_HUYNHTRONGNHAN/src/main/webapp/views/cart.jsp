<%--
  Created by IntelliJ IDEA.
  User: nhant
  Date: 9/16/2025
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
<div class="container">
    <h2>Giỏ hàng</h2>

    <c:choose>
        <c:when test="${empty sessionScope.cart}">
            <div class="cart-panel"><p>Giỏ hàng trống!</p>
                <a class="btn ghost" href="${pageContext.request.contextPath}/products">Quay lại mua hàng</a></div>
        </c:when>
        <c:otherwise>
            <div class="cart-panel">
                <div class="cart-list">
                    <c:forEach var="it" items="${sessionScope.cart}">
                        <div class="cart-row">
                            <div class="left">
                                <div class="name">${it.name}</div>
                                <div class="meta">Price: ${it.price} USD</div>
                            </div>
                            <div class="qty-control">
                                <a class="btn small" href="${pageContext.request.contextPath}/cart?action=decrease&id=${it.productId}">-</a>
                                <div>${it.quantity}</div>
                                <a class="btn small" href="${pageContext.request.contextPath}/cart?action=add&id=${it.productId}">+</a>
                                <a class="btn small ghost" href="${pageContext.request.contextPath}/cart?action=remove&id=${it.productId}">Remove</a>
                            </div>
                            <div class="price">${it.price * it.quantity} USD</div>
                        </div>
                    </c:forEach>
                </div>

                <!-- tính tổng -->
                <c:set var="total" value="0" scope="page"/>
                <c:forEach var="it" items="${sessionScope.cart}">
                    <c:set var="total" value="${total + (it.price * it.quantity)}" scope="page"/>
                </c:forEach>

                <div class="totals">
                    <div>Tổng:</div>
                    <div><strong>${total} USD</strong></div>
                </div>

                <div style="margin-top:12px">
                    <a class="btn" href="${pageContext.request.contextPath}/products">Tiếp tục mua</a>
                    <a class="btn ghost" href="${pageContext.request.contextPath}/cart?action=clear">Xóa giỏ</a>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>


