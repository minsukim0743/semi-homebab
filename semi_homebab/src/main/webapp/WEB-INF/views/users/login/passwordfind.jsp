<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 아이디 인증</title>
<link rel="stylesheet" href="/resources/css/common/common.css">
<!-- 아이디 인증 SCC -->
<link rel="stylesheet" href="/resources/css/login/passwordfind.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../../../resources/js/users/passwordfind.js"></script>
</head>
<body>
	<div id="pwWrap">
		<h1>비밀번호 찾기</h1>
		<div class="pwContent">
			<div>
				<input type="text" name="pfId" id="pfId" placeholder="ID" autocomplete="off">
				<button class="pfIdBtn" id="pfIdBtn">아이디확인</button>
			</div>
			<div style="display : none;">
				<input type="text" name="pfEmail" id="pfEmail" placeholder="EMAIL" autocomplete="off">
				<button class="pfEmailBtn">인증번호전송</button>
			</div>
			<div style="display : none;">
				<input type="text" name="pfAuthNum" id="pfAuthNum" placeholder="인증번호" autocomplete="off">
				<button class="pfAuthNumBtn">인증번호확인</button>
			</div>
		</div>
		<div class="pwResetContent" style="display : none;">
			<input type="password" name="pw" class="pw" placeholder="비밀번호" autocomplete="off">
			<input type="password" name="pwCheck" class="pwCheck" placeholder="비밀번호확인" autocomplete="off">
			<button class="pwModBtn">비밀번호변경</button>
		</div>
	</div>
</body>
</html>