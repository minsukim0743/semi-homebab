<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminMemberList</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/adminMemberList.css">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/admin/common.css">
</head>
<body>
	<jsp:include page="../main/adminMain.jsp"/>
	
	<div class="centertable">
	<form id="loginForms" action="${ pageContext.servletContext.contextPath }/adminMember/list" method="get">
            <div class="alluserlistheader">
                <a>회원리스트</a>	
                <select class="searchCondition" name="searchCondition">
                	<option value="userId" ${ requestScope.selectCriteria.searchCondition eq "userId"? "selected" : "" }>ID</option>
                	<option value="name" ${ requestScope.selectCriteria.searchCondition eq "name"? "selected" : "" } >이름</option>
                	<option value="nickName" ${ requestScope.selectCriteria.searchCondition eq "nickName"? "selected" : ""}>닉네임</option>
                </select>
                <input class="text" type="text" name="searchValue" value="<c:out value="${ requestScope.selectCriteria.searchValue }"/>">
                <input class="find" type="submit" value="검색">
            </div>
   	</form>
            <table class="usertable">
                <tr height=41px>
                    <th width="70">번호</th>
                    <th width="120">ID</th>
                    <th width="120">이름</th>
                    <th width="120">닉네임</th>
                    <th>E-mail</th>
                    <th width="120">생년월일</th>
                    <th width="50">성별</th>
                    <th width="120">가입일</th>
                </tr>
                
                <c:forEach var="list" items="${ requestScope.adminMemberList }">
                <tr height=41px>
                	<td><c:out value="${ list.memberIdx }"/></td>
                    <td><c:out value="${ list.userId }"/></td>
                    <td><c:out value="${ list.name }"/></td>
                    <td><c:out value="${ list.nickName }"/></td>
                    <td><c:out value="${ list.email }"/></td>
                    <td><fmt:formatDate pattern="yyyy/MM/dd" value="${ list.birth }"/></td>
                    <td><c:out value="${ list.gender }"/></td>
                    <td><fmt:formatDate pattern="yyyy/MM/dd" value="${ list.ammDTO.regDate }"/></td>
                </tr>
                </c:forEach>
            </table>
            <div class="alluserlistfooter">
                <jsp:include page="../paging/memberPaging.jsp"/>
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

					const number = this.parentNode.children[0].innerText
					location.href = "${ pageContext.servletContext.contextPath }/adminMember/detail?number="+number;
				}
				
			}
			
		}
		
	</script>
	
</body>
</html>