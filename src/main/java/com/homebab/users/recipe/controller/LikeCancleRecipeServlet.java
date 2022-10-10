package com.homebab.users.recipe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.recipe.model.dto.RecipeLikeDTO;
import com.homebab.users.recipe.service.RecipeService;

@WebServlet("/recipe/likeCancel")
public class LikeCancleRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rcpIdx = Integer.parseInt(request.getParameter("rcpIdx"));
		int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));
		String stateYn = request.getParameter("stateYn");
		
		RecipeLikeDTO recipeLike = new RecipeLikeDTO();
		
		recipeLike.setRcpIdx(rcpIdx);
		recipeLike.setMemberIdx(memberIdx);
		recipeLike.setStateYn(stateYn);
		
		System.out.println("추천 취소 눌렀을 때 테스트입니다 테스트 : " + recipeLike);
		
		RecipeService recipeService = new RecipeService();
		int recipe = recipeService.likeCancelRecipe(rcpIdx, memberIdx, stateYn); 
				
		if(recipe > 0) {
			
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		}
		
	}

}
