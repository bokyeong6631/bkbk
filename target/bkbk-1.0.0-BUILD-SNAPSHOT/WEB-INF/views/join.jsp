<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<c:import url="/WEB-INF/views/inc/head.jsp"/>
<script>

$(document).ready(function() {
		//아이디체크 버튼을 클릭했을때
		$("#checkId").click(function() {
			var loginId = $("#loginId").val();
			if(loginId == ""){
				alert("아이디를 적어주세요");
			}else{
				//6자리 이상 아이디 체크
				if(loginId.length >= 6){
				 //아이디 중복검사 실행
				 var url = "${_ctx}/check/id.java6?loginId="+loginId; //경로 뒤에 ?는 get방식.?뒤에는 controller checkId 메서드의 파라미터
				 $.get(url,function(data){
					if(data.code > 0){
						alert(data.msg);
						//아이디 중복 체크를 했음.
						$("#isCheckedId").val("Y");
						$("#checkId").focus().val("N");
					}else{
						alert(data.msg);
						$("#isCheckedId").val("N");
					}
				 })
				}else{
					alert("6자리 이상 적어주세요.")
				}
			}
		});
		//핸드폰 중복체크
		$("#checkPhone").click(function() {
			var phoneN = $("#phoneN").val();
			if(phoneN == ""){
				alert("핸드폰번호를 적어주세요");
			}else{
				if(phoneN.length>=13){
					var url = "${_ctx}/check/phone.java6?phoneNumber="+phoneN;
					$.get(url, function(data) {
						if(data.code>0){
							alert(data.msg);
							$("#isCheckedPhone").val("Y");
						}else{
							alert(data.msg);
							$("#isCheckedPhone").val("N");
						}
					})
				}else{
					alert("올바른 형식으로 적어주세요.")
				}
			}
		});
		//이메일 중복체크
		$("#checkEmail").click(function() {
			var email = $("#email").val();
			if(email == ""){
				alert("이메일을 적어주세요");
			}else{
				if(email.length>=5){
					var url = "${_ctx}/check/email.java6?email="+email;
					$.get(url, function(data) {
						if(data.code>0){
							alert(data.msg);
							$("#isCheckedEmail").val("Y");
						}else{
							alert(data.msg);
							$("#isCheckedEmail").val("N");
						}
					})
				}else{
					alert("이메일 형식을 지켜주세요")
				}
			}
		})
		
		
		//캡챠아이디 클릭시 변하게함
		$("#re").click(function(){
			$("#imgcaptcha").attr("src","${_ctx}/captcha/index.java6");
		}); 
		
		//핸드폰에 마스크추가
		$("#phoneN").setMask();
		
		//저장 눌렀을시
		$("#btnSave").click(function() {
			//1.아이디 중복체크 검사
			var isCheckedId = $("#isCheckedId").val();
			if(isCheckedId =="N"){
				alert("아이디 중복체크를 먼저 해주세요.");
				return;
			}
			//검정에 통과하면
			if($("#frmJoin").valid()){
			$.get("${_ctx}/captcha/isRight", {captcha : $("#captcha").val()}, function(data) {
				console.log(data);
				var url = "${_ctx}/join.java6";
				if (data == 1) {
					//서버에 데이터 전송
					//$.post(url,parameter,callback)
					$.post(url, $("#frmJoin").serialize(), function(data) { 
						console.log(data);
						if (data == 1) {
							alert("회원가입 성공");
							document.location.href = "${_ctx}/login.java6";
						} else {
							alert("회원가입 실패");
							document.location.reload();
						}
					});
				} else {
					alert("입력하신 문자가 다릅니다. 다시 시도해주시기 바랍니다.")
				}
			});
		}
	});
	
	//포커스 인아웃시 배경색 변경.
	$("input").on("focusin", function() {
		$(this).css("background-color","yellow");
	});
	$("input").on("focusout", function() {
		$(this).css("background-color","white");
	});
	//페이징 로딩완료후 포커스잡음
	$("#loginId").focus();
});

</script>
</head>
<body>
<div id="loginWrap">
    <div id="join">
    	<h1>회 원 가 입</h1>
        <form id="frmJoin" action="${_ctx}/join.java6" name="frmJoin">
			<!--아이디기록을 숨겨놓음 value가 N일때는 체크안함 -->
        	<input type="hidden" id="isCheckedId" value="N"/>
        	<input type="hidden" id="isCheckedPhone" value="N"/>
        	<input type="hidden" id="isCheckedEmail" value="N"/>
        
        	<dl>
                <dd><input type="text" id="loginId" name="loginId" placeholder="아이디" maxlength="15" minlength="6" style="width:70%" required="required"/>
                	<a href="javascript:;" class="checkId" id="checkId">ID체크</a></dd>
                <dd><input type="password" id="loginPw" name="loginPw" placeholder="비밀번호" maxlength="15" minlength="6" required="required"/></dd>
                <dd><input type="password" name="reLoginPw" placeholder="비밀번호확인" equalTo="#loginPw" maxlength="15" minlength="6" required="required"/></dd>
                <dd><input type="text" name="name" placeholder="이름" maxlength="30" required="required"/></dd>
                <dd><input type="text" id="phoneN" name="phone" placeholder="핸드폰" alt="mobile" maxlength="13" style="width:70%" required="required"/>
                	<a href="javascript:;" class="checkPhone" id="checkPhone">중복체크</a></dd>
                <dd><input type="email" id="email" name="email" placeholder="이메일" maxlength="20" style="width:70%" required="required"/>
                	<a href="javascript:;" class="checkEmail" id="checkEmail"/>중복체크</a></dd>
                <dd>
                <img src="${_ctx}/captcha/index.java6" id="imgcaptcha" />
                <img src="res/images/re.png" id="re" title="새로고침" style="width: 50px;height:50px" />
                <input type="text" name="captcha" id="captcha" placeholder="이미지문자" title="이미지문자를 작성하세요" style="width:182px" required="required"/>
                </dd>
            </dl>
            
            <a href="javascript:;" class="loginBtn" id="btnSave">저 장</a>
            <a href="${_ctx}/index.java6" class="joinBtn" style="width:99.5%">취 소</a>
            
        
        </form>
        
    </div>

	

</div>

</body>
</html>
