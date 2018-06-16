<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<html>
<head>
<c:import url="/WEB-INF/views/message/left.jsp" />
<script type="text/javascript" src="${_ctx}/res/editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<style>
body{
	color: #000;
	background-color:#ffffff;
}
#receiveId{
	border: 0.5px solid #000;
	width: 89%;
	height: 40px;
}
#title{
	border: 0.5px solid #000;
	width: 100%;
	height: 40px;
}
#contents{
	border: 0.5px solid #000;
	width: 100%;
}
.myButton {
	-moz-box-shadow:inset 0px 1px 12px 0px #d9fbbe;
	-webkit-box-shadow:inset 0px 1px 12px 0px #d9fbbe;
	box-shadow:inset 0px 1px 12px 0px #d9fbbe;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #b8e356), color-stop(1, #a5cc52));
	background:-moz-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
	background:-webkit-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
	background:-o-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
	background:-ms-linear-gradient(top, #b8e356 5%, #a5cc52 100%);
	background:linear-gradient(to bottom, #b8e356 5%, #a5cc52 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#b8e356', endColorstr='#a5cc52',GradientType=0);
	background-color:#b8e356;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #83c41a;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:16px;
	font-weight:bold;
	padding:10px 24px;
	text-decoration:none;
	text-shadow:2px -2px 5px #86ae47;
	float:right;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #a5cc52), color-stop(1, #b8e356));
	background:-moz-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
	background:-webkit-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
	background:-o-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
	background:-ms-linear-gradient(top, #a5cc52 5%, #b8e356 100%);
	background:linear-gradient(to bottom, #a5cc52 5%, #b8e356 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#a5cc52', endColorstr='#b8e356',GradientType=0);
	background-color:#a5cc52;
}
.myButton:active {
	position:relative;
	top:1px;
}

</style>
</head>
<body>

<script>
var oEditors = [];
$(document).ready(function(){
	$("#addressList").click(function(){
		$.get("${_ctx}/message/address.java6",function(html){
			$("#addressListPopup").html(html);
		});
	});
	
	$("#btnSave").click(function(){
			oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
			var contents =  document.getElementById("contents").value;
			var receiveId = $("#receiveId").val();
			var title = $("#title").val();
			var params = {
					receiveId : receiveId,
					title : title,
					contents : contents
			}
			if(contents != "<p><br></p>"){
				$.post("${_ctx}/message/write.java6",params,function(){
					
				});
			}else{
				alert("내용을 입력해주세요");
			}
	});
	
	nhn.husky.EZCreator.createInIFrame({
	    oAppRef: oEditors,
	    elPlaceHolder: "contents",
	    sSkinURI: "${_ctx}/res/editor/SmartEditor2Skin.html",
	    fCreator: "createSEditor2"
	});
});

function addressChoice(userId){ 
// 	alert(userId);
	dialog.dialog( "close" );
	$("#receiveId").attr("value",userId);
}
</script>


<div class="container">
	<div><h1>쪽지보내기</h1><br/>
		<div id="addressListPopup"></div>
			<input type="text" id="receiveId" name="receiveId" value="" placeholder="받는 사람" required="required"/>
			<a href="javascript:;" id="addressList"><img src="${_ctx}/res/images/receiveUser.png" style="width:43px"></a><br/><br/>
			<input type="text" id="title" name="title"  placeholder="제목 입력" required="required"/><br/><br/>
			<textarea rows="10" cols="5" id="contents" name="contents" placeholder="내용 입력" required="required"></textarea>
			<a href="${_ctx}/message/list.java6" class="myButton">취소</a>
			<a href="javascipt:;" class="myButton" id="btnSave">보내기</a>
	</div>
</div>


</body>
</html>