package com.homebab.users.mypage.model.dto;

import java.sql.Date;

/**
 * MEMBER_MNG 데이터 DTO
 * @author hani
 *
 */
public class MemberMngDTO {
	
	private int memberIdx;
	private int memberSort;
	private Date regDate;
	private Date mod_Date;
	private String useYn;
	
	public MemberMngDTO() {}
	
	public MemberMngDTO(int memberIdx, int memberSort, Date regDate, Date mod_Date, String useYn) {
		super();
		this.memberIdx = memberIdx;
		this.memberSort = memberSort;
		this.regDate = regDate;
		this.mod_Date = mod_Date;
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
	public Date getMod_Date() {
		return mod_Date;
	}
	public void setMod_Date(Date mod_Date) {
		this.mod_Date = mod_Date;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	
	@Override
	public String toString() {
		return "MemberMngDTO [memberIdx=" + memberIdx + ", memberSort=" + memberSort + ", regDate=" + regDate
				+ ", mod_Date=" + mod_Date + ", useYn=" + useYn + "]";
	}
	
	
	
}
