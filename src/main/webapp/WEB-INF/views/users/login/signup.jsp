<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/common/common.css">
<link rel="stylesheet" href="/resources/css/login/signup.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../../../resources/js/users/signup.js"></script>
</head>
<body>
	<div class="suWrap">
		<input class="overId" type="hidden" value="1">
		<input class="overNickName" type="hidden" value="1">
		<div>
			<form action="/member/signup/regist" method="post" onsubmit="return validate();">
				<h1>회원가입</h1>
				<div class="suArea">
					<input type="text" id="suId" name="suId" autocomplete="off" maxlength="50" required>
					<label for="suId">아이디</label>
				</div>
				<div class="overLapId" style="color:red; display:none">중복된 아이디가 있습니다.</div>
				<div class="overUserId" style="color:green; display:none">사용가능한 아이디입니다.</div>
				<div class="suArea">
					<input type="password" id="suPw" name="suPw" maxlength="50" autocomplete="off" required>
					<label for="suPw">비밀번호</label>
				</div>
				<div class="suArea">
					<input type="password" id="suPwCk" name="suPwCk" maxlength="50" autocomplete="off" required>
					<label for="id">비밀번호 재확인</label>
				</div>
				<div class="suArea">
					<input type="text" id="suNickName" name="suNickName" maxlength="30" autocomplete="off" required>
					<label for="id">닉네임</label>
				</div>
				<div class="overLapNickName" style="color:red; display:none">중복된 닉네임이 있습니다.</div>
				<div class="overUserNickName" style="color:green; display:none">사용가능한 닉네임입니다.</div>
				<div class="suArea">
					<input type="text" id="suName" name="suName" maxlength="30" autocomplete="off" required>
					<label for="id">이름</label>
				</div>
				<div class="suArea">
					<input type="text" id="suEmail" name="suEmail" maxlength="50" autocomplete="off" required>
					<label for="id">이메일</label>
				</div>
				<br>
				<div>
					<p>생년월일</p>
					<input type="date" id="suDate" name="suDate" required>
				</div>
				<select id="suGender" name="suGender">
					<option value="" selected>성별</option>
					<option value="M">남자</option>
					<option value="F">여자</option>
				</select>
				<br>
				<br>
				<button class="signUpBtn" type="submit">가입하기</button>
			</form>
		</div>
	</div>
</body>
</html>