<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Spring Shop</title>
    <!-- CSS Link -->
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>

    <!-- Header Include -->
    <jsp:include page="header.jsp" />

    <!-- Hero Banner -->
    <section class="hero">
        <div class="container">
            <h1>2024 S/S New Collection</h1>
            <p>봄 신상 최대 30% 할인 이벤트 진행 중!</p>
        </div>
    </section>

    <!-- Main Content -->
    <div class="container">
        
        <!-- Best Items -->
        <h2 class="section-title">🔥 Best Items</h2>
        <div class="product-grid">
            <!-- Dummy Product 1 -->
            <div class="product-card">
                <a href="#">
                    <div class="product-img">📷</div>
                    <div class="product-info">
                        <span class="product-name">베이직 코튼 셔츠</span>
                        <div class="product-price">29,900원</div>
                        <div class="product-desc">데일리로 입기 좋은 기본 셔츠</div>
                    </div>
                </a>
            </div>
            <!-- Dummy Product 2 -->
            <div class="product-card">
                <a href="#">
                    <div class="product-img">📷</div>
                    <div class="product-info">
                        <span class="product-name">와이드 데님 팬츠</span>
                        <div class="product-price">39,900원</div>
                        <div class="product-desc">트렌디한 핏의 데님</div>
                    </div>
                </a>
            </div>
            <!-- Dummy Product 3 -->
            <div class="product-card">
                <a href="#">
                    <div class="product-img">📷</div>
                    <div class="product-info">
                        <span class="product-name">오버핏 후드티</span>
                        <div class="product-price">45,000원</div>
                        <div class="product-desc">편안한 착용감의 후드</div>
                    </div>
                </a>
            </div>
            <!-- Dummy Product 4 -->
            <div class="product-card">
                <a href="#">
                    <div class="product-img">📷</div>
                    <div class="product-info">
                        <span class="product-name">캔버스 스니커즈</span>
                        <div class="product-price">59,000원</div>
                        <div class="product-desc">어디에나 잘 어울리는 신발</div>
                    </div>
                </a>
            </div>
        </div>

        <!-- New Arrivals -->
        <h2 class="section-title">✨ New Arrivals</h2>
        <div class="product-grid">
             <!-- Dummy Product 5 -->
             <div class="product-card">
                <a href="#">
                    <div class="product-img">📷</div>
                    <div class="product-info">
                        <span class="product-name">린넨 자켓</span>
                        <div class="product-price">89,000원</div>
                        <div class="product-desc">시원한 소재의 여름 자켓</div>
                    </div>
                </a>
            </div>
        </div>

    </div>

    <!-- Footer Include -->
    <jsp:include page="footer.jsp" />

</body>
</html>
