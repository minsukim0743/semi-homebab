package com.homebab.users.freeboard.model.dto;

public class FreeboardFileUploadDTO {
	
	private int fileIdx;
	private String orgname;
	private String filename;
	private String path;
	private int fbIdx;
	
	public FreeboardFileUploadDTO() {
		
	}

	public FreeboardFileUploadDTO(int fileIdx, int fbIdx, String orgname, String filename, String path) {
		this.fileIdx = fileIdx;
		this.fbIdx = fbIdx;
		this.orgname = orgname;
		this.filename = filename;
		this.path = path;
	}

	public int getFileIdx() {
		return fileIdx;
	}

	public void setFileIdx(int fileIdx) {
		this.fileIdx = fileIdx;
	}

	public int getFbIdx() {
		return fbIdx;
	}

	public void setFbIdx(int fbIdx) {
		this.fbIdx = fbIdx;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "FreeboardFileUploadDTO [fileIdx=" + fileIdx + ", fbIdx=" + fbIdx + ", orgname=" + orgname
				+ ", filename=" + filename + ", path=" + path + "]";
	}

}
