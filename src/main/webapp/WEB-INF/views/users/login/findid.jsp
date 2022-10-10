<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="/resources/css/common/common.css">
<link rel="stylesheet" href="/resources/css/login/findid.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../../../resources/js/users/findid.js"></script>
</head>
<body>
	<div class="findIdWrap">
		<h1>아이디 찾기</h1>
			<div class="area id">
				<input type="text" id="findId" name="findId" autocomplete="off" required>
				<label for="findId">이름</label>
			</div>
			<br>
			<div class="area datebirth">
				<input type="date" id="findDate" name="findDate">
			</div>
			<div class="btn-area">
				<button type="submit" class="findSend">전송</button>
				<button type="submit" class="findMain">메인으로</button>
			</div>
	</div>
</body>
</html>