package com.homebab.users.login.model.dto;

import java.sql.Date;

public class UsersMngDTO {
	private int memberIdx;
	private String userId;			// 아이디
	private String userPwd;			// 비밀번호
	private String name;			// 이름
	private String nickName;		// 닉네임
	private String email;			// 이메일
	private Date birth;			// 생년월일
	private char gender;			// 성별
	private int authNum;			// 인증번호
	
	public UsersMngDTO() {}

	public UsersMngDTO(int memberIdx, String userId, String userPwd, String name, String nickName, String email,
			Date birth, char gender, int authNum) {
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAuthNum() {
		return authNum;
	}

	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}

	@Override
	public String toString() {
		return nickName;
	}

}