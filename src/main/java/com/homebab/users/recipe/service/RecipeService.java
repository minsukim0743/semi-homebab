package com.homebab.users.recipe.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.users.recipe.model.dao.RecipeMapper;
import com.homebab.users.recipe.model.dto.RecipeCommentsDTO;
import com.homebab.users.recipe.model.dto.RecipeDTO;
import com.homebab.users.recipe.model.dto.RecipeFileUploadDTO;
import com.homebab.users.recipe.model.dto.RecipeLikeDTO;

public class RecipeService {

	private RecipeMapper recipeMapper;

	/**
	 * <pre>
	 *   레시피 등록 메소드
	 * </pre>
	 * 
	 * @param recipe
	 * @return
	 */

	public int insertRecipe(RecipeDTO recipe) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		int result = 0;

		int recipeResult = recipeMapper.insertRecipe(recipe);

		List<RecipeFileUploadDTO> fileList = recipe.getFileList();

		for (int i = 0; i < fileList.size(); i++) {

			fileList.get(i).setRcpIdx(recipe.getRcpIdx());

		}

		int recipeFileUpload = 0;

		recipeFileUpload += recipeMapper.insertFileUpload(fileList.get(0));

		if (recipeResult > 0 && recipeFileUpload > 0) {

			sqlSession.commit();

			result = 1;
		} else {

			sqlSession.rollback();

		}

		sqlSession.close();

