<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminBlacklist</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminMemberList.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/common.css">
</head>
<body>
	<jsp:include page="../main/adminMain.jsp"/>
	
	<div class="centertable">
		<form id="blacklistForm" action="${ pageContext.servletContext.contextPath }/adminBlackList/list" method="get">
            <div class="alluserlistheader">
                <a>블랙리스트</a>
               	<select class="searchCondition" name="searchCondition">
               		<option value="userId" ${ requestScope.selectCriteria.searchCondition eq "userId"? "selected" : "" }>ID</option>
               		<option value="name" ${ requestScope.selectCriteria.searchCondition eq "name"? "selected" : "" }>이름</option>
               		<option value="nickName" ${ requestScope.selectCrieteria.searchCondition eq "nickName"? "selected" : "" }>닉네임</option>
               	</select> 
               	<input type="text" class="text" name="searchValue">
               	<input type="submit" class="find" value="검색">
            </div>
   		</form>
            <table class="usertable">
                <tr height=41px>
                	<th>번호</th>
                	<th>ID</th>
                	<th>이름</th>
                	<th>닉네임</th>
                	<th>등록일</th>
                </tr>
                <c:forEach var="blacklist" items="${ requestScope.adminblacklist }">
                <tr height=41px>
                	<td><c:out value="${ blacklist.memberIdx }"/></td>
                	<td><c:out value="${ blacklist.userId }"/></td>
                	<td><c:out value="${ blacklist.name }"/></td>
                	<td><c:out value="${ blacklist.nickName }"/></td>
                	<td><fmt:formatDate pattern="yyyy/MM/dd" value="${ blacklist.blacklistDTO.regDate }"/></td>
                </tr>
                </c:forEach>
            </table>
            <div class="alluserlistfooter">
				<jsp:include page="../paging/blacklistPaging.jsp"/> 
           	</div>
        </div>
        <script>
		
		if(document.getElementsByTagName("td")) {
			
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "#f4f4f2";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.backgroundColor = "white";
				}
				
				function buttonAction(number) {
					
				}
				
				$tds[i].onclick = function() {
					const number = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/adminMember/detail?number="+number;
				}
				
			}
			
		}
		
	</script>
</body>
</html>