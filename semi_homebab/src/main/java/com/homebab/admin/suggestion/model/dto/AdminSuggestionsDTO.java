package com.homebab.admin.suggestion.model.dto;

import java.util.Date;

import com.homebab.admin.member.model.dto.AdminMemberDTO;

public class AdminSuggestionsDTO {
	private int sgtIdx;
	private String title;
	private String content;
	private int memberIdx;
	private String answerYn;
	private Date regDate;
	private Date modDate;
	private AdminMemberDTO amDTO;
	
	public AdminSuggestionsDTO() {}

	public AdminSuggestionsDTO(int sgtIdx, String title, String content, int memberIdx, String answerYn, Date regDate,
			Date modDate, AdminMemberDTO amDTO) {
		super();
		this.sgtIdx = sgtIdx;
		this.title = title;
		this.content = content;
		this.memberIdx = memberIdx;
		this.answerYn = answerYn;
		this.regDate = regDate;
		this.modDate = modDate;
		this.amDTO = amDTO;
	}

	public int getSgtIdx() {
		return sgtIdx;
	}

	public void setSgtIdx(int sgtIdx) {
		this.sgtIdx = sgtIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getAnswerYn() {
		return answerYn;
	}

	public void setAnswerYn(String answerYn) {
		this.answerYn = answerYn;
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

	public AdminMemberDTO getAmDTO() {
		return amDTO;
	}

	public void setAmDTO(AdminMemberDTO amDTO) {
		this.amDTO = amDTO;
	}

	@Override
	public String toString() {
		return "AdminSuggestionsDTO [sgtIdx=" + sgtIdx + ", title=" + title + ", content=" + content + ", memberIdx="
				+ memberIdx + ", answerYn=" + answerYn + ", regDate=" + regDate + ", modDate=" + modDate + ", amDTO="
				+ amDTO + "]";
	}

	
}
