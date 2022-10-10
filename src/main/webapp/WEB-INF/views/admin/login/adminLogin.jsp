<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="resources/css/admin/adminLogin.css"/>
<title>adminLogin</title>
</head>
<body>
	<c:if test="${ empty sessionScope.loginAdmin }">
	<form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/login" method="post">
    <div class = "login">
        <h1 class = "title"><img src="resources/images/admin/favicon_100x100.png" alt="HOMEBOB LOGIN"/></h1>HOMEBOB ADMIN</h1>
        <div class="loginarea">
            <input class="text id" type="text" placeholder="ID" name="userId"/><br>
            <input class="text pw" type="password" placeholder="PW" name="userPwd"/>
            <p><button class = "submit">로그인</button></p>
        </div>
    </div>
    </form>
    </c:if>
</body>
</html>