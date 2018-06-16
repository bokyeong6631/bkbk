<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<c:import url="/WEB-INF/views/inc/head.jsp"/>
<style>
	.leftBox {
	  float: left;
	  width: 30%;
	}
	.rightBox {
	  float: right;
	  width: 60%;
	}
	tbody tr:nth-child(2n) {
      background-color: #bbdefb;
	}
	tbody tr:nth-child(2n+1) {
	  background-color: #e3f2fd;
	}
</style>
</head>

<body>
<script>
//날씨 API
var apiURI = "http://api.openweathermap.org/data/2.5/weather?q=Gwangju&appid=7a28e574a5689b9ff388763ac15c6244";
$.ajax({
    url: apiURI,
    dataType: "json",
    type: "GET",
    async: "false",
    success: function(resp) {
        console.log(resp);
        console.log("현재온도 : "+ (resp.main.temp- 273.15) );
        console.log("현재습도 : "+ resp.main.humidity);
        console.log("날씨 : "+ resp.weather[0].main );
        console.log("상세날씨설명 : "+ resp.weather[0].description );
        console.log("날씨 이미지 : "+ resp.weather[0].icon );
        console.log("바람   : "+ resp.wind.speed );
        console.log("나라   : "+ resp.sys.country );
        console.log("도시이름  : "+ resp.name );
        console.log("구름  : "+ (resp.clouds.all) +"%" );                 
    }
});

$(document).ready(function(){
	busList();
});
//버스 리스트
function busList(){
	var url = "${_ctx}/main/bus.java6";
	
	$.get(url, function(html){
		$("#busList").html(html);
	});
}
function excelFileDownload(){
// 	$.post("${_ctx}/main/bus.java6", function(){
// 		out.clear();
// 		out = pageContext.pushBody();
// 	});

	location.href="${_ctx}/main/down.java6";
}
//페이지 전체 새로고침없이 버스리스트만 리로드
function refreshBus(){
	$.ajax({
        type : "GET",
        url : "${_ctx}/main/bus.java6",
        dataType : "text",
        error : function() {
          alert('통신실패!!');
        },
        success : function(data) {
          $('#busList').html(data);
          return false;
        }
    });
}


</script>
<!-- 날씨 툴 -->
<script>window.myWidgetParam ? window.myWidgetParam : window.myWidgetParam = [];  window.myWidgetParam.push({id: 15,cityid: '1841811',appid: '7a28e574a5689b9ff388763ac15c6244',units: 'metric',containerid: 'openweathermap-widget-15',  });  
(function() {var script = document.createElement('script');script.async = true;script.charset = "utf-8";script.src = "//openweathermap.org/themes/openweathermap/assets/vendor/owm/js/weather-widget-generator.js";
var s = document.getElementsByTagName('script')[0];s.parentNode.insertBefore(script, s);  })();
</script>

<div id="wrap">

	<c:import url="/WEB-INF/views/inc/header.jsp"></c:import>
	<c:import url="/WEB-INF/views/inc/left.jsp"></c:import>
	    
    
    <div id="rightWrap">
    	<div class="rightBlock">
            <div class="page_top"><h1>메인 페이지</h1></div>
	            <div class="leftBox" id="openweathermap-widget-15"></div>
	            <div class="rightBox" id="busList"></div>
        </div>
    </div>
    
</div>

</body>
</html>
