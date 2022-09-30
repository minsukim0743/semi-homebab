<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suggestion Detail Page</title>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#dtContent").html("${ requestScope.suggestion.content }");
	});
</script>

<script>
	const movePath = "/suggestion/users/delete?sgtIdx=${ suggestionDetail.sgtIdx }";

	function button_event() {
		if (confirm("정말 삭제하시겠습니까?") == true) { //확인

			location.replace(movePath);

		} else { //취소
			return;
		}
	};
</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="container" align="center">
		<div style="text-align: center; margin-top: 50px;">
			<h3>건의사항 상세내역</h3>
			<br>
			<!-- <hr style="width : 600px "> -->
			<table align="center" class="table table-bordered " style="width: 700px; margin-left: 170px;">
				<br>
				<tr style="height: 30px;">
					<td style="width: 90px; background-color: #F1F1F2;">작성자</td>
					<td style="width: 250px;"><p>
							<c:out value="${ requestScope.suggestionDetail.name }" />
						</p></td>
					<td style="width: 90px; background-color: #f1f1f2;">작성일</td>
					<td style="width: 250px;"><p>
							<c:out value="${ requestScope.suggestionDetail.regDate }" />
						</p></td>
				</tr>
				<tr style="height: 30px;">
					<td style="width: 90px; background-color: #f1f1f2;">제목</td>
					<td colspan="3"><p>
							<c:out value="${ requestScope.suggestionDetail.title }" />
						</p></td>
				</tr>

				<tr>
					<td style="background-color: #F1F1F2;">내용</td>
					<td colspan="3"	style="height: 300px;">
					<p style="text-align: left; margin: 20px;">
					<c:out value="${ requestScope.suggestionDetail.content }"/>
					</p>
					</td>
				</tr>
				
			</table>
			<br> <input type="hidden"
				value="${ suggestionDetail.memberIdx }" name="memberIdx"> <input
				type="hidden" value="${ suggestionDetail.sgtIdx }" name="sgtIdx">
				<button style="margin:4px;" class="btn btn-default" type="button" value="뒤로가기" onclick="goBack();">뒤로가기</button>
			<c:if test="${ sessionScope.loginUser.memberIdx eq suggestionDetail.memberIdx }">
			<div style ="display: inline-flex; margin:4px;" >
				<button class="btn btn-default" onclick="location.href='${ pageContext.servletContext.contextPath }/suggestion/users/update?sgtIdx=${ suggestionDetail.sgtIdx }'" style="display: inline-flex; margin:4px;">수정하기</button>
				<button class="btn btn-default" onclick="button_event()">삭제하기</button>
			</div>
			</c:if>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>