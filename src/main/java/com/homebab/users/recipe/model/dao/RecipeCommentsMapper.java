package com.homebab.users.recipe.model.dao;

import java.util.Map;

public interface RecipeCommentsMapper {

	// 레시피 게시물 댓글 등록
	int commentsInsert(Map<String, Object> commentInsert);

	// 레시피 게시물 댓글 삭제
	int commentsDelete(Map<String, String> delete);

	// 레시피 게시물 댓글 신고
	int insertSiren(Map<String, String> siren);

}