		return result;

	}

	/**
	 * <pre>
	 *   레시피 전체 게시글 조회
	 * </pre>
	 * 
	 * @return
	 */

	public List<RecipeDTO> selectRecipeList(SelectCriteria selectCriteria) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		List<RecipeDTO> recipeList = recipeMapper.selectRecipeList(selectCriteria);

		sqlSession.close();

		return recipeList;

	}

	/**
	 * <pre>
	 *   레시피명으로 레시피 상세페이지 조회
	 *   클릭시 조회수 증가
	 * </pre>
	 * 
	 * @param rcpIdx
	 * @return
	 */

	public RecipeDTO selectOneRecipeWriting(int rcpIdx) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);
		
		RecipeDTO recipe = null;
		
		int result = recipeMapper.incrementRecipeCount(rcpIdx);
		
		if (result > 0) {
			
			recipe = recipeMapper.selectOneRecipeWriting(rcpIdx);

			if(recipe != null) {

				sqlSession.commit();

			} else {

				sqlSession.rollback();

			}

		} else {

			sqlSession.rollback();

		}
		
		sqlSession.close();
		
		return recipe; 
		
	}

	/**
	 * <pre>
	 *   레시피 카테고리 조회
	 * </pre>
	 * @param ctgrTit1
	 * @return
	 */

	public List<RecipeDTO> selectRecipeCategory(String ctgrTit) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		List<RecipeDTO> recipe = recipeMapper.selectRecipeCategory(ctgrTit);

		sqlSession.close();

		return recipe;

	}

	/**
	 * <pre>
	 *   레시피 삭제 메소드
	 * </pre>
	 * @param rcpIdx
	 * @return
	 */

	public int deleteFile(int rcpIdx) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		System.out.println("deleteFile check");

		int deleteResult = recipeMapper.deleteFile(rcpIdx);

		System.out.println("deleteFile check : " + deleteResult);

		int result = 0;
		
		int deleteResult2 = 0;
		
		if(deleteResult > 0) {

			deleteResult2 = recipeMapper.deleteRecipe(rcpIdx);

			System.out.println("deleteFile check2 : " + deleteResult2);

		} 
		
		if(deleteResult > 0 && deleteResult2 > 0) {
			
			sqlSession.commit();

			result = 1;

		} else {
			
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;

	}
	
	/**
	 * <pre>
	 *   수정 할 레시피 조회
	 * </pre>
	 * @param rcpIdx
	 * @return
	 */

	public RecipeDTO updateSelectRecipe(int rcpIdx) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);
		
		RecipeDTO recipe = recipeMapper.updateSelectRecipe(rcpIdx);
		
		sqlSession.close();
		
		return recipe;

	}
	
	/**
	 * <pre>
	 *   레시피 수정 메소드
	 * </pre>
	 * @param recipe
	 * @return
	 */

	public int updateRecipe(RecipeDTO recipe, int rcpIdx) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);
		
		int result = 0;

		recipe.setRcpIdx(rcpIdx);
		
		System.out.println("레시피 출력 테스트 : " + recipe);

		int insertFileResult = 0;

		int recipeResult = recipeMapper.updateRecipe(recipe);

		/* 수정해야할 파일 존재할 경우 */

		if(recipe.getFileList() != null) {

			int deleteResult = recipeMapper.deleteFile(rcpIdx);

			/* 삭제 완료 되었을 경우 */

			if(deleteResult > 0) {

				/* 새로 첨부된 파일 넣기 */

				RecipeFileUploadDTO recipeFile = recipe.getFileList().get(0);

				recipeFile.setRcpIdx(rcpIdx);

				insertFileResult = recipeMapper.updateInsertFileUpload(recipeFile);

			}

		}
		
		System.out.println("recipeResult : " + recipeResult);
		
		if(recipeResult > 0 || insertFileResult > 0) {
			
			sqlSession.commit();

			result = 1;
			
		} else {
			
			sqlSession.rollback();

		}
		
		sqlSession.close();

		return result;

	}

	/**
	 * <pre>
	 *   Paging 관련 메소트 (토탈 카운트)
	 * </pre>
	 * @param rcpIdx
	 * @return
	 */

	public int selectTotalCount() {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);
		
		int totalCount = recipeMapper.selectTotalCount();
		
		sqlSession.close();
		
		return totalCount;

	}

	/**
	 * <pre>
	 *   레시피 검색 메소드
	 * </pre>
	 * @param keyword
	 * @param type
	 * @return
	 */

	public List<RecipeDTO> searchRecipe(String keyword, String type) {
		
		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		List<RecipeDTO> searchList = recipeMapper.searchRecipe(keyword, type);

		sqlSession.close();
		return searchList;
	}

	/**
	 * <pre>
	 *   레시피 상세페이지 추천수 증가
	 * </pre>
	 * @param rcpIdx
	 * @param memberIdx
	 * @return
	 */

	public int likeCountRecipe(int rcpIdx, int memberIdx, String stateYn) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		int result = 0;
		
		int table = recipeMapper.likeCountRecipe(rcpIdx, memberIdx, stateYn);

		if(table > 0 ) {
			
			int likeCount = recipeMapper.likeCountRecipe2(rcpIdx);
			
			if(likeCount > 0 ) {
				
				result = 1;

				sqlSession.commit();

			}
			
		} else {
			
			sqlSession.rollback();

		}
		
		sqlSession.close();
		
		return result;

	}

	/**
	 * <pre>
	 *  레시피 상세페이지 추천수 감소
	 * </pre>
	 * @param rcpIdx
	 * @param memberIdx
	 * @param stateYn
	 * @return
	 */

	public int likeCancelRecipe(int rcpIdx, int memberIdx, String stateYn) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		int result = 0;
		
		int deleteTableRecipe = recipeMapper.deleteTableRecipe(rcpIdx, memberIdx, stateYn);
		
		if(deleteTableRecipe > 0 ) {
			
			int likeCencel = recipeMapper.likeCencelRecipe(rcpIdx);
			
			if(likeCencel > 0 ) {

				result = 1;

				sqlSession.commit();

			}
			
		} else {
			
			sqlSession.rollback();

		}
		
		sqlSession.close();
		
		return result;

	}

	/**
	 * <pre>
	 *   레시피 댓글 조회 메소드
	 * </pre>
	 * @param commentsMap
	 * @return
	 */

	public List<RecipeCommentsDTO> recipeCommentsSelect(Map<Object, Object> commentsMap) {
		
		SqlSession sqlSession = getSqlSession();

		recipeMapper = sqlSession.getMapper(RecipeMapper.class);

		List<RecipeCommentsDTO> recipeCommentsList = recipeMapper.recipeCommentsSelect(commentsMap);
		
		sqlSession.close();
		
		return recipeCommentsList;

	}

	/**
	 * <pre>
	 *   레시피 댓글 개수 조회
	 * </pre>
	 * @param rcpIdx
	 * @return
	 */

	public int recipeCommentsCount(int rcpIdx) {

		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);
		
		int totalCount = recipeMapper.recipeCommentsCount(rcpIdx);
		
		sqlSession.close();
		
		return totalCount;

	}

	/**
	 * <pre>
	 *   추천 누른 사용자 리스트 조회
	 * </pre>
	 * @param rcpIdx
	 * @param memberIdx
	 * @return
	 */

	public RecipeLikeDTO selectRecipeLike(int rcpIdx, int memberIdx) {


		
		SqlSession sqlSession = getSqlSession();


		recipeMapper = sqlSession.getMapper(RecipeMapper.class);


		
		RecipeLikeDTO likeRecipe = recipeMapper.selectRecipeLike(rcpIdx,memberIdx);


		
		sqlSession.close();


		
		return likeRecipe;


	}
	
	public RecipeLikeDTO selectRecipeLike2(int rcpIdx) {
		
		SqlSession sqlSession = getSqlSession();


		recipeMapper = sqlSession.getMapper(RecipeMapper.class);


		
		RecipeLikeDTO likeRecipe = recipeMapper.selectRecipeLike2(rcpIdx);


		
		sqlSession.close();


		
		return likeRecipe;
	}

	
	/**
	 * <pre>
	 *   메인페이지 추천 오름차순 추천레시피 조회
	 * </pre>
	 * @return
	 */

	public List<RecipeDTO> selectLikeRecipeList() {
		
		SqlSession sqlSession = getSqlSession();
		recipeMapper = sqlSession.getMapper(RecipeMapper.class);
		
		List<RecipeDTO> selectLikeRecipeList = recipeMapper.seleteLikeRecipeList();
		
		sqlSession.close();
		
		return selectLikeRecipeList;

	}


	


}
