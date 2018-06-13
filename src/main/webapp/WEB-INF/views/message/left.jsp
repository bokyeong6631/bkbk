<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '': pageContext.request.contextPath}" scope="application"></c:set>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/3.3.7/darkly/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
  <link rel="stylesheet" href="${_ctx}/res/message/dist/navbar-fixed-right.min.css">
  <link rel="stylesheet" href="${_ctx}/res/message/dist/navbar-fixed-left.min.css">
  <link rel="stylesheet" href="${_ctx}/res/message/docs/docs.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${_ctx}/res/message/docs/docs.js"></script>
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <title>쪽지확인</title>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-left">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">==쪽지함==</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="${_ctx}/message/write.java6">쪽지보내기</a></li>
        <li><a href="${_ctx}/message/receivelist.java6">받은쪽지함</a></li>
        <li><a href="${_ctx}/message/sendlist.java6">보낸쪽지함</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">스팸 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">스팸메일함</a></li>
            <li><a href="#">스팸메일 처리 문자</a></li>
<!--             <li role="separator" class="divider"></li> -->
<!--             <li class="dropdown-header">Nav header</li> -->
<!--             <li><a href="#">Separated link</a></li> -->
<!--             <li><a href="#">One more separated link</a></li> -->
          </ul>
        </li>
       </ul>
     <ul class="nav navbar-nav navbar-right">
        <li>
          <a data-class="navbar-fixed-left">
            <i class="fa fa-arrow-left"></i>
          </a>
        </li>
        <li>
          <a data-class="navbar-fixed-top">
            <i class="fa fa-arrow-up"></i>
          </a>
        </li>
        <li>
          <a data-class="navbar-fixed-right">
            <i class="fa fa-arrow-right"></i>
          </a>
         </li>
      </ul>
    </div>
  </div>
</nav>

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</body>
</html>