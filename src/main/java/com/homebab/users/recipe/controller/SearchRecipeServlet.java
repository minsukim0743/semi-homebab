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

@WebServlet("/recipe/search")
public class SearchRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		
		System.out.println("테스트 keyword : " + keyword + " 테스트 type : " + type);
		
		RecipeService recipeService = new RecipeService();
		List<RecipeDTO> recipe = recipeService.searchRecipe(keyword, type);
		
		for(RecipeDTO search : recipe) {
			
			System.out.println("값 확인 " + search);
		}
		
		request.setAttribute("recipe", recipe);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("/WEB-INF/views/users/recipe/searchRecipe.jsp").forward(request, response);
	}

}
