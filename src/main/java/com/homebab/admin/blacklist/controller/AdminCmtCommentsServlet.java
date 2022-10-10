package com.homebab.admin.blacklist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.homebab.admin.blacklist.service.AdminCmtReportListService;

/**
 * Servlet implementation class AdminRecipeDeleteCommentsServlet
 */
@WebServlet("/adminCmtComments/delete")
public class AdminCmtCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cmtIdx = request.getParameter("cmtIdx");
		
		System.out.println("memberIdx : " + cmtIdx );
		
		AdminCmtReportListService service = new AdminCmtReportListService();
		
		int result = service.adminCommentsDelete(cmtIdx);
		
		if(result > 0) {
			
			JOptionPane.showMessageDialog(null, "삭제에 성공하였습니다.");
			response.sendRedirect(request.getContextPath()+"/adminBlackList/comments");
		} else {
			
			JOptionPane.showMessageDialog(null, "삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/adminBlackList/comments");
		}
	
	}

}
