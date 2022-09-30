<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<div id="visual">
		<section class="main">
			<div class="board">
				<h3 style="text-align: center; margin-top: 50px; font-size: 20px">건의사항</h3>
				<br><br>
				<table align="center" class="table table-hover " style="width: 1000px;margin:auto;">
					<tr style="background: rgba(168, 168, 168, 0.103);">
						<td width="100px" align="center">번호</td>
						<td width="400px" align="center">제목</td>
						<td width="50px" align="center">글쓴이</td>
						<td width="100px" align="center">작성일</td>
					</tr>

					<c:forEach items="${ suggestionList }" var="sugg">
						<tr style="height: 60px">
							<td align="center" style="vertical-align : middle;"><c:out value="${ sugg.sgtIdx }" /></td>
							<td align="center"  style="vertical-align : middle;"><c:out value="${ sugg.title }" /></td>
							<td align="center"  style="vertical-align : middle;"><c:out value="${ sugg.name }" /></td>
							<td align="center"  style="vertical-align : middle;"><c:out value="${ sugg.regDate }" /></td>
						</tr>
					</c:forEach>
				</table>
				<br><br>
				<jsp:include
					page="/WEB-INF/views/users/suggestion/suggestionPasing.jsp" />
				<br>
				<!-- 검색 폼 -->
				<div class="search-area" align="center" style="width: 100%">
					<form id="loginForm" action="${ pageContext.servletContext.contextPath }/suggestion/users/list" method="get" style="display: inline-flex; margin:4px;">
						<input type="hidden" name="currentPage" value="1"> 
							<select id="searchCondition" name="searchCondition" class="form-control" style="width: 80px; margin-right: 10px">
							<option value="title" ${ requestScope.selectCriteria.searchCondition eq "title"? "selected": "" }>제목</option>
							<option value="content" ${ requestScope.selectCriteria.searchCondition eq "content"? "selected": "" }>내용</option>
							
							</select> 
							<input type="search" style="margin-right: 10px" class="form-control" id="searchValue" name="searchValue" value="<c:out value='${ requestScope.selectCriteria.searchValue }'/>">
							<button type="submit" class="btn btn-default">검색하기</button>
					</form>
				</div>
			</div>
			<c:if test="${ !empty sessionScope.loginUser.memberIdx }">
				<a href="${ pageContext.servletContext.contextPath }/suggestion/users/insert">
					<button type="button" value="등록" style="position: relative; left: 1250px; width: 80px; height: 35px;" class="btn btn-default">등록</button>
				</a> 
			</c:if>
		</section>
	</div>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script>
		if (document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for (let i = 0; i < $tds.length; i++) {

				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/suggestion/users/detail?sgtIdx=" + no;
				}

			}

		}
	</script>


</body>
</html>