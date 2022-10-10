package com.homebab.admin.member.model.dto;

import java.util.Date;

public class AdminMemberMngDTO {
	
	private int memberIdx;
	private int memberSort;
	private Date regDate;
	private Date modDate;
	private String useYn;
	
	public AdminMemberMngDTO() {}

	public AdminMemberMngDTO(int memberIdx, int memberSort, Date regDate, Date modDate, String useYn) {
		super();
		this.memberIdx = memberIdx;
		this.memberSort = memberSort;
		this.regDate = regDate;
		this.modDate = modDate;
		this.useYn = useYn;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getMemberSort() {
		return memberSort;
	}

	public void setMemberSort(int memberSort) {
		this.memberSort = memberSort;
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

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "AdminMemberMngDTO [memberIdx=" + memberIdx + ", memberSort=" + memberSort + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", useYn=" + useYn + "]";
	}
}
