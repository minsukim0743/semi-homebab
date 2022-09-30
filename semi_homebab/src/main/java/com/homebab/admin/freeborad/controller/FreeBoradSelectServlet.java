package com.homebab.admin.freeborad.controller;

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
import com.homebab.admin.freeborad.model.dto.FreeBoradDTO;
import com.homebab.admin.freeborad.service.FreeBoradService;

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
import com.homebab.admin.freeborad.model.dto.FreeBoradDTO;
import com.homebab.admin.freeborad.service.FreeBoradService;

@WebServlet("/adminFreeboard/select")
public class FreeBoradSelectServlet extends HttpServlet {
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
		
		FreeBoradService boardService = new FreeBoradService();
		int totalCount = boardService.selectTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);
		
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<FreeBoradDTO> boardList = boardService.selectBoardList(selectCriteria);
		
		System.out.println("boardList : " + boardList);
		
		String path = "";
		
		if(boardList != null) {
			
			path = "/WEB-INF/views/admin/freeboard/adminFreeBoard.jsp";
			
			request.setAttribute("boardList", boardList);
			request.setAttribute("selectCriteria", selectCriteria); // 페이징 처리 해주는 값 불러오는거 가져갈꺼
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

