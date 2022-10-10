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
            <div class="alluserlistheader">
                <a>상세보기</a>
                <input type="hidden" name="adminNumber" value="${ loginAdmin.memberIdx }">	
            </div>
          
            <table id ="table" class="usertable detail">
                <tr height=41px>
                    <th width="100">번호</th>
                    <th width="100">ID</th>
                    <th width="100">이름</th>
                    <th width="100">닉네임</th>
                    <th width="150">생년월일</th>
                    <th width="150">가입일</th>
                    <th width="100">성별</th>
                    <th width="100">사용여부</th>
					<th width="200">블랙리스트</th>
                </tr>
                <tr height=41px>
	                <td><c:out value="${ memberDetailDTO.memberIdx }"/></td>
	                <td><c:out value="${ memberDetailDTO.userId }"/></td>
	                <td><c:out value="${ memberDetailDTO.name } "/></td>
	                <td><c:out value="${ memberDetailDTO.nickName } "/></td>
	                <td><fmt:formatDate pattern="yyyy/MM/dd" value="${ memberDetailDTO.birth }"/></td>
	                <td><fmt:formatDate pattern="yyyy/MM/dd" value="${ memberDetailDTO.ammDTO.regDate }"/></td>
	                <td><c:out value="${ memberDetailDTO.gender } "/></td>
	                <td id="YorN"><c:out value="${ memberDetailDTO.ammDTO.useYn } "/></td>
	                <td>
	               		<input type="hidden" value="${ memberDetailDTO.memberIdx }">
	               		<c:if test="${ memberDetailDTO.ammDTO.useYn eq 'Y'}">
						<input type="submit" value="등록" class="useYn" >
						<input type="submit" value="해제" class="useNy" disabled>
						</c:if>
						<c:if test="${ memberDetailDTO.ammDTO.useYn eq 'N'}">
						<input type="submit" value="등록" class="useYn" disabled>
						<input type="submit" value="해제" class="useNy" >
						</c:if>
					</td>

                </tr>
            </table>
            <table class="usertable detail">
            	<tr height=41px>
            		<th colspan=6>레시피 리스트</th>            		
            	<tr>
           		<tr height=41px>
	                <td width="100">번호</td>
	                <td width="300">제목</td>
	                <td width="400">내용</td>
	                <td width="150">등록일</td>
	                <td width="150">수정일</td>
	                <td width="100">승인여부</td>
                </tr>
                <tr>
                	<td></td>
                	<td></td>
                	<td></td>
                	<td></td>
                	<td></td>
                	<td></td>
                </tr>
            </table>
            <table class="usertable detail">
            	<tr height=41px>
            		<th colspan=4>댓글 리스트</th>            		
            	<tr>
           		<tr height=41px>
	                <td width="100">번호</td>
	                <td width="150">게시판</td>
	                <td >댓글</td>
	                <td width="150">등록일</td>
                </tr>
                <tr>
                	<td></td>
                	<td></td>
                	<td></td>
                	<td></td>
                </tr>	
            </table>
        </div>
        <script>
        if(document.getElementsByClassName("useYn")) {

            const $tds = document.getElementsByClassName("useYn");
      
            for(let i = 0; i < $tds.length; i++) {

                let memberIdx = '';
                $tds[i].onclick = function() {
                
                	number = this.parentElement.children[0].value;
                	location.href='${ pageContext.servletContext.contextPath }/adminBlackList/update/yton?number=' + number;
                	
                }
            }
        }
        if(document.getElementsByClassName("useNy")) {

            const $tds = document.getElementsByClassName("useNy");
            for(let i = 0; i < $tds.length; i++) {

                $tds[i].onclick = function() {

                	number = this.parentElement.children[0].value;
                    location.href='${ pageContext.servletContext.contextPath }/adminBlackList/update/ntoy?number=' + number; 
                }
            }
        }
		
	</script>
</body>
</html>