package com.homebab.users.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.login.service.LoginService;

@WebServlet("/signup/nicknamecheck")
public class SignUpNickNameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpNickNameCheckServlet() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String suNickName = request.getParameter("suNickName");

		LoginService ls = new LoginService();

		int result = ls.signUpNickNameCheck(suNickName);

		PrintWriter out = response.getWriter();

		out.print(result);

		out.flush();
		out.close();
	}

}
