package com.homebab.users.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.mypage.model.dto.MyInfoDTO;
import com.homebab.users.mypage.service.MyInfoPageService;

/**
 * <pre>
 *   나의 정보조회 서블릿 
 * </pre>
 * @author hani
 *
 */
@WebServlet("/myinfo/select")
public class MyInfoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int loginUserIdx = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getMemberIdx();
		System.out.println("login session > " + loginUserIdx);
		
		MyInfoPageService myInfo = new MyInfoPageService();
				
		List<UsersMngDTO> userList = myInfo.selectMember(loginUserIdx);
		
		System.out.println("매퍼 찍고온 userList : " + userList);
		
		String path = "";
		
		if(path != null) {
			
			path = "/WEB-INF/views/users/mypage/myInfo.jsp";
			request.setAttribute("value", "1");
			
		} else {
			path = "/WEB-INF/views/error/500.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
