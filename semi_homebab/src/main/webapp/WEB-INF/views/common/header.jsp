<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>

    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- font css -->
<link rel="stylesheet" href="/resources/css/common/common.css">
<!-- header CSS -->
<link rel="stylesheet" href="/resources/css/common/header.css">
</head>
<body>
	<header>
		<div class="hdWrap">
			<ul class="gnb">
				<li><a href="${ pageContext.servletContext.contextPath }/recipe/page">레시피</a></li>
	            <li class="gongji"><a href="${ pageContext.servletContext.contextPath }/notice/users/list">공지사항</a></li>
	            <li class="guni"><a href="${ pageContext.servletContext.contextPath }/suggestion/users/list">건의사항</a></li>
	            <li class="free"><a href="${ pageContext.servletContext.contextPath }/freeboard/users/list">자유게시판</a></li>
			</ul>
			<div class="logo"><a href="${ pageContext.servletContext.contextPath }/main"><img src="/resources/images/common/favicon_100x100.jpg"></a></div>
			<div class="hdSubMenu">
				
				<div class="login">
					<!-- 비로그인 -->
					<c:if test="${ empty sessionScope.loginUser }">
						<div class="user"><a href="${ pageContext.servletContext.contextPath }/login"><img src="/resources/images/common/ico_user.png" width="35px" height="35px"></a></div>
				    </c:if>
				    <!-- 로그인 -->
				    <c:if test="${ !empty sessionScope.loginUser }">
				    	<div class="write"><a href="${ pageContext.servletContext.contextPath }/recipe/insert"><img src="/resources/images/common/tmn_write.png" width="35px" height="35px"></a></div>
				    	<div class="mypage"><a href="${ pageContext.servletContext.contextPath }/myrecipe/page"><img src="/resources/images/common/hdMypage.png" width="35px" height="35px"></a></div>
				        <div class="logout"><a href="${ pageContext.servletContext.contextPath }/login/logout"><img src="/resources/images/common/hdLogOut.png" width="35px" height="35px"></a></div>
				    </c:if>
				</div>
			</div>
		</div>
	</header>
</body>
</html>