package com.homebab.users.freeboard.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.common.pagin.Pagenation;
import com.homebab.common.pagin.SelectCriteria;
import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.freeboard.service.FreeboardService;

/**
 * Servlet implementation class FreeboardSelectListServlet
 */
@WebServlet("/freeboard/users/list")
public class FreeboardSelectListServlet extends HttpServlet {
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
		
		FreeboardService freeboardService = new FreeboardService();
		int totalCount = freeboardService.selectTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);
		
		int limit = 5;	
		
		System.out.println(limit);
		int buttonAmount = 5;
		
		System.out.println(buttonAmount);
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<FreeboardDTO> freeboardlist = freeboardService.selectAllFreeboardlist(selectCriteria);
		
//		int memberIdx = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getMemberIdx();

		System.out.println(freeboardlist);
		String path= "";  
		
		if(freeboardlist != null) {
			
			path = "/WEB-INF/views/users/freeboard/freeboard.jsp";
			request.setAttribute("freeboardlist", freeboardlist);
			request.setAttribute("selectCriteria", selectCriteria);
		}else {
			
			path = "/WEB-INF/views/common/failedPage.jsp";
			request.setAttribute("message", "자유 게시판 조회 실패!!");
			
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
