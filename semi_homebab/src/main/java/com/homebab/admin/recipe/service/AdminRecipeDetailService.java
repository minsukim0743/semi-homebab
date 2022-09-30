package com.homebab.admin.recipe.service;

import static com.homebab.common.config.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.recipe.model.dao.AdminRecipeDetail;
import com.homebab.admin.recipe.model.dao.AdminRecipeMapper;
import com.homebab.users.recipe.model.dao.RecipeMapper;
import com.homebab.users.recipe.model.dto.RecipeDTO;

public class AdminRecipeDetailService {

	private AdminRecipeDetail recipeMapper;

	public RecipeDTO selectOneRecipeWriting(int rcpIdx) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(AdminRecipeDetail.class);
		
		RecipeDTO recipe = null;
		
		int result = recipeMapper.incrementRecipeCount(rcpIdx);
		
		if (result > 0) {
			
			recipe = recipeMapper.selectOneRecipeWriting(rcpIdx);

			if(recipe != null) {

				sqlSession.commit();

			} else {

				sqlSession.rollback();

			}

		} else {

			sqlSession.rollback();

		}
		
		sqlSession.close();
		
		return recipe; 
		
	}
		
	
}
