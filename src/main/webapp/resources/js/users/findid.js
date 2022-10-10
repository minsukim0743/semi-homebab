$(document).ready(function(){
	
	$(".findSend").on("click", function(){
		
		let findId = $("#findId").val();
		let findDate = $("#findDate").val();
		
		let data = {
			findId : findId,
			findDate : findDate
		}
		
		$.ajax({
			url: "/findid",
			type: "POST",
			data: data,
			success: function(data){
				console.log(data);
				console.log(data.userId);
				if(data != null){
					
					let id = data.userId;
					console.log(id);
					let url = "/login/openfindid?userId="+id;
					
					window.open(url, "HOMEBAB", "top=100, left=100, height=200, width=500, status=no, menubar=no, toolbar=no, resizable=no");
					
				} else {
					alter("해당 아이디가 없습니다.");
				}
				
			},
			error: function(error){
				console.log(error);
			}
		});
		
	});
	
	$(".findMain").on("click", function(){
		
		location.href = "/index.jsp";
		
	});
	
});