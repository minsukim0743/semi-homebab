package com.homebab.users.recipe.model.dto;

import java.util.Date;

import com.homebab.users.member.model.dto.UsersMngDTO;

public class RecipeCommentsDTO {
	
	private int cmtIdx;
	private String cmtContent;
	private Date regDate;
	private int memberIdx;
	private int rcpIdx;
	private UsersMngDTO umDTO;
	private RecipeCmtReportDTO cmtReportDTO;
	
	public RecipeCommentsDTO() {}

	public RecipeCommentsDTO(int cmtIdx, String cmtContent, Date regDate, int memberIdx, int rcpIdx, UsersMngDTO umDTO,
			RecipeCmtReportDTO cmtReportDTO) {
		super();
		this.cmtIdx = cmtIdx;
		this.cmtContent = cmtContent;
		this.regDate = regDate;
		this.memberIdx = memberIdx;
		this.rcpIdx = rcpIdx;
		this.umDTO = umDTO;
		this.cmtReportDTO = cmtReportDTO;
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

	public UsersMngDTO getUmDTO() {
		return umDTO;
	}

	public void setUmDTO(UsersMngDTO umDTO) {
		this.umDTO = umDTO;
	}

	public RecipeCmtReportDTO getCmtReportDTO() {
		return cmtReportDTO;
	}

	public void setCmtReportDTO(RecipeCmtReportDTO cmtReportDTO) {
		this.cmtReportDTO = cmtReportDTO;
	}

	@Override
	public String toString() {
		return "RecipeCommentsDTO [cmtIdx=" + cmtIdx + ", cmtContent=" + cmtContent + ", regDate=" + regDate
				+ ", memberIdx=" + memberIdx + ", rcpIdx=" + rcpIdx + ", umDTO=" + umDTO + ", cmtReportDTO="
				+ cmtReportDTO + "]";
	}

	
}
