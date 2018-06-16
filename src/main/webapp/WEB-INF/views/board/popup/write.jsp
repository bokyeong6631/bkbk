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
$(document).ready(function(){
	$("#btnSavePop").click(function() {
		
		if ($("#frmWrite").valid()) {
			$("#frmWrite").submit();
		}
	});
});

function addFile() {
	var appendingFileHtml = "<input type='file' name='files' style='width:90%' /><img src=${_ctx}/res/images/delete.png style='width:25px; cursor:pointer;' onclick='delFile(this)'/>";
	var size = $("td#tdFile > input[type=file]").length;
	if (size < 5) {
		$("#tdFile").append(appendingFileHtml);
	} else {
		alert("더 이상 추가할 수 없습니다");
	}

}
function delFile(file) {
	console.log(file);
	$(file).prev().remove();
	$(file).remove();
}
	

</script>

<div id="rightWrap">

<div class="rightBlock">
	<div class="page_top">
		<h1>팝업관리</h1>
	</div>

	<div class="boardWrap">
		<form id="frmWrite" name="frmWrite" action="${_ctx}/board/popup/write.java6" method="post" enctype="multipart/form-data">
			<input type="hidden" name="mapId" value="${search.mapId}"/>
			<input type="hidden" name="popupId" value="${search.popupId}"/>
		<table class="base_tbl tbl_write">
			<tbody>
				<tr>
					<th width="20%" class="t_color" id="writeTitle">제목입력</th>
					<td><input type="text" name="title" placeholder="제목입력" required="required"/>
					</td>
				</tr>
				<tr>
					<th width="8%" class="t_color">활성화여부</th>
					<td>활성화 <input type="radio" name="UseYn" value="Y" style="width:30px"/> 
						비활성화 <input type="radio" name="UseYn" value="N" style="width:30px"/></td>
				</tr>
                <tr>
					<th class="t_color">첨부파일
                        <a href="javascript:addFile()" style="width:23%" id="addBtn" class="disPB btnBase">추가</a>
					</th>
                        <td id="tdFile">
                    </td>
				</tr>
			</tbody>
		</table>
		</form>
		
		<div class="btnSet alignCenter">
			<a href="javascript:;" class="disPB btnBase" name="btnSaveDoc" id="btnSavePop">저장</a> 
			<a href="${_ctx}/board/popup/list.java6?mapId=${search.mapId}" class="disPB btnBase" >취소</a>
		</div>
	</div>
</div>
</div>

</body>
</html>