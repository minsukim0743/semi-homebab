package com.homebab.users.recipe.model.dto;

public class RecipeCmtReportDTO {
	
	private int cmtIdx;
	private int memberIdx;
	private int regDate;
	private String stateYn;
	
	public RecipeCmtReportDTO() {}

	public RecipeCmtReportDTO(int cmtIdx, int memberIdx, int regDate, String stateYn) {
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

	public int getRegDate() {
		return regDate;
	}

	public void setRegDate(int regDate) {
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
		return "RecipeCmtReportDTO [cmtIdx=" + cmtIdx + ", memberIdx=" + memberIdx + ", regDate=" + regDate
				+ ", stateYn=" + stateYn + "]";
	}

	
}
