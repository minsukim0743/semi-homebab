<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/users/recipe/recipeDetail.jsp" />
      <div id="form-commentInfo">
		<div id="comment-count">
			댓글 <span id="count">${ fn:length(requestScope.recipeCommentsList) }</span>개
		</div>
		<form id="commentForm" action="${ pageContext.servletContext.contextPath }/recipeComments/insert" method="get">
			<input type="text" id="comment-input" name="cmtContent" placeholder="댓글을 입력해 주세요.">
		    <input type="submit" id="submit" value="등록"> 
		    <input type="hidden" name="rcpIdx" value="${ recipe.rcpIdx }">
		</form>
		<table class="comments-table" style="width:100%">
			<c:forEach var="comments" items="${ requestScope.recipeCommentsList }">
				<tr>
					<td width=45><img src="/resources/images/common/ico_user.png" width="35px" height="35px"></td>
					<td width=135 class="name-date">
						<p class="name">
							<c:out value="${ comments.umDTO.nickName }" />
						</p>
						<p class="date">
							<fmt:formatDate pattern="yyyy.MM.dd HH:mm"
								value="${ comments.regDate }" />
						</p>
					</td>
					<td class="cmtContent"><c:out value="${ comments.cmtContent }" /></td>
					<td></td>
					<td width=40 class="siren"><c:if test="${ loginUser ne null && loginUser.memberIdx ne comments.memberIdx && comments.cmtReportDTO.stateYn ne 'Y' }">
							<form id="sirenForm" action="${ pageContext.servletContext.contextPath }/recipeComments/insert/siren">
								<button class="siren-button" type="submit">
									<img src="/resources/images/common/siren.png" width="30px" height="30px" id="img-siren">
								</button> 
								<input type="hidden" name="cmtIdx" value="${ comments.cmtIdx }">
								<input type="hidden" name="rcpIdx" value="${ recipe.rcpIdx }">
								<input type="hidden" name="memberIdx" value="${ comments.umDTO.memberIdx }">
							</form>
						</c:if> 
						<c:if test="${ loginUser eq null || loginUser.memberIdx eq comments.memberIdx || comments.cmtReportDTO.stateYn eq 'Y' }">
							<img src="/resources/images/common/nosiren.png" width="30px" height="30px">
						</c:if>
						</td>
					<td width=40 class="delete">
						<c:if test="${ loginUser.memberIdx eq comments.memberIdx }">
								<a href="${ pageContext.servletContext.contextPath }/recipeComments/delete?rcpIdx=${ recipe.rcpIdx }?memberIdx=${ loginUser.memberIdx }?cmtIdx=${ comments.cmtIdx }" >
									<img src="/resources/images/common/delete-button.png" width="20px" height="20px">
								</a>
						</c:if>
						 <c:if test="${ loginUser.memberIdx ne comments.memberIdx }">
							<img src="/resources/images/common/undelete-button.png" width="20px" height="20px">
						</c:if>
					</td>
			</c:forEach>
		</table>

				<script src="index.js"></script>
		</div>
	
		<form action="view" method="get" encType="multipart/form-data">
		</form>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
</body>
</html>