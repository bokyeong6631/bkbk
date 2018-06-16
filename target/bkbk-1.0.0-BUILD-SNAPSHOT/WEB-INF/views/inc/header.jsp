<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

  <script>

  </script>

<div id="header">
    	<ul>
        	<li><a href="${_ctx}/board/doc/all.java6" >전체게시판</a></li>
            <li><a href="${_ctx}/board/doc/user.java6?userId=${userDTO.userId}">내가 쓴 게시물</a></li>
            <li><a href="${_ctx}/board/comment/user.java6?userId=${userDTO.userId}">내가 남긴 댓글</a></li>
            <li><a href="${_ctx}/board/doc/like/list.java6?userId=${userDTO.userId}">내가 좋아요 한 글</a></li>
            <li><a href="${_ctx}/websocket.java6">채팅창</a></li>
            <li><a href="${_ctx}/attendance/check.java6">출석 체크</a></li>
            <li><a href="${_ctx}/navermap/map.java6">찾아오는 길</a></li>
            <li><a href="${_ctx}/main/bus.java6">버스정보</a></li>


       </ul>
</div>

