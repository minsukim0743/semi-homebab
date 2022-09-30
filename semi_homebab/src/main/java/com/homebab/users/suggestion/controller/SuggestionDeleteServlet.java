package com.homebab.users.suggestion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.suggestion.service.SuggestionService;

/**
 * Servlet implementation class SuggestionDeleteServlet
 */
@WebServlet("/suggestion/users/delete")
public class SuggestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("여긴 나오냐?");
		
		int sgtIdx = Integer.parseInt(request.getParameter("sgtIdx"));
		
		System.out.println("HTTP 상태 405 – 허용되지 않는 메소드" + sgtIdx);
		
		int result = new SuggestionService().suggestionDelete(sgtIdx);
	
		
		System.out.println("HTTP 상태 405 – 허용되지 않는 메소드" + result);
		String path = "";
		
		if(result > 0) {
			
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "SuggestionDelete");
		} else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "건의사항 삭제 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		

		
		
	}

}
