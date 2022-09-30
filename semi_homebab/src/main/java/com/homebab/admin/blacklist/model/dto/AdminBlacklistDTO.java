package com.homebab.admin.blacklist.model.dto;

import java.util.Date;

public class AdminBlacklistDTO {
	
	private int memberIdx;
	private int regMemIdx;
	private Date regDate;
	private Date modDate;
	
	public AdminBlacklistDTO() {}

	public AdminBlacklistDTO(int memberIdx, int regMemIdx, Date regDate, Date modDate) {
		super();
		this.memberIdx = memberIdx;
		this.regMemIdx = regMemIdx;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getRegMemIdx() {
		return regMemIdx;
	}

	public void setRegMemIdx(int regMemIdx) {
		this.regMemIdx = regMemIdx;
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

	@Override
	public String toString() {
		return "AdminBlacklistDTO [memberIdx=" + memberIdx + ", regMemIdx=" + regMemIdx + ", regDate=" + regDate
				+ ", modDate=" + modDate + "]";
	}
}
