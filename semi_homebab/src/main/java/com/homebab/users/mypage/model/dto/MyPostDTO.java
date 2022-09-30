package com.homebab.users.mypage.model.dto;

import java.sql.Date;

public class MyPostDTO {
	
	private int fbIdx;
	private String name;
	private String title; 
	private Date regDate;
	private int memberIdx;
	
	public MyPostDTO() {}

	public MyPostDTO(int fbIdx, String name, String title, Date regDate, int memberIdx) {
		super();
		this.fbIdx = fbIdx;
		this.name = name;
		this.title = title;
		this.regDate = regDate;
		this.memberIdx = memberIdx;
	}

	public int getFbIdx() {
		return fbIdx;
	}

	public void setFbIdx(int fbIdx) {
		this.fbIdx = fbIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	@Override
	public String toString() {
		return "MyPostDTO [fbIdx=" + fbIdx + ", name=" + name + ", title=" + title + ", regDate=" + regDate
				+ ", memberIdx=" + memberIdx + "]";
	}


}
