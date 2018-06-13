<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="/WEB-INF/views/inc/head.jsp"/>
<style>
body {
    background-color: #60c8fb;
}
#findStart{
	width: 199.9px;
	height: 40px;
	background-color: #b7ff00;
	border: 1px solid #709218;
}
#gofindPw{
	width: 405.9px;
	height: 40px;
	background-color: #acc8f9;
	border: 1px solid #acc8f9;
}

#cancel{
	width: 199.9px;
	height: 40px;
}

</style>
<script>
	$(document).ready(function() {
		$("#cancel").click(function() {
			window.close();
		});
		$("#findStart").click(function(data) {
			var url = "${_ctx}/find/id.java6";
			if($("#findIdBlock").valid()){
				$.post(url, $("#findIdBlock").serialize(), function(data) { 
					alert("찾으시는 아이디는 "+data+"입니다-!");
					$("#dlBtn").append("<a href='${_ctx}/find/pw.java6' class='findPw' id='gofindPw'>비밀번호 찾기</a>");
					$("#findIdBlock").submit();
				});
			}
		});
		$("#phone").setMask();
	});
	
</script>

</head>
<body>

<div id="loginWrap">
    <div id="login">
    	<h1>아 이 디 찾 기</h1>
        <form id="findIdBlock" method="get" name="findIdBlock" action="${_ctx}/find/pw.java6" >
        	<input type="hidden" id="loginId" value="${loginId}"/>       
        	<dl>
            	<dt>name</dt>
                <dd><input type="text" name="name" placeholder="이름을 적어주세요" title="이름을 적어주세요" required="required"></dd>
                <dt>phone</dt>
                <dd><input type="text" name="phone" id="phone" alt="mobile" placeholder="휴대폰번호를 적어주세요" title="휴대폰번호를 적어주세요" required="required"></dd>
            </dl>
            
            <a href="javascript:;" class="findPw" id="findStart">찾 기</a>
            <a href="javascript:;" class="joinBtn" id="cancel" >취 소</a>
        	<dl id="dlBtn"></dl>
        </form>
        
    </div>

</div>
</body>
</html>