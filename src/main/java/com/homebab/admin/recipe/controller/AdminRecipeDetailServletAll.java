package com.homebab.admin.recipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.recipe.service.AdminRecipeDetailService;
import com.homebab.users.recipe.model.dto.RecipeDTO;

/**
 * Servlet implementation class PathRecipeServlet
 */
@WebServlet("/adminRecipe/detailAll")
public class AdminRecipeDetailServletAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rcpIdx = Integer.parseInt(request.getParameter("rcpIdx"));
		RecipeDTO recipe =  new AdminRecipeDetailService().selectOneRecipeWriting(rcpIdx);
		
		System.out.println("recipe : " + recipe);
		
		String path = "";
		if(recipe != null) {
			
			path = "/WEB-INF/views/users/recipe/recipeComments.jsp";
			request.setAttribute("recipe", recipe);
		} else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "썸네일 게시판 상세 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

