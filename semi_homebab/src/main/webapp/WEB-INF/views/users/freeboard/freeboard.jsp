<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<div id="visual">
		<section class="main">
		<h3 style="text-align: center; margin-top: 50px; font-size: 20px">자유 게시판</h3>
		<br>
			<h4 class="d-none"></h4>
			<div class="board">
				<table class="table table-hover"  style="width: 1000px;margin:auto;">
					<tr style="background: rgba(168, 168, 168, 0.103);">
						<td width="100px" align="center">번호</td>
						<td width="400px" align="center">제목</td>
						<td width="50px" align="center">글쓴이</td>
						<td width="100px" align="center">작성일</td>
					</tr>
					<c:forEach items="${ freeboardlist }" var="freelist">
						<tr style="height: 60px">
							<td align="center"  style="vertical-align : middle;"><c:out value="${ freelist.fbIdx }" /></td>
							<td align="center"  style="vertical-align : middle;"><c:out value="${ freelist.title }" /></td>
							<td align="center"  style="vertical-align : middle;"><c:out value="${ freelist.name }" /></td>
							<td align="center"  style="vertical-align : middle;"><c:out value="${ freelist.regDate }" /></td>
						</tr>
					</c:forEach>
				</table>
				<br><br>
				<!-- 페이징 처리 -->
				<jsp:include page="/WEB-INF/views/common/pasing.jsp" />
				<br>
				<!-- 검색 폼 -->
				<div class="search-area" align="center" style="width: 100%">
					<form id="loginForm" action="${ pageContext.servletContext.contextPath }/freeboard/users/list" method="get" style="display: inline-flex">
						<input type="hidden" name="currentPage" value="1"> 
						<select id="searchCondition" name="searchCondition" class="form-control"  style="width: 80px; margin-right: 10px">
							<option value="title" ${ requestScope.selectCriteria.searchCondition eq "title"? "selected": "" }>제목</option>
							<option value="content" ${ requestScope.selectCriteria.searchCondition eq "content"? "selected": "" }>내용</option>
<%-- 						<option value="name" ${ requestScope.selectCriteria.searchCondition eq "name"? "selected": "" }>작성자</option> --%>
						</select> 
						<input type="search" id="searchValue" class="form-control" name="searchValue" value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">
						<button type="submit" class="btn btn-default">검색하기</button>
					</form>
				</div>
			</div>



			<c:if test="${ !empty sessionScope.loginUser.memberIdx }">
				<a href="${ pageContext.servletContext.contextPath }/freeboard/users/insert">
				<button type="button" value="등록" style="position: relative; top: -35px; left: 1300px; width: 60px; height: 30px;"> 등록</button>
				</a>
			</c:if>

			
		</section>
	</div>
	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/freeboard/users/detail?fbIdx=" + no;

				}
			}
			
		}
	</script> 
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>