<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/head.jsp" %>
<%@ include file="/WEB-INF/views/inc/header.jsp" %>
<%@ include file="/WEB-INF/views/inc/left.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=Was_9xcSwiYtcOXSZGHu"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=Was_9xcSwiYtcOXSZGHu&callback=CALLBACK_FUNCTION"></script>

<script>
var map = null;

$(document).ready(function() {
	
	var HOME_PATH = window.HOME_PATH || '.';

	var cityhall = new naver.maps.LatLng(35.160177, 126.910005),
	    map = new naver.maps.Map('map', {
	        center: cityhall.destinationPoint(0, 500),
	        zoom: 14
	    }),
	    marker = new naver.maps.Marker({
	        map: map,
	        position: cityhall
	    });

	var contentString = [
	        '<div class="iw_inner">',
	        '   <img src="${_ctx}/res/images/qqq.png" width="55" height="55" class="thumb" /><br/>',
	        '   <p style="font-size:14px;color:black;"> 북구 경양로170 한경빌딩 5층 한국경영원 인재개발원<br/>',
	        '      062)720-4800 | 디자인웹솔루션<br/><br/>',
	        '   </p>',
	        '</div>'
	    ].join('');

	var infowindow = new naver.maps.InfoWindow({
	    content: contentString
	});

	naver.maps.Event.addListener(marker, "click", function(e) {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, marker);
	    }
	});

	infowindow.open(map, marker);
});

</script>

</head>
<body>
<script>

</script>
<div id="rightWrap">
   	<div class="rightBlock">
        <div class="page_top">
       		<h1>찾아오는 길</h1>
        </div>
        <div class="boardWrap">
			<div id="map" style="width: 100%; height: 65%;"></div>
			<br/><span style="font-size:30px;color:black">광주광역시 북구 경양로170 한경빌딩 5층 한국경영원 인재개발원</span>
		</div>
	</div>
</div>

</body>
</html>