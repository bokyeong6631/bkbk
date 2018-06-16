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
  </style>
</head>

<body>

<c:forEach items="${list}" var="item">
<script>

var dialog

$(document).ready(function() {
	 dialog = $("#dialog-form-${item.popupId}").dialog({
       autoOpen: false,
       height: 400,
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
});
</script>

 <div id="dialog-form-${item.popupId}" title="팝업">
  	<c:forEach items="${item.fileList}" var="file">
  		<img src="${_ctx}/${file.filePath}/${file.newFileName}.${file.fileExt}" /> 
  	</c:forEach>
 </div>
</c:forEach>

</body>
</html>