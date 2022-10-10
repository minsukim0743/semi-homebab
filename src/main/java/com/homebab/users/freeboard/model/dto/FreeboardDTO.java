package com.homebab.users.freeboard.model.dto;

import java.sql.Date;
import java.util.List;

import com.homebab.users.login.model.dto.UsersMngDTO;

public class FreeboardDTO {

	private int fbIdx;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private int memberIdx;
	private String nickName;
	private String name;
	private int count;
	private List<FreeboardFileUploadDTO> fileList;

	public FreeboardDTO() {
	}

	public FreeboardDTO(int fbIdx, String title, String content, Date regDate, Date modDate, int memberIdx,
			String nickName, String name, int count, List<FreeboardFileUploadDTO> fileList) {
		super();
		this.fbIdx = fbIdx;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.memberIdx = memberIdx;
		this.nickName = nickName;
		this.name = name;
		this.count = count;
		this.fileList = fileList;
	}

	public int getFbIdx() {
		return fbIdx;
	}

	public void setFbIdx(int fbIdx) {
		this.fbIdx = fbIdx;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<FreeboardFileUploadDTO> getFileList() {
		return fileList;
	}

	public void setFileList(List<FreeboardFileUploadDTO> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "FreeboardDTO [fbIdx=" + fbIdx + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", memberIdx=" + memberIdx + ", nickName=" + nickName + ", name=" + name
				+ ", count=" + count + ", fileList=" + fileList + "]";
	}

	
}