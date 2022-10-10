<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
<link rel="stylesheet" href="/resources/css/common/common.css">
<link rel="stylesheet" href="/resources/css/login/login.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../../../resources/js/users/login.js"></script>
<link rel="stylesheet" href="/resources/css/login/login.css">
<link rel="stylesheet" href="/resources/css/common/style.css">
</head>
<body>

	<div id="loginForm">
		<div>
			<h1>Login</h1>
			<form action="/users/login" method="post">
				<div class="area id">
					<input type="text" id="memberId" name="memberId" autocomplete="off" required>
					<label for="id">USER ID</label>
				</div>
				<div class="area pw">
					<input type="password" id="memberPwd" name="memberPwd" autocomplete="off" required>
					<label for="pw">PASSWORD</label>
				</div>
				<button id="loginBtn" type="submit">LOGIN</button>
			</form>
			<div class="caption">
				<a href="${ pageContext.servletContext.contextPath }/findid">아이디 찾기</a>
				<a href="${ pageContext.servletContext.contextPath }/password/find">비밀번호 찾기</a>
				<a href="${ pageContext.servletContext.contextPath }/signup">회원가입</a>
			</div>
		</div>
	</div>
</body>
</html>