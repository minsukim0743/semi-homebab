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
 * Servlet implementation class DeleteRecipeCommentsServlet
 */
@WebServlet("/recipeComments/delete")
public class DeleteRecipeCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parameter = request.getParameter("rcpIdx");
		
		System.out.println("parameter : " + parameter);
		
		String[] arrIdx = parameter.split("\\?");
		
		String rcpIdx = arrIdx[0];
		
		String paramMemberIdx = arrIdx[1];
		String[] arrMemberIdx = paramMemberIdx.split("\\=");
		String memberIdx = arrMemberIdx[1];
		
		String paramCmtIdx = arrIdx[2];
		String[] arrCmtIdx = paramCmtIdx.split("\\=");
		String cmtIdx = arrCmtIdx[1];		
		
		System.out.println("rcpIdx " + rcpIdx);
		System.out.println("memberIdx " + memberIdx);
		System.out.println("cmtIdx " + cmtIdx);
				
		Map<String, String> delete = new HashMap<>();
		delete.put("rcpIdx", rcpIdx);
		delete.put("memberIdx", memberIdx);
		delete.put("cmtIdx", cmtIdx);
		
		System.out.println("delete : " + delete);
		
		RecipeCommentsService service = new RecipeCommentsService();
		
		int result = service.commentsDelete(delete);
		
		if(result > 0) {
			
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		} else {
			 
			JOptionPane.showMessageDialog(null, "실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect(request.getContextPath()+"/recipeComments/view?rcpIdx="+rcpIdx);
		}	
	
	}

}
