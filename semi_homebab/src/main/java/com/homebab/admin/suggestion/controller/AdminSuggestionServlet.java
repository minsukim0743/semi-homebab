package com.homebab.admin.suggestion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.suggestion.model.dto.AdminSuggestionsDTO;
import com.homebab.admin.suggestion.service.AdminSuggestionListService;

/**
 * Servlet implementation class AdminSuggestionServlet
 */
@WebServlet("/adminSuggestion/select")
public class AdminSuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminSuggestionListService suggestion = new AdminSuggestionListService();
		
		List<AdminSuggestionsDTO> suggestList = suggestion.allSelectSuggestion();
		
		System.out.println("suggestList : " + suggestList);
		
		String path = ""; 
		
		if(suggestList != null) {
			
			path = "/WEB-INF/views/admin/suggestion/adminSuggestion.jsp";
			request.setAttribute("suggestList", suggestList);
			
		} else { 
//			 		--에러발생-1
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
