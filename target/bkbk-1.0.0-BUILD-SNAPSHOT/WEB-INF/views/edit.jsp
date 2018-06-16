<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />

<body>
<script>

$(document).ready(function() {
		
		//캡챠아이디 클릭시 변하게함
		$("#re").click(function(){
			$("#imgcaptcha").attr("src","${_ctx}/captcha/index.java6");
		}); 
		
		//핸드폰에 마스크추가
		$("#phoneN").setMask();
		
		//저장 눌렀을시
		$("#btnSave").click(function() {
			if($("#frmJoin").valid()){
				$.get("${_ctx}/captcha/isRight", {captcha : $("#captcha").val()}, function(data) {
					console.log(data);
					var url = "${_ctx}/edit.java6";
					if (data == 1) {
						//서버에 데이터 전송
						//$.post(url,parameter,callback)
						$.post(url, $("#frmJoin").serialize(), function(data) { 
							if (data == 1) {
								alert("정보수정 성공");
								alert("다시 로그인 바랍니다.");
								document.location.href = "${_ctx}/index.java6";
							} else {
								alert("정보수정 실패");
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



	<div id="rightWrap">
		<div class="rightBlock">
			<div class="page_top">
				<h1>나의 정보 수정</h1>
			</div>
		</div>
		<div id="loginWrap">
			<div id="join">

        <form id="frmJoin" action="${_ctx}/join.java6" name="frmJoin">
				<dl>
					<dd>
						<input type="text" id="loginId" name="loginId" value="${userDTO.loginId}" disabled="disabled"/>
					</dd>
					<dd>
						<input type="password" id="loginPw" name="loginPw"
							placeholder="비밀번호" maxlength="15" minlength="6"
							required="required" />
					</dd>
					<dd>
						<input type="password" name="reLoginPw" placeholder="비밀번호확인"
							equalTo="#loginPw" maxlength="15" minlength="6"
							required="required" />
					</dd>
					<dd>
						<input type="text" name="name" placeholder="이름" maxlength="30"
							required="required" />
					</dd>
					<dd>
						<input type="text" id="phoneN" name="phone" placeholder="핸드폰"
							alt="mobile" maxlength="13" 
							required="required" />
					</dd>
					<dd>
						<input type="email" id="email" name="email" placeholder="이메일"
							maxlength="20" required="required" />
					</dd>
					<dd>
						<img src="${_ctx}/captcha/index.java6" id="imgcaptcha" /> <img
							src="res/images/re.png" id="re" title="새로고침" style="width: 50px" ,"height:50px" />
						<input type="text" name="captcha" id="captcha" placeholder="이미지문자"
							title="이미지문자를 작성하세요" style="width: 182px" required="required" />
					</dd>
				</dl>
		</form>
				<a href="javascript:;" class="loginBtn" id="btnSave">저 장</a> <a
					href="${_ctx}/board/doc/list.java6" class="joinBtn" style="width: 99.5%">취소</a>



			</div>



		</div>
	</div>


</body>
</html>
