function validate() {

	let suId = document.getElementById("suId");
	let suPw = document.getElementById("suPw");
	let suPwCk = document.getElementById("suPwCk");
	let suNickName = document.getElementById("suNickName");
	let suName = document.getElementById("suName");
	let suEmail = document.getElementById("suEmail");

	let suGender = document.getElementById("suGender");
	let suDate = document.getElementById("suDate");

	if (!chk(/^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/, suEmail, "이메일 형식에 어긋납니다.")) {

		return false;
	}

	if (!chk(/[0-9]/, suId, "아이디에 숫자가 하나 이상 포함합니다.")) {

		return false;
	}

	if (suPw.value != suPwCk.value) {

		alert("비밀번호가 다릅니다.");
		suPwCk.select();
		return false;
	}

	if (!chk(/^[가-힣]{2,}$/, suName, "이름은 한글로 2글자 이상을 넣으십시오.")) {

		return false;
	}

	if (suGender.options[suGender.selectedIndex].value == "") {
		alert("성별을 입력해주세요.");
		return false;
	}

	if (!chk(/./, suNickName, "닉네임을 입력해주세요.")) {

		return false;
	}
	
	let overId = document.getElementsByClassName("overId")[0].value;
	let overNickName = document.getElementsByClassName("overNickName")[0].value;
	
	if(overId == 1){
		alert("중복된 아이디가 있습니다.");
		return false;
	} 
	
	if(overNickName == 1){
		alert("중복된 닉네임이 있습니다.");
		return false;
	}

}

function chk(regExp, ele, msg) {

	if (!regExp.test(ele.value)) {
		alert(msg);
		ele.select();

		return false;
	}

	return true;
}

$(document).ready(function() {

	$("#suId").focusout(function() {

		let suId = $("#suId").val();
		let regExp = /[0-9]/;

		$.ajax({
			url: "/signup/idcheck",
			type: "POST",
			data: { suId: suId },
			success: function(data) {

				if (data == 0) {
					$(".overId").val(data);
					$(".overLapId").css("display", "none");
					$(".overUserId").css("display", "block");

					if (!regExp.test(suId)) {
						$(".overId").val("1");
						$(".overLapId").css("display", "none");
						$(".overUserId").css("display", "none");
						alert("아이디에 숫자가 하나 이상 포함합니다.");
					}

				} else {
					$(".overId").val("1");
					$(".overLapId").css("display", "block");
					$(".overUserId").css("display", "none");
				}
			},
			error: function(error) {
				console.log(error);
			}
		});
	});


	$("#suNickName").focusout(function() {

		let suNickName = $("#suNickName").val();

		if (suNickName != "") {

			$.ajax({
				url: "/signup/nicknamecheck",
				type: "POST",
				data: { suNickName: suNickName },
				success: function(data) {

					if (data == 0) {

						$(".overNickName").val(data);
						$(".overLapNickName").css("display", "none");
						$(".overUserNickName").css("display", "block");

					} else {
						$(".overNickName").val("1");
						$(".overLapNickName").css("display", "block");
						$(".overUserNickName").css("display", "none");
					}
				},
				error: function(error) {
					console.log(error);
				}
			});
			
		}
		
	});


});