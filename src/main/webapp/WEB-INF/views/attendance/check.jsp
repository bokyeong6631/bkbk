<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />
<script type="text/javascript" src="${_ctx}/res/attendance/js/jquery.js?ver=2"></script>
<link href="${_ctx}/res/attendance/css/monthly.css?ver=2" rel="stylesheet">
<script src="${_ctx}/res/attendance/js/monthly.js?ver=2"></script>
</head>

<body>
<div id="rightWrap">
   	<div class="rightBlock">
	   		<div class="page_top"><h1>출석체크 </h1></div>
		   		<div class="boardWrap" style="width: 95%;height: 80%;display:inline-block">
					<div class="monthly" id="demo-1"></div>
		   		</div>
<!-- 			<input type="text" id="date-picker" > -->
<!-- 			<div class="monthly" id="demo-2"></div> -->
	</div>
</div>



<script>

$(document).ready(function(){
	attendanceCheck();
	var now = new Date();
    var year= now.getFullYear();
    var mon = (now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
    var day = now.getDate()>9 ? ''+now.getDate() : '0'+now.getDate();
    var chan_val = year + '/' + mon + '/' + day;
	$(".monthly-today").click(function(){
		alert("나오너라");
		$.post("${_ctx}/attendance/write.java6",{userId:"${view.userId}",checkYn:"Y"},function(){
			
		});
	});
	
});
function attendanceCheck(){
	$('#demo-1').monthly({
		mode: 'picker',
		xmlUrl: '${_ctx}/res/attendance/events.xml'
	});
	
	
}



// $('#demo-2').monthly({
// 	target: '#date-picker',
// 	startHidden: true,
// 	showTrigger: '#date-picker'
// });

// $('#selector').monthly({
// 	  // 'Sun' or 'Mon'
// 	  weekStart: 'Sun',
// 	  // 'event' = event calendar mode
// 	  mode: '',
// 	  // Path to events XML file
// 	  xmlUrl: '',
// 	  // target element
// 	  target: '',
// 	  // shows listing of events under calendar
// 	  eventList: true,
// 	  // max width of the calendar
// 	  // hides calender until trigger is clicked
// 	  startHidden: false,
// 	  // trigger element to show the calendar
// 	  showTrigger: ''
// 	});

</script>
</body>
</html>