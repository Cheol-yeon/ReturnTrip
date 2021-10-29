<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="/public/stylesheet/stylesheet.css?v=2.1" rel='stylesheet'>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/include/header.jsp"%>
	<article id="wrapper">
		<section id="result_page" class="area">
			<section class="contents_area">
				<div class="result_intro">
					<p id="result_text">
						<span id="result_text_first">${city }</span><span>에 대한 검색결과 입니다.</span>
					</p>
					<hr id="result_division" />
				</div>
				<div class="list_area">
				<c:forEach var="journey" items="${journeyList}" begin="${startNum }" end="${endNum }">
				<a class="list_link" href="/journey_info?place=${city}&placeNumber=${journey.journeyno }">
					<div class="town_list">
						<img src="${journey.img1 } " />
						<p>
							<span class="town_title">관광지명 : </span><span>${journey.journeyName}</span>
						</p>
						<p>
							<span class="town_title">주소 : </span><span>${journey.road_base_addr}</span>
						</p>
						<p>
							<span class="town_title">전화번호 : </span><span>${journey.phone}</span>
						</p>
					</div>
				</c:forEach>
				</div>
				</a>
				<div class="list_navi">
					 <!--   ${journeySize }-->
					 <c:forEach var="i" begin = "1" end = "${Last_Page }">
					 	<button value="${i}" class="list_button" onclick="location.href='/journey?place=${city}&page=${i}'">${i}</button>
					 </c:forEach>
				</div>


				<!-- <div class="town_list">
                    <img src="public/img/gyoungju1.jpg" />
                    <p><span class="town_title">관광지명 : </span><span>경주 동궁과 월지</span></p>
                    <p><span class="town_title">주소 : </span><span>경북 경주시 원화로 102</span></p>
                    <p><span class="hashtag">#야경</span>
                        <span class="hashtag">#사진맛집</span>
                        <span class="hashtag">#경주</span>
                        <span class="hashtag">#산책</span>
                    </p>
                </div>
                <div class="town_list">
                    <a href="info.html"><img src="public/img/gyoungju2.jpg" /></a>

                    <p><a href="info.html"><span class="town_title">관광지명 : </span><span>경주 황리단길</span></a></p>

                    <p><span class="town_title">주소 : </span><span>경북 경주시 포석로 1080(황남동)</span></p>
                    <p><span class="hashtag">#카페</span>
                        <span class="hashtag">#인생샷</span>
                        <span class="hashtag">#산책</span>
                        <span class="hashtag">#추억의거리</span>
                    </p>
                </div> -->
			</section>
		</section>
	</article>

</body>
	<footer>
		
	</footer>
</html>