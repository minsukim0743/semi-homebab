package com.homebab.admin.login.model.dto;

public class AdminDTO {
	
	private int memberIdx;
	private String userId;
	private String userPwd;
	private String name;
	
	public AdminDTO() {}

	public AdminDTO(int memberIdx, String userId, String userPwd, String name) {
		super();
		this.memberIdx = memberIdx;
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
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

	@Override
	public String toString() {
		return "AdminDTO [memberIdx=" + memberIdx + ", userId=" + userId + ", userPwd=" + userPwd + ", name=" + name
				+ "]";
	}

	
}
