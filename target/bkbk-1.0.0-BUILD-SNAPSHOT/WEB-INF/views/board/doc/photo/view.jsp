<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />
<link rel="stylesheet" href="${_ctx}/res/js/jqueryui/jquery-ui.min.css"></link>

<style>
  body {
   font-family: Arial, Helvetica, sans-serif;
  }
  
  table {
   font-size: 1em;
  }
  
  .ui-draggable, .ui-droppable {
   background-position: top;
  }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  </style>


</head>

<body>
<script>
var dialog

$(document).ready(function() {
	 dialog = $( "#dialog-form" ).dialog({
	       autoOpen: false,
	       height: 400,
	       width: 350,
	       modal: true,
	       buttons: {
	         "닫기": function() {
	           dialog.dialog( "close" );
	         }
	       },
	       close: function() {
	       }
	     });
	   
	   $("#viewUser").on( "click", function() {
	    dialog.dialog( "open" );
	   });

	//댓글 등록 클릭시
	$("#commentWrap").on("click","#btnComment", function() {
		var comment = $("#comments").val();
		var url = "${_ctx}/board/comment/enroll.java6";
		var param ={
				docId:"${view.docId}"
				,comments:comment
		};
		$.post(url,param,function(data){
			//댓글 목록 가져오기
			listComment();
		});
	});
	//댓글 input에 엔터를 치면 등록
	$("#commentWrap").on("keydown","#comments" ,function(e) {
		if(e.keyCode == 13){
			$("#btnComment").click();
		}
	});
	listComment();
	
	
	
});

	//댓글 삭제
	function deleteComment(commentId){
		var url = "${_ctx}/board/comment/delete.java6";
		$.post(url,{commentId:commentId},function(data){
			alert("댓글이 삭제되었습니다.");
			listComment();
		});
	}



	//댓글 목록 가져오기
	function listComment() {
		var url = "${_ctx}/board/comment/list.java6?docId=${view.docId}";
		$.get(url, function(html) {
			$("#commentWrap").html(html);
		});
	}
	
	
</script>
 <div id="dialog-form" title="View User">
   <p class="validateTips">사용자 조회</p>
  
   <form>
     <fieldset>
       <label for="loginId">loginId</label>
       <input type="text" name="loginId" id="loginId" value="${userDTO.loginId}" class="text ui-widget-content ui-corner-all"/>
       <label for="name">Name</label>
       <input type="text" name="name" id="name" value="${view.userName}" class="text ui-widget-content ui-corner-all"/>
       <label for="email">Email</label>
       <input type="text" name="email" id="email" value="${userDTO.email}" class="text ui-widget-content ui-corner-all"/>
       <label for="loginId">phone</label>
       <input type="text" name="phone" id="phone" value="${userDTO.phone}" class="text ui-widget-content ui-corner-all"/>
  
       <!-- Allow form submission with keyboard without duplicating the dialog button -->
       <input type="submit" tabindex="-1" style="position:absolute; top:-1000px"/>
     </fieldset>
   </form>
 </div>

<div id="rightWrap">
    
    	<div class="rightBlock">
            <div class="page_top">
                <h1>${boardMapDTO.mapName}</h1>
            </div>
            
            <div class="boardWrap">
                
                <table class="base_tbl">
                    <thead>
                        <tr>
                            <th colspan="8" class="t_color">${view.title}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td width="8%">작성자</td>
                            <td class="txtCut alignLeft" id="viewUser" style="cursor: pointer">${view.userName}</td>
                            <td width="10%">작성일</td>
                            <td width="20%" class="t_color"><fmt:formatDate value="${view.regDt}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                            <td width="10%">조회수</td>
                            <td width="20%" class="t_color">${view.cntRead}</td>
                        </tr>
						<tr>
							<td width="8%">첨부파일</td>
							<c:forEach items="${list}" var="file">
	                            <td class="txtCut alignLeft"><a href="${_ctx}/file/downloadFile.java6?docId=${file.docId}&fileSno=${file.fileSno}">${file.orgFileName}</a></td>
	                        </c:forEach>
						</tr>
						<tr>
                            <td colspan="6" class="txtCut alignLeft">
                            ${view.boardContents}
                            <c:forEach items="${list}" var="file">
                            <img src="${_ctx}/${file.filePath}/${file.newFileName}" />
                            </c:forEach>
                            </td>
                        </tr>
                    </tbody>
                </table>
                
                <div class="btnSet">
                    <a href="${_ctx}/board/doc/photo/list.java6?mapId=${view.mapId}" class="disPB btnBase">목록</a>
                    <c:if test="${userDTO.name eq view.userName}">
	                    <a href="${_ctx}/board/doc/photo/edit.java6?${search.params}&docId=${view.docId}" class="disPB btnBase">수정</a>
	                    <a href="${_ctx}/board/doc/photo/remove.java6?${search.params}&docId=${view.docId}" 
	                    class="disPB btnBase">삭제</a>
                    </c:if>
                </div>
                <div class="replyWrap" id="commentWrap">

			
                </div>
            </div>
        </div>
    </div>
</body>
</html>