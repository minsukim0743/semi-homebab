package com.homebab.users.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.login.service.LoginService;

@WebServlet("/findid")
public class pathFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public pathFindIdServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/users/login/findid.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String findId = request.getParameter("findId");
		String findDate = request.getParameter("findDate");
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("findId", findId);
		hm.put("findDate", findDate);
		LoginService ls = new LoginService();
		UsersMngDTO userDTO = ls.findId(hm);
		
		System.out.println(userDTO);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(gson.toJson(userDTO));
		
		out.flush();
		out.close();
		
	}

}
