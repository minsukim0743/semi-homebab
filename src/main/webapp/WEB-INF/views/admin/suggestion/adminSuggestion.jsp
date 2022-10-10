<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/admin/common.css">
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminFree.css">
</head>
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
	
<body>
 
	<jsp:include page="../main/adminMain.jsp" />

	<div class="centertable">
		<div class="freeBoardHeader">
			<a>건의사항(관리자용)</a>
		</div>
		<table class="usertable">
			<colgroup>
				<col width="5%">
				<col width="20%">
				<col width="35%">
				<col width="20%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>사용자</th>
					<th>답변여부</th>
					<th>등록일</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${ requestScope.suggestList }">
					<tr>
						<td><c:out value="${ list.sgtIdx }" /></td>
						<td><a href=""><c:out value="${ list.title }" /></a></td>
						<td><c:out value="${ list.content }" /></td>
						<td><c:out value="${ list.amDTO.nickName }" /></td>
						<td><c:out value="${ list.answerYn }" /></td>
						<td><c:out value="${ list.regDate }" /></td>
						
					</tr>
				</c:forEach>
			
			</tbody>
		</table>

		<div class="alluserlistfooter">
			<jsp:include page="../paging/memberPaging.jsp" />
		</div>

	<script>
		if (document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for (let i = 0; i < $tds.length; i++) {

				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/adminSuggestion/datil?sgtIdx=" + no;
				}

			}

		}
	</script>
	</div>
</body>
</html>