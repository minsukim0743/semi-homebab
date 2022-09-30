package com.homebab.users.recipe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.homebab.users.recipe.service.RecipeCommentsService;

/**
 * Servlet implementation class UpdateSirenRecipeComments
 */
@WebServlet("/recipeComments/insert/siren")
public class InsertSirenRecipeComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberIdx = request.getParameter("memberIdx");
		String cmtIdx = request.getParameter("cmtIdx");
		String rcpIdx = request.getParameter("rcpIdx");
	
		System.out.println("cmtIdx : " + cmtIdx);
		System.out.println("memberIdx : " + memberIdx);
		System.out.println("rcpIdx : " + rcpIdx);
	
		Map<String, String> siren = new HashMap<>();
		siren.put("cmtIdx", cmtIdx);
		siren.put("memberIdx", memberIdx);
		
		RecipeCommentsService service = new RecipeCommentsService();
		
		int result = service.insertSiren(siren);
		
		if(result> 0) {
			
			JOptionPane.showMessageDialog(null, "신고 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		} else {
			
			JOptionPane.showMessageDialog(null, "실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		}
		
	}

}
