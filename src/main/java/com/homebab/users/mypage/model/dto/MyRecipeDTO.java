package com.homebab.users.mypage.model.dto;

import java.sql.Date;

/**
 * 나의 레피시 게시글 DTO
 * @author hani
 */
public class MyRecipeDTO {

	private int rcpIdx;         // 레시피 인덱
	private String title;       // 제목 
	private int memberIdx;      // 계정인덱스
	private String regDate;       // 등록일
	
	public MyRecipeDTO() {
	}
	public MyRecipeDTO(int rcpIdx, String title, int memberIdx, String regDate) {
		super();
		this.rcpIdx = rcpIdx;
		this.title = title;
		this.memberIdx = memberIdx;
		this.regDate = regDate;
	}
	public int getRcpIdx() {
		return rcpIdx;
	}
	public void setRcpIdx(int rcpIdx) {
		this.rcpIdx = rcpIdx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "MyRecipeDTO [rcpIdx=" + rcpIdx + ", title=" + title + ", memberIdx=" + memberIdx + ", regDate="
				+ regDate + "]";
	}
	
}
