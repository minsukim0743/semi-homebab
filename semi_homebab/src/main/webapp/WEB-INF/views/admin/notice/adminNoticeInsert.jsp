<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if(request.getAttribute("param") != null && request.getAttribute("param") == "Y") {
		request.setAttribute("param", null);
		response.sendRedirect("/homebab/adminNotice/select");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>공지사항작성</title>
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminNoticeInsert.css">
<script>
	
	$(document).ready(function(){
		listener();
		
	});
	
	function listener(){
		$('#submit').click(function(){
			$('#ucontent').val($('#ucontent').val().replaceAll('\n','<br>'));
			$('#ifrom').submit();
		});
	}
</script>

</head>
<body>
	<jsp:include page="../main/adminMain.jsp" />
	<div id="board_write">
		<h3>공지사항작성</h3>
		<div id="write_area">
			<form id="ifrom" action="${ pageContext.servletContext.contextPath }/adminNotice/insert" method="post">
				<div id="in_title">
				    <span class="b_header">제목</span><input name="title" id="utitle">
				</div>
				<div id="in_content">
					<textarea name="content" id="ucontent" placeholder="내용" required></textarea>
				</div>
				<div class="bt_se">
					<button id="submit">글 작성</button>
				</div>
				<input id="param" type="hidden">
			</form>
		</div>
	</div>
</body>
</html>