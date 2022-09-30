package com.homebab.users.recipe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.recipe.service.RecipeCommentsService;

/**
 * Servlet implementation class RecipeCommentsServlet
 */
@WebServlet("/recipeComments/insert")
public class RecipeCommentsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmtContent = request.getParameter("cmtContent");
		String rcpIdx = request.getParameter("rcpIdx");
		
		HttpSession session = request.getSession(); 
		UsersMngDTO loginUser = (UsersMngDTO) session.getAttribute("loginUser");
		
		int memberIdx = loginUser.getMemberIdx();
		
		System.out.println("memberIdx : " + memberIdx);
		System.out.println("rcpIdx : " + rcpIdx);
		
		RecipeCommentsService service = new RecipeCommentsService();
		
		Map<String, Object> commentInsert = new HashMap<>();
		commentInsert.put("cmtContent", cmtContent);
		commentInsert.put("memberIdx", memberIdx);
		commentInsert.put("rcpIdx", rcpIdx);
		
		
		int result = service.commentsInsert(commentInsert);
		
		if(result > 0) {
			
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		} else {
			
			JOptionPane.showMessageDialog(null, "실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		}
		
	}
}
