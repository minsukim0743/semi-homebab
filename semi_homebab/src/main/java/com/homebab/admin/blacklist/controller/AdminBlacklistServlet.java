package com.homebab.admin.blacklist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.blacklist.model.dto.MemberRcpBlacklistDTO;
import com.homebab.admin.blacklist.service.AdminBlacklistService;
import com.homebab.admin.common.pagin.Pagenation;
import com.homebab.admin.common.pagin.SelectCriteria;

/**
 * Servlet implementation class AdminBlackListServlet
 */
@WebServlet("/adminBlackList/list")
public class AdminBlacklistServlet extends HttpServlet {
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
		
		Map<String,String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		AdminBlacklistService blacklistService = new AdminBlacklistService();
		
		int totalCount = blacklistService.blacklistTotalCount(searchMap);
		
		System.out.println("totalCount :" + totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		
		List<MemberRcpBlacklistDTO> adminblacklist = blacklistService.blacklistSelect(selectCriteria);
		
		System.out.println("adminblacklist :" + adminblacklist);
		
		String path="";
		
		if(adminblacklist != null) {
			
			request.setAttribute("adminblacklist", adminblacklist);
			request.setAttribute("selectCriteria", selectCriteria);
			path = "/WEB-INF/views/admin/blacklist/adminBlacklist.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		} else {
			
			request.setAttribute("message", "조회에 실패하였습니다.");
			path = "/WEB-INF/views/common/error/failed.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		
	}

}
