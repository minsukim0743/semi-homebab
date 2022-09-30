package com.homebab.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.notice.model.dto.NoticeDTO;
import com.homebab.admin.notice.service.Noticeservice;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/adminNotice/view")
public class NoticeServletView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*
		String p_ntcIdx = request.getParameter(("ntcIdx"))  != null ? request.getSession().getAttribute("ntcIdx").toString() : "";
		String p_title = request.getSession().getAttribute("title") != null ? request.getSession().getAttribute("title").toString() : "";
		String p_regDate = request.getSession().getAttribute("regDate") != null ? request.getSession().getAttribute("regDate").toString() : "";
		String p_content = request.getSession().getAttribute("content") != null ? request.getSession().getAttribute("content").toString() : "";
		
		request.setAttribute("ntcIdx",p_ntcIdx);
		request.setAttribute("title",p_title);
		request.setAttribute("regDate",p_regDate);
		request.setAttribute("content",p_content);*/
		String path = "";
		path = "/WEB-INF/views/admin/notice/adminNoticeView.jsp";
		/*
		if (noticeList != null) {
			
			path = "/WEB-INF/views/admin/notice/adminNoticeView.jsp";
			request.setAttribute("noticeList", noticeList);

		} else {
//	    	           --에러발생-1

		}
*/
		request.getRequestDispatcher(path).forward(request, response);

	}

}

