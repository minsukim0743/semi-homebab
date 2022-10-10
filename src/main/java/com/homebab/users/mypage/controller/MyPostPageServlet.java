package com.homebab.users.mypage.controller;

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
import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.mypage.model.dto.MyPostDTO;
import com.homebab.users.mypage.model.dto.MyRecipeDTO;
import com.homebab.users.mypage.service.MyPostService;

/**
 * <pre>
 * 나의 게시물 조회하기 servlet
 * </pre>
 */
@WebServlet("/mypost/page")
public class MyPostPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
		 * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
		 * */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		/* 전체 게시물 수가 필요하다.
		 * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
		 * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
		 * */
		int loginUserIdx = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getMemberIdx();
		
		MyPostService myPostService = new MyPostService();
		int totalCount = myPostService.selectPostTotalCount(loginUserIdx);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("selectCriteria", selectCriteria);
		map.put("loginUserIdx", loginUserIdx);
		
		System.out.println(selectCriteria);
		
		/* 조회해온다 */
		List<MyPostDTO> myRecipeList = myPostService.selectPostList(map);	
		
		System.out.println("xml 찍고 온 값 : " + myRecipeList);
		
		String path = "";
		
		if(myRecipeList != null) {
			
			path = "/WEB-INF/views/users/mypage/mypage.jsp";
			request.setAttribute("myPageList", myRecipeList);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("type", "myPost");
			request.setAttribute("value", "3");
		} else {
		
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시글 조회를 실패하였습니다. ");
			
		}
		
	 request.getRequestDispatcher(path).forward(request, response);
	
		
	}


}
