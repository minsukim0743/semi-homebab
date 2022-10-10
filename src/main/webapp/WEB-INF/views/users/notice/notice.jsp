<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<script>
// $(document).ready(function(){
//    jQuery('tr').each(function(i) { 
//       this.style.backgroundColor = (i % 2) ? 'rgba(116, 178, 67, 0.15)' : 'white';
//    });
// });
</script>


<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/><br><br><br>
        <div id ="noticeboard">
            <h3 align="center"> 공 지 사 항 </h3><br><br><br>
			<c:forEach items= "${ noticeList }" var="notice">
					<table class="table table-hover" style=" margin:auto; top: 15px; width: 1000px">
						<tr style="height: 60px; font-size: 14px; ">
							<td align="center" style ="width: 150px; vertical-align : middle;"><c:out value="${ notice.ntcIDx }"/></td>
							<td align="center" style ="width: 600px; vertical-align : middle;"><c:out value="${ notice.title }"/></td>
							<td align="center" style ="width: 150px; vertical-align : middle;"><c:out value="${ notice.regDate }"/></td>
						    <hr style="color: #289F5D; width: 900px; margin:auto;" >
						</tr>
					</table>
            </c:forEach>
		</div>

		
		<br><br><br><br>
		<jsp:include page="/WEB-INF/views/users/notice/noticePasing.jsp"/>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
		
		<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/notice/users/detail?fdIdx=" + no;
				}
			}
		}
	</script> 
</body>
</html>