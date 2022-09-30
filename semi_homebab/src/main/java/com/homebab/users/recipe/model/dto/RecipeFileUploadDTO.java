package com.homebab.users.recipe.model.dto;

public class RecipeFileUploadDTO {

	private int fileIdx; // 파일인덱스
	private String orgName; // 원본이름
	private String changeFileName; // 변경이름
	private String mainPaht; // 메인경로
	private String subPath; // 서브경로
	private int rcpIdx; // 레시피인덱스
	
	public RecipeFileUploadDTO() {}

	public RecipeFileUploadDTO(int fileIdx, String orgName, String changeFileName, String mainPaht, String subPath,
			int rcpIdx) {
		this.fileIdx = fileIdx;
		this.orgName = orgName;
		this.changeFileName = changeFileName;
		this.mainPaht = mainPaht;
		this.subPath = subPath;
		this.rcpIdx = rcpIdx;
	}

	public int getFileIdx() {
		return fileIdx;
	}

	public void setFileIdx(int fileIdx) {
		this.fileIdx = fileIdx;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getChangeFileName() {
		return changeFileName;
	}

	public void setChangeFileName(String changeFileName) {
		this.changeFileName = changeFileName;
	}

	public String getMainPaht() {
		return mainPaht;
	}

	public void setMainPaht(String mainPaht) {
		this.mainPaht = mainPaht;
	}

	public String getSubPath() {
		return subPath;
	}

	public void setSubPath(String subPath) {
		this.subPath = subPath;
	}

	public int getRcpIdx() {
		return rcpIdx;
	}

	public void setRcpIdx(int rcpIdx) {
		this.rcpIdx = rcpIdx;
	}

	@Override
	public String toString() {
		return "RecipeFileUploadDTO [fileIdx=" + fileIdx + ", orgName=" + orgName + ", changeFileName=" + changeFileName
				+ ", mainPaht=" + mainPaht + ", subPath=" + subPath + ", rcpIdx=" + rcpIdx + "]";
	}
	
}
