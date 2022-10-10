package com.homebab.users.recipe.model.dto;

import java.sql.Date;
import java.util.List;

import com.homebab.users.login.model.dto.UsersMngDTO;

public class RecipeDTO {
	
	private int rcpIdx;			// 레시피 인덱스
	private String title;		// 제목
	private String content;		// 내용
	private int memberIdx;	// 계정인덱스
	private String regDate;		// 등록일
	private Date modDate;		// 수정일
	private int viewCnt;		// 조회수
	private int likeCnt;		// 좋아요
	private int ctgrIdx; // 카테고리 인덱스
	private String aprState;	// 승인여부
	private char stateYn;		// 상태여부
	private int serving;		// 인분
	private int cookingTime;	// 조리시간
	private CategoryDTO ctgrTit; // 카테고리 타이틀
	private List<RecipeFileUploadDTO> fileList; // 첨부파일 리스트
	private List<CategoryDTO> category; // 카테고리인덱스
	private UsersMngDTO nickName; // 닉네임
	
	public RecipeDTO() {}
	
	public RecipeDTO(int rcpIdx, String title, String content, int memberIdx, String regDate, Date modDate, int viewCnt,
			int likeCnt, int ctgrIdx, String aprState, char stateYn, int serving, int cookingTime, CategoryDTO ctgrTit,
			List<RecipeFileUploadDTO> fileList, List<CategoryDTO> category, UsersMngDTO nickName) {
		this.rcpIdx = rcpIdx;
		this.title = title;
		this.content = content;
		this.memberIdx = memberIdx;
		this.regDate = regDate;
		this.modDate = modDate;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.ctgrIdx = ctgrIdx;
		this.aprState = aprState;
		this.stateYn = stateYn;
		this.serving = serving;
		this.cookingTime = cookingTime;
		this.ctgrTit = ctgrTit;
		this.fileList = fileList;
		this.category = category;
		this.nickName = nickName;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getCtgrIdx() {
		return ctgrIdx;
	}

	public void setCtgrIdx(int ctgrIdx) {
		this.ctgrIdx = ctgrIdx;
	}

	public String getAprState() {
		return aprState;
	}

	public void setAprState(String aprState) {
		this.aprState = aprState;
	}

	public char getStateYn() {
		return stateYn;
	}

	public void setStateYn(char stateYn) {
		this.stateYn = stateYn;
	}

	public int getServing() {
		return serving;
	}

	public void setServing(int serving) {
		this.serving = serving;
	}

	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}

	public CategoryDTO getCtgrTit() {
		return ctgrTit;
	}

	public void setCtgrTit(CategoryDTO ctgrTit) {
		this.ctgrTit = ctgrTit;
	}

	public List<RecipeFileUploadDTO> getFileList() {
		return fileList;
	}

	public void setFileList(List<RecipeFileUploadDTO> fileList) {
		this.fileList = fileList;
	}

	public List<CategoryDTO> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryDTO> category) {
		this.category = category;
	}

	public UsersMngDTO getNickName() {
		return nickName;
	}

	public void setNickName(UsersMngDTO nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "RecipeDTO [rcpIdx=" + rcpIdx + ", title=" + title + ", content=" + content + ", memberIdx=" + memberIdx
				+ ", regDate=" + regDate + ", modDate=" + modDate + ", viewCnt=" + viewCnt + ", likeCnt=" + likeCnt
				+ ", ctgrIdx=" + ctgrIdx + ", aprState=" + aprState + ", stateYn=" + stateYn + ", serving=" + serving
				+ ", cookingTime=" + cookingTime + ", fileList=" + fileList + ", category=" + category + ", nickName=" + nickName;
	}


		
}
