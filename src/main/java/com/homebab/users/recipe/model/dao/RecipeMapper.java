package com.homebab.users.recipe.model.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.users.recipe.model.dto.RecipeCommentsDTO;
import com.homebab.users.recipe.model.dto.RecipeDTO;
import com.homebab.users.recipe.model.dto.RecipeFileUploadDTO;
import com.homebab.users.recipe.model.dto.RecipeLikeDTO;

public interface RecipeMapper {

	// 레시피 페이지 전체 리스트 조회 
	List<RecipeDTO> selectRecipeList(SelectCriteria selectCriteria);

	// 레시피 게시글 내 파일 업로드 저장
	int insertRecipe(RecipeDTO recipe);

	// 레시피 파일 등록
	int insertFileUpload(RecipeFileUploadDTO recipeFileUploadDTO);

	// 레시피 카테고리별 조회
	List<RecipeDTO> selectRecipeCategory(String ctgrTit);

	// 조회수 증가
	int incrementRecipeCount(int rcpIdx);

	// 레시피 게시물 상세조회
	RecipeDTO selectOneRecipeWriting(int rcpIdx);
	
	// 레시피 게시글 내용 수정
	int updateRecipe(RecipeDTO recipe);

	// 레시피 게시물 업로드파일 삭제
	int deleteFile(int rcpIdx);
	
	// 레시피 파일 삭제
	int deleteRecipe(int rcpIdx);

	// 수정 할 레시피 페이지 게시글 조회
	RecipeDTO updateSelectRecipe(int rcpIdx);

	// 레시피 게시글 수정 후 파일 저장
	int updateInsertFileUpload(RecipeFileUploadDTO recipeFile);

	// 레시피 검색
	List<RecipeDTO> searchRecipe(@Param("keyword")String keyword, @Param("type")String type);

	// 추천 클릭시 한 계정 중복추천을 방지하기 위하여 추천 테이블에 추가
	int likeCountRecipe(@Param("rcpIdx")int rcpIdx, @Param("memberIdx")int memberIdx);

	// 추천 클릭시 추천수 증가
	int likeCountRecipe2(@Param("rcpIdx")int rcpIdx);
	
	// 레시피 게시글 내 댓글 조회
	List<RecipeCommentsDTO> recipeCommentsSelect(Map<Object, Object> commentsMap);

	// 레시피 게시글 내 댓글 개수
	int recipeCommentsCount(int rcpIdx);
	
	// 레시피 전체 게시물 개수 조회
	int selectTotalCount();

	// 추천 클릭시 추천 테이블 내 정보 삭제
	int deleteTableRecipe(@Param("rcpIdx")int rcpIdx, @Param("memberIdx")int memberIdx);

	// 추천 클릭시 추천수 감소
	int likeCencelRecipe(@Param("rcpIdx")int rcpIdx);

	// 추천 테이블 조회
	List<RecipeLikeDTO> selectRecipeLike(@Param("rcpIdx")int rcpIdx, @Param("memberIdx")int memberIdx);

	// 추천 테이블 조회
	List<RecipeLikeDTO> selectRecipeLike2(int rcpIdx);
	
	// 메인페이지 추천레시피 추천 수 오름차순
	List<RecipeDTO> seleteLikeRecipeList();

}
