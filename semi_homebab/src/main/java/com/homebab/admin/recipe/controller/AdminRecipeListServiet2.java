package com.homebab.admin.recipe.controller;

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
import com.homebab.admin.recipe.model.dto.AdminRecipeListDTO;
import com.homebab.admin.recipe.service.AdminRecipeListService;

/**
 * Servlet implementation class AdminRecipeListServiet
 */
@WebServlet("/adminRecipe/list2")
public class AdminRecipeListServiet2 extends HttpServlet {
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
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		AdminRecipeListService service = new AdminRecipeListService();
		
		int totalCount = service.adminRecipeListCount2(searchMap);
		
		int limit = 10;
		int buttonAmount = 5;
		
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		List<AdminRecipeListDTO> adminRecipeList = service.adminRecipeListSelect2(selectCriteria);
		System.out.println("totalCount :" + totalCount);
		System.out.println("selectCriteria : " + selectCriteria);
		System.out.println("adminRecipeList : " + adminRecipeList);
		
		String path = "";
		
		if(adminRecipeList != null) {
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("adminRecipeList", adminRecipeList);	
			request.setAttribute("selectCriteria", selectCriteria);
			path = "/WEB-INF/views/admin/recipe/adminRecipelist2.jsp";

			
		} else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "조회에 실패하였습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
