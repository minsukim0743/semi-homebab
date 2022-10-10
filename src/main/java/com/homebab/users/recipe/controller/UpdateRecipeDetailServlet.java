package com.homebab.users.recipe.controller;

import java.io.File;
import java.io.IOException;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.homebab.users.login.model.dto.UsersMngDTO;
import com.homebab.users.recipe.model.dto.RecipeDTO;
import com.homebab.users.recipe.model.dto.RecipeFileUploadDTO;
import com.homebab.users.recipe.service.RecipeService;

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/recipe/update")
public class UpdateRecipeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rcpIdx = Integer.parseInt(request.getParameter("rcpIdx"));
		
		RecipeService recipeService = new RecipeService();
		RecipeDTO recipe = recipeService.updateSelectRecipe(rcpIdx);
		
		System.out.println(recipe);
		
		String path = "";
		if(recipe != null) {
		
			System.out.println(recipe);
			path = "/WEB-INF/views/users/recipe/updateRecipe.jsp";
			request.setAttribute("recipe", recipe);
			
		
		} else {
			System.out.println(recipe);
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "레시피 게시물 수정 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> fileMap = new HashMap<>();
		Map<String, String> parameter = new HashMap<>();
		List<Map<String, String>> fileList = new ArrayList<>();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			
			System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
			
			String fileUploadDirectory = rootLocation + "/upload/recipe/original/";
			String thumbnailDirectory = rootLocation + "/upload/recipe/sub/";
			
			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			directory.mkdirs();
			directory2.mkdirs();
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory)); 
			fileItemFactory.setSizeThreshold(maxFileSize);
			
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(int i = 0; i < fileItems.size(); i++) {
					
					FileItem item = fileItems.get(i);
					
					if(!item.isFormField()) {
						
						if(item.getSize() > 0) {
							
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
							if("recipeKeyVisual".equals(filedName)) {
								
								width = 800;
								height = 400;
							}
							
							Thumbnails.of(fileUploadDirectory + randomFileName)
									.size(width, height)
									.toFile(thumbnailDirectory + "recipe_" + randomFileName);
							
							fileMap.put("recipePath", "/upload/recipe/sub/recipe_" + randomFileName);
							
							fileList.add(fileMap);
							
						}
						
					} else {
						
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					}
				}
				
				RecipeDTO recipe = new RecipeDTO();
				
				System.out.println("fileList : " + fileList);
				System.out.println("parameter : " + parameter);
				
				int memberIdx = ((UsersMngDTO) request.getSession().getAttribute("loginUser")).getMemberIdx();
				
				recipe.setTitle(parameter.get("recipeTitle")); 
				recipe.setContent(parameter.get("content"));
				recipe.setMemberIdx(memberIdx);
				recipe.setCtgrIdx(Integer.parseInt(parameter.get("category")));
				recipe.setServing(Integer.parseInt(parameter.get("recipeServing")));
				recipe.setCookingTime(Integer.parseInt(parameter.get("cookingTime")));
				recipe.setRcpIdx(Integer.parseInt(parameter.get("rcpIdx")));
				
				int rcpIdx = Integer.parseInt(parameter.get("rcpIdx"));
				
				recipe.setFileList(new ArrayList<RecipeFileUploadDTO>());
				List<RecipeFileUploadDTO> list = recipe.getFileList(); 
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					RecipeFileUploadDTO FileInfo = new RecipeFileUploadDTO();
					FileInfo.setOrgName(file.get("originFileName"));
					FileInfo.setChangeFileName(file.get("savedFileName"));
					FileInfo.setMainPaht(file.get("savePath"));
					FileInfo.setSubPath(file.get("recipePath"));
					
					list.add(FileInfo);
				}
				
				RecipeService recipeService = new RecipeService();
				
				int result = recipeService.updateRecipe(recipe, rcpIdx);
				
				String path = "";
				
				if (result > 0) {

					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "updateRecipe");
					request.setAttribute("rcpIdx", Integer.parseInt(parameter.get("rcpIdx")));
				} else {
					
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "레시피 게시판 수정에 실패하셨습니다.");
				}

				 request.getRequestDispatcher(path).forward(request, response); 
				
				
			} catch (Exception e) {
				
				int cnt = 0;
				for(int i = 0; i < fileList.size(); i++) {
					
					Map<String, String> file = fileList.get(i);
					
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				
				if(cnt == fileList.size()) {
					
					e.printStackTrace();
					System.out.println("업로드에 실패한 모든 사진 삭제 완료!");
				} else {
						
					e.printStackTrace();
				}
			} 
		}	

	}
	
}
