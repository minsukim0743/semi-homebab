<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
	<link rel="stylesheet" href="/resources/css/users/recipeDetail.css">
	<link rel="stylesheet" href="/resources/css/users/recipeComments.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<script>
	const movePath = "/recipe/delete?rcpIdx=${ recipe.rcpIdx }";
	
	function button_event(){
		  if (confirm("정말 삭제하시겠습니까?") == true){    //확인
			  
		  location.replace(movePath);
		  
		  } else {   //취소
		      return;
		  }
		};
	</script>
	
	<!-- S: container -->
        <div class="container">
            <div class="recipe-view-wrap">
             
                <div class="title-box" id="recipeTitle"><c:out value="${ recipe.title }"/></div>
                <div class="regdate-box"><span id="date">등록일&nbsp;&nbsp; : &nbsp;&nbsp;<c:out value="${ recipe.regDate }"/></span></div>
                <div class="writer-box"><span id="writer">등록자&nbsp;&nbsp; : &nbsp;&nbsp;<c:out value="${ recipe.nickName }"/></span></div>
                <div class="writer-box"><span id="writer">조회수&nbsp;&nbsp; : &nbsp;&nbsp;<c:out value="${ recipe.viewCnt }"/>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;추천수&nbsp;&nbsp; : &nbsp;&nbsp;<c:out value="${ recipe.likeCnt }"/></span></div>
                <div class="detail-box">
                	<div class="category"><span id="recipeCategory">카테고리 &nbsp;:&nbsp;&nbsp;<c:out value="${ recipe.ctgrTit }"/></span></div>
                    <div class="serving-box"><span id="recipeSeving"><span>몇 인분&nbsp;&nbsp;? &nbsp;&nbsp;:  &nbsp;&nbsp;</span><c:out value="${ recipe.serving }"/></span>&nbsp;&nbsp;인분</div>
                    <div class="time-box"><span id="recipeTime"><span>조리시간 &nbsp;:&nbsp;&nbsp;</span><c:out value="${ recipe.cookingTime }"/></span>분</div>
                </div>
                <div class="keyVisual-box">
                    <img src="${ recipe.fileList[0].subPath }" id="recipeKeyVisual" width="800px" height="600px"/>
                </div>
                <div class="content-box">
                    <div class="recipeContent" id="recipeContent"><textarea readonly style="width:880px;height:400px; resize:none"><c:out value="${ recipe.content }"/></textarea></div>
                </div>
                <div class="back-box" align="center">
                	<table>
						<button onclick="location.href='${ pageContext.servletContext.contextPath }/recipe/page'">돌아가기</button>
						<form action="${ pageContext.servletContext.contextPath }/recipe/like" method="get">
							<c:if test="${!empty sessionScope.loginUser && empty recipeLike[0].stateYn }">
								<input type="hidden" name="rcpIdx" value="${ recipe.rcpIdx }">
								<input type="hidden" name="memberIdx" value="${ sessionScope.loginUser.memberIdx }">
								<button class="like">추천</button>
							</c:if>
						</form>
						<form action="${ pageContext.servletContext.contextPath }/recipe/likeCancel" method="get">
							<c:if test="${ !empty sessionScope.loginUser && recipeLike[0].stateYn eq 'Y' }">
								<input type="hidden" name="rcpIdx" value="${ recipe.rcpIdx }">
								<input type="hidden" name="memberIdx" value="${ sessionScope.loginUser.memberIdx }">
								<button>추천 취소</button>								
							</c:if>
						</form>
						<c:if test="${ sessionScope.loginUser.memberIdx eq recipe.memberIdx }">
						<button onclick="location.href='${ pageContext.servletContext.contextPath }/recipe/update?rcpIdx=${ recipe.rcpIdx }'">수정하기</button>
						<button onclick="button_event()">삭제하기</button>
						</c:if>
					</table>
				</div>
            </div>
        </div>
        <!-- E: container -->

</body>
</html>
