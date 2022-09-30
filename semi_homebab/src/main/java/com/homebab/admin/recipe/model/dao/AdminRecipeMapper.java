package com.homebab.admin.recipe.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.recipe.model.dto.AdminRecipeListDTO;
import com.homebab.users.recipe.model.dto.RecipeDTO;

public interface AdminRecipeMapper {



	int adminRecipeListCount(Map<String, String> searchMap);

	int adminRecipeListCount2(Map<String, String> searchMap);

	List<AdminRecipeListDTO> adminRecipeListSelect(SelectCriteria selectCriteria);

	List<AdminRecipeListDTO> adminRecipeListSelect2(SelectCriteria selectCriteria);

	int adminRecipeUpdate(String number);

	int adminRecipeUpdate2(String number);

	int adminDelete(String number);

}
