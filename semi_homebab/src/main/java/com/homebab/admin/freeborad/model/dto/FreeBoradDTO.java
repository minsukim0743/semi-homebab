package com.homebab.admin.freeborad.model.dto;

import java.sql.Date;

import com.homebab.users.member.model.dto.UsersMngDTO;

public class FreeBoradDTO {
	private int pbIdx;
	private String title;
	private String content;
	private Date regDate;
	private String name;
	private UsersMngDTO umDTO;
	
	public FreeBoradDTO() {}
	
	public FreeBoradDTO(int pbIdx, String title, String content, Date regDate, String name, UsersMngDTO umDTO) {
		super();
		this.pbIdx = pbIdx;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.name = name;
		this.umDTO = umDTO;
	}

	public int getPbIdx() {
		return pbIdx;
	}

	public void setPbIdx(int pbIdx) {
		this.pbIdx = pbIdx;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UsersMngDTO getUmDTO() {
		return umDTO;
	}

	public void setUmDTO(UsersMngDTO umDTO) {
		this.umDTO = umDTO;
	}

	@Override
	public String toString() {
		return "FreeBoradDTO [pbIdx=" + pbIdx + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", name=" + name + ", umDTO=" + umDTO + "]";
	}
	
	

}

	
	
	
	