package com.homebab.users.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.freeboard.service.FreeboardService;
import com.homebab.users.notice.model.dto.NoticeDTO;
import com.homebab.users.notice.service.NoticeService;

/**
 * Servlet implementation class NoticeSelectDetailServlet
 */
@WebServlet("/notice/users/detail")
public class NoticeSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ntcIDx = Integer.parseInt(request.getParameter("fdIdx"));
		
		NoticeService noticeService = new NoticeService();
		NoticeDTO noticeDetail = noticeService.selectNoticeDetail(ntcIDx);
		
		System.out.println("noticeDetail : " +  noticeDetail );

		request.setAttribute("noticeDetail", noticeDetail);
		request.getRequestDispatcher("/WEB-INF/views/users/notice/noticeDetail.jsp").forward(request, response);
		
		

	}
}