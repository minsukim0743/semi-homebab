<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminRecipeList</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminMemberList.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/common.css">
</head>
<body>
	<jsp:include page="../main/adminMain.jsp"/>
	
	<div class="centertable">
		<form id="recipeListForm" action="${ pageContext.servletContext.contextPath }/adminRecipe/list" method="get">
            <div class="alluserlistheader">
                <a>레시피리스트</a>
               	<select class="searchCondition" name="searchCondition">
               		<option value="userId" ${ requestScope.selectCriteria.searchCondition eq "userId"? "selected" : "" }>ID</option>
               		<option value="nickName" ${ requestScope.selectCrieteria.searchCondition eq "nickName"? "selected" : "" }>닉네임</option>
               	</select> 
               	<input type="text" class="text" name="searchValue">
               	<input type="submit" class="find" value="검색">
            </div>
   		</form>
            <table class="usertable">
                <tr height=41px>
                	<th>레시피번호</th>
                	<th>ID</th>
                	<th>닉네임</th>
                	<th>제목</th>
                	<th>등록일</th>
                	<th>승인여부</th>
                	<th>상태여부</th>
                	<th colspan=3>승인/반려</th>
                	<th width="10"></th>
                </tr>	
      
            <c:forEach var="recipe" items="${ requestScope.adminRecipeList }">
            	<tr height=41px>
                	<td><c:out value="${ recipe.rcpIdx }"/></td>
                	<td><c:out value="${ recipe.amDTO.userId }"/></td>
                	<td><c:out value="${ recipe.amDTO.nickName }"/></td>
                	<td><c:out value="${ recipe.title }"/></td>
                	<td><c:out value="${ recipe.regDate }"/></td>
                	<td><c:out value="${ recipe.aprState }"/></td>
                	<td><c:out value="${ recipe.stateYn }"/></td>
                	<th width="50">
                	<form id="recipeUpdateForm" action="${ pageContext.servletContext.contextPath }/adminRecipe/update/stateNy" method="get">
                		<c:if test="${ recipe.stateYn eq 'Y' || recipe.aprState eq '반려' }">
                			<button type="submit" name="approval" class="stateNy" value="${ recipe.rcpIdx }" disabled>승인</button>
                		</c:if>
                		<c:if test="${ recipe.stateYn eq 'N' && recipe.aprState eq '요청' }">
                			<button type="submit" name="approval" class="stateNy" value="${ recipe.rcpIdx }">승인</button>
                			<input type="hidden" name="currentPage" value="${ requestScope.currentPage }">
                		</c:if>
                		</form>
                	</th>
                	<th width="50">
                	<form id="recipeUpdateForm2" action="${ pageContext.servletContext.contextPath }/adminRecipe/update/stateYn" method="get">
	                	<c:if test = "${ recipe.aprState eq '반려' || recipe.aprState eq '승인' }">
	                		<button type="submit" name="approval" class="stateYn" value="${ recipe.rcpIdx }" disabled>반려</button>
	                	</c:if>
	                	<c:if test = "${ recipe.aprState eq '요청'}">
	                		<button type="submit" name="approval" class="stateYn" value="${ recipe.rcpIdx }">반려</button>
	                		<input type="hidden" name="currentPage" value="${ requestScope.currentPage }">
	                	</c:if>
                	</form>
                	</th>
                	<th width="50">
                	<form id="recipeUpdateForm2" action="${ pageContext.servletContext.contextPath }/adminRecipe/delete" method="get">
	                	<c:if test = "${ recipe.aprState eq '요청' || recipe.aprState eq '반려' }">
	                		<button type="submit" name="delete" class="delete" value="${ recipe.rcpIdx }" disabled>삭제</button>
	                	</c:if>
	                	<c:if test = "${ recipe.aprState eq '승인' }">
	                		<button type="submit" name="delete" class="delete" value="${ recipe.rcpIdx }">삭제</button>
	                		<input type="hidden" name="currentPage" value="${ requestScope.currentPage }">
	                	</c:if>
                	</form>
                	</th>
                	<th></th>
   	            </tr>
            </c:forEach>
            </table>
            <div class="alluserlistfooter">
				<jsp:include page="../paging/recipeListPaging.jsp"/> 
           	</div>
        </div>
        <script>
		
		if(document.getElementsByTagName("td")) {
			
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "#f4f4f2";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.backgroundColor = "white";
				}
				
				function buttonAction(number) {
					
				}
				
				$tds[i].onclick = function() {
					const number = this.parentNode.children[0].innerText;
					var newWindow = window.open("about:blank");
					newWindow.location.href = "${ pageContext.servletContext.contextPath }/adminRecipe/detailAll?rcpIdx="+number;
				}
				
			}
			
		}
		
	</script>
</body>
</html>