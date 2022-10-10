package com.homebab.admin.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.common.pagin.Pagenation;
import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.member.model.dto.AdminMemberDTO;
import com.homebab.admin.member.service.AdminMemberService;

/**
 * Servlet implementation class AdminMemberSelectServlet
 */
@WebServlet("/adminMember/list")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		AdminMemberService adminMemberService = new AdminMemberService();
		int totalCount = adminMemberService.adminMemberTotalCount(searchMap);
		
		System.out.println(searchMap);
		System.out.println("totalCount : " + totalCount);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println("selectCriteria : " + selectCriteria);
		
		List<AdminMemberDTO> adminMemberList = adminMemberService.selectMemberList(selectCriteria);
		
		System.out.println("adminList :" +adminMemberList);
		
		
		
		String path="";
		
		if(adminMemberList != null) {
			
			path = "/WEB-INF/views/admin/member/adminMemberList.jsp";
			request.setAttribute("adminMemberList", adminMemberList);
			request.setAttribute("selectCriteria", selectCriteria);
			
		} else {
			
			path = "/WEB_INF/views/common/error/failde/jsp";
			request.setAttribute("message", "회원 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
