<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/src/webapp/resources/css/style.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h3>${user.name}님의 마이페이지</h3>
        <hr>
        <div class="row">
            <div class="col-md-4">
                <div class="card p-3">
                    <h5>보유 포인트: <span class="text-primary">${user.point}P</span></h5>
                </div>
            </div>
        </div>

        <h4 class="mt-5">최근 주문 내역</h4>
        <table class="table mt-3">
            <thead class="table-dark">
                <tr>
                    <th>주문번호</th>
                    <th>상품명</th>
                    <th>결제금액</th>
                    <th>상태</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orderList}">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.productName}</td>
                        <td>${order.totalPrice}원</td>
                        <td>${order.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>