package com.homebab.users.suggestion.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.suggestion.model.dto.SuggestionDTO;
import com.homebab.users.suggestion.service.SuggestionService;

/**
 * Servlet implementation class suggestioninsertServlet
 */
@WebServlet("/suggestion/users/insert")
public class SuggestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String path = "/WEB-INF/views/users/suggestion/suggestionInsert.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		System.out.println(((UsersMngDTO)session.getAttribute("loginUser")));
		
		int memberIdx = ((UsersMngDTO)session.getAttribute("loginUser")).getMemberIdx();
		
		Date regDate = new Date(System.currentTimeMillis());
		
		SuggestionDTO suggestion = new SuggestionDTO();
		
		suggestion.setMemberIdx(memberIdx);
		suggestion.setTitle(request.getParameter("title"));
		suggestion.setContent(request.getParameter("content"));
		suggestion.setRegDate(regDate);
		
		System.out.println("나오냐" + suggestion);
		
		
		SuggestionService suggestionService = new SuggestionService();
		int result = suggestionService.insertSuggestion(suggestion);
	
		System.out.println("result" + result);
		
		String path= "";
		
		if(result > 0 ) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "SuggestionInsert");
			
		}else {
			path = "/WEB-INF/views/common/failedPage.jsp";
			request.setAttribute("message", "건의사항 등록 실패");

		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
