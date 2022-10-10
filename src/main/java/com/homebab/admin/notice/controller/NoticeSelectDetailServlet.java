package com.homebab.admin.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.admin.login.model.dto.AdminDTO;
import com.homebab.admin.notice.model.dto.NoticeDTO;
import com.homebab.admin.notice.service.Noticeservice;

/**
 * Servlet implementation class NoticeSelectDetailServlet
 */
@WebServlet("/adminNotice/insert")
public class NoticeSelectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeSelectDetailServlet() {}

    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String path = "/WEB-INF/views/admin/notice/adminNoticeInsert.jsp";
    	
    	request.getRequestDispatcher(path).forward(request, response);
    	
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Object loginAdmin = request.getSession().getAttribute("loginAdmin");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int memberIdx = 0;
		
		if(loginAdmin != null) memberIdx = ((AdminDTO) loginAdmin).getMemberIdx();
		
		Noticeservice noticeservice = new Noticeservice();
		NoticeDTO noticeList = new NoticeDTO();
		 
		noticeList.setTitle(title);
		noticeList.setContent(content);
		noticeList.setMemberIdx(memberIdx);
		
		int result = noticeservice.insertNotice(noticeList);
		
		
		if(result > 0) {
			
		} else {
			
		}
		System.out.println(title);
		System.out.println(content);
		System.out.println(memberIdx);
		String path = "";
		
		if (noticeList != null) {
			
			  path ="/adminNotice/select";
		         response.sendRedirect(request.getContextPath() + path);
		} 

	}

}
