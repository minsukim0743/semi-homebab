<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <li><button class="all"  onclick="location.href='${ pageContext.servletContext.contextPath }/recipe/page'">전체보기</button></li>
                <li><button class="cook" value="1" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=일반식'">일반식</button></li>
                <li><button class="nomal" value="2" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=3분요리'" >3분요리</button></li>
                <li><button class="night" value="3" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=야식'">야식</button></li>
                <li><button class="diet" value="4" onclick="location.href='${ pageContext.servletContext.contextPath }/select/category?ctgrTit=다이어트'">다이어트</button></li>
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
        
	     <div class="searchArea">   
	        <c:choose>
				<c:when test="${ empty requestScope.recipe }">
					<div class="recipeResult" style="border: 0;">
						<table style="font-size: 30px; color: black; margin : 0 auto;">
							<tr>
								<td style="padding : 150px;">검색된 결과가 없습니다.</td>
							</tr>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div id="container">
						<div class="thumbnail-area" id="thumbnailArea">
							<c:forEach var="recipe" items="${ requestScope.recipe }">
								<div class="recipe-list" align="center">
									<div>
										<img src="${ recipe.fileList[0].subPath }" width="270px" height="230px" onclick="location.href='/recipe/view?rcpIdx=${ recipe.rcpIdx }'">
									</div>
									<p>레시피명&nbsp;&nbsp; :&nbsp;<label><c:out value="${ recipe.title }"/></label><br>
									조회수&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ recipe.viewCnt }"/><br>
									등록자&nbsp;&nbsp; :&nbsp;&nbsp;<c:out value="${ recipe.nickName }"/>
									</p>
								</div>
							</c:forEach>
						</div>
					</div>		
				</c:otherwise>
			</c:choose>					
		</div>				
	        <br><br><br><br>
	</div>			
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>