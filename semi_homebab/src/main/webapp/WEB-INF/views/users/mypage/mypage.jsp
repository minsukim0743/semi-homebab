<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/common/header.css">
<link rel="stylesheet" href="/resources/css/common/footer.css">
<link rel="stylesheet" href="/resources/css/common/webfont.css">
<link rel="stylesheet" href="/resources/css/users/mypage.css">
<script type="text/javascript" src="../../../resources/js/users/mypage.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


</head>
<body>
	<div id="wrap">
      <!-- header start -->
      <jsp:include page="/WEB-INF/views/common/header.jsp"/>
      <!-- header end -->
     
      <!-- main start -->
      <div id="main">
      
      <div id="myPostPageBtt">
          <button class="learn-more myInfo" onclick="click1();">나의 정보수정</button>
          <button class="learn-more myRecipe" onclick="click2();">나의 레시피</button>
          <button class="learn-more myPost" onclick="click3();">나의 게시물</button>
          <button class="learn-more amySuggestions" onclick="click4();">나의 건의사항</button>
      </div>
      
     <input type="hidden" id="hiddenBtt" value="${ requestScope.value}">
      
    	<!-- 1. 인풋히든
    	2. 온클릭이벤트를 펑셔느로만들어서 펑션에 파라미터를 넣어서 로케이션태우고 인풋히든에 벨류를 바꾼다.
    	3. idx는 스크립트의 조건을 걸어 히든값을 가져와 거기에 데이터를 맞추어 넣어서 로케이션을 만든다. -->
    
      <div id="forPost">
        <table class="table table-hover">
          <tr>
            <th width="10%">NO</th>
            <th width="40%">TITLE</th>
            <th width="25%">DATE</th>
            <th width="15%">Post Number</th>
          </tr>
    <c:forEach var="myPageList" items="${ requestScope.myPageList }">
      <c:set var="i" value="${i+1}"/>      
        <tr>
          <td><c:out value="${ i }"/></td>
          <td><c:out value="${ myPageList.title }"/></td>
          <td><c:out value="${ myPageList.regDate }"/></td>
          <c:if test="${ requestScope.type eq 'myRecipe' }">
            
            <td class="myrecipe"><c:out value="${ myPageList.rcpIdx }"/></td>
          </c:if>
            
          <c:if test="${ requestScope.type eq 'myPost' }">
            
            <td><c:out value="${ myPageList.fbIdx }"/></td> 
          </c:if>
          <c:if test="${ requestScope.type eq 'mySuggestions' }">
            
            <td><c:out value="${ myPageList.fbIdx }"/></td> 
          </c:if>            	
        </tr> 
      </c:forEach> 
    </table> <!-- e: table -->
     </div> <!-- e: forPost --> 

     
      <!-- 페이지 처리  -->
      <jsp:include page="/WEB-INF/views/users/mypage/paging.jsp"/>
				
      <!-- S: footer -->
      <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </div>  
  </div>
    
    <script type="text/javascript">
    
 	let hiddenBtt = $("#hiddenBtt").val();
 	
    function click1() {
    	
    	location.href = "${ pageContext.servletContext.contextPath }/myinfo/select";
    	$(hiddenBtt).val(1);
    }
    
    function click2() {
		
		location.href="${ pageContext.servletContext.contextPath }/myrecipe/page";
		$(hiddenBtt).val(2);
    }
    
	function click3() {
		
		location.href="${ pageContext.servletContext.contextPath }/mypost/page";
		$(hiddenBtt).val(3);
    }
	
	function click4() {
		
		location.href="${ pageContext.servletContext.contextPath }/mysuggestions/page";
		$(hiddenBtt).val(4);
    }

    
    if(document.getElementsByTagName("td")) {
		const myInfo = document.getElementsByClassName(".myIfno");
		const myRecipe = document.getElementsByClassName(".myRecipe");
		const mySuggestions = document.getElementsByClassName(".mySuggestions");
		const $tds = document.getElementsByTagName("td");
		
		for(let i = 0; i < $tds.length; i++) {
			
			$tds[i].onmouseenter = function() {
				this.parentNode.style.backgroundColor = "#f4f4f2";
				this.parentNode.style.cursor = "pointer";
			}
			
			$tds[i].onmouseout = function() {
				this.parentNode.style.backgroundColor = "white";
			}
			
			
			$tds[i].onclick = function() {
				
				const number = this.parentNode.children[3].innerText;
				
			if(hiddenBtt == 2){
				console.log(hiddenBtt);
				location.href = "${ pageContext.servletContext.contextPath }/recipe/view?number="+number;
			
			}else if(hiddenBtt == 3) {
				
				location.href = "${ pageContext.servletContext.contextPath }/freeboard/users/detail?number="+number;
				
			}else if(hiddenBtt == 4) {

				location.href = "${ pageContext.servletContext.contextPath }/suggestion/users/detail?number="+number;
			}
			
		
		
		
		}
		
	}
    
    }
    
    </script>
  
</body>
</html>