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
                <a>신고된 댓글</a>	
                <input id="searchCondition" type="hidden" name="currentPage" value="1">
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
                	<th >사용자</th>
                	<th ">게시물</th>
                	<th>ID</th>
                	<th>닉네임</th>
                	<th>댓글</th>
                	<th>신고된날짜</th>
                	<th>사용여부</th>
                	<th width="100">블랙리스트</th>
                	<th width="70">삭제</th>
                </tr>
                <c:forEach var="comments" items="${ requestScope.cmtReportList }">
                <tr height=41px>
                	<td><c:out value="${ comments.cmtReportDTO.memberIdx }"/></td>
	  				<td><c:out value="${ comments.rcpCommentsDTO.rcpIdx }"/></td>
                	<td><c:out value="${ comments.amDTO.userId }"/></td>
                	<td><c:out value="${ comments.amDTO.nickName }"/></td>
                	<td><c:out value="${ comments.rcpCommentsDTO.cmtContent }"/></td>
                	<td><fmt:formatDate pattern="yyyy/MM/dd" value="${ comments.cmtReportDTO.regDate }"/></td>
                	<td><c:out value="${ comments.adminMemberMngDTO.useYn }"/></td>
	                <td>
	               		<input type="hidden" value="${ comments.cmtReportDTO.memberIdx }">
	               		<c:if test="${ comments.adminMemberMngDTO.useYn eq 'Y' }">
						<input type="submit" value="등록" class="useYn" >
						<input type="submit" value="해제" class="useNy" disabled>
						</c:if>
						<c:if test="${ comments.adminMemberMngDTO.useYn eq 'N' }">
						<input type="submit" value="등록" class="useYn" disabled>
						<input type="submit" value="해제" class="useNy" >
						</c:if>
					</td>
					
					<th>
						<form id="deleteCmtCommentsForm" action="${ pageContext.servletContext.contextPath }/adminCmtComments/delete" method="get">
							<button class="delete" type="submit" name="delete">삭제</button>
							<input type="hidden" name="cmtIdx" value="${ comments.cmtReportDTO.cmtIdx }">
						</form>
					</th>
					
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

					const rcpIdx = this.parentNode.children[1].innerText
					var newWindow = window.open("about:blank");
					newWindow.location.href = "${ pageContext.servletContext.contextPath }/recipeComments/view?rcpIdx="+rcpIdx;
				}
				
			}
			
		}
		if(document.getElementsByClassName("useYn")) {

            const $tds = document.getElementsByClassName("useYn");
      
            for(let i = 0; i < $tds.length; i++) {

                let memberIdx = '';
                $tds[i].onclick = function() {
                
                	number = this.parentNode.children[0].value;
                	location.href='${ pageContext.servletContext.contextPath }/adminBlackList/update/yton3?number=' + number;
                	
                }
            }
        }
        if(document.getElementsByClassName("useNy")) {

            const $tds = document.getElementsByClassName("useNy");
            for(let i = 0; i < $tds.length; i++) {

                $tds[i].onclick = function() {

                	number = this.parentNode.children[0].value;
                    location.href='${ pageContext.servletContext.contextPath }/adminBlackList/update/ntoy4?number=' + number; 
                }
            }
        }

		
	</script>
</body>
</html>