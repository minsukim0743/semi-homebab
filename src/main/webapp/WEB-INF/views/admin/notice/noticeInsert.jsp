<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homebab admin notice page</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>


</head>
<body>
<jsp:forward page="/notice/insert">
        <div class="outer outer-notice-insert">
            <div style="text-align: center; margin-top: 50px; font-size: 20px;">
               공지사항 등록
            </div>
            <br><br>
            <textarea class="summernote" name="editordata" ></textarea>    
          </div>
          <script>
          $('.summernote').summernote({
                    
                   
                    height: 400,                 // 에디터 높이
                    minHeight: null,             // 최소 높이
                    maxHeight: null,             // 최대 높이
                    focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
                    lang: "ko-KR",					// 한글 설정
                    placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
            // toolbar: [
			//     // [groupName, [list of button]]
			//     ['fontname', ['fontname']],
			//     ['fontsize', ['fontsize']],
			//     ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			//     ['color', ['forecolor','color']],
			//     ['table', ['table']],
			//     ['para', ['ul', 'ol', 'paragraph']],
			//     ['height', ['height']],
			//     ['insert',['picture','link','video']],
			//     ['view', ['fullscreen', 'help']]
			//   ],
			// fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			// fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']

              });
          </script>
        <!-- footer start -->
        <hr>`
       <a href="../html/freeboard.html"><button type="button" style="position: relative; left: 1300px; width:80px; height: 35px;" >등록</button></a>

        <br><br><br>
        


</body>
</html>