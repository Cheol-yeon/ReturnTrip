<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReturnTrip</title>
<link href="/public/stylesheet/header.css?v=1.5" rel='stylesheet' type="text/css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/public/javascript/menu.js?v=1.1" type="text/javascript"></script>

</head>
<body>
<!-- 
   <header>
      <a href = "${pageContext.request.contextPath}/home" id="logo"><span class = "sb">Return</span> trip;</a>
      <nav>
         <a href="${pageContext.request.contextPath}/notice" >공지사항</a>
         <a href="${pageContext.request.contextPath}/journey" >진행중인 축제</a>
      </nav>
      <div id = "user">
         <a href = "${pageContext.request.contextPath}/login">로그인</a>
         <a href ="${pageContext.request.contextPath}/join">회원가입</a>
         
      </div>
   </header>
    -->
    <div class="menu_section">

        <section class="menu">
            <div class="menu_area">
                <p><a href="#">마이페이지</a></p>
                <p><a href="#">menu</a></p>
                <p><a href="#">menu</a></p>
            </div>
        </section>
    </div>
    
    <header>
    <input type="hidden" value="${login_member.name}" id="login_session" />
        <section class="title_section">
            <div class="top_area">
                <h1>
                    <a href="${pageContext.request.contextPath}/home"><span id="first_title">Return</span><span id="second_title">Trip</span><span
                            id="first_title">;</span></a>
                    </span>
                </h1>
                <img id='menu_button' src="../public/img/menubutton.png">
                    <div class="login_area" id="before_login">
                     <span><a href="${pageContext.request.contextPath}/login">로그인</a></span> | <span><a href="${pageContext.request.contextPath}/join">회원가입</a></span>                
                    </div>
                    <div class="login_area" id="after_login">
                     <span><a href="${pageContext.request.contextPath}/mypage">${login_member.name}님</a></span> | <span><a href="${pageContext.request.contextPath}/home/logout">로그아웃</a></span>                
                    </div>
        </section>
    </header>
</body>
<script>
	$(document).ready(function(){
		let login_session = $('#login_session').val();
		if(login_session == null || login_session == undefined || login_session== ""){
			$('#before_login').show();
			$('#after_login').hide();
		}
		else{
			$('#before_login').hide();
			$('#after_login').show();
		}
	});
</script>
</html>