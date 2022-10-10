package com.homebab.users.member.model.dto;

import java.sql.Date;

public class MemberMngDTO {
	private int memberIdx;  // 계정인덱스
	private int memberSort; // 계정구분
	private Date regDate;   // 등록일
	private Date modDate;   // 수정일
	private char useYn;     // 사용여부
	
	public MemberMngDTO() {}

	public MemberMngDTO(int memberIdx, int memberSort, Date regDate, Date modDate, char useYn) {
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

	public char getUseYn() {
		return useYn;
	}

	public void setUseYn(char useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "MemberMngDTO [memberIdx=" + memberIdx + ", memberSort=" + memberSort + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", useYn=" + useYn + "]";
	}
	
}
