package com.homebab.users.suggestion.model.dto;

import java.sql.Date;

import com.homebab.users.login.model.dto.UsersMngDTO;

public class SuggestionDTO {
	
	private int sgtIdx;
	private String title;
	private String content;
	private char answerYn;
	private Date regDate;
	private Date modDate;
	private int memberIdx;
	private String name;
	
	public SuggestionDTO() {}

	public SuggestionDTO(int sgtIdx, String title, String content, char answerYn, Date regDate, Date modDate,
			int memberIdx, String name) {
		super();
		this.sgtIdx = sgtIdx;
		this.title = title;
		this.content = content;
		this.answerYn = answerYn;
		this.regDate = regDate;
		this.modDate = modDate;
		this.memberIdx = memberIdx;
		this.name = name;
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

	public char getAnswerYn() {
		return answerYn;
	}

	public void setAnswerYn(char answerYn) {
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

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SuggestionDTO [sgtIdx=" + sgtIdx + ", title=" + title + ", content=" + content + ", answerYn="
				+ answerYn + ", regDate=" + regDate + ", modDate=" + modDate + ", memberIdx=" + memberIdx + ", name="
				+ name + "]";
	}

	
}
