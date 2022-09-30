<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
</head>
<body>
	<script>
		(function(){
			let message = "${ requestScope.message }";
			let movePath = "";
			
			switch(message){
				case "loginFailed" : 
					message = "로그인 실패!";
					movePath = "/login";
					break;
			}
	
			alert(message);
			
			location.replace(movePath);
		})();
	</script>
</body>
</html>