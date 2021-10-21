<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Return Trip</title>
    <link href="/public/stylesheet/stylesheet.css" rel="stylesheet">
</head>

<body>
    <header>
        <section class="title_section">
            <div class="top_area">
                <h1>
                    <a href="main.html"><span id="first_title">Return</span><span id="second_title">Trip</span><span
                            id="first_title">;</span></a>
                    </span>
                </h1>
                <span><img id='menu_button' src="/public/img/menubutton.png">
                    <div class="login_area">
                        <span><a href="login.html">로그인</a></span> | <span><a href="join.html">회원가입</a></span>
                    </div>
            </div>
        </section>
    </header>
    <article id="wrapper">
        <section class="login_area contents_area">
            <a clas="main.html">
                <h1>LOGIN</h1>
            </a>
            <hr />
            <div class="login_form">
                <form method="post" action>
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