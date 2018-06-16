<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${_ctx}/res/js/jquery-3.3.1.min.js"></script>
<style>
	table {
	  width: 100%;
	  border-top: 1px solid #444444;
	  border-collapse: collapse;
	}
	#busInfo th{	
	  border-bottom: 1px solid #444444;
	  padding: 10px;
	  text-align: center;
	  width: 350px;
	  height: 30px;
	  background-color: #67a86c;
	  font-weight:bold;
	  color: #000;
	}
	#busInfo td {	
	  border-bottom: 0px solid #444444;
	  padding: 10px;
	  text-align: center;
	  width: 350px;
	  height: 30px;
	  background-color: #b5e5b9;
	  font-weight:50;
	  color: #000000;
	}

</style>
</head>
<body>
<script>
$(document).ready(function(){
	var url = "/bkbk/main/bus.java6";
	$.post(url,function(data){
		//불러온 데이터 파싱
		var json = JSON.parse(data);
		var result = json.RESULT;
		if(result.RESULT_CODE == 'SUCCESS') {
			var busStopList = json.BUSSTOP_LIST;
			
			busStopList.forEach(function(cx) {
				console.log(cx);
				
				var str = '<table><tbody><tr>'
							+ '<td>'+cx.BUSSTOP_NAME+'</td>'
							+ '<td>'+cx.LINE_NAME+'</td>'
							+ '<td>'+cx.DIR_END+'</td>'
							+ '<td>'+cx.DIR_START+'</td>'
							+ '<td>'+cx.REMAIN_MIN+'분'+'</td>'
							+ '<td>'+cx.REMAIN_STOP+'</td>'
					 		+ '</tr></tbody></tbody>';
				$("#busInfo").append(str);
			});
		}
	});
});
</script>

<div id="busInfo">
	<a href="javascript:refreshBus();"><img src="${_ctx}/res/images/re.png" style="width:30px;float:right;"></a>
	<a href="javascript:excelFileDownload();"><img src="${_ctx}/res/images/excel.png" style="width:30px;float:right;"></a>
	<p style="font-size:30px">현대자동차 정류장</p>
	<table>
		<tbody>
			<tr>
				<th>현재 버스 위치</th>
				<th>버스 명 </th>
				<th>종점</th>
				<th>출발점</th>
				<th>남은 시간</th>
				<th>남은 정류장 수</th>
			</tr>
		</tbody>
	</table>

</div>

</body>
</html>