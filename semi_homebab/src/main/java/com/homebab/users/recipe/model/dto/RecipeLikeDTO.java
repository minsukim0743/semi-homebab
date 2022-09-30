package com.homebab.users.recipe.model.dto;

public class RecipeLikeDTO {

	private int rcpIdx; // 레시피 인덱스
	private int memberIdx; // 사용자 인덱스
	private String stateYn; // 클릭 여부
	
	public RecipeLikeDTO() {}

	public int getRcpIdx() {
		return rcpIdx;
	}

	public void setRcpIdx(int rcpIdx) {
		this.rcpIdx = rcpIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getStateYn() {
		return stateYn;
	}

	public void setStateYn(String stateYn) {
		this.stateYn = stateYn;
	}

	@Override
	public String toString() {
		return "RecipeLikeDTO [rcpIdx=" + rcpIdx + ", memberIdx=" + memberIdx + ", stateYn=" + stateYn + "]";
	}
	
}
