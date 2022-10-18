package com.homebab.users.recipe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.common.pagin.Pagenation;
import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.recipe.model.dto.RecipeCommentsDTO;
import com.homebab.users.recipe.model.dto.RecipeDTO;
import com.homebab.users.recipe.model.dto.RecipeLikeDTO;
import com.homebab.users.recipe.service.RecipeService;

@WebServlet("/recipeComments/view")
public class SelectRecipeCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object recipeLike;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RecipeService service = new RecipeService();
		
		int rcpIdx = Integer.parseInt(request.getParameter("rcpIdx"));
		
		RecipeDTO recipe =  new RecipeService().selectOneRecipeWriting(rcpIdx);
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);	
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		
		int totalCount = service.recipeCommentsCount(rcpIdx);
		
		System.out.println("totalCount : "+totalCount);
		
		int limit = 99;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("selectCriteria :" + selectCriteria);
		
		String rcpIdx2 = request.getParameter("rcpIdx");
		
		Map<Object, Object> commentsMap = new HashMap<>();
		commentsMap.put("rcpIdx2", rcpIdx2);
		commentsMap.put("selectCriteria", selectCriteria);
		
		System.out.println("commentsMap : " + commentsMap);
		
		List<RecipeCommentsDTO> recipeCommentsList = service.recipeCommentsSelect(commentsMap);
		
		System.out.println("recipeCommentsList : " + recipeCommentsList);
		System.out.println("selectCriteria : " + selectCriteria);
		String path = "";
		
		System.out.println("currentPage2 : " + currentPage);
		
		Object session = request.getSession().getAttribute("loginUser");
		
		System.out.println("session : " + session);
		
		if(session != null) {
			
			int memberIdx = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getMemberIdx();
			
			System.out.println("memberIdx : " + memberIdx);

			
			List<RecipeLikeDTO> recipeLike = service.selectRecipeLike(rcpIdx, memberIdx);

	
		} else {
			
			List<RecipeLikeDTO> recipeLike = service.selectRecipeLike2(rcpIdx);

		}

		if(recipeCommentsList != null) {
			
			path = "/WEB-INF/views/users/recipe/recipeComments.jsp";
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("recipeCommentsList", recipeCommentsList);
			request.setAttribute("recipe", recipe);
			request.setAttribute("recipeLike", recipeLike);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "실패랑꼐!");

		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

