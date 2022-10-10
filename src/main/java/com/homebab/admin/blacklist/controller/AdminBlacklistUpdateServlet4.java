package com.homebab.admin.blacklist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.homebab.admin.blacklist.service.AdminBlacklistService;

/**
 * Servlet implementation class AdminBlacklistUpdateServlet2
 */
@WebServlet("/adminBlackList/update/ntoy4")
public class AdminBlacklistUpdateServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String number = request.getParameter("number");
		
		System.out.println("number : " + number);
		
		AdminBlacklistService service = new AdminBlacklistService();
		
		int result = service.blacklistUpdate2(number);
		
		String path = "";
		
		if(result > 0) {
			
			JOptionPane.showMessageDialog(null, "블랙리스트가 해제되었습니다.");
			
			path = "/adminBlackList/comments";
			response.sendRedirect(request.getContextPath()+path);
		} else {
			JOptionPane.showMessageDialog(null, "등록 실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			
			path = "/adminBlackList/comments";
			response.sendRedirect(request.getContextPath()+path);
		}
		
		
	}

}
