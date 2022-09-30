package com.homebab.users.freeboard.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.homebab.users.freeboard.model.dto.FreeboardDTO;
import com.homebab.users.freeboard.model.dto.FreeboardFileUploadDTO;
import com.homebab.users.freeboard.service.FreeboardService;
import com.homebab.users.login.model.dto.UsersMngDTO;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Servlet implementation class FreeboardUpdateServlet
 */
@WebServlet("/freeboard/users/update")
public class FreeboardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 	throws ServletException, IOException {

		HttpSession session = request.getSession();

		int fbIdx = Integer.parseInt(request.getParameter("fbIdx"));

		System.out.println("fbIdx test : " + fbIdx);
		
		FreeboardDTO freeboard = new FreeboardService().selectFreeboardDetail(fbIdx);

		System.out.println("나오는건가요?" + freeboard);

		String path = "";

		if (freeboard != null) {
			
			path = "/WEB-INF/views/users/freeboard/freeboardUpdate.jsp";
			request.setAttribute("freeboard", freeboard);
		} else {

			path = "/WEB-INF/views/common/failedPage.jsp";
			request.setAttribute("message", "자유 게시판 수정 실패!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		Map<String,String> fileMap = new HashMap<>();
		Map<String,String> parameter = new HashMap<>();
		List<Map<String,String>> fileList = new ArrayList<>();
		
		if (ServletFileUpload.isMultipartContent(request)) {

			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";

			String fileUploadDirectory = rootLocation + "/upload/freeBoard/original/";
			String thumbnailDirectory = rootLocation + "/upload/freeBoard/subb/";

			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			directory.mkdir();
			directory2.mkdir();

			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);

			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);

//				for (FileItem item : fileItems) {
//
//					System.out.println(item);
//				}

				/* 위에서 출력해본 모든 item들을 다 처리할 것이다. */
				for (int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);

					if (!item.isFormField()) {

						/* 파일 데이터인 경우 */
						if (item.getSize() > 0) {

							String filedName = item.getFieldName();
							String originFileName = item.getName();

							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);

							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;

							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);

							item.write(storeFile);
							
							fileMap.put("filedName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);

							fileList.add(fileMap);
							
							int width = 0;
							int height = 0;
							if ("freeboardfile".equals(filedName)) {
								fileMap.put("fileType", "TITLE");

								/* 썸네일로 변환 할 사이즈를 지정한다. */
								width = 350;
								height = 200;
							} 

							/* 썸네일로 변환 후 저장한다. */
							Thumbnails.of(fileUploadDirectory + randomFileName).size(width, height)
									.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);

							/* 나중에 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다. */
							fileMap.put("thumbnailPath", "/upload/freeBoard/subb/thumbnail_" + randomFileName);

							fileList.add(fileMap);

						}

					} else {

						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));

					}
				}

				HttpSession session = request.getSession();

				int memberIdx = ((UsersMngDTO) session.getAttribute("loginUser")).getMemberIdx();
				String name = ((UsersMngDTO) session.getAttribute("loginUser")).getName();
				Date modDate = new Date(System.currentTimeMillis());

				System.out.println(memberIdx);
				
				FreeboardDTO freeboard = new FreeboardDTO();
				freeboard.setFbIdx(Integer.parseInt(parameter.get("fbIdx")));
				freeboard.setTitle(parameter.get("title"));
				freeboard.setContent(parameter.get("content"));
				freeboard.setMemberIdx(memberIdx);
				freeboard.setRegDate(modDate);

				
				System.out.println(freeboard);
				
				int fbIdx = Integer.parseInt(parameter.get("fbIdx"));
				
				freeboard.setFileList(new ArrayList<FreeboardFileUploadDTO>());
				List<FreeboardFileUploadDTO> list = freeboard.getFileList();
				for (int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);

					FreeboardFileUploadDTO tempFileInfo = new FreeboardFileUploadDTO();
					
					tempFileInfo.setFbIdx(fbIdx);
					tempFileInfo.setOrgname(file.get("originFileName"));
					tempFileInfo.setFilename(file.get("filedName"));
					tempFileInfo.setPath(file.get("thumbnailPath"));


					list.add(tempFileInfo);
				}
				
				freeboard.setFileList(list);

				
				System.out.println("sdk;jbvsdlk b;ds너무해" + list);
				FreeboardService freeboardService = new FreeboardService();

				int result = freeboardService.freeboardUpdate(freeboard);

				System.out.println("result result result result " + result );
				System.out.println("result result result result " + freeboard );
				
				String path = "";
				if (result > 0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "FreeboardUpdate");
					request.setAttribute("fbIdx", Integer.parseInt(parameter.get("fbIdx")));

				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "자유 게시판 수정 실패!");
				}

				request.getRequestDispatcher(path).forward(request, response);

			} catch (Exception e) {
				// 어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다.
				int cnt = 0;
				for (int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);

					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();

					if (isDeleted) {
						cnt++;
					}
				}

				if (cnt == fileList.size()) {
					System.out.println("업로드에 실패한 모든 사진 삭제 완료!");
					e.printStackTrace();
				} else {
					e.printStackTrace();
				}

			}

		}
	}

}
