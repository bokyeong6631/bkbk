<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="/WEB-INF/views/inc/head.jsp" />
</head>
<body>
<script>
$(document).ready(function(){
	var url = "${_ctx}/main/bus.java6";
	$.get(url,function(data){
		console.log(data);
	});
});
</script>
<dl></dl>
</body>
</html>