<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<script type="text/javascript">
$(function() {
	loadTreeMap();
	
	$("#openMessage").click(function(){
		window.open("${_ctx}/message/receivelist.java6","messageWindow","scrollbars=yes,toolbar=yes,resizable=yes,width=850,height=500,left=50,top=50");
	});
});

//통합맵 가져오기
function loadTreeMap() {
	d = new dTree('d');
	var url = "${_ctx}/board/map/list.java6";
	$.get(url, function(json) {
		if($.isArray(json)){
			$(json).each(function(index) {
				if(this.parMapId == null){
	 			 	d.add(this.mapId, -1, this.mapName);
				}else if((this.mapId == 7)||(this.parMapId == 7)){
					d.add(this.mapId, this.parMapId, this.mapName, "${_ctx}/board/doc/photo/list.java6?mapId="+this.mapId);
				}else if(this.mapId == 20){
					d.add(this.mapId, 1, this.mapName, "${_ctx}/board/popup/list.java6?mapId="+this.mapId);
				}else{
				 	d.add(this.mapId, this.parMapId, this.mapName, "${_ctx}/board/doc/list.java6?mapId="+this.mapId);
				}
			});
		$("#dtree").html(d.toString());
		}
	});
}
</script>


<div id="leftWrap">
	<div id="infoWrap">
		<div class="info_txt">
			<p class="info_name">${_user.name}</p>
			<p class="info_pic">
				<img src="${_ctx}/res/images/qqq.png" alt="qqq">
			</p>
			<p class="info_date"><br/>
				<a href="javascript:;" id="openMessage"><img src="${_ctx}/res/images/message2.png" style="width:30px;float:right;"/></a>
			</p>
		</div>
		<span>
			<a href="${_ctx}/edit.java6" style="width:48.5%;display:inline-block">정보수정</a>
			<a href="${_ctx}/logout.java6" style="width:48.5%;display:inline-block">Logout</a><br>
		</span><br>
		<span>
			<a href="#">내정보</a>
		</span>
	</div>

	<div id="category">
		<!-- dtree 시작 -->
		<div class="dtree" id="dtree"></div>
		<!-- dtree 끝 -->
	</div>

</div>
