<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />

<body>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function() {
	//검색조건유지
	$("#searchType > option[value='${search.searchType}']").attr("selected",true);
	
	//글쓰기 버튼
	$("#btnWrite").click(function() {
		document.location.href="${_ctx}/board/doc/write.java6?mapId=${boardMapDTO.mapId}";
	});
	
	$( "#tabs" ).tabs({
      beforeLoad: function( event, ui ) {
        ui.jqXHR.fail(function(html) {
          ui.panel.html(html);
        });
      }
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
	//잠금팝업으로 이동
	function goLock(docId){
		$.get("${_ctx}/board/doc/lock.java6?docId="+docId,function(html){
			$("#secretPwPopup").html(html);
		});
	}
</script>


	<div id="rightWrap">
    	<div class="rightBlock">
            <div class="page_top">
                <h1>내가 좋아요 한 글</h1>
            </div>
            <div id="secretPwPopup"></div>
            
            <div id="tabs">
			  <ul>
			    <li><a href="#tabs-1">좋아유</a></li>
			    <li><a href="${_ctx}/board/doc/like/dislike.java6?userId=${userDTO.userId}">싫어유</a></li>
			  </ul>
			  <div id="tabs-1">
            <div class="boardWrap">
                <table class="base_tbl">
                    <thead>
                        <tr>
                        	<th width="12%">맵네임</th>
                            <th>제목</th>
                            <th width="15%">첨부파일</th>
                            <th width="15%">작성자</th>
                            <th width="10%">작성일</th>
                            <th width="10%">조회</th>
                            <th width="10%">좋아요</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="item">
                    <c:if test="${item.likeYn=='Y'}">
                    	<tr>
                    		<td>${item.mapName}</td>
                    		<td class="txtCut alignLeft">
                    		<c:set var="lock" value="${item.lockYn}" />
								<c:choose>
								    <c:when test="${lock eq 'Y'}">
									    <a href="javascript:goLock('${item.docId}');">${item.title} 
			                    		<c:if test="${item.cntComment>0}">
			                    			[${item.cntComment}]
			                    		</c:if>
			                    		</a>
								    </c:when>
								    <c:otherwise>
								        <a href="javascript:goView('${item.docId}');">${item.title} 
			                    		<c:if test="${item.cntComment>0}">
			                    			[${item.cntComment}]
			                    		</c:if>
			                    		</a>
								    </c:otherwise>
								</c:choose>
								
		                    	<c:if test="${item.lockYn=='Y'}">
		                    		<img style="width:22px" src="${_ctx}/res/images/lock.png"/>
		                    	</c:if>
                    		</td>
                    		<td>
	                    		<c:forEach var="file" items="${item.fileList}">
		        			        <a href="${_ctx}/file/downloadFile.java6?docId=${file.docId}&fileSno=${file.fileSno} ">
		               				<img src="${_ctx}/res/images/file.png"style="width:25px"></img></a>       
								</c:forEach>
							</td>
                    		<td>${item.userName}</td>
                    		<td><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm"/></td>
                    		<td><fmt:formatNumber value="${item.cntRead}"/></td>
                    		<td><img src="${_ctx}/res/images/heart.png" style="width:20px"/>${item.cntLikeY}<br/>
                    			<img src="${_ctx}/res/images/brokenheart.png" style="width:20px"/>${item.cntLikeN}
                    		</td>
                    	</tr>
                    	</c:if>
                    </c:forEach>
                 	
                    </tbody>
                </table>
                <div class="btnSet">
                	 <a href="javascript:;" id="btnWrite" class="disPb btnBase">글쓰기</a>
                </div>
                <pagetag:paging page="${search}"/>
            </div>
        	</div>
        </div>
    </div>
    </div>
    <form id="frmView" name="frmView" action="${_ctx}/board/doc/view.java6" method="get">
	    <input type="hidden" id="docId" name="docId"/>
	    <input type="hidden" name="mapId" value="${boardMapDTO.mapId}"/>
	    <input type="hidden" id="page" name="page" value="${search.page}"/>
	    <input type="hidden" id="searchType" name="searchType" value="${search.searchType}"/>
	    <input type="hidden" id="searchText" name="searchText" value="${search.searchText}"/>
    </form>
    
</body>
</html>
