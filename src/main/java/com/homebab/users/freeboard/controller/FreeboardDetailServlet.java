package com.homebab.users.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.freeboard.service.FreeboardService;

/**
 * Servlet implementation class FreeboardDetailServletR
 */
@WebServlet("/freeboard/users/detail")
public class FreeboardDetailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      int fbIdx = Integer.parseInt(request.getParameter("fbIdx"));
      System.out.println("fdIdxfdIdx" + fbIdx);
      
      FreeboardDTO freeboardDetail = new FreeboardService().selectFreeboardDetail(fbIdx);

      System.out.println("freeboardDetail : " + freeboardDetail);

      String path = "";
      
      if (freeboardDetail != null) {
         path = "/WEB-INF/views/users/freeboard/freeboardDetail.jsp";
         request.setAttribute("freeboardDetail", freeboardDetail);
      } else {
         path = "/WEB-INF/views/common/failed.jsp";
         request.setAttribute("message", "자유게시판 상세 조회 실패");
      }

      request.getRequestDispatcher(path).forward(request, response);

   }

}