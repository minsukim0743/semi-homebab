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
@WebServlet("/adminNotice/select")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Noticeservice noticexx = new Noticeservice();
		NoticeDTO noticedto = new NoticeDTO();
		//noticedto.setNtcIdx(0);
		noticedto.setTitle("");
		noticedto.setContent("");
		
		List<NoticeDTO> noticeList = noticexx.selectNoticeList(noticedto);

		System.out.println("noticeList : " + noticeList);
		
		String path = "";
		
		if (noticeList != null) {
			
			path = "/WEB-INF/views/admin/notice/adminNotice.jsp";
			request.setAttribute("noticeList", noticeList);

		} else {
//	    	           --에러발생-1

		}

		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeDTO noticedto = new NoticeDTO();
		
		//게시글 번호로 삭제하기
		String p_dBool = request.getParameter("dBool");
		String p_dNum = request.getParameter("dNum");
		System.out.println(p_dBool);
		System.out.println(p_dNum);
		Noticeservice noticexx = new Noticeservice();
		
		if(p_dBool != null && p_dNum != null && p_dBool.equals("Y")) {
			noticedto.setNtcIdx(Integer.parseInt(p_dNum));
			int result = noticexx.deleteNotice(noticedto);
		}
		
		int p_stype = request.getParameter("stype") != null ? Integer.parseInt(request.getParameter("stype")) : 0;
		String p_svalue = request.getParameter("svalue") != null ? request.getParameter("svalue") : "";
		
		
		
		switch(p_stype) {
			case 1:
				//noticedto.setNtcIdx(Integer.parseInt(p_svalue));
				//noticedto.setTitle("");
				//noticedto.setContent("");
				break;
			case 2:
				//noticedto.setNtcIdx(0);
				noticedto.setTitle(p_svalue);
				noticedto.setContent("");
				break;
			case 3:
				//noticedto.setNtcIdx(0);
				noticedto.setTitle("");
				noticedto.setContent(p_svalue);
				break;
			default:
				//noticedto.setNtcIdx(0);
				noticedto.setTitle("");
				noticedto.setContent("");
				break;
		}
		
		
		List<NoticeDTO> noticeList = noticexx.selectNoticeList(noticedto);

		System.out.println("noticeList : " + noticeList);
		
		String path = "";
		
		if (noticeList != null) {
			
			path = "/WEB-INF/views/admin/notice/adminNotice.jsp";
			request.setAttribute("noticeList", noticeList);

		} else {
//	    	           --에러발생-1

		}

		request.getRequestDispatcher(path).forward(request, response);

	}
}
