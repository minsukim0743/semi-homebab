package com.homebab.users.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.login.service.LoginService;

@WebServlet("/password/find")
public class PathPasswordFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PathPasswordFindServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/users//login/passwordfind.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pfId = request.getParameter("pfId");
		
		LoginService ls = new LoginService();
		String email = ls.selectOneEamil(pfId);
		
		System.out.println("email > " + email);
		
		PrintWriter out = response.getWriter();
				
		out.print(email);

		out.flush();
		out.close();
	}

}
