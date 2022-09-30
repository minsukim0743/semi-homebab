<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	(function(){
		const successCode = "${ requestScope.successCode }";
		const rcpIdx = "${ requestScope.rcpIdx }";
		const fbIdx =  "${ requestScope.fbIdx }";
		const sgtIdx =  "${ requestScope.sgtIdx }";
		let successMessage = "";
		let movePath = "";
		
		switch(successCode){
			case "insertRecipe" : 
				successMessage = "레시피 게시판 등록에 성공하셨습니다!";
				movePath = "/recipe/page";
				break;
				
			case "updateRecipe" : 
				successMessage = "레시피 수정에 성공하셨습니다!";
				movePath = "/recipe/view?rcpIdx=" + rcpIdx;
				break;
				
			case "deleteRecipe"	:
				successMessage = "레시피 삭제에 성공하셨습니다!";
				movePath = "/recipe/page";
				break;
				
			case "FreeboardInsert" : 
				successMessage = "자유 게시판 등록에 성공하셨습니다!";
				movePath = "${pageContext.servletContext.contextPath}/freeboard/users/list";
				break;
				
			case "FreeboardUpdate" : 
				successMessage = "수정에 성공하셨습니다!";
				movePath = "/freeboard/users/detail?fbIdx=" + fbIdx;
				break;
				
			case "FreeboardDelete"	:
				successMessage = "삭제에 성공하셨습니다!";
				movePath = "/freeboard/users/list";
				break;
				
			case "SuggestionInsert" : 
				successMessage = "건의 게시판 등록에 성공하셨습니다!";
				movePath = "${pageContext.servletContext.contextPath}/suggestion/users/list";
				break;
				
			case "SuggestionUpdate" : 
				successMessage = "수정에 성공하셨습니다!";
				movePath = "/suggestion/users/detail?sgtIdx=" + sgtIdx;
				break;
				
			case "SuggestionDelete"	:
				successMessage = "삭제에 성공하셨습니다!";
				movePath = "/suggestion/users/list";
				break;
		}

		alert(successMessage);
		
		location.replace(movePath);
	})();
	
	</script>
</body>
</html>