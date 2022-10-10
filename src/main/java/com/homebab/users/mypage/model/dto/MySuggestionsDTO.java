package com.homebab.users.mypage.model.dto;

import java.sql.Date;

/**
 * @author hani
 *<pre>
 *  SUGGESTION DTO 나의 건의사항 게시물 조회용 DTO
 *</pre>
 */
public class MySuggestionsDTO {

	private int sgtIdx;     // 건의사항 인덱스 
	private String title;   // 제목 
	private Date regDate;   // 등록일 
	private int memberIdx;  // 멤버 인덱스
	
	public MySuggestionsDTO() {
	}
	
	public MySuggestionsDTO(int sgtIdx, String title, Date regDate, int memberIdx) {
		super();
		this.sgtIdx = sgtIdx;
		this.title = title;
		this.regDate = regDate;
		this.memberIdx = memberIdx;
	}
	public int getSgtIdx() {
		return sgtIdx;
	}
	public void setSgtIdx(int sgtIdx) {
		this.sgtIdx = sgtIdx;
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
		return "MySuggestionsDTO [sgtIdx=" + sgtIdx + ", title=" + title + ", regDate=" + regDate + ", memberIdx="
				+ memberIdx + "]";
	}
	
	
}
