<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="pagetag" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />
</head>
<body>
<script>
function goView(popupId){
	$("#popupId").val(popupId);
	$("#frmView").submit();
}
</script>
<div id="rightWrap">
   	<div class="rightBlock">
        <div class="page_top">
            <h1>팝업관리</h1>
        </div>
        
        <div class="boardWrap">
            <table class="base_tbl">
                <thead>
                    <tr>
                        <th width="8%">순번</th>
                        <th width="30%">제목</th>
                        <th width="15%">활성여부</th>
                        <th width="20%">작성일</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="item">
                	<tr>
                		<td>${item.popupId}</td>	
                		<td class="txtCut alignLeft">
                 			<a href="javascript:goView('${item.popupId}');">${item.title} </a>
                		</td>
                		<td>${item.useYn}</td>	
<!--                 		<td> -->
<%-- 	                 		<c:forEach var="file" items="${item.fileList}"> --%>
<%-- 	      			        <a href="${_ctx}/board/popup/downloadfile.java6?popupId=${file.popupId}"> --%>
<%-- 	             			<img src="${_ctx}/res/images/file.png"style="width:25px"></a>        --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
                		<td><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm"/></td>
                	</tr>
                </c:forEach>
             	
                </tbody>
               </table>
               <div class="btnSet">
               	 <a href="${_ctx}/board/popup/write.java6?mapId=${search.mapId}" id="btnWrite" class="disPb btnBase">글쓰기</a>
               </div>
           </div>
       </div>
   </div>
<form action="${_ctx}/board/popup/view.java6" id="frmView">
	<input type="hidden" id="popupId" name="popupId"/>
	<input type="hidden" id="mapId" name="mapId" value="${mapId}"/>
</form>
</body>
</html>