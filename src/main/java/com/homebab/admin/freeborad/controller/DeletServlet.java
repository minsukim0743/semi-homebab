package com.homebab.admin.freeborad.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.homebab.admin.freeborad.service.FreeBoradService;

/**
 * Servlet implementation class DeletServlet
 */
@WebServlet("/delet/admin/servlet")
public class DeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String pbIdx = request.getParameter("pbIdx");
	
	FreeBoradService service = new FreeBoradService();
	int result = service.deletborad(pbIdx); 
	
	String path = "/adminFreeboard/select"; 
	
	if(result > 0 ) {
		
		response.sendRedirect(request.getContextPath()+path);
	} else {
		
		 JOptionPane.showMessageDialog(null, "실패하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		 response.sendRedirect(request.getContextPath()+path);
	}
	
	
	}

}
