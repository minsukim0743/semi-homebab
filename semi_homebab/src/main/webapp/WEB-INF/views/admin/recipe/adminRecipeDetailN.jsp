<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOMEBAB</title>
<link rel="stylesheet" href="/resources/css/users/recipeDetail.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<script>
	const movePath = "/recipe/delete?rcpIdx=${ recipe.rcpIdx }";
	
	function button_event(){
		  if (confirm("정말 삭제하시겠습니까?") == true){    //확인
			  
		  location.replace(movePath);
		  
		  } else {   //취소
		      return;
		  }
		};
	</script>
	
	<!-- S: container -->
        <div class="container">
            <div class="recipe-view-wrap">
                <div class="title-box" id="recipeTitle"><c:out value="${ recipe.title }"/></div>
                <div class="category-box"><span id="recipeCategory">카테고리 &nbsp;:&nbsp;&nbsp;<c:out value="${ recipe.ctgrTit }"/></span></div>
                <div class="regdate-box"><span id="date">등록일&nbsp;&nbsp; : &nbsp;&nbsp;<c:out value="${ recipe.regDate }"/></span></div>
                <div class="writer-box"><span id="writer">등록자&nbsp;&nbsp; : &nbsp;&nbsp;<c:out value="${ recipe.nickName }"/></span></div>
                <div class="detail-box">
                    <div class="serving-box"><span id="recipeSeving"><span>몇 인분&nbsp;&nbsp;? &nbsp;&nbsp;:  &nbsp;&nbsp;</span><c:out value="${ recipe.serving }"/></span>&nbsp;&nbsp;인분</div>
                    <div class="time-box"><span id="recipeTime"><span>조리시간 &nbsp;:&nbsp;&nbsp;</span><c:out value="${ recipe.cookingTime }"/></span>분</div>
                </div>
                <div class="keyVisual-box">
                    <img src="${ recipe.fileList[0].subPath }" id="recipeKeyVisual" width="800px" height="400px"/>
                </div>
                <div class="content-box">
                    <div class="recipeContent" id="recipeContent"><c:out value="${ recipe.content }"/></div>
                </div>
                <div class="back-box" align="center">
					<button onclick="location.href='${ pageContext.servletContext.contextPath }/recipe/page'">돌아가기</button>
					<c:if test="${ sessionScope.loginUser.memberIdx eq recipe.memberIdx }">
					<button onclick="location.href='${ pageContext.servletContext.contextPath }/recipe/update?rcpIdx=${ recipe.rcpIdx }'">수정하기</button>
					<button onclick="button_event()">삭제하기</button>
					</c:if>
				</div>
            </div>
        </div>
        <!-- E: container -->
        
            <div id="form-commentInfo">
            <div id="comment-count">댓글 <span id="count">0</span></div>
            <input id="comment-input" placeholder="댓글을 입력해 주세요.">
            <button id="submit">등록</button>
            <div id=comments>
            </div>
        <script src="index.js"></script>
        </div>
        
    <script>
    //1.입력받으면 입력값 초기화
    //2. 입력값 댓글로들어가기
    //3. 댓글 삭제, 수정기능
    //4. 좋아요 투표기능
    //5. 타임스템프기능
    //6. 무작위 아이디  
    //7. 댓글 삭제기능
    //8. 댓글 수정기능

    const inputBar = document.querySelector("#comment-input");
    const rootDiv = document.querySelector("#comments");
    const btn = document.querySelector("#submit");
    const mainCommentCount = document.querySelector('#count'); //맨위 댓글 숫자 세는거.

    //타임스템프 만들기
    function generateTime(){
        const date = new Date();
        const year = date.getFullYear();
        const month = date.getMonth() + 1;
        const wDate = date.getDate();
        const hour = date.getHours();
        const min = date.getMinutes();
        const sec = date.getSeconds();

        const time = year+'-'+month+'-'+wDate+' '+hour+':'+min+':'+sec;
        return time;

    }

    //유저이름 발생기
    //유저이름은 8글자로 제한.
    function generateUserName(){
        let alphabet = 'abcdefghijklmnopqrstuvwxyz';
        var makeUsername = '';
        for(let i=0; i<4;i++){
            let index = Math.floor(Math.random(10) * alphabet.length);
            makeUsername += alphabet[index];        
        }
        for(let j=0;j<4;j++){
            makeUsername += "*";
        }
        return makeUsername;    
    }

    function numberCount(event){
        console.log(event.target);
        if(event.target === voteUp){
            console.log("2");
        return voteUp.innerHTML++; 
        
        }else if(event.target === voteDown){
        return voteDown.innerHTML++; 
        }   
        
    }

    function deleteComments(event){    
        const btn = event.target;    
        const list = btn.parentNode.parentNode;//commentList
        rootDiv.removeChild(list);
        //메인댓글 카운트 줄이기.
        if(mainCommentCount.innerHTML <='0'){
            mainCommentCount.innerHTML = 0;
        }else{
            mainCommentCount.innerHTML--;
        }
    }


    //댓글보여주기
    function showComment(comment){
        const userName = document.createElement('div');
        const inputValue = document.createElement('span');
        const showTime = document.createElement('div');
        const voteDiv = document.createElement('div');
        const countSpan = document.createElement('span')
        const voteUp = document.createElement('button');
        const voteDown = document.createElement('button');  
        const commentList = document.createElement('div');  //이놈이 스코프 밖으로 나가는 순간 하나지우면 다 지워지고 입력하면 리스트 다불러옴.
        //삭제버튼 만들기
        const delBtn = document.createElement('button');
        delBtn.className ="deleteComment";
        delBtn.innerHTML="신고";
        commentList.className = "eachComment";
        userName.className="name";
        inputValue.className="inputValue";
        showTime.className="time";
        voteDiv.className="voteDiv";
        //유저네임가져오기 
        userName.innerHTML = generateUserName();    
        userName.appendChild(delBtn);  
        //입력값 넘기기
        inputValue.innerText = comment;
        //타임스템프찍기
        showTime.innerHTML = generateTime();
        countSpan.innerHTML=0;
        //투표창 만들기, css먼저 입혀야함.  
        // voteUp.id = "voteUp";
        // voteUp.innerHTML = '↑';    
        // voteDown.id = "voteDown";
        // voteDown.innerHTML = '↓';       
        // voteDiv.appendChild(voteUp);
        // voteDiv.appendChild(voteDown);

        //댓글뿌려주기       
        commentList.appendChild(userName);
        commentList.appendChild(inputValue);
        commentList.appendChild(showTime);
        commentList.appendChild(voteDiv);
        rootDiv.prepend(commentList);

        voteUp.addEventListener("click",numberCount);
        voteDown.addEventListener("click",numberCount);
        delBtn.addEventListener("click",deleteComments);
    console.dir(rootDiv);

    }

    //버튼만들기+입력값 전달
    function pressBtn(){ 
    const currentVal = inputBar.value;
    
    if(!currentVal.length){
        alert("댓글을 입력해주세요.");
    }else{
        showComment(currentVal);  
        mainCommentCount.innerHTML++;
        inputBar.value ='';
    }
    }

    btn.onclick = pressBtn;
    
    </script>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>