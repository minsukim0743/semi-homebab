package com.homebab.admin.notice.model.dto;

import java.sql.Date;

public class NoticeDTO {

	private int ntcIdx; 
	private	String title; 
	private String content;
	private java.sql.Date regDate;
	private java.sql.Date modDate;
	private int memberIdx;
	
	public NoticeDTO() {}
	
	public NoticeDTO(int ntcIdx, String title, String content, Date regDate, Date modDate, int memberIdx) {
		super();
		this.ntcIdx = ntcIdx;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.memberIdx = memberIdx;
	}

	public int getNtcIdx() {
		return ntcIdx;
	}

	public void setNtcIdx(int ntcIdx) {
		this.ntcIdx = ntcIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	public java.sql.Date getModDate() {
		return modDate;
	}

	public void setModDate(java.sql.Date modDate) {
		this.modDate = modDate;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	@Override
	public String toString() {
		return "NoticeDTO [ntcIdx=" + ntcIdx + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", memberIdx=" + memberIdx + "]";
	} 
	
	
	
	
}
