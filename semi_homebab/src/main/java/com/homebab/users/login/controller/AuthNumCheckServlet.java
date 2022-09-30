package com.homebab.users.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.login.service.LoginService;

@WebServlet("/password/authnumcheck")
public class AuthNumCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pfId = request.getParameter("pfId");
		String pfAuthNum = request.getParameter("pfAuthNum");

		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("pfId", pfId);
		hm.put("pfAuthNum", pfAuthNum);
		
		LoginService ls = new LoginService();
		int result = ls.authNumCheck(hm);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
		
	}

}
