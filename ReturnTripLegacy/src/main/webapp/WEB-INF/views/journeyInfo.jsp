<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <link href="/public/stylesheet/stylesheet.css?v=2.3" rel='stylesheet'>
    <link href="/public/stylesheet/infoStyle.css?v=1.2" rel="stylesheet">
    <script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c7412fc3b7e0c0c8c4b525ee57199d1c"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    
</head>

<body>




	<%@ include file="/WEB-INF/include/header.jsp"%>
    <article id="wrapper">
        <section class="info_contents">
            <section class="info_intro">
                <p class="info_middle_title">${journeyInfo.journeyName }</p>
                <hr class="info_hr" />
            </section>
            <section class="town_info">
                <div class="img_area">
                    <img src="public/img/picture_area.png" id="img_frame" />
                    <div class="img_element">
                        <ul>
                            <li><img id="bigImg" src="${journeyInfo.img1 }" /></li>
                        </ul>
                    </div>
                </div>
                <div class="preview_list">
                    <div class="preview">
                        <img class="prewview_img" src="${journeyInfo.img1 }" />
                    </div>
                    <div class="preview">
                        <img class="prewview_img" src="${journeyInfo.img2 }" />
                    </div>
                </div>
                
                <div class="info_title">
                    <h3>관광지 기본 정보</h3>
                    <hr class="info_line" />
                    <p><span class="detail_point">전화번호 :</span><span>${journeyInfo.road_base_addr }</span></p>
                </div>
                <div class="info_detail">
                    <h3>관광지 상세 정보</h3>
                    <hr class="info_line" />
                    <p><span class="detail_point">전화번호 :</span><span> ${journeyInfo.phone }</span>
                    <p><span class="detail_point">여행지 설명 :</span><span> ${journeyInfo.content }</span>
                    <p><span class="detail_point">여행지 카테고리 :</span><span> ${journeyInfo.category }</span>
                    </p>
                </div>
            </section>
            <section class="info_wether">
                <p class="info_middle_title">현재 기상 정보</p>
                <hr class="info_hr" />
                <div class="wether_item">
                    <div class="wether">
                        <p>기상 정보</p>
                        <div class="item_box">
                            <div class="today">
                                <p>오늘</p>
                                <img src="public/img/wether/shin.png" />
                                <p>34°C</p>
                            </div>
                            <div class="tomorrow">
                                <p>내일</p>
                                <img src="public/img/wether/rain.png" />
                                <p>27°C</p>
                            </div>
                        </div>
                    </div>
                    <div class="dust">
                        <p>미세 먼지</p>
                        <div class="item_box">
                            <div class="today">
                                <p>오늘</p>
                                <img src="public/img/wether/smile.png" />
                                <p>매우 좋음</p>
                            </div>
                            <div class="tomorrow">
                                <p>내일</p>
                                <img src="public/img/wether/blue.png" />
                                <p>매우 나쁨</p>
                            </div>
                        </div>
                    </div>
                    <div class="rain">
                        <p>강수 확률</p>
                        <div class="item_box">
                            <div class="today">
                                <p>오늘</p>
                                <img src="public/img/wether/cloud.png" />
                                <p>75%</p>
                            </div>
                            <div class="tomorrow">
                                <p>내일</p>
                                <img src="public/img/wether/cloud.png" />
                                <p>85%</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="info_map">
                <p class="info_middle_title">오시는 길</p>
                <hr class="info_hr" />
                <div id="map_area">
                </div>
            </section>
            <section class="reply_area">
                <p class="info_middle_title">
                    <span>사용자 리뷰</span><span>
                        (20)
                    </span>
                </p>
                <hr />
                <div class="reply_el_area">
                    <span class="reply_name">김경태</span><span class="reply_date">2021-10-10</span>
                    <pre class="reply_contents">댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.</pre>
                    <hr />
                    <span class="reply_name">박시현</span><span class="reply_date">2021-10-10</span>
                    <pre class="reply_contents">댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.</pre>
                    <hr />
                    <span class="reply_name">서동현</span><span class="reply_date">2021-10-10</span>
                    <pre class="reply_contents">댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.댓글 영역입니다.</pre>
                    <hr />
                </div>
                <div class="reply_input_area">
                    <textarea class="reply_input_textarea" placeholder="이쁜만 고운말 써주세욤."></textarea>
                    <button id="reply_input_button">댓글 입력</button>
                </div>
            </section>
        </section>
    </article>
    <input type="hidden" value="${journeyInfo.lattitude }" name="latt" />
    <input type="hidden" value="${journeyInfo.longitude }" name="longitude" />
    <input type="hidden" value="${journeyInfo.journeyName }" name="journame" />
    <footer>

    </footer>
    

</body>
   <script src="/public/javascript/kakaomap.js?v=1.1" type="text/javascript"></script>
<script>


    const boxParent = $('.marker-box').parent('div');

    boxParent.css('position', 'relative');

</script>
<script>
        $(document).ready(function () {
            $('.prewview_img').on('click', function () {
                let bigSrc = $(this).attr('src');
                $('#bigImg').attr('src', bigSrc);
            })

        });
    </script>
</html>