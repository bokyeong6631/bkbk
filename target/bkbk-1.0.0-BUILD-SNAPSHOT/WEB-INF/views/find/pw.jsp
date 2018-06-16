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
</head>
<body>
<script>
$(document).ready(function(){
	$("#phone").setMask();
	$("#checkPhone").click(function() {
		var phone = $("#phone").val();
		var url = "${_ctx}/find/check/phone.java6?phone="+phone;
		$.get(url,function(data){
			console.log(url);
			if(data.code==0){
				alert(data.msg);
				$("#isCheckedPhone").val("Y");
			}else{
				alert(data.msg);
				$("#isCheckedPhone").val("N");
			}
		});
	});
});
</script>

<div id="loginWrap">
    <div id="login">
    	<h1>비 밀 번 호 찾 기</h1>
        <form id="findIdBlock" method="get" name="findIdBlock" action="${_ctx}/find/pw.java6" >        
        	<input type="hidden" id="isCheckedPhone" value="N"/>
        	<dl>
            	<dt>name</dt>
                <dd><input type="text" name="name" value="${loginId}" maxlength="15" minlength="6" required="required" disabled="disabled"/>
                </dd>
                <dt>phone</dt>
                <dd><input type="text" id="phone" name="phone" placeholder="휴대폰번호를 적어주세요" style="width:70%" alt="mobile" maxlength="13" required="required">
                	<a href="javascript:;" class="checkPhone" id="checkPhone">확인</a>
                </dd>
            </dl>
            
            <a href="javascript:;" class="findPw" id="findStart">찾 기</a>
            <a href="javascript:window.close();" class="joinBtn" id="cancel" >취 소</a>
        	<dl id="dlBtn"></dl>
        </form>
        
    </div>

</div>
</body>

</html>
