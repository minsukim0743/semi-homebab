package com.homebab.admin.blacklist.model.dto;

import java.util.Date;

public class AdminBlacklistRcpCommentsDTO {

	private int cmtIdx;
	private String cmtContent;
	private Date regDate;
	private int memberIdx;
	private int rcpIdx;
	
	public AdminBlacklistRcpCommentsDTO() {}

	public AdminBlacklistRcpCommentsDTO(int cmtIdx, String cmtContent, Date regDate, int memberIdx, int rcpIdx) {
		super();
		this.cmtIdx = cmtIdx;
		this.cmtContent = cmtContent;
		this.regDate = regDate;
		this.memberIdx = memberIdx;
		this.rcpIdx = rcpIdx;
	}

	public int getCmtIdx() {
		return cmtIdx;
	}

	public void setCmtIdx(int cmtIdx) {
		this.cmtIdx = cmtIdx;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
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

	public int getRcpIdx() {
		return rcpIdx;
	}

	public void setRcpIdx(int rcpIdx) {
		this.rcpIdx = rcpIdx;
	}

	@Override
	public String toString() {
		return "AdminBlacklistRcpCommentsDTO [cmtIdx=" + cmtIdx + ", cmtContent=" + cmtContent + ", regDate=" + regDate
				+ ", memberIdx=" + memberIdx + ", rcpIdx=" + rcpIdx + "]";
	}
	
	
	
}
