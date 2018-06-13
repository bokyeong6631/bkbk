<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/views/message/left.jsp" />
<link href="${_ctx}/res/css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://pagead2.googlesyndication.com/pagead/show_ads.js"></script>
<style>
body{
	color: #000;
	background-color:#ffffff;
}
#rightWrap{
	margin-left: 55px;
	margin-top: -110px;
}
#rightWrap .page_top h1{
	min-width: 560px;
}
.search_area{
	min-width: 560px;
    height: 65px;
}
.search_area dl{
	margin-top: -16px;
}
.boardWrap{
	min-width: 560px;
}
</style>
</head>
<body>
<div class="container">
	<div id="rightWrap">
    	<div class="rightBlock">
            <div class="page_top">
                <h1>보낸 쪽지함</h1>
            </div>
            
            <!-- 검색 시작 -->
            <form id="frmSearch" method="get" name="frmSearch" action="#" title="검색" class="search_area">
                <input type="hidden" name="mapId" value=""/>
                <input type="hidden" id="page" name="page" value=""/>
                <dl>
                    <dt>검 색</dt>
                    <dd>
                        <select id="searchType" name="searchType" title="선택" style="height:35px">
                            <option value="">::검색조건::</option>
                            <option value="T">제목</option>
                            <option value="C">내용</option>
                            <option value="TC">제목 + 내용</option>
                            <option value="U">작성자</option>
                        </select>
                    </dd>
                    <dd>
                        <input type="text" id="searchText" name="searchText" placeholder="검색어 입력" style="height:32px;width:200px" value="${search.searchText}"/>
                    </dd>
                    <dd>
                    	<div class="btnSet">
                        <a href="javascript:goPage('1');" class="disPb btnBase">검색</a>
                        </div>
                    </dd>
                </dl>            
            </form>
            <!-- 검색 끝 -->
            
            <div class="boardWrap">
                <table class="base_tbl">
                    <thead>
                        <tr>
                            <th width="8%">받는사람</th>
                            <th width="15%">내용</th>
                            <th width="15%">보낸날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="item">
                    	<tr>
                    		<td>${item.receiveId}</td>
                    		<td><a href="#" >${item.title}</a></td>
                    		<td><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm"/></td>
                    	</tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
	
   
</div>
</body>
</html>