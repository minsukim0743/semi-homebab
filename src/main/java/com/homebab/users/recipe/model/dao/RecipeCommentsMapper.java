package com.homebab.users.recipe.model.dao;

import java.util.Map;

public interface RecipeCommentsMapper {

	int commentsInsert(Map<String, Object> commentInsert);

	int commentsDelete(Map<String, String> delete);

	int insertSiren(Map<String, String> siren);

}
