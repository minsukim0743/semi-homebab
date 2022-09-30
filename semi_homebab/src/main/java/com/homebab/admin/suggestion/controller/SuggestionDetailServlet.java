package com.homebab.admin.suggestion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.suggestion.model.dto.AdminSuggestionsDTO;
import com.homebab.admin.suggestion.service.AdminSuggestionListService;


/**
 * Servlet implementation class SuggestionDetailServlet
 */
@WebServlet("/adminSuggestion/datil")
public class SuggestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int sgtIdx = Integer.parseInt(request.getParameter("sgtIdx"));
		
		AdminSuggestionsDTO suggestionDetail = new AdminSuggestionListService().selectSuggestionDetail(sgtIdx);

		System.out.println("suggestionDetail" + suggestionDetail);
		
		String path = "";

		if (suggestionDetail != null) {
			path = "/WEB-INF/views/admin/suggestion/suggestionDetail.jsp";
			request.setAttribute("suggestionDetail", suggestionDetail);
			
		} else {
			
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dBool = request.getParameter("dBool");
		String dNum = request.getParameter("dNum");
		
		int result = 0;
		
		if(dBool.equals("Y")) {
			System.out.println("건의사항 삭제");
			AdminSuggestionListService ss = new AdminSuggestionListService();
			
			result = ss.deleteSgtIdx(dNum);
		}

		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/admin/suggestion/adminSuggestion.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			path = "/WEB-INF/views/admin/suggestion/adminSuggestion.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	
	

}
