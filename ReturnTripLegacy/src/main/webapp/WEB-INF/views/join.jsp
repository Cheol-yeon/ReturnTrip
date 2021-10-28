<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import = "org.json.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return Trip</title>
<link href="/public/stylesheet/stylesheet.css?v=1.5" rel="stylesheet" type="text/css">
<link href="/public/stylesheet/join.css?v=1.5" rel='stylesheet' type="text/css">

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
<%@ include file="/WEB-INF/include/header.jsp" %>
    <article id="wrapper">
        <div class="contents_area">
            <section class="con_area">
                <p id='join'>JOIN</p>
                <hr />
            </section>

            <div>
            <form method="post" action="/join">
                <table class="con_area_a">
                    <colgroup>
                        <col width="20%" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th class="j_title"><span class="join_title">아이디</span></th>
                            <td><input type="text" class="int" name="joinId">
                                <button type="button" class="btnJoin">
                                    <span>중복확인</span>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title" >이름</span></th>
                            <td><input type="text" class="int" name="joinName"></td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title" >비밀번호</span></th>
                            <td><input type="password" class="int" name="joinPw"></td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title"></span></th>
                            <td class="int_b">비밀번호는 8~13자로 공백없이 입력해주세요</td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title" >비밀번호 확인</span></th>
                            <td><input type="password" class="int" name="joinPwCheck"></td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title"></span></th>
                            <td class="int_b">
                                <p id="pwcheck"></p>
                            </td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title" >이메일</span></th>
                            <td>
                                <input type="text" class="int_a" name="joinEmailFirst"><span>@</span>
                                <input type="text" class="int_a" name="joinEmailSecond">
                                <span>
                                    <select name="joinEmailSecond">
                                        <option value="" selected>선택하세요</option>
                                        <option value="naver.com">naver.com</option>
                                        <option value="hotmail.com">hotmail.com</option>
                                        <option value="hanmail.com">hanmail.com</option>
                                        <option value="yahoo.co.kr">yahoo.co.kr</option>
                                    </select>
                                </span>
                                <button type="button" class="btnJoin">
                                    <span>이메일 인증</span>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title"></span></th>
                            <td class="int_b">인증 코드는 5분간 유효 합니다</td>
                        </tr>
                        <tr>
                            <th class="j_title"><span class="join_title">인증번호</span></th>
                            <td><input type="text" class="int_a">
                                <button type="button" class="btnJoin">
                                    <span>인증확인</span>
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="btn_wrap">
                <button type="button" class="btnJoin_a">
                    <span>취소</span>
                </button>
                <input type="submit" value="회원가입" class="btnJoin_b" />
            </div>
            </form>
        </div>
    </article>

</body>
</html>
