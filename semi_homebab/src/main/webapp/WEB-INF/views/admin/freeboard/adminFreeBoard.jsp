<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>

	<jsp:include page="../main/adminMain.jsp" />

	<div class="centertable">
		<div class="freeBoardHeader">
			<a>자유게시판(관리자용)</a>
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
					<th>등록일</th>
					<th>사용자</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${ requestScope.boardList }">
					<tr>
						<td><c:out value="${ list.pbIdx }"/></td>
						<td><a href=""><c:out value="${ list.title}"/></a></td>
						<td><c:out value="${ list.content }"/></td>
						<td><c:out value="${ list.regDate }"/></td>
						<td><c:out value="${ list.umDTO.name }"/></td>
						<td><button onclick="location='${ pageContext.servletContext.contextPath }/delet/admin/servlet?pbIdx=${ list.pbIdx }'">삭제</button></td>
					</tr>	
				</c:forEach>
		
			</tbody>
		</table>

		<div class="alluserlistfooter">
			<jsp:include page="../paging/adminFreeBoardPaging.jsp" />
		</div>
	
	</div>

	
</body>
</html>