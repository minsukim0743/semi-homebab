<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homebab Notice Detail Page</title>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<div class="container" align="center">
		<div style="text-align: center; margin-top: 50px;">
			<h3>공지사항 상세보기</h3><br>
<!-- 			<hr style="width : 600px ; margin:auto;"> -->
				<br><br>
			<table class="table table-bordered " style="width: 700px; margin-left : 170px;">
				<tr>
					<td style="width: 100px;">제목</td>
					<td style="margin-left : 210px;"><c:out value="${ requestScope.noticeDetail.title }" /></td>
				</tr>
				<tr>
					<td style="width: 100px;">작성일</td>
					<td><c:out value="${ requestScope.noticeDetail.regDate }" /></td>
				</tr>
				<tr>
					<td style="width: 100px; height: 400px; vertical-align : middle;">내용</td>
					<td><p style="text-align: left; margin: 20px;"><c:out value="${ requestScope.noticeDetail.content }" /></p></td>
				</tr>
			</table>
			<br> 
			<input type="button" class="btn btn-default" value="뒤로가기" onclick="goBack();" />
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>