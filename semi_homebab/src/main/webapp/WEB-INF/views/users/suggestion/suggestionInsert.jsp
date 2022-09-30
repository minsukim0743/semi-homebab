<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 800px;
	margin-top: 30px;
	border-top: 1px solid gray;
	text-align: center;
}
</style>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
 <script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container" align="center">
		<div style="text-align: center; margin-top: 50px;">
			<h3>건의사항 등록</h3>
			<br>

			<form
				action="${ pageContext.servletContext.contextPath }/suggestion/users/insert"
				method="post">
				<table class="table table-bordered " style="width: 700px; margin: auto;">
					<tr style="display: none">
						<td>memberIdx</td>
						<td><c:out value="${ sessionScope.loginUser.memberIdx }">
						<input type="text" name="memberIdx" readonly>
						</c:out></td>
					</tr>
					<tr>
						<td style="width : 100px;">제목</td>
						<td><input type="text" size="50" name="title" style="height: 40px; width: 100%; "></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td style=" vertical-align : middle;"><c:out value="${ sessionScope.loginUser.name }">
								<p style="text-align: left; margin: 20px; ">
									<input type="text" name="name" readonly>
								</p>
							</c:out></td>
					</tr>
					<tr>
						<td style="width: 100px; height: 400px; vertical-align: middle;">내용</td>
						<td>
							<div style="width: 700px; margin: auto;">
								<textarea id="summernote" rows="10" cols="40" name="content"></textarea>
							</div>
						</td>
					</tr>
				</table>
				<br> <br>
				<div align="center" style ="display: inline-flex; margin:10px;">
					<button style="margin:5px" class="btn btn-default" type="button" value="뒤로가기" onclick="goBack();">뒤로가기</button>
					<button style="margin:5px" class="btn btn-default" type="submit">등록</button>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {
			//여기 아래 부분
			$('#summernote').summernote({
				height : 300, // 에디터 높이
				minHeight : null, // 최소 높이
				maxHeight : null, // 최대 높이
				focus : true, // 에디터 로딩후 포커스를 맞출지 여부
				lang : "ko-KR", // 한글 설정
				placeholder : '내용을 적어주세요' //placeholder 설정

			});
		});
	</script>
</body>
</html>