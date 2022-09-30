package com.homebab.users.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.member.service.SignUpService;

@WebServlet("/member/signup/regist")
public class SignUpRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpRegistServlet() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String suId = request.getParameter("suId");
		String suPw = request.getParameter("suPw");
		String suNickName = request.getParameter("suNickName");
		String suName = request.getParameter("suName");
		String suEmail = request.getParameter("suEmail");
		String suDate = request.getParameter("suDate");
		String suGender = request.getParameter("suGender");
		
		Map<String, Object> hm = new HashMap<>();
		
		hm.put("suId", suId);
		hm.put("suPw", suPw);
		hm.put("suNickName", suNickName);
		hm.put("suName", suName);
		hm.put("suEmail", suEmail);
		hm.put("suDate", suDate);
		hm.put("suGender", suGender);
		
		SignUpService sus = new SignUpService();
		
		int result = sus.signUpRegist(hm);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/users/member/success.jsp";
			request.setAttribute("successCode", "signUpRegist");
		} else {
			path = "/WEB-INF/views/users/member/failed.jsp";
			request.setAttribute("message", "회원가입 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
			
	}

}
