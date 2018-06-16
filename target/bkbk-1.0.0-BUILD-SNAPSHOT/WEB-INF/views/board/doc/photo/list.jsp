<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />
<style>
.photoSize{
	width:270px;
	height:300px;
	display: inline-block;
}
.tr td a{
     color: #222;
     font-size: 20px;
     font-weight: 700;
     text-decoration: none;
 }
</style>

</head>

<body>
<script>
$(function() {
	//검색조건유지
	$("#searchType > option[value='${search.searchType}']").attr("selected",true);
	
	//글쓰기 버튼
	$("#btnWrite").click(function() {
		document.location.href="${_ctx}/board/doc/photo/write.java6?mapId=${boardMapDTO.mapId}";
	});
});
	//페이지 이동
	function goPage(page) {
		$("#page").val(page);
		$("#frmSearch").submit();
	}
	//조회페이지 이동
	function goView(docId) {
		$("#docId").val(docId);
		$("#frmView").submit();
	}
</script>
	<div id="rightWrap">
    	<div class="rightBlock">
            <div class="page_top">
                <h1>${boardMapDTO.mapName}</h1>
            </div>
            
            <!-- 검색 시작 -->
            <form id="frmSearch" method="get" name="frmSearch" action="${_ctx}/board/doc/photo/list.java6" title="검색" class="search_area">
                <input type="hidden" name="mapId" value="${boardMapDTO.mapId}"/>
                <input type="hidden" id="page" name="page" value="${search.page}"/>
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
	                <div>
                    <c:forEach items="${list}" var="item">
	                	<table class="photoSize" class="base_tbl">
                    	<tr>
                    		<td class="txtCut alignLeft">
                    		${item.docId}<br/>
                    		<a href="javascript:goView('${item.docId}');">
                    		<c:forEach items="${item.fileList}" var="file">
                    			<img style="width:200px;height:200px" src="${_ctx}/${file.filePath}/${file.newFileName}"></img>
                   			</c:forEach> 
                   			</a>
                    		<br/><a href="javascript:goView('${item.docId}');">${item.title}</a>
                    		<br/>작성자 : ${item.userName}
                    		<br/>조회수 : <fmt:formatNumber value="${item.cntRead}"/>
                    		<br/><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm"/>
                    		</td>
                    	</tr>
                    	</table>
                    </c:forEach>
                 	</div>
                <div class="btnSet">
                	 <a href="javascript:;" id="btnWrite" class="disPb btnBase">글쓰기</a>
                </div>
                <pagetag:paging page="${search}"/>
            </div>
        </div>
    </div>
    <form id="frmView" name="frmView" action="${_ctx}/board/doc/photo/view.java6" method="get">
	    <input type="hidden" id="docId" name="docId"/>
	    <input type="hidden" name="mapId" value="${boardMapDTO.mapId}"/>
	    <input type="hidden" id="page" name="page" value="${search.page}"/>
	    <input type="hidden" id="searchType" name="searchType" value="${search.searchType}"/>
	    <input type="hidden" id="searchText" name="searchText" value="${search.searchText}"/>
    </form>
</body>
</html>
