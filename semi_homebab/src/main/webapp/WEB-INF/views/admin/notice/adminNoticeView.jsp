<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if(request.getAttribute("param") != null && request.getAttribute("param") == "Y") {
		request.setAttribute("param", null);
		response.sendRedirect("/homebab/adminNotice/select");
	}

	String ntcIdx = request.getParameter("ntcIdx") == null ? "" : request.getParameter("ntcIdx").toString();
	String title = request.getParameter("title") == null ? "" : request.getParameter("title").toString();
	String regDate = request.getParameter("regDate") == null ? "" : request.getParameter("regDate").toString();
	String content = request.getParameter("content") == null ? "" : request.getParameter("content").toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>세부조회</title>
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminNoticeInsert.css">
<script>
	
	$(document).ready(function(){
		listener();
		
	});
	
	function listener(){
		$('#list').click(function(){
			$('#dBool').val("");
			$('#form1').submit();
		});
		
		$('#del').click(function(){
			$('#dBool').val("Y");
			$('#form1').submit();
		});
	}
</script>

</head>
<body>
	<jsp:include page="../main/adminMain.jsp" />
	<div id="board_write">
		<h3>상세조회</h3>
		<div id="write_area">
			<form id="ifrom" action="" method="post">
				<div id="in_title">
				    <span class="b_header">제목</span><input name="title" id="utitle" value="<%=title %>" readonly>
				</div>
				<div id="in_content">
					<div name="content" id="ucontent"><%=content %></div>
				</div>
				
				<input id="param" type="hidden">
			</form>
			<form id="form1" action="${ pageContext.servletContext.contextPath }/adminNotice/select" method="post">
					<input id="dBool" name="dBool" type="hidden" value="">
					<input name="dNum" type="hidden" value="<%=ntcIdx %>">
					<button id="list">목록</button>
					<button id="del">삭제</button>
				</form>
		</div>
	</div>
	
</body>
</html>