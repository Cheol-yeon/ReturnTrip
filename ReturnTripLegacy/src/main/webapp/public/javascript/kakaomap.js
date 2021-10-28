let container = document.getElementById('map_area');
let options = {
    center: new kakao.maps.LatLng(35.83852, 129.20972),
    level: 5
};

let map = new kakao.maps.Map(container, options);

// 마커가 표시될 위치입니다 
let markerPosition = new kakao.maps.LatLng(35.83852, 129.20972);

// 마커를 생성합니다
let marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

let iwContent = '<div class="marker-box" style="padding:5px;">황리단길 <br><a href="https://map.kakao.com/link/map/황리단길,35.83852, 129.20972" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>',
    iwPosition = new kakao.maps.LatLng(35.83852, 129.20972); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
let infowindow = new kakao.maps.InfoWindow({
    position: iwPosition,
    content: iwContent
});

// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker);