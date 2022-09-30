package com.homebab.users.suggestion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.suggestion.model.dto.SuggestionDTO;
import com.homebab.users.suggestion.service.SuggestionService;

/**
 * Servlet implementation class SuggestionDetailServlet
 */
@WebServlet("/suggestion/users/detail")
public class SuggestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int sgtIdx = Integer.parseInt(request.getParameter("sgtIdx"));
		
		SuggestionDTO suggestionDetail = new SuggestionService().selectSuggestionDetail(sgtIdx);

		String path = "";

		if (suggestionDetail != null) {
			path = "/WEB-INF/views/users/suggestion/suggestionDetail.jsp";
			request.setAttribute("suggestionDetail", suggestionDetail);
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "건의사항 상세 조회 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

}
