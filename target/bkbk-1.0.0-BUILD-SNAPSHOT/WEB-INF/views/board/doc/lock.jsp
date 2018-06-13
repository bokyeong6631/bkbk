<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="${_ctx}/res/js/jqueryui/jquery-ui.min.css"></link>

<style>
  body {
   font-family: Arial, Helvetica, sans-serif;
  }
  
  table {
   font-size: 1em;
  }
  
  .ui-draggable, .ui-droppable {
   background-position: top;
  }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 600px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
    .lockPwBtn{
        padding: 9px;
	    color: #843838;
	    font-weight: 700;
	    border: 1px solid #929292;
	    text-decoration: none;
	    font-size: 16px;
	    border-radius: 15px;
	    background-color: #f8b64a;
	}
    
  </style>
</head>

<body>

<script>

var dialog
												
$(document).ready(function() {
	 dialog = $("#dialog-form").dialog({
       autoOpen: false,
       height: 200,
       width: 350,
       modal: true,
       buttons: {
         "닫기": function() {
           dialog.dialog( "close" );
         }
       },
       close: function() {
       }
     }).dialog("open");
	 
	 $("#lockPwCheckBtn").click(function(){
		 var lockPw = $("#writeLockPw").val();
		 if(lockPw == "${boardDocDTO.lockPw}"){
			 $("#frmLockView").valid();
			 $("#frmLockView").submit();
		 }else{
			 alert("틀림ㅜㅜ");
		 }
	 });
	 $("#writeLockPw").keydown(function(key) {
		if(key.keyCode == 13){
			$("#lockPwCheckBtn").click();
		}
	 });
});
</script>

 <div id="dialog-form" title="팝업">
 	※비밀글※
 	<p>비밀번호를 적어주세요-!</p>
	<input type="text" id="writeLockPw" name="writeLockPw" style="display: inline-block;height:30px"/> 
	<input type="submit" id="lockPwCheckBtn" value="확인" class="lockPwBtn" style="display: inline-block;cursor: pointer"/>
 </div>
 <form action="${_ctx}/board/doc/view.java6" id="frmLockView" name="frmLockView" method="get">
 	<input type="hidden" name="docId" value="${search.docId}"/>
 	<input type="hidden" name="mapId" value="${boardDocDTO.mapId}"/>
    <input type="hidden" id="page" name="page" value="${search.page}"/>
    <input type="hidden" id="searchType" name="searchType" value="${search.searchType}"/>
    <input type="hidden" id="searchText" name="searchText" value="${search.searchText}"/>
 </form>

</body>
</html>