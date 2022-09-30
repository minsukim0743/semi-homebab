<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>adminMain</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminMain.css" />
</head>
<body>
	<div id="header">
		<a href="${ pageContext.servletContext.contextPath }/main"><img class="logo" src="${ pageContext.servletContext.contextPath }/resources/images/admin/favicon_100x100.png" alt="logo" width="40" height="40"></a> 
			<a class="logotext" href="${ pageContext.servletContext.contextPath }/main"><b>Homebab</b></a>
		<c:if test="${ !empty sessionScope.hm }">
			<a><c:out value="${ sessionScope.hm.memberId }" />(admin)님이 로그인하셨습니다.</a>
			<a class="btns website" href="${ pageContext.servletContext.contextPath }/main">website</a>
			<a class="btns logout" href="${ pageContext.servletContext.contextPath }/admin/logout">logout</a>
		</c:if>
		<c:if test="${ empty sessionScope.hm }">
			<form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/login" method="post" width="400">
				<div class="loginarea">
					<input class="texts id" type="text" placeholder="ID" name="userId" />
					<input class="texts pw" type="password" placeholder="PW" name="userPwd" />
					<button class="button">로그인</button>
				</div>
			</form>
	    </c:if>
	</div>
	<div class="sidebar">
		<div class="sidebarhead">
			<a href="${ pageContext.servletContext.contextPath }"><b>Administator</b></a>
		</div>
		<div id="Accordion_wrap">
			<div class="mainmenu">
				<span>회원관리</span>
			</div>
			<div class="submenu">
				<a href="${ pageContext.servletContext.contextPath }/adminMember/list">회원조회</a><br>
			</div>
			<div class="mainmenu">
				<span>공지사항관리</span>
			</div>
			<div class="submenu two">
				<a href="${ pageContext.servletContext.contextPath }/adminNotice/select">공지사항조회</a><br>
				<a href="${ pageContext.servletContext.contextPath }/adminNotice/insert">공지사항작성</a>
			</div>
			<div class="mainmenu">
				<span>건의사항관리</span>
			</div>
			<div class="submenu">
				<a href="${ pageContext.servletContext.contextPath }/adminSuggestion/select">건의사항조회</a>
			</div>
			<div class="mainmenu">
				<span>레시피관리</span>
			</div>
			<div class="submenu two">
				<a href="${ pageContext.servletContext.contextPath }/adminRecipe/list">레시피조회</a><br>
				<a href="${ pageContext.servletContext.contextPath }/adminRecipe/list2">미검토레시피조회</a>
			</div>
			<div class="mainmenu">
				<span>자유게시판관리</span>
			</div>
			<div class="submenu">
				<a href="${ pageContext.servletContext.contextPath }/adminFreeboard/select">게시물조회</a>
			</div>
			<div class="mainmenu">
				<span>블랙리스트</span>
			</div>
			<div class="submenu two">
				<a href="${ pageContext.servletContext.contextPath }/adminBlackList/list">블랙리스트조회</a><br>
				<a href="${ pageContext.servletContext.contextPath }/adminBlackList/comments">신고게시물조회</a>
			</div>
		</div>
	</div>
	<script>
	$(".mainmenu").click(function() {
	   $(this).next(".submenu").stop().slideToggle(300);
	   $(this).toggleClass('on').siblings().removeClass('on');
	   $(this).next(".submenu").siblings(".submenu").slideUp(300);
	});	
</script>
</body>
</html>