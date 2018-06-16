<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${_ctx}/res/js/jqueryui/jquery-ui.min.css"/>
<link rel="stylesheet" href="${_ctx}/res/js/jqueryui/jquery-ui.min.css"></link>
<script type="text/javascript" src="${_ctx}/res/js/jqueryui/jquery-ui.min.js"></script>
<style>

</style>
</head>
<body>
<script>
var dialog

$(document).ready(function() {
	 dialog = $("#dialog-form").dialog({
       autoOpen: false,
       height: 400,
       width: 480,
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
<div id="dialog-form" title="주소록">
	<c:forEach items="${userList}" var="list">
		<a href="javascript:addressChoice(${list.userId});" id="addressChoice">${list.name}
		(${list.loginId})
		${list.email}<br/></a>>
	</c:forEach>
</div>
</body>
</html>