package com.homebab.users.notice.model.dto;

import java.sql.Date;

public class NoticeDTO {

	private int ntcIDx;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private String memberIdx;
	
	public NoticeDTO() {
	}

	public NoticeDTO(int ntcIDx, String title, String content, Date regDate, Date modDate, String memberIdx) {
		this.ntcIDx = ntcIDx;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.memberIdx = memberIdx;
	}

	public int getNtcIDx() {
		return ntcIDx;
	}

	public void setNtcIDx(int ntcIDx) {
		this.ntcIDx = ntcIDx;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public String getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(String memberIdx) {
		this.memberIdx = memberIdx;
	}

	@Override
	public String toString() {
		return "NoticeDTO [ntcIDx=" + ntcIDx + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", memberIdx=" + memberIdx + "]";
	}


	
	
}
