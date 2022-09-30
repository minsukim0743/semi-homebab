package com.homebab.users.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.login.service.LoginService;

@WebServlet("/users/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd : " + memberPwd);
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("memberId", memberId);
		hm.put("memberPwd", memberPwd);
		
		LoginService ls = new LoginService();
		int result = ls.loginAdminSelect(hm);
		
		System.out.println("관리자 로그인 체크 > " + result);
		
		// 관리자 접속
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("hm", hm);
			System.out.println("관리자로 접속");
//			response.sendRedirect("/adminlogin");
			request.getRequestDispatcher("/WEB-INF/views/admin/main/adminMain.jsp").forward(request, response);
			//response.sendRedirect("/index.jsp");
//			<%-- <jsp:forward page="/WEB-INF/views/admin/login/adminLogin.jsp"/> --%>
			return;
		}
		
		UsersMngDTO loginUser = ls.loginUserSelect(hm);
		
		System.out.println("loginUser 로그인 > " + loginUser);
		
		if(loginUser != null) {
			System.out.println("사용자 로그인 성공");
			HttpSession session = request.getSession();
			System.out.println("se : " + session);
			session.setAttribute("loginUser", loginUser);
			request.setAttribute("loginUser", loginUser);
			System.out.println("loginUser : " + loginUser);
			
			response.sendRedirect("/main");
		} else {
			System.out.println("사용자 로그인 실패");
			request.setAttribute("message", "loginFailed");
			request.getRequestDispatcher("/WEB-INF/views/users/login/failed.jsp").forward(request, response);
		}
		
	}

}
