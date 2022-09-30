package com.homebab.users.recipe.model.dto;

public class CategoryDTO {

	private int ctgrIdx; // 카테고리 인덱스
	private String ctgrTit; // 카테고리명
	
	public CategoryDTO() {}
	
	public CategoryDTO(int ctgrIdx, String ctgrTit) {
		this.ctgrIdx = ctgrIdx;
		this.ctgrTit = ctgrTit;
	}

	public int getCtgrIdx() {
		return ctgrIdx;
	}

	public void setCtgrIdx(int ctgrIdx) {
		this.ctgrIdx = ctgrIdx;
	}

	public String getCtgrTit() {
		return ctgrTit;
	}

	public void setCtgrTit(String ctgrTit) {
		this.ctgrTit = ctgrTit;
	}

	@Override
	public String toString() {
		return ctgrTit;
	}
	
}
