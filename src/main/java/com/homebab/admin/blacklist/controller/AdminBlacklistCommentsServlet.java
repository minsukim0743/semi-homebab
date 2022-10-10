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
import javax.swing.JOptionPane;

import com.homebab.admin.blacklist.model.dto.AdminCmtReportListDTO;
import com.homebab.admin.blacklist.service.AdminCmtReportListService;
import com.homebab.admin.common.pagin.Pagenation;
import com.homebab.admin.common.pagin.SelectCriteria;

/**
 * Servlet implementation class AdminBlacklistCommentsServlet
 */
@WebServlet("/adminBlackList/comments")
public class AdminBlacklistCommentsServlet extends HttpServlet {
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
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		AdminCmtReportListService service = new AdminCmtReportListService();
		
		int totalCount = service.cmtReportTotalCount(searchMap);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {

			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		List<AdminCmtReportListDTO> cmtReportList = service.cmtReportSelect();
		
		System.out.println(cmtReportList);
		
		String path="";
		
		if(cmtReportList != null) {
			
			request.setAttribute("cmtReportList", cmtReportList);
			request.setAttribute("selectCriteria", selectCriteria);
			path = "/WEB-INF/views/admin/blacklist/adminBlacklistComments.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			
			request.setAttribute("message", "조회에 실패하였습니다.");
			path = "/WEB-INF/views/common/error/failed.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
	}

}
