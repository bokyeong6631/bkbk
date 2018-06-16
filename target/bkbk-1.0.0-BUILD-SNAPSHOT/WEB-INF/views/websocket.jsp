<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8"/>
<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${_ctx}/res/websocket/sockjs.min.js"></script>
</head>
<body>
<div id="rightWrap">
    	<div class="rightBlock">
	        <div class="page_top">
				<h1>채팅</h1>            
			</div>
		<div class="boardWrap">
			<form id="chatForm">
				<input type="text" id="message" style="height:30px;width:60%;"/>
				<a href="javascript:;"><img src="${_ctx}/res/images/send.png" style="width:80px"></a>
			</form>
			<div id="chat" style="font-size:15px;color:#56b3e1;"></div>
		</div>

	</div>
</div>
<script>
	$(document).ready(function(){
		$("#chat").append("<br/>"+"${userDTO.name} 님이 접속하셨습니다." + "<br/>");
		
		$("#chatForm").submit(function(event){
			event.preventDefault();
			sock.send($("#message").val());
			$("#message").val('').focus();
		});

	});
		
		var sock = new SockJS("/bkbk/echo");
		sock.onmessage = function(e){
			$("#chat").append("${userDTO.name}"+e.data + "<br/>");
		}
		
		sock.onclose = function(){
			$("#chat").append("연결 종료");
		}
	
</script>
</body>
</html>