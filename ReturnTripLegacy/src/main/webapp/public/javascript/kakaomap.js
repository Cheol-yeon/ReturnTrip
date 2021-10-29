let container = document.getElementById('map_area');

let latt = document.getElementsByName('latt')[0].value;
let longitude = document.getElementsByName('longitude')[0].value;
let journame = document.getElementsByName('journame')[0].value;

let floatLatt = parseFloat(latt);
let floatLong = parseFloat(longitude);

let options = {
    center: new kakao.maps.LatLng(floatLatt, floatLong),
    level: 5
};
let map = new kakao.maps.Map(container, options);

// 마커가 표시될 위치입니다 
let markerPosition = new kakao.maps.LatLng(floatLatt, floatLong);

// 마커를 생성합니다
let marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

let linkHref = "https://map.kakao.com/link/map/"+journame+","+latt+","+longitude;

let loadHref = "https://map.kakao.com/link/to/"+journame+","+latt+","+longitude;

let iwContent = '<div class="marker-box" style="padding:5px;">'+journame+' <br><a href="'+linkHref+'" style="color:blue" target="_blank">큰지도보기</a> <a href="'+loadHref+'" style="color:blue" target="_blank">길찾기</a></div>',
    iwPosition = new kakao.maps.LatLng(floatLatt,floatLong); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
let infowindow = new kakao.maps.InfoWindow({
    position: iwPosition,
    content: iwContent
});

// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker);