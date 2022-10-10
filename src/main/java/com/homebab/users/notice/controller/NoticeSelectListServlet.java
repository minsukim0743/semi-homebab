package com.homebab.users.notice.controller;

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
import com.homebab.users.notice.model.dto.NoticeDTO;
import com.homebab.users.notice.service.NoticeService;
import com.homebab.users.suggestion.service.SuggestionService;



/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/users/list")
public class NoticeSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */
		NoticeService noticeService = new NoticeService();
		int totalCount = noticeService.selectTotalCount(searchMap);
		
		System.out.println("totalBoardCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 20;		//얘도 파라미터로 전달받아도 된다.
		
		System.out.println(limit);
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		System.out.println(buttonAmount);
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<NoticeDTO> noticeList = noticeService.selectAllNoticeList(selectCriteria);
	
		System.out.println(noticeList);
		String path = "";
		
		if(noticeList != null) {
			path = "/WEB-INF/views/users/notice/notice.jsp";
			
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("selectCriteria", selectCriteria);
		}else {
			path = "/WEB-INF/views/common/failedPage.jsp";
			request.setAttribute("message", "건의사항 조회 실패");
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
		


}