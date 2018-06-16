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
	width: 181.9px;
	height: 40px;
}
.findPw {
    width: 390px;
    height: 40px;
    padding: 0 9px 0 9px;
    border: 1px solid #B4B4B4;
    border-radius: 5px;
}

</style>
</head>
<body>
<script>
$(document).ready(function(){
	$("#findStart").click(function(){
		if($("#findIdBlock").valid()){
			var url = "${_ctx}/find/cntpw.java6";
			$.get(url,$("#findIdBlock").serialize(),function(data){
				if(data==1){
					var FindPassword = "<dd><input type='text' name='loginPw' class='findPw' id='FindPassword' placeholder='바꿀 비밀번호를 적어주세요' required='required'/></dd>";
					var CheckFindPassword = "<dd><input type='text' name='checkLoginPw' class='findPw' equalTo='#FindPassword' placeholder='비밀번호를 확인해주세요' required='required'/></dd>";
					var FindPasswordBtn = "<a href='javascript:editPassword()' class='loginBtn' id='FindPasswordBtn' style='height:41px;background-color:#b7ff00;color:#333'>수정</a> "
					$("#dlBtn").append(FindPassword,CheckFindPassword,FindPasswordBtn);
				}else{
					alert("로그인 아이디와 전화번호가 틀립니다.");
				}
			});
		}
	});
	$("#phone").setMask();
});
function editPassword(){
// 	alert("!");
	var url = "${_ctx}/find/editpw.java6";
	var loginId = $("#loginId").val();
	var phone = $("#phone").val();
	var FindPassword = $("#FindPassword").val();
	
	var param = {
			loginId : loginId
			,phone : phone
			,loginPw : FindPassword
	};
	$.post(url,param,function(){
		alert("수정되었습니다.");
		window.close();
	});
}
</script>

<div id="loginWrap">
    <div id="login">
    	<h1>비 밀 번 호 찾 기</h1>
        <form id="findIdBlock" method="post" name="findIdBlock" action="${_ctx}/find/editpw.java6" >        
        	<dl>
            	<dt>name</dt>
                <dd><input type="text" id="loginId" name="loginId" placeholder="아이디를 적어주세요" maxlength="15" minlength="6" required="required">
                </dd>
                <dt>phone</dt>
                <dd><input type="text" id="phone" name="phone" placeholder="휴대폰번호를 적어주세요" alt="mobile" maxlength="13" required="required">
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
