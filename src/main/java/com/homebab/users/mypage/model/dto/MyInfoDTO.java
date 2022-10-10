package com.homebab.users.mypage.model.dto;

import java.sql.Date;

public class MyInfoDTO {
	private int memberIdx;
	private String nickName;
	private String userId;
	private String name;
	private String email;
	private String userPwd;
	private String gender;
	private Date birth;
	
	public MyInfoDTO() {}
	
	public MyInfoDTO(int memberIdx, String nickName, String userId, String name, String email, String userPwd,
			String gender, Date birth) {
		super();
		this.memberIdx = memberIdx;
		this.nickName = nickName;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.userPwd = userPwd;
		this.gender = gender;
		this.birth = birth;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "WithdrawalDTO [memberIdx=" + memberIdx + ", nickName=" + nickName + ", userId=" + userId + ", name="
				+ name + ", email=" + email + ", userPwd=" + userPwd + ", gender=" + gender + ", birth=" + birth + "]";
	}
	
	
	
	
	
	
}
