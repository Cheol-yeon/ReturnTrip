<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>


	<c:forEach var="journey" items="${journeyList}">
		journey 이름 : ${journey.journeyName}<br>
		journey 도시 : ${journey.cityName}<br>
		journey 도로명 : ${journey.road_base_addr}<br>
		journey 주소 : ${journey.nomination}<br>
		journey 위도 : ${journey.lattitude}<br>
		journey 경도 : ${journey.longitude}<br>
		journey 전화번호 : ${journey.phone}<br>
		journey 설명 : ${journey.content}<br>
		journey 홈페이지 : ${journey.homepage}<br>
		journey 카테고리 : ${journey.category}<br>
		<br><br>
	</c:forEach>

	<%-- <c:if test="${list != null}">
		<c:forEach var="l" items="${list}">
		journey 이름 : ${list.journeyName}<br>
		journey 도시 : ${l.cityName}<br>
		journey 도로명주소 : ${l.road_base_addr}<br>
		journey 지명 : ${l.nomination}<br>
		journey 위도 : ${l.lattitude}<br>
		journey 위도 : ${l.longitude}<br>
		journey 전화 : ${l.phone}<br>
		journey 홈페이지 : ${l.homepage}<br>
		journey 홈페이지 : ${l.category}<br>
		
		journey 날씨 : ${l.weatherDO.weather}<br>
		journey 미세먼지 :${l.weatherDO.fine_dust}<br>
		journey 초미세먼지 :${l.weatherDO.ultra_fine_dust}<br>
		</c:forEach>
	</c:if> --%>
</body>
</html>