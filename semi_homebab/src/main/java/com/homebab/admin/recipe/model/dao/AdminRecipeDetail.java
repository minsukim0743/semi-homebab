package com.homebab.admin.recipe.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.recipe.model.dto.AdminRecipeListDTO;
import com.homebab.users.recipe.model.dto.RecipeDTO;

public interface AdminRecipeDetail {


	int incrementRecipeCount(int rcpIdx);

	RecipeDTO selectOneRecipeWriting(int rcpIdx);

	int incrementRecipeCountAll(int rcpIdx);

	RecipeDTO selectOneRecipeWritingAll(int rcpIdx);

}
