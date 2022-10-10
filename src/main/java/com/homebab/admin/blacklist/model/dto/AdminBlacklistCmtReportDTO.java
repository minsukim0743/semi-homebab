package com.homebab.admin.blacklist.model.dto;

import java.util.Date;

public class AdminBlacklistCmtReportDTO {
	
	private int cmtIdx;
	private int memberIdx;
	private Date regDate;
	private String stateYn;
	
	public AdminBlacklistCmtReportDTO() {}

	public AdminBlacklistCmtReportDTO(int cmtIdx, int memberIdx, Date regDate, String stateYn) {
		super();
		this.cmtIdx = cmtIdx;
		this.memberIdx = memberIdx;
		this.regDate = regDate;
		this.stateYn = stateYn;
	}

	public int getCmtIdx() {
		return cmtIdx;
	}

	public void setCmtIdx(int cmtIdx) {
		this.cmtIdx = cmtIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getStateYn() {
		return stateYn;
	}

	public void setStateYn(String stateYn) {
		this.stateYn = stateYn;
	}

	@Override
	public String toString() {
		return "AdminBlacklistCmtReportDTO [cmtIdx=" + cmtIdx + ", memberIdx=" + memberIdx + ", regDate=" + regDate
				+ ", stateYn=" + stateYn + "]";
	}
	
	

	
	
	

}
