package com.homebab.users.recipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.recipe.model.dto.RecipeDTO;
import com.homebab.users.recipe.service.RecipeService;

@WebServlet("/select/category")
public class SelectCategoryRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ctgrTit = request.getParameter("ctgrTit");
		
		RecipeService recipeService = new RecipeService();
		
		List<RecipeDTO> categoryRecipeList = recipeService.selectRecipeCategory(ctgrTit);
		
		for(RecipeDTO recipe : categoryRecipeList) {
			
			System.out.println(recipe);
		}
		
		String path = "";
		if(categoryRecipeList != null) {
			path = "/WEB-INF/views/users/recipe/categoryRecipePage.jsp";
			request.setAttribute("categoryRecipeList", categoryRecipeList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "카테고리별 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}
