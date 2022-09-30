package com.homebab.common.controller;


import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import com.homebab.users.recipe.model.dto.RecipeDTO;

import com.homebab.users.recipe.service.RecipeService;


@WebServlet("/main")

public class PathMainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RecipeService recipeService = new RecipeService();
		
		List<RecipeDTO> selectLikeRecipeList = recipeService.selectLikeRecipeList();
		
		for(RecipeDTO recipe : selectLikeRecipeList) {

			System.out.println("테스트 List : " + recipe);

		}
		
		String path = "";
		
		if(selectLikeRecipeList != null) {

			path = "/WEB-INF/views/main/main.jsp";

			request.setAttribute("selectLikeRecipeList", selectLikeRecipeList);

		}

		request.getRequestDispatcher(path).forward(request, response);		
		
	}

}


