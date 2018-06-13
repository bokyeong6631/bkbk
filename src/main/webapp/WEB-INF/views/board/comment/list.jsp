<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		
	<dl>
		<dd>
			<input type="text" id="comments" name="replyName"
				placeholder="댓글을 남겨주세요" title="replyName" style="width: 85%;display: inline-block;" /> <a
				href="javascript:;" id="btnComment" class="disPB btnBase">댓글등록</a>
		</dd>
	</dl>
	
	<table class="replyList" id="replyList">
		<c:forEach items="${list}" var="item">
			<tr>
				<th class="name" >${item.userName}</th>
				<td class="cont" >${item.comments}
				<a href="javascript:;" onclick="deleteComment(${item.commentId})" class="disPB btnS" id="deleteComment">삭제</a></td>
				<td class="date"><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
		</c:forEach>
	
	</table>
