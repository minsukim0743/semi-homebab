package com.homebab.admin.recipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.homebab.admin.recipe.service.AdminRecipeListService;

/**
 * Servlet implementation class AdminRecipeDeleteServlet
 */
@WebServlet("/adminRecipe/delete")
public class AdminRecipeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		String number = request.getParameter("delete");
		
		System.out.println("currentPage :" + currentPage);
		System.out.println("number :" + number);
		
		AdminRecipeListService service = new AdminRecipeListService();
		
		int result = service.adminDelete(number);
		
		System.out.println("result : " + result);
		
		  if(result > 0) {
			  
			  JOptionPane.showMessageDialog(null, "삭제되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			  response.sendRedirect(request.getContextPath()+"/adminRecipe/list?currentPage="+currentPage);
		  } else {
			  JOptionPane.showMessageDialog(null, "실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			  response.sendRedirect(request.getContextPath()+"/adminRecipe/list?currentPage="+currentPage);
		  }
		
	
	}

}
