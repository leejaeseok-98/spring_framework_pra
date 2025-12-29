<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>회워가입</title>
</head>
<body>
    <h2>회원가입</h2>

    <form action="${pageContext.request.contextPath}/user/join" method="post">
        <div>
            이름: <input type="text" name="userName" required>
        </div>
        <div>
            아이디: <input type="text" name="loginId" required>
        </div>
        <div>
            비밀번호: <input type="password" name="userPw" required>
        </div>
        <div>
            이메일: <input type="email" name="email" required>
        </div>
        <button type="submit">회원가입</button>
    </form>

    <script>
        // 빈 값일 때 alert가 뜨지 않도록 처리
                const msg = "${msg}";
                if(msg && msg.trim() !== "") {
                    alert(msg);
                }
    </script>
</body>
</html>