<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Return Trip</title>
    <link href="/public/stylesheet/stylesheet.css?v=1.1" rel="stylesheet">
    
</head>

<body>
    <%@ include file="/WEB-INF/include/header.jsp" %>
     <article id="wrapper">
        <section class="login_area contents_area">
            <a clas="main.html">
                <h1>LOGIN</h1>
            </a>
            <hr />
            <div class="login_form">
                <form method="post">
                    <div class="login_id_area">
                        <span>아이디 </span><input type="text" name="login_id" class="login_input" required>
                    </div>
                    <div class="login_pw_area">
                        <span>비밀번호 </span><input type="password" name="login_pw" class="login_input" required>
                    </div>
                    <div class="login_button_area">
                        <input id="login_button" type="submit" value="로그인">
                    </div>
                </form>
            </div>
        </section>
    </article>

</body>

</html>