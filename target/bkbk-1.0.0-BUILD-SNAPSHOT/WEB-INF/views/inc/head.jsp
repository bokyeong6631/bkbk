<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '': pageContext.request.contextPath}" scope="application"></c:set>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta name="keywords" content="한국경영원 인재개발원" />
<meta name="subject" content="한국경영원 인재개발원" />
<meta name="description" content="매뉴얼" />
<meta name="robots" content="길라잡이, 매뉴얼" />
<meta name="copyright" content="COPYRIGHT ⓒ KMS. ALL RIGHTS RESERVED." />
<title>통합게시판[보경]</title>


<!-- css -->
<link href="${_ctx}/res/js/jqueryui/jquery-ui.min.css"/>
<link href="${_ctx}/res/css/base.css" rel="stylesheet" type="text/css" />
<link href="${_ctx}/res/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${_ctx}/res/js/jqueryui/jquery-ui.structure.min.css" rel="stylesheet"/>
<link href="${_ctx}/res/js/jqueryui/jquery-ui.theme.min.css" rel="stylesheet"/>



<!-- js -->
<script type="text/javascript" src="${_ctx}/res/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/validate/additional-methods.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/main.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/validate/localization/messages_ko.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/validate/meiomask.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/dtree/dtree.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/jquery.form.js"></script>
