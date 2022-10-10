<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>공지사항조회</title>
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/admin/notic.css">
<script>
	$(document).ready(function(){
		listener();
	});
	
	function listener() {
		
		$('#notice_write').click(function(){
			location.href = 'insert';
		});
		
		$('tr[no]').click(function(){
			$('[name=ntcIdx]').val($(this).find('.p_idx')[0].innerText);
			$('[name=title]').val($(this).find('.p_title')[0].innerText);
			$('[name=regDate]').val($(this).find('.p_regDate')[0].innerText);
			$('[name=content]').val($(this).find('input[name=contentq]')[0].value);
			$('#view').submit();
		});
		
	}
</script>
</head>
<body>
	<jsp:include page="../main/adminMain.jsp" />

	<div class="centertable">
		<div class="container">
			<section class="notice">
				<div class="pagele">
					<div class="container">
						<h3>공지사항조회</h3>
					</div>
				</div>
				<div id="board-search">
					<div class="container">
						<div class="search-window">
							<form action="${ pageContext.servletContext.contextPath }/adminNotice/select" method="post">
								<div>
								<select name="stype" style="display: inline-block;">
									<!--  <option value="1">번호</option> -->
									<option value="2">제목</option>
									<option value="3">내용</option>
								</select>
								<input id="search" type="search" name="svalue" placeholder="검색어를 입력해주세요.">
								<button type="submit" class="btn btn-dark">검색</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div id="board-list">
					<div class="container">
						<table class="board-table">
							<thead>
								<tr>
									<th scope="col" class="th-num">번호</th>
									<th scope="col" class="th-title">제목</th>
									<th scope="col" class="th-date">등록일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="noticeList" items="${ requestScope.noticeList }">
									<tr no="<c:out value="${ noticeList.ntcIdx }"></c:out>">
										<td class="p_idx"><c:out value="${ noticeList.ntcIdx }"></c:out></td>
										<td class="p_title"><c:out value="${ noticeList.title }"></c:out></td>
										<td class="p_regDate"><c:out value="${ noticeList.regDate }"></c:out></td>
										<input name="contentq" type="hidden" value='<c:out value="${ noticeList.content }"></c:out>'> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="footerbutton">
					<button id="notice_write">등록</button>
					
				</div>
				<form id="view" style="display:none" action="${ pageContext.servletContext.contextPath }/adminNotice/view" method="post">
					<input name="ntcIdx" type="hidden">
					<input name="title" type="hidden">
					<input name="regDate" type="hidden">
					<input name="content" type="hidden">
				</form>
			</section>



		</div>
</body>
</html>