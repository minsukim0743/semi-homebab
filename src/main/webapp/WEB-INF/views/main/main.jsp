<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>HOMEBAB</title>
    <!-- mainPage CSS -->
    <link rel="stylesheet" href="/resources/css/common/mainPage.css">
    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>	
    <div id="wrap">
    
    <div id="visual"> <!-- visual start -->
        <!-- Swiper -->
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
          <div class="swiper-slide"><a href="https://www.youtube.com/c/paikscuisine"><img src="/resources/images/common/slide1.JPG"></a></div>
          <div class="swiper-slide"><a href="https://www.youtube.com/channel/UC4Icothd_W0M7jRzNyAszoA"><img src="/resources/images/common/slide2.JPG"></a></div>
          <div class="swiper-slide"><a href="https://www.youtube.com/channel/UCC9pQY_uaBSa0WOpMNJHbEQ"><img src="/resources/images/common/slide3.JPG"></a></div>
          <div class="swiper-slide"><a href="https://www.youtube.com/channel/UCUsoowBBnGAmhl0XBaFuQWA"><img src="/resources/images/common/slide4.JPG"></a></div>
          <div class="swiper-slide"><a href="https://www.youtube.com/c/yasigi"><img src="/resources/images/common/slide5.JPG"></a></div>
        </div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
      </div>
  
      <!-- Swiper JS -->
      <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  
      <!-- Initialize Swiper -->
      <script>
        var swiper = new Swiper(".mySwiper", {
          rewind: true,
          navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
          },
        });
      </script>
    </div>  <!-- visual End-->  

    <hr>
    <br><br>
    	<!-- content start -->
	    <div id="content">
	        <ul>
	            <li class="recommend" style="font-size: 20px;">추천 레시피</li>
	        </ul>
    		<c:forEach var="selectLikeRecipeList" items="${ requestScope.selectLikeRecipeList}" begin="0" end="4">	
		    <div class="gallery">
		          <img src="${ selectLikeRecipeList.fileList[0].subPath }" onclick="location.href='/recipeComments/view?rcpIdx=${ selectLikeRecipeList.rcpIdx }'" width="500" height="300" style="cursor:pointer;">
		    	  <div class="desc"><c:out value="${ selectLikeRecipeList.title }"/></div>
		    </div>
		    </c:forEach>
	    </div>
	    <!-- content End-->  
		
	
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
