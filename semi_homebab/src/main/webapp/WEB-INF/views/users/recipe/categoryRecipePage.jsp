<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="/resources/css/users/recipePage.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	 <!-- content Start 레시피 페이지-->
	 <div id="wrap">
        <div id="content">
            <ul>
                <li><button class="all"  onclick="location.href='${ pageContext.servletContext.contextPath }/recipe/page'" id = "recipe">전체보기</button></li>
                <li><button class="cook" value="1" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=일반식'" >일반식</button></li>
                <li><button class="nomal" value="2" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=3분요리'" >3분요리</button></li>
                <li><button class="night" value="3" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=야식'" >야식</button></li>
                <li><button class="diet" value="4" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=다이어트'" id = >다이어트</button></li>
            </ul>
        </div>
        <!-- content End -->
        
        <div id="visual">
			<form action="${ pageContext.servletContext.contextPath }/recipe/search" method="get">
					<select name="type">
						<option value="title">레시피명</option>
						<option value="writer">작성자</option>
						<option value="category">카테고리</option>
					</select>
				<input type="text" class="name" id="searchTitle" name="keyword" placeholder="   내용을 입력해주세요.">
				<button type="submit" class="button">검색</button>
		    </form>    
    	</div>
        
        <br><br><br><br>
        
        <div id="container">
        	<div class="thumbnail-area" id="thumbnailArea">
				<c:forEach var="recipe" items="${ requestScope.recipeList }">
					<div class="recipe-list" align="center">
						<div>
							<img src="${ recipe.fileList[0].subPath }" width="270px" height="230px" onclick="location.href='/recipeComments/view?rcpIdx=${ recipe.rcpIdx }'">
						</div>
						<p>
							레시피명&nbsp;&nbsp; :&nbsp;<label><c:out value="${ recipe.title }"/></label><br>
							조회수&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ recipe.viewCnt }"/><br>
							추천수&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ recipe.likeCnt }"/><br>
							등록자&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ recipe.nickName }"/>
						</p>
					</div>
				</c:forEach>
				
				<c:forEach var="categoryRecipeList" items="${ requestScope.categoryRecipeList }">
					<div class="recipe-list" align="center">
					
						<div>
							<img src="${ categoryRecipeList.fileList[0].subPath }" width="270px" height="230px" 
							onclick="location.href='/recipeComments/view?rcpIdx=${ categoryRecipeList.rcpIdx }'">
						</div>
						<p>
							레시피명&nbsp;&nbsp; :&nbsp;<label><c:out value="${ categoryRecipeList.title }"/></label><br>
							조회수&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ categoryRecipeList.viewCnt }"/><br>
							추천수&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ categoryRecipeList.likeCnt }"/><br>
							등록자&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ categoryRecipeList.nickName }"/>
						</p>	
					</div>
				</c:forEach>
			</div>
		</div>
	  </div>		
	
      <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
      
</body>
</html>
