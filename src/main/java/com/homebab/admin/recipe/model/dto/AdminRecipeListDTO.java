package com.homebab.admin.recipe.model.dto;

import java.util.Date;

import com.homebab.admin.member.model.dto.AdminMemberDTO;

public class AdminRecipeListDTO {
	
	private int rcpIdx;
	private String title;
	private String regDate;
	private String aprState;
	private String stateYn;
	private AdminMemberDTO amDTO;
	
	public AdminRecipeListDTO() {}

	public AdminRecipeListDTO(int rcpIdx, String title, String regDate, String aprState, String stateYn,
			AdminMemberDTO amDTO) {
		super();
		this.rcpIdx = rcpIdx;
		this.title = title;
		this.regDate = regDate;
		this.aprState = aprState;
		this.stateYn = stateYn;
		this.amDTO = amDTO;
	}

	public int getRcpIdx() {
		return rcpIdx;
	}

	public void setRcpIdx(int rcpIdx) {
		this.rcpIdx = rcpIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getAprState() {
		return aprState;
	}

	public void setAprState(String aprState) {
		this.aprState = aprState;
	}

	public String getStateYn() {
		return stateYn;
	}

	public void setStateYn(String stateYn) {
		this.stateYn = stateYn;
	}

	public AdminMemberDTO getAmDTO() {
		return amDTO;
	}

	public void setAmDTO(AdminMemberDTO amDTO) {
		this.amDTO = amDTO;
	}

	@Override
	public String toString() {
		return "AdminRecipeListDTO [rcpIdx=" + rcpIdx + ", title=" + title + ", regDate=" + regDate + ", aprState="
				+ aprState + ", stateYn=" + stateYn + ", amDTO=" + amDTO + "]";
	}
	
	
	
}
