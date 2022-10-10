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

import com.homebab.smtp.SendMail;
import com.homebab.users.login.service.LoginService;

@WebServlet("/password/emailsend")
public class EmailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pfId = request.getParameter("pfId");
		String pfEmail = request.getParameter("pfEmail");
		
		Map<String, Object> hm = new HashMap<>();
		int authNum = (int)(Math.random()*1000000);
		
		hm.put("pfId", pfId);
		hm.put("pfEmail", pfEmail);
		hm.put("authNum", authNum);
		
		LoginService ls = new LoginService();
		int result = ls.modRandomAuth(hm);
		
		Boolean sendResult = false;
		System.out.println("랜덤난수 (6자리) : " + authNum);
		System.out.println("발송 이메일 : " + pfEmail);
		
		// 메일발송
		if(result > 0) {
			SendMail sm = new SendMail();
		    sendResult = sm.senderSmtp(hm);
		    System.out.println("메일발송 성공");
		} 
		
		PrintWriter out = response.getWriter();
		out.print(sendResult);

		out.flush();
		out.close();
		
	}

}
