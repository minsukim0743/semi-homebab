package com.homebab.users.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.member.model.dto.MemberMngDTO;
import com.homebab.users.mypage.model.dto.MyInfoDTO;
import com.homebab.users.mypage.service.MyInfoPageService;

/**
 * 나의 정보 회원탈퇴 servlet
 * @author hani
 *
 */
@WebServlet("/users/withdrawal")
public class MyInfoWithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int loginUserIdx = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getMemberIdx();
		System.out.println("login session > " + loginUserIdx);
		
		MyInfoDTO memberWithdrawal = new MyInfoDTO();		
		memberWithdrawal.setMemberIdx(loginUserIdx);
		
		MyInfoPageService myInfoPageService = new MyInfoPageService();
		
		int result = myInfoPageService.updateUsersWithdrawal(memberWithdrawal);
		
		System.out.println("controller의 result :" + result);
		
		boolean isCheck = false;
		if(result > 0) {
			
			isCheck = true;

		} else {
			
			isCheck = false;
		}
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(isCheck);
		
		out.flush();
		out.close();
		
		
		
	}
	

}
