package com.homebab.users.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.mypage.model.dto.MyInfoDTO;
import com.homebab.users.mypage.service.MyInfoPageService;

/**
 * <pre>
 * 나의 정보 저장 서블릿 
 * </pre>
 */
@WebServlet("/user/info/save")
public class UsersInfoSavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memberIdx = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getMemberIdx();
		String nickName = request.getParameter("nickName");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String userPwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		java.sql.Date birth = java.sql.Date.valueOf(request.getParameter("birth"));
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String pw = passwordEncoder.encode(userPwd);
	    
	    System.out.println("암호화한 비밀번호 pw : " + pw);
		
		MyInfoDTO myInfoDTO = new MyInfoDTO();
		myInfoDTO.setMemberIdx(memberIdx);
		myInfoDTO.setNickName(nickName);
		myInfoDTO.setName(name);
		myInfoDTO.setEmail(email);
		myInfoDTO.setUserPwd(pw);
		myInfoDTO.setGender(gender);
		myInfoDTO.setBirth(birth);
		
		System.out.println("MyInfoDTO 확인  : " + myInfoDTO);
		MyInfoPageService myInfo = new MyInfoPageService();
		
		int result = myInfo.updateMyInfoSave(myInfoDTO);
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		out.flush();
		out.close();
	}

}
