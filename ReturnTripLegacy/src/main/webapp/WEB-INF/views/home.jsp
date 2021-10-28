<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/public/stylesheet/stylesheet.css?v=1.6" rel='stylesheet'>
</head>	
<body>
	<!-- <form action = "journey" method = "GET">
		<section>
			<div id = "center">
			어디로 <span class = "sb">떠나고</span> 싶으신가요?<br>
			<input class = "text" type = "text" id = "place" name = "place" onkeyup="searchFunction()" placeholder = "지역,장소를 입력해주세요"/>
			</div>
			<div  id ="search"></div>
		</section>
			
		<p id= "test">
		</p>
	</form> -->
	<%@ include file="/WEB-INF/include/header.jsp" %>
	<article id="wrapper" style="padding:0;">
		<section id="intro_page" class="area">
            <section class="contents_area">
                <p id='intro'>어디로 <span id="intro_point">떠나고</span> 싶은가요?</p>
                <div class="search_area">
                    <form class='search_form' method="GET" action="/journey">
                        <input id='input_town' type="text" name = "place" onkeyup="searchFunction()" placeholder='지역, 장소를 입력해주세요.'>
                    </form>
                </div>
            </section>
        </section>
	</article>
</body>
<script>
 
let request = new XMLHttpRequest();
function searchFunction() {
	if(document.getElementById("input_town").value.length > 0.5){
	request.open("GET", "./search?category=" + encodeURIComponent(document.getElementById("place").value),true);
	request.onreadystatechange = searchProcess;
	request.send(null);	
	}
}

function searchProcess() {
	let table = document.getElementById("search");
	table.innerHTML ="";
	if(request.readyState == 4 && request.status == 200){
		let a =JSON.parse(request.responseText);
		table.innerHTML = a.result;
	}
}
 
</script>

</html>