package com.homebab.admin.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homebab.admin.login.model.dto.AdminDTO;
import com.homebab.admin.login.service.AdminLoginService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		AdminDTO requestAdmin = new AdminDTO();
		
		requestAdmin.setUserId(userId);
		requestAdmin.setUserPwd(userPwd);
		
		System.out.println("controller id:" + userId);
		System.out.println("controller pwd:" + userPwd);
		
		AdminLoginService adminLoginService = new AdminLoginService();
		
		AdminDTO loginAdmin = adminLoginService.adminLogin(requestAdmin);
		
		System.out.println(loginAdmin);
		
		String path="";
		
		if(loginAdmin != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", loginAdmin);
			
			path = "/WEB-INF/views/admin/main/adminMain.jsp";

			request.getRequestDispatcher(path).forward(request, response);
			
		} else {
				
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
			
		}

	}
	

}
