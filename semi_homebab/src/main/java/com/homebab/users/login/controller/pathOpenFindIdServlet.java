package com.homebab.users.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pathOpenFindIdServlet
 */
@WebServlet("/login/openfindid")
public class pathOpenFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/views/users/login/openfindid.jsp").forward(request, response);
	}


}
