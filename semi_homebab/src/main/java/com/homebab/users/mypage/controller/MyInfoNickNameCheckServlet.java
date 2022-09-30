package com.homebab.users.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.mypage.model.dto.MyInfoDTO;
import com.homebab.users.mypage.service.MyInfoPageService;

/**
 * <pre>
 *   나의 정보 닉네임체크 서블릿 -hani
 * </pre>
 */
@WebServlet("/myinfo/nickname/check")
public class MyInfoNickNameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickName = request.getParameter("nickName");
		
		String sessionNickName = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getNickName();
		
		System.out.println(nickName);
		System.out.println(sessionNickName);
		
		
		MyInfoPageService withdrawal = new MyInfoPageService();
		
		int result = withdrawal.checkNickName(nickName);
		
		System.out.println("result :" + result);
		
		boolean isCheck = false;
		
		if(result > 0) {
			
			if(nickName.equals(sessionNickName)) {
				
				isCheck = true;
				
			} else {
				
				isCheck = false;
				
			}
			
		} else {
			
			isCheck = true;
		}
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(isCheck);
		
		out.flush();
		out.close();
		
		
		
	}

}
