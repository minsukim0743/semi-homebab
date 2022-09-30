package com.homebab.users.suggestion.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homebab.users.member.model.dto.UsersMngDTO;
import com.homebab.users.suggestion.model.dto.SuggestionDTO;
import com.homebab.users.suggestion.service.SuggestionService;

/**
 * Servlet implementation class SuggestionUpdateServlet
 */
@WebServlet("/suggestion/users/update")
public class SuggestionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "";

		int sgtIdx = Integer.parseInt(request.getParameter("sgtIdx"));

		SuggestionService suggestionService = new SuggestionService();
		SuggestionDTO suggestion = suggestionService.selectSuggestionDetail(sgtIdx);

		if (request.getParameter("sgtIdx") != null) {
			path = "/WEB-INF/views/users/suggestion/suggestionUpdate.jsp";
			request.setAttribute("suggestion", suggestion);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "자유게시판 상세 조회 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int sgtIdx = Integer.parseInt(request.getParameter("sgtIdx"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		SuggestionDTO suggestion = new SuggestionDTO();
		suggestion.setContent(content);
		suggestion.setTitle(title);
		suggestion.setSgtIdx(sgtIdx);

		SuggestionService suggestionService = new SuggestionService();

		int result = suggestionService.suggestionUpdate(suggestion);

		System.out.println("dsgoihefsbsifbi;e;sbdf;j1111111111111111111111111112===================>>" + result);

		String path = "";

		if (result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "SuggestionUpdate");
			request.setAttribute("sgtIdx", Integer.parseInt(request.getParameter("sgtIdx")));

		} else {
			path = "/WEB-INF/views/common/failedPage.jsp";
			request.setAttribute("message", "건의사항 수정 실패");

		}

		request.getRequestDispatcher(path).forward(request, response);
	}
}
