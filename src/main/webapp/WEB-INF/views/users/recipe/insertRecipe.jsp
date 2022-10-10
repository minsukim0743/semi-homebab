<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
   <!-- jquery cdn -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
   <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
   <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
   <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
   <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
   <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
   
    <!-- CSS -->
    <link href="/resources/css/users/insertRecipe.css" rel="stylesheet">
    
</head>
<body>
    <script>
    $(document).ready(function() {
        //여기 아래 부분
        $('#board_content').val("${board_data.BOARD_CONTENT}");
        $('#board_content').summernote({
              height: 300,                 // 에디터 높이
              minHeight: null,             // 최소 높이
              maxHeight: null,             // 최대 높이
              focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
              lang: "ko-KR",               // 한글 설정
              placeholder: '예) 요리순서 및 조리방법',   //placeholder 설정
            	  callbacks: {
      	        	onImageUpload: function(files, editor, welEditable) {
      	        		for(var i = files.length -1; i>=0; i--) {
      	        			sendFile(files[i], this);
      	        		}
      	        	}
      	        }
        });
    
    });
    </script>
    
    
</head>
<body>
 <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <!-- S: container -->
        <div class="container">
            <div class="title-box">레시피 등록</div>

            <div class="recipe-wrap">
	            <form action="/recipe/insert" method="post" encType="multipart/form-data">
	                <table cellpadding="0" cellspacing="0">
	                    <colgroup>
	                        <col style="width: 25%;">
	                        <col>
	                    </colgroup>
	                    <tr>
	                        <th><label for="recipeTitle" class="form-name" name="form-name">레시피 명</label></th>
	                        <td><input type="text" class="name" id="recipeTitle" name="recipeTitle" placeholder="예) 미역국"></td>
	                    </tr>
	                    <tr>
	                        <th><label for="recipeContent" class="form-content" name="form-content">내용</label></th>
	                        <td>
	                            <table>
	                                <tr>
	                                    <td colspan="2">
	                                    <textarea id="summernote" name="content"></textarea>
	                                    </td>
	                                </tr>
	                            </table>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th><label for="recipeServing">몇인분</label></th>
	                        <td><input id="recipeServing" type="number" min="0" max="100" step="1" name="recipeServing" placeholder="인분">인분
	                        </td>
	                    </tr>
	                    <tr>
	                        <th><lable for="recipeTime">조리시간</lable></th>
	                        <td><input id="recipeTime" type="number" min="0" max="100" step="5" name="cookingTime" placeholder="분">분
	                        </td>
	                    </tr>
	                    <tr>
	                        <th><label for="recipeCategory">레시피 카테고리</label></th>
	                        <td>
	                            <select id="recipeCategory" name="category">
	                                <option value=""selected>카테고리</option>
		                                <option value="1">일반식</option>
		                                <option value="2">3분요리</option>
		                                <option value="3">야식</option>
		                                <option value="4">다이어트</option>
	                            </select>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th><label for="recipeKeyVisual" class="picture">요리 대표사진</label></th>
	                        <td><input type="file" id="recipeKeyVisual" name="recipeKeyVisual"></td>
	                    </tr>
	                </table>
	                <div class="cta-outer">
	                    <button type="submit">등록</button>
	                </div>
	            </form>
            </div>
        </div>
        <!-- E: container -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>