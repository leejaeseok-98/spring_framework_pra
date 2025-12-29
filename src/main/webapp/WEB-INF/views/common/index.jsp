<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop Main</title>
    <style>
        body { font-family: sans-serif; padding: 20px; }
        .info-box { border: 1px solid #ddd; padding: 15px; border-radius: 5px; background-color: #f9f9f9; }
        .highlight { color: #007bff; font-weight: bold; }
    </style>
</head>
<body>
    <h2>🛍️ Shop Main Page</h2>
    
    <div class="info-box">
        <h3>Redis Session Test</h3>
        <ul>
            <li><strong>Session ID:</strong> <span class="highlight">${sessionId}</span></li>
            <li><strong>User Name:</strong> <span class="highlight">${username}</span></li>
            <li><strong>Visit Count:</strong> <span class="highlight">${visitCount}</span></li>
        </ul>
        <p>새로고침(F5)을 누르면 Visit Count가 증가합니다.</p>
        <p>Redis 콘솔에서 <code>keys *</code> 명령어로 세션 키가 생성되었는지 확인해보세요.</p>
    </div>
</body>
</html>
