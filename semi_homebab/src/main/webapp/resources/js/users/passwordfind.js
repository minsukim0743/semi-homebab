$(document).ready(function(){
	
	$("#pfIdBtn").on("click", function(){
		
		let pfId = $("#pfId").val();
		
		$.ajax({
			url: "/password/find",
			type: "POST",
			data: {pfId:pfId},
			success: function(data){
				
				if(!data || data == "null"){
					alert("아이디가 없습니다.");
					
					$(".pwContent div:not(:first)").css("display", "none");
					$("#pfEmail").val("");
				} else {
					
					$(".pwContent div:not(:first)").css("display", "block");
					$("#pfEmail").val(data);
				}
				
			},
			error: function(error){
				console.log(error);
			}
		});
		
	});
	
	
	$(".pfEmailBtn").on("click", function(){
		
		let pfId = $("#pfId").val();
		let pfEmail = $("#pfEmail").val();
		
		$.ajax({
			url: "/password/emailsend",
			type: "POST",
			data: {
				pfId:pfId,
				pfEmail:pfEmail
				},
			success: function(data){
				
				if(data == false){
					alert("이메일 발송에 실패했습니다.");
				} else {
					alert("이메일 발송하였습니다.");
				}
			},
			error: function(error){
				console.log(error);
			}
		});
		
	});
	
	
	$(".pfAuthNumBtn").on("click", function(){
		
		let pfId = $("#pfId").val();
		let pfAuthNum = $("#pfAuthNum").val();
		
		$.ajax({
			url: "/password/authnumcheck",
			type: "POST",
			data: {
				pfId:pfId,
				pfAuthNum:pfAuthNum
				},
			success: function(data){
				
				if(data == false){
					alert("인증번호가 틀렸습니다.");
					$(".pwResetContent").css("display", "none");
				} else {
					alert("인증번호가 일치합니다.");
					$(".pwResetContent").css("display", "block");
				}
			},
			error: function(error){
				console.log(error);
			}
		});
		
	});
	
	$(".pwModBtn").on("click", function(){
		
		let pfId = $("#pfId").val();
		let pw = $(".pw").val();
		let pwCheck = $(".pwCheck").val();
		
		if(pw == pwCheck){
			
			$.ajax({
				url: "/password/pwmodify",
				type: "POST",
				data: {
					pfId:pfId,
					pw:pw
					},
				success: function(data){
					
					if(data > 0 ){
						alert("비밀번호가 수정되었습니다.");
						location.href = "/index.jsp";
					} else {
						alert("비밀번호수정이 실패되었습니다.");
					}
				},
				error: function(error){
					console.log(error);
				}
			});
			
		} else {
			alert("비밀번호가 일치하지 않습니다.");
			$(".pwCheck").val("");
		}
		
		
	});
	
	
});