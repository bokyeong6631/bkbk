<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<c:import url="/WEB-INF/views/inc/head.jsp" />
<!-- 	헤드밑에다가넣기 -->
	<link href="${_ctx}/res/js/lightbox/magnific-popup.css" rel="stylesheet"></link>
	<script type="text/javascript" src="${_ctx}/res/js/lightbox/jquery.magnific-popup.min.js"></script>
	
	<script>
	$(document).ready(function() {
		$("#btnLogin").click(function() {
			if($("#frmLogin").valid()){
				$("#frmLogin").submit();
				cosole.log("err");
			}
		});
		$("#loginPw").keydown(function(key) {
			if(key.keyCode == 13){
				$("#btnLogin").click();
			}
		});
		$("#findId").click(function() {
			window.open("${_ctx}/find/id.java6","팝업","scrollbars=yes,toolbar=yes,resizable=yes,width=800,height=500,left=50,top=50");
		});
		$("#findPw").click(function() {
			window.open("${_ctx}/find/editpw.java6","팝업","scrollbars=yes,toolbar=yes,resizable=yes,width=800,height=800,left=50,top=50");
		});
		
// 		$.get("${_ctx}/board/popup/openPopup.java6",function(html){
// 			$("#openPopup").html(html);
// 		});
		
		//이미지 사이즈 일괄처리
		$(".parent-container > a > img").css("width","200px");
		
		$('.parent-container').magnificPopup({
		  delegate: 'a', 
		  type: 'image',
		  // other options
		  gallery: {
		      enabled: true,
		      navigateByImgClick: true,
		      preload: [0,1]
		  }
		});
	});
	</script>
</head>

<body>

<div id="openPopup"></div>

<div id="loginWrap">
    <div id="login">
    	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
    		<font color="red">
      		Your login attempt was not successful due to <br/><br/>
      			<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
    		</font>
    	<c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
		    <script>
		     // query string 제거
		     history.replaceState({}, null, location.pathname);
		    </script>
   		</c:if>
    	<h1>로 그 인 페 이 지</h1>
        <form id="frmLogin" method="post" name="frmLogin" action="${_ctx}/security/login" >        
        	<dl>
            	<dt>id</dt>
                <dd><input type="text" name="loginId" placeholder="User ID"  data-msg-required="ID를 적으세요" data-msg-minlength="ID를 {0}자 이상 적으세요" minlength="6" required="required"/></dd>
                <dt>pw</dt>
                <dd><input type="password" name="loginPw" id="loginPw" placeholder="Password" data-msg-required="PW를 적으세요" data-msg-minlength="PW를 {0}자 이상 적으세요" minlength="6" required="required"/></dd>
            </dl>
            <a href="javascript:;" class="loginBtn" id="btnLogin">로 그 인</a>
             <a href="javascript:;" class="findId" id="findId">I D 찾기</a>
            <a href="javascript:;" class="findPw" id="findPw">P W 찾기</a>
            <a href="${_ctx}/join.java6" class="joinBtn">회 원 가 입</a>
        </form>
        
    </div>

</div>
<div class="parent-container">
  <a href="${_ctx}/res/images/lightbox/Chrysanthemum.jpg"><img src="${_ctx}/res/images/lightbox/Chrysanthemum.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Desert.jpg"><img src="${_ctx}/res/images/lightbox/Desert.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Hydrangeas.jpg"><img src="${_ctx}/res/images/lightbox/Hydrangeas.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Jellyfish.jpg"><img src="${_ctx}/res/images/lightbox/Jellyfish.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Koala.jpg"><img src="${_ctx}/res/images/lightbox/Koala.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Lighthouse.jpg"><img src="${_ctx}/res/images/lightbox/Lighthouse.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Penguins.jpg"><img src="${_ctx}/res/images/lightbox/Penguins.jpg"/></a>
  <a href="${_ctx}/res/images/lightbox/Tulips.jpg"><img src="${_ctx}/res/images/lightbox/Tulips.jpg"/></a>
</div>
</body>
</html>
