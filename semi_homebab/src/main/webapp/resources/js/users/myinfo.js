/* 닉네임 중복체크 스크립트  */
	$("#nickName").focusout(function(){
			
		const nickName = $("#nickName").val();
		console.log(nickName);
		$.ajax({
			url: "/myinfo/nickname/check",
			type: "get",
			data: {
				nickName : nickName
			}, 
			success: function(data) {
				
				if(data == 'true'){
						
					alert("사용가능한 닉네임 입니다. ")
					$("#nickNameHidden").val("Y");
					console.log($("#nickNameHidden").val());
		
				} else {
						
					alert("중복된 닉네임 입니다.");
						
					}
				},
			error: function(error) {
					
				console.log(error);
			}
		});
	});
	
/* 아이디,이메일,비밀번호 설정 정규표현식 */

function validate() {
     let nickName = document.getElementById("nickName");
     let userId = document.getElementById("userId");
     let email = document.getElementById("email");
     let password1 = document.getElementById("password1");
     let password2 = document.getElementById("password2");
     let password3 = document.getElementById("password3");
         
        if (
          !chk(
            /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/,
            email,
            "이메일 형식에 어긋납니다."
          )
        ) {
          return false;
        }

        if (
          !chk(
            /^[a-z][a-z\d]{3,11}$/,
            userId,
            "아이디의 첫글자는 영문 소문자, 4~12자로 입력할 것!"
          )
        ) {
          return false;
        }
        if (!chk(/[0-9]/, userId, "아이디에 숫자가 하나 이상 포함!")) {
          return false;
        }

       
        if (password2.value != password3.value) {
          alert("비밀번호가 다릅니다.");
          password3.select();
          return false;
        }
        
	
	

/* 회원탈퇴 script */
$("#withdrawal").click(function(){
	const withdrawal = confirm('삭제하시면 복구 할 수 없습니다. 정말로 삭제하시겠습니까??');
	console.log(withdrawal);
		
	let sessionId = "user01";
		
	if(withdrawal == true) {
			
		$.ajax({
			url: "/users/withdrawal",
			type: "post",
			data: {
				sessionId : sessionId
			}, 
				
			success: function(data) {
					
				console.log(data);
					
				if(data == 'true'){
						
					alert("회원탈퇴가 완료 되었습니다:)");
						
						
						
						
				} else {
						
					alert("회원탈퇴에 실패하였습니다.");
						
						
				}
			},
			
		error: function(error) {
				
			console.log(error);
		},	
	
});
}
});
	
/* 유저 정보저장 처리 script */
$("#userInfoSave").click(function(){
		
	if($("#nickNameHidden").val() == 'Y') {
		console.log("hidden통과했습니다. ");

			
		if($("#password2").val() == $("#password3").val()) {
			console.log("password2 통과 ");
			
			const nickName = $("#nickName").val();
			const name = $("#name").val();
			const email = $("#email").val();
			const userPwd = $("#password2").val();
			const gender = $("#gender").val();
			const birth = $("#birthDate").val();
				
			$.ajax({
					
				   url: "/user/info/save",
			       type: "post",
			       data: {
						nickName : nickName,
						name : name,
						email : email,
						userPwd : userPwd,
						gender : gender,
						birth : birth
						},
				    	   
			    	   success: function(data) {
								
				   console.log(data);			
				   alert("회원정보가 저장되었습니다:)");
					   
			    	   },
						
					error: function(error) {
							
						console.log(error);
						alert("회원정보가 저장에 실패하였습니다.");
				   },	
						
			}); /* e: ajax */
		} /* e: 패스워드 if */ else {
			
			alert("변경하실 비밀번호가 다릅니다 다시 입력해주세요.")
				
		} /* e: 패스워드 else */	
	} /* e: 닉네임 중복 if */ else {	
			
		alert("닉네임이 중복되었습니다 다시 입력해주세요. ")	
		
	} /* e: 닉네임 중복 else */
});/* e: click.function  */
}