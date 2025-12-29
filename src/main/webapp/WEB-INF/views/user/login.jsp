<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <h2>로그인</h2>

    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <div>
            아이디: <input type="text" name="loginId" required>
        </div>
        <div>
            비밀번호: <input type="password" name="userPw" required>
        </div>
        <button type="submit">로그인</button>
    </form>

    <script>
        // Controller의 rttr.addFlashAttribute("msg", ...)가 전달한 메시지 처리
        const msg = "${msg}";
        if(msg) {
            alert(msg);
        }
    </script>
</body>
</html>