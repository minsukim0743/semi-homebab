package com.homebab.admin.blacklist.model.dto;

import java.util.Date;

public class AdminBlacklistMemberDTO {
	
	private int memberIdx;
	private String userId;
	private String userPwd;
	private String name;
	private String nickName;
	private String email;
	private Date birth;
	private String gender;
	private String authNum;
	
	public AdminBlacklistMemberDTO() {}

	public AdminBlacklistMemberDTO(int memberIdx, String userId, String userPwd, String name, String nickName,
			String email, Date birth, String gender, String authNum) {
		super();
		this.memberIdx = memberIdx;
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.authNum = authNum;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAuthNum() {
		return authNum;
	}

	public void setAuthNum(String authNum) {
		this.authNum = authNum;
	}

	@Override
	public String toString() {
		return "AdminBlacklistMemberDTO [memberIdx=" + memberIdx + ", userId=" + userId + ", userPwd=" + userPwd
				+ ", name=" + name + ", nickName=" + nickName + ", email=" + email + ", birth=" + birth + ", gender="
				+ gender + ", authNum=" + authNum + "]";
	}
	
	
	
}
