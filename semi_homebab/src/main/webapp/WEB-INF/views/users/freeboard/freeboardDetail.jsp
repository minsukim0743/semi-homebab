<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
<link rel="stylesheet" href="/resources/css/users/boardDetail.css">
</head>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
<script>
	$(document).ready(function() {
		$("#dtContent").html("${ requestScope.freeboardDetail.content }");
	});
</script>
<script>
	const movePath = "/freeboard/users/delete?fbIdx=${ freeboardDetail.fbIdx }";

	function button_event() {
		if (confirm("정말 삭제하시겠습니까?") == true) { //확인

			location.replace(movePath);

		} else { //취소
			return;
		}
	};
</script>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<div class="container" align="center">
		<div style="text-align: center; margin-top: 50px;">
			<h3>자유 게시판 상세내용</h3>
			<br>
			<!-- <hr style="width : 600px "> -->
			<table class="table table-bordered "
				style="width: 700px; margin-left: 170px;">

				<br>
				<tr style="height: 30px;">
					<td style="width: 90px; background-color: #F1F1F2;">작성자</td>
					<td style="width: 250px; border-bottom: 1px solid #F1F1F2;"><p>
							<c:out value="${ requestScope.freeboardDetail.name }"></c:out>
						</p></td>
					<td style="width: 90px; background-color: #f1f1f2;">작성일</td>
					<td style="width: 250px; border-bottom: 1px solid #F1F1F2;;"><p>
							<c:out value="${ requestScope.freeboardDetail.regDate }" />
						</p></td>
				</tr>
				<tr style="height: 30px;">
					<td style="width: 90px; background-color: #f1f1f2;">제목</td>
					<td colspan="3" style="border-bottom: 1px solid #F1F1F2; margin-left : 210px;"><p>
					<c:out value="${ requestScope.freeboardDetail.title }" />
					</p></td>
				</tr>
				<tr>
					<c:if test="${!empty freeboardDetail.fileList[0].path }"> 
					<td style="width: 90px; background-color: #f1f1f2;">이미지 사진</td>
					<td colspan="5">
						<div id="freeboardImg" align="center">
							<img id="freeboardImg" width="500" height="300"
								src="${ freeboardDetail.fileList[0].path }" />
						</div>
					</td>
					</c:if>
				</tr>
				<tr>
					<td style="background-color: #F1F1F2;">내용</td>
					<td colspan="3" id="dtContent"
						style="height: 300px; border-bottom: 1px solid #F1F1F2;"></td>
				</tr>
			</table>
			<br>


				<input type="hidden" value="${ freeboardDetail.memberIdx }"
					name="memberIdx">

					<input type="hidden" value="${ freeboardDetail.fbIdx }" name="fbIdx">
					<div style ="display: inline-flex; margin:4px;" >
					<button style="margin:4px;" class="btn btn-default" type="button" value="뒤로가기" onclick="goBack();">뒤로가기</button>
				<c:if test="${ sessionScope.loginUser.memberIdx eq freeboardDetail.memberIdx }">
					<button style="margin:4px;" class="btn btn-default" onclick="location.href='${ pageContext.servletContext.contextPath }/freeboard/users/update?fbIdx=${ freeboardDetail.fbIdx }'">수정하기</button>
					<button style="margin:4px;" onclick="button_event()" class="btn btn-default">삭제하기</button>
				</c:if>
				</div>	
			</div>
		</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>