<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
    <div class="container header-inner">
        <a href="<c:url value='/main'/>" class="logo">Spring<span>Shop</span></a>
        
        <ul class="nav-menu">
            <li><a href="#">BEST</a></li>
            <li><a href="#">NEW</a></li>
            <li><a href="#">TOP</a></li>
            <li><a href="#">BOTTOM</a></li>
            <li><a href="#">OUTER</a></li>
        </ul>

        <div class="user-menu">
            <c:choose>
                <c:when test="${not empty sessionScope.userId}">
                    <span><strong>${sessionScope.userName}</strong>님 환영합니다!</span>
                    <a href="<c:url value='/user/mypage'/>">마이페이지</a>
                    <a href="#">장바구니</a>
                    <a href="<c:url value='/user/logout'/>">로그아웃</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value='/user/login'/>">로그인</a>
                    <a href="<c:url value='/user/join'/>">회원가입</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>
