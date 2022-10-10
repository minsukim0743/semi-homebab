package com.homebab.users.recipe.model.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.users.recipe.model.dto.RecipeCommentsDTO;
import com.homebab.users.recipe.model.dto.RecipeDTO;
import com.homebab.users.recipe.model.dto.RecipeFileUploadDTO;
import com.homebab.users.recipe.model.dto.RecipeLikeDTO;

public interface RecipeMapper {

	List<RecipeDTO> selectRecipeList(SelectCriteria selectCriteria);

	int insertRecipe(RecipeDTO recipe);

	int insertFileUpload(RecipeFileUploadDTO recipeFileUploadDTO);

	List<RecipeDTO> selectRecipeCategory(String ctgrTit);

	int incrementRecipeCount(int rcpIdx);

	RecipeDTO selectOneRecipeWriting(int rcpIdx);
	
	int updateRecipe(RecipeDTO recipe);

	int deleteFile(int rcpIdx);
	
	int deleteRecipe(int rcpIdx);

	RecipeDTO updateSelectRecipe(int rcpIdx);

	int selectRecipeLastNum();

	int updateInsertFileUpload(RecipeFileUploadDTO recipeFile);

	List<RecipeDTO> searchRecipe(@Param("keyword")String keyword, @Param("type")String type);

	int likeCountRecipe(@Param("rcpIdx")int rcpIdx, @Param("memberIdx")int memberIdx, @Param("stateYn")String stateYn);

	int likeCountRecipe2(@Param("rcpIdx")int rcpIdx);
	
	List<RecipeCommentsDTO> recipeCommentsSelect(Map<Object, Object> commentsMap);

	int recipeCommentsCount(int rcpIdx);
	
	int selectTotalCount();

	int deleteTableRecipe(@Param("rcpIdx")int rcpIdx, @Param("memberIdx")int memberIdx, @Param("stateYn")String stateYn);

	int likeCencelRecipe(@Param("rcpIdx")int rcpIdx);

	RecipeLikeDTO selectRecipeLike(@Param("rcpIdx")int rcpIdx, @Param("memberIdx")int memberIdx);

	List<RecipeDTO> seleteLikeRecipeList();

	RecipeLikeDTO selectRecipeLike2(int rcpIdx);


}
