<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css"	rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<script src="lang/summernote-ko-KR.js"></script>

</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<form action="${ pageContext.servletContext.contextPath }/freeboard/users/update" method="post" encType="multipart/form-data">
		<div style="text-align: center; margin-top: 50px; font-size: 20px;">
			자유 게시판 수정</div>
		<br>
		<br>
				<table class="table table-bordered " style="width: 700px; margin: auto;">
			<tr style="display: none">
				<td>memberIdx</td>
				<td><c:out value="${ sessionScope.loginUser.memberIdx }">
					<input type="text" name="memberIdx" readonly>
					</c:out></td>
			</tr>
			<tr>
				<td style="width : 100px;">제목</td>
				<td><input type="text" size="50" name="title" value="${ freeboard.title }"></td>
			</tr>

			<tr>
				<td>작성자</td>
				<td style=" vertical-align : middle;">
					<p style="text-align: left; margin: 20px; ">
						<c:out value="${ sessionScope.loginUser.name }">
						<input type="text" name="name" readonly>
					</c:out>
					</p>
				</td>
			</tr>
			
			<tr>
				<td style ="vertical-align : middle;">내용</td>
				<td style="width: 100px; height: 400px; margin: 10px;">
				<textarea id="summernote" name="content"><c:out value="${ freeboard.content }"/></textarea>
			</tr>
			<tr>
				<th><label for="freeboardfile" class="picture">파일 업로드</label></th>
				<td><input type="file" id="freeboardfile" name="freeboardfile"
					onchange="LoadImg(this,1)"></td>
			</tr>
		</table>
		<br><br>
<!-- 		position: relative; left:500px -->
		<div style="margin-left: 775px;" >
		<input type="hidden" name="fbIdx" value ="${ freeboard.fbIdx }">
		<button class="btn btn-default" type="button"  value="뒤로가기" onclick="goBack();">뒤로가기</button>
		<button class="btn btn-default" type="submit" >등록</button>
		</div>
		</form>
	
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
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
	
	<script>
		function loadImg(value, num) {
			if (value.files && value.files[0]) {
				const reader = new FileReader();
				reader.onload = function(e) {
					switch (num) {
					case 1:
						document.getElementById("freeboardfile").src = e.target.result;
						break;
					}
				}
				reader.readAsDataURL(value.files[0]);
			}
		}
	</script>
</body>
</html>