<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


</head>
<body>
<c:import url="/WEB-INF/views/inc/head.jsp" />
<c:import url="/WEB-INF/views/inc/header.jsp" />
<c:import url="/WEB-INF/views/inc/left.jsp" />
<script type="text/javascript" src="${_ctx}/res/editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script>
var oEditors = [];
	$(document).ready(function() {
		//저장 클릭시
		$("#btnSaveDoc").click(function() {
			//기존에 있던 파일 체크시 삭제
			$("#deleteFileEdit").each(function(){
				var tf = $("#deleteFileEdit").is(":checked");
				var fileSno = $("#fileSno").val();
				var param = {
						docId : "${view.docId}"
						,fileSno : fileSno
				};
				if(tf==true){
					$.post("${_ctx}/file/remove.java6",param,function(data){
					});
				}
			});
			if($("#frmWrite").valid()){
				oEditors.getById["boardContents"].exec("UPDATE_CONTENTS_FIELD", []);
				// 에디터의 내용에 대한 값 검증은 이곳에서
			    // document.getElementById("ir1").value를 이용해서 처리한다.
				var contents =  document.getElementById("boardContents").value;
				if(contents != "<p><br></p>"){
				$("#frmWrite").submit();
				}else{
					alert("내용을 입력해주세요");
				}
			}
		});
		nhn.husky.EZCreator.createInIFrame({
		    oAppRef: oEditors,
		    elPlaceHolder: "boardContents",
		    sSkinURI: "${_ctx}/res/editor/SmartEditor2Skin.html",
		    fCreator: "createSEditor2"
		});
	});
	//첨부파일 추가
	function addFile(){
		var appendingFileHtml = "<input type='file' name='files' style='width: 90%'/>";
		var removeFileHtml = "<img src='${_ctx}/res/images/delete.png' style='width: 30px' title='삭제'/>";
		var filelength = $("#tdFile>input[type=file]").length;
		if(filelength<5){
			$("#tdFile").append(appendingFileHtml,removeFileHtml);
		}else{
			alert("5개까지만 첨부할 수 있습니다.");
		}
		//첨부파일 삭제
		$("#tdFile>img").on("click",function(){
			$(this).prev().remove();
			$(this).remove();
		});
	}
</script>

<div id="rightWrap">

	<div class="rightBlock">
		<div class="page_top">
			<h1>${boardMapDTO.mapName}</h1>
		</div>


		<div class="boardWrap">
			<form id="frmWrite" name="frmWrite"  action="${_ctx}/board/doc/edit.java6" method="post">
			<input type="hidden" name="mapId" value="${search.mapId}"/>
			<input type="hidden" name="docId" value="${search.docId}"/>
			<input type="hidden" name="searchType" value="${search.searchType}"/>
			<input type="hidden" name="searchText" value="${search.searchText}"/>
			<input type="hidden" name="params" value="${search.page}"/>
			<table class="base_tbl tbl_write">
				<tbody>
						<tr>
							<th width="20%" class="t_color" id="writeTitle">제목입력</th>
							<td><input type="text" name="title" placeholder="제목입력"
								value="${view.title}" required="required" /></td>
						</tr>
						<tr>
							<th class="t_color">내용입력</th>
							<td><textarea name="boardContents" id="boardContents" required>${view.boardContents}</textarea></td>
						</tr>
						<tr>
							<th class="t_color">비밀글 설정</th>
							<td>
							<c:set var="lock" value="${view.lockYn}" />
							<c:choose>
							    <c:when test="${lock eq 'Y'}">
							    	<input type="checkbox" id="lockCheck" name="lockYn" value="Y" style="width:20px;" checked="checked">비밀글</input>
							    	<input type="text" name="lockPw" id="textLockPw" placeholder="비밀번호4자리" value="${view.lockPw}" maxlength="4" style="width:80%"></input>
							    </c:when>
							    <c:otherwise>
							    	<input type="checkbox" id="lockCheck" name="lockYn" value="Y" style="width:20px;">비밀글</input>
									<input type="text" name="lockPw" id="textLockPw" placeholder="비밀번호4자리" maxlength="4" style="width:80%"></input>
							    </c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<th class="t_color">첨부파일 삭제</th>
							<td>
							<c:forEach items="${list}" var="file">
								<input type="checkbox" id="deleteFileEdit" value="N" style="width:30px"/><a>${file.orgFileName}</a>
								<input type="hidden" id="fileSno" value="${file.fileSno}"/>
							</c:forEach>
							</td>
						</tr>
						<tr>
							<th class="t_color">첨부파일 <a href="javascript:addFile();"
								style="width: 23%" id="addBtn" class="disPB btnBase">추가</a>

							</th>
							<td id="tdFile"></td>
						</tr>
				</tbody>
			</table>
			</form>
			
			<div class="btnSet alignCenter">
				<a href="javascript:;" class="disPB btnBase" name="btnSaveDoc" id="btnSaveDoc">저장</a> 
				<a href="javascript:history.back();" class="disPB btnBase">이전</a>
				<a href="${_ctx}/board/doc/list.java6?${search.params}&docId=${view.docId}" class="disPB btnBase">취소</a>
			</div>
		</div>
	</div>
	</div>
	</body>
</html>