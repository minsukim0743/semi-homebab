<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>homebab notice page</title>
    <link rel="stylesheet" href="../css/header_footer.css">
    <link rel="stylesheet" href="../css/notice.css">
    <link rel="stylesheet" href="../homebab_hm/css/style.css">
</head>
<body>
<jsp:forward page="/notice/list">

	<div id="visual" style="width: 800px;">
        <ul id = "noticeboard" style="position: relative; left:400px ;">
            <!-- 게시판 제목 -->

           	<h2 align="center">  N O T I C E  </h2>
            <br>
            <h3 align="center"> 공 지 사 항 </h3>
            <br>
            <hr style="color: #289F5D; width: 800px;">
            <!-- 게시판 목록  -->
           
			<c:forEach items= "${ noticeList }" var="notice">
	            <div clsss="noticeListSelect">
	            	<div><c:out value="${ notice.registDate }"/></div>
	            	<div><c:out value="${ notice.title }"/></div>
	            	<div><c:out value="${ notice.writer.nickname }"/></div>
	            </div>
            </c:forEach>
            
            <div>
            <div style="width : 750px; height: 50px;text-align: left; font-size: 14px;">22.22.22 <br> [ 공지 ] 뭐를 넣을까여?? </div>
            </div>
            <div>
            <div style="width : 750px; height: 50px; background-color: #74B243 ; opacity: 0.2;text-align: left; font-size: 10px;">22.22.22 <br> [ 공지 ] 뭐를 넣을까여??</div>                
            </div>
            <br>
            
            <!-- 관리자인 경우에만 작성하기 버튼 on -->
            <c:if test="${ sessionScope.loginMember.role eq 'ADMIN' }">
				<button id="writeNotice">작성하기</button>
			</c:if>
            <!-- 게시판 페이징 영역 -->
           
        
            <div class="page-wrap">
                <ul class="page-nation">
                    <li><a href="/board/list?p=1">1</a></li>
                    <li><a href="/board/list?p=2">2</a></li>
                    <li><a href="/board/list?p=3">3</a></li>
                    <li><a href="/board/list?p=4">4</a></li>
                    <!-- <div><button type="button" onclick="history.back();">▶</div> -->
                </ul>
            </div>
		<!-- onclick="location.href='${ pageContext.servletContext.contextPath}'"-->
        <a href="/notice/noticeInsert.jsp"><button type="button" style="position: relative; left: 800px; width:80px; height: 35px;" >등록</button></a>

	</div>
<!-- <script>
	if(document.getElementsByTegName)

</script> -->
	


</body>
</html>