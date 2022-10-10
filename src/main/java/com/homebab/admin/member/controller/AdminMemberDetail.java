package com.homebab.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.member.model.dto.AdminMemberDTO;
import com.homebab.admin.member.service.AdminMemberService;

/**
 * Servlet implementation class AdminMemberDetail
 */
@WebServlet("/adminMember/detail")
public class AdminMemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String number = request.getParameter("number");
		
		System.out.println("number : " + number);
		
		AdminMemberDTO memberDetailDTO = new AdminMemberDTO();
		
		AdminMemberService adminMemberService = new AdminMemberService();
		
		memberDetailDTO = adminMemberService.adminMemberDetail(number);
		
		System.out.println("memberDetailDTO : " +memberDetailDTO);
		
		request.setAttribute("memberDetailDTO", memberDetailDTO);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/member/adminMemberDetail.jsp").forward(request, response);
	}

}
