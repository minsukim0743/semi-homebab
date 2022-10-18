package com.homebab.users.recipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.recipe.model.dto.RecipeLikeDTO;
import com.homebab.users.recipe.service.RecipeService;

@WebServlet("/recipe/like")
public class LikeCountRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rcpIdx = Integer.parseInt(request.getParameter("rcpIdx"));
		int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));
		
		RecipeLikeDTO recipeLike = new RecipeLikeDTO();
		
		recipeLike.setRcpIdx(rcpIdx);
		recipeLike.setMemberIdx(memberIdx);
		
		RecipeService recipeService = new RecipeService();
		int recipe = recipeService.likeCountRecipe(rcpIdx, memberIdx);
		
		if(recipe > 0) {
			
			request.setAttribute("recipeLike", recipeLike);
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		}
		
	}

}
