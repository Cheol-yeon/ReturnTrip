<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import = "org.json.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="button.css">
<style>
*{
font-family:sans-serif;
}
body {
	background-color : #0B4C5F;
}
#loginForm { /* form은 블럭요소이다.*/
	text-align: center;
	position: absolute;
	display: inline-block;
	padding: 1% 5% 1% 5%;
	background-color: white;
	top: 10%;
	left: 35%;
	border-radius: 2em;
}

.inForm {
	margin: 8% 0 8% 0;
	border-bottom : 2px solid gray;
	width : 20em;
}

.text {
	
	width: 100%;
  	font-size:20px;
  	height:30px;
  	border: none;
  	
}
h2 {
font-size : 40px;

}

</style>
<script type="text/javascript">
  function loginWithKakao() {
    Kakao.Auth.login({
      success: function(authObj) {
        alert(JSON.stringify(authObj))
      },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
  }
</script>

</head>
<body>

	<form action="/join"  id="loginForm">
		<h2>회원가입</h2>
		<div class="inForm">
			<input type="text" name="joinId" id="joinId" class="text" placeholder="아이디(최대글자수:15)"
				required />
		</div>
		<div class="inForm">
			<input type="password" name="joinPw" id="joinPw" class="text" placeholder="비밀번호(최대글자수:15)"
				required />
		</div>
		<div class="inForm">
			<input type="password" name="joinPwCheck" id="joinPwCheck" class="text" placeholder="비밀번호확인"
				required />
		</div>
		<div class="inForm">
			<input type="text" name="joinName" id="joinName" class="text" placeholder="이름"
				required />
		</div>
		<div class="inForm">
			<input type="text" name="joinEmail" id="joinEmail" class="text" placeholder="이메일"
				required/>
		</div>
		<div>
			<input type="submit" class="button" value="sign up" /> 
			<input type="reset" class="button" value="reset"/>
		</div>
		<a id="custom-login-btn" href="javascript:loginWithKakao()">
	  <img
	    src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
	    width="222"
	  />
</a>
	</form>
</body>
</html>