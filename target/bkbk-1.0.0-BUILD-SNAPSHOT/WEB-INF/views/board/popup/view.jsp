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
    div#users-contain { width: 600px; margin: 20px 0; }
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
	   
	   $("#image").on( "click", function() {
	    dialog.dialog( "open" );
	   });
	   
	
});

</script>
 <div id="dialog-form" title="View User">
   <p class="validateTips">팝업관리</p>
  
   <form>
     <fieldset>
       <label for="loginId">image</label>
       <input type="image" name="image" id="image" value="${_ctx}/res/images/qqq.png" />
  
       <!-- Allow form submission with keyboard without duplicating the dialog button -->
       <input type="submit" tabindex="-1" style="position:absolute; top:-1000px"/>
     </fieldset>
   </form>
 </div>
 


<div id="rightWrap">
    
    	<div class="rightBlock">
            <div class="page_top">
                <h1>asasa</h1>
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
                            <td width="20%">작성일</td>
                            <td width="20%" class="t_color"><fmt:formatDate value="${view.regDt}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                            <td width="20%">활성여부</td>
                            <td width="20%" class="t_color"><p>${view.useYn}</p></td>
                        </tr>
						<tr>
							<td width="8%">첨부파일</td>
							<c:forEach items="${fileList}" var="file">
	                            <td class="txtCut alignLeft"><a>${file.orgFileName}</a></td>
	                        </c:forEach>
						</tr>
						<tr>
                            <td colspan="6" class="alignLeft">
                            <c:forEach items="${view.fileList}" var="item">
							<img src="${_ctx}/${item.filePath}/${item.newFileName}.${item.fileExt}"/>
							</c:forEach>
                            </td>
                        </tr>
                    </tbody>
                </table>
                
                <div class="btnSet">
                    <a href="${_ctx}/board/popup/list.java6?mapId=${search.mapId}" class="disPB btnBase">목록</a>
                    <a href="#" class="disPB btnBase">수정</a>
                    <a href="${_ctx}/board/popup/remove.java6?popupId=${popupId}" class="disPB btnBase">삭제</a>
                </div>
                <div class="replyWrap" id="commentWrap">

			
                </div>
            </div>
        </div>
    </div>
</body>
</html>