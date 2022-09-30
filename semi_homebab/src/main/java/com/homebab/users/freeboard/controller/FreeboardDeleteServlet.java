
package com.homebab.users.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.freeboard.service.FreeboardService;

/**
 * Servlet implementation class FreeboardDeleteServlet
 */
@WebServlet("/freeboard/users/delete")
public class FreeboardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int fbIdx = Integer.parseInt(request.getParameter("fbIdx"));
		
		FreeboardService freeboardService = new FreeboardService();
		
		int deleteFile = freeboardService.freeboardDeleteFile(fbIdx);
		
		String path = "";
		
		if(deleteFile > 0) {
			
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "FreeboardDelete");
		} else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "자유 게시판 삭제 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
