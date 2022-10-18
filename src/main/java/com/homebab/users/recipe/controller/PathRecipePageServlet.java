package com.homebab.users.recipe.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.homebab.admin.common.pagin.Pagenation;
import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.users.recipe.model.dto.RecipeDTO;
import com.homebab.users.recipe.service.RecipeService;

@WebServlet("/recipe/page")

public class PathRecipePageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {

			pageNo = Integer.parseInt(currentPage);

		}

		if(pageNo <= 0) {

			pageNo = 1;

		}

		RecipeService recipeService = new RecipeService();

		int totalCount = recipeService.selectTotalCount(); 

		System.out.println("totalBoardCount : " + totalCount);

		int limit = 8;	

		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;

		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("selectCriteria"+selectCriteria);

		List<RecipeDTO> recipeList = recipeService.selectRecipeList(selectCriteria);

		System.out.println("recipeList : " + recipeList);

		for (RecipeDTO recipe : recipeList) {

			
			System.out.println(recipe);

		}

		
		String path = "";

		if(recipeList != null) {

			path = "/WEB-INF/views/users/recipe/recipePage.jsp";

			request.setAttribute("currentPage", currentPage);

			request.setAttribute("recipeList", recipeList);

			request.setAttribute("selectCriteria", selectCriteria);

		} else {

			path = "/WEB-INF/views/common/failed.jsp";

			request.setAttribute("message", "게시판 조회 실패!");

		}

		request.getRequestDispatcher(path).forward(request, response);

	}

}



