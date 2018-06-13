<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<!-- <html xmlns="http://www.w3.org/1999/xhtml"> -->
<head>
<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
body {
  padding-top: 70px;
}
.btn-grey{
    background-color:#D8D8D8;
	color:#FFF;
}
.rating-block{
	background-color:#FAFAFA;
	border:1px solid #EFEFEF;
	padding:15px 15px 20px 15px;
	border-radius:3px;
}
.bold{
	font-weight:700;
}
.padding-bottom-7{
	padding-bottom:7px;
}

.review-block{
	background-color:#FAFAFA;
	border:1px solid #EFEFEF;
	padding:15px;
	border-radius:3px;
	margin-bottom:15px;
}
.review-block-name{
	font-size:12px;
	margin:10px 0;
}
.review-block-date{
	font-size:12px;
}
.review-block-rate{
	font-size:13px;
	margin-bottom:15px;
}
.review-block-title{
	font-size:15px;
	font-weight:700;
	margin-bottom:10px;
}
.review-block-description{
	font-size:13px;
}
.review-block .row{
	border-bottom: 0.5px solid #c1c1c1;
}
.container{
    margin-left: 400px;
    margin-top: 50px;
}
.pagination>li>a, .pagination>li>span { 
	border-radius: 50% !important;
	margin: 0 5px;
}

</style>

</head>
<body>
<script>
window.alert = function(){};
var defaultCSS = document.getElementById('bootstrap-css');
function changeCSS(css){
    if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
    else $('head > link').filter(':first').replaceWith(defaultCSS); 
}
function goPage(page) {
	$("#page").val(page);
	$("#frmPage").submit();
}
$(document).ready(function() {
  var iframe_height = parseInt($('html').height()); 
  window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
  
});
</script>

  <div class="container">
  			
<div class="row">
	<div class="col-sm-3">
		<div class="rating-block">
			<h4>평 점</h4>
			<h2 class="bold padding-bottom-7">4.3 <small>/ 10</small></h2>
			<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
			  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
			  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
			  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
			  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
			  <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</button>
		</div>
	</div>
	<div class="col-sm-3">
		<img src="${_ctx}/res/images/jurassic.png" style = "float:right"/>
	</div>			
</div>			

<div class="row">
	<div class="col-sm-7">
		<hr/>
		<div class="review-block">
			<c:forEach items="${list}" var="list">
			<div class="row">
				<div class="col-sm-3">
					<div class="review-block-name"><a href="#">${list.mwriter}</a></div>
					<div class="review-block-date">${list.mdate}</div>
				</div>
				<div class="col-sm-9">
					<div class="review-block-rate">
						  <span>평점 : ${list.mscore} / 10</span>
					<div class="review-block-title">${list.mtitle}</div>
					<div class="review-block-description">${list.mreviews}</div>
				</div>
			</div>
			</div>
			</c:forEach>
			<hr/>
			</div>
			<pagetag:paging page="${search}"/>
		</div>
	</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')</script>
</body>
</html>