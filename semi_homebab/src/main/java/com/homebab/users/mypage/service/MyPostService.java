package com.homebab.users.mypage.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.users.mypage.model.dao.MyPostMapper;
import com.homebab.users.mypage.model.dto.MyPostDTO;
import com.homebab.users.mypage.model.dto.MyRecipeDTO;
import com.homebab.users.mypage.model.dto.MySuggestionsDTO;

public class MyPostService {
	
	private MyPostMapper myPostMapper;
	

	/**
	 * <pre>
	 * 나의 레시피 조회 메소드 
	 * </pre>
	 * @param loginUser session 담은 값  
	 * @return
	 */
	public List<MyRecipeDTO> selectRecipeList(Map<String, Object> map) {
		

		SqlSession sqlSession = getSqlSession();
		
		myPostMapper = sqlSession.getMapper(MyPostMapper.class);
		
		List<MyRecipeDTO> myReceipeList = myPostMapper.selectRecipeList(map);
		System.out.println("매퍼 고 온 값 : " + myReceipeList);
		sqlSession.close();
		
		return myReceipeList;
	}

	
	/**
	 * <pre>
	 *   나의 게시물 조회 메소드 
	 * </pre>
	 * @param map
	 * @return
	 */
	public List<MyPostDTO> selectPostList(Map<String, Object> map) {
		
		SqlSession sqlSession = getSqlSession();
		
		myPostMapper = sqlSession.getMapper(MyPostMapper.class);
		
		List<MyPostDTO> myReceipeList = myPostMapper.selectPostList(map);
		System.out.println("매퍼 고 온 값 : " + myReceipeList);
		sqlSession.close();
		
		return myReceipeList;
	}
	
	/**
	 * 나의 건의사항 조회하는 서비스 메소드 
	 * @param loginUser session 담은 값  
	 * @return
	 */
	public List<MySuggestionsDTO> selectSuggestionsList(Map<String, Object> map) {
		
		SqlSession sqlSession = getSqlSession();
		
		myPostMapper = sqlSession.getMapper(MyPostMapper.class);
		
		List<MySuggestionsDTO> myReceipeList = myPostMapper.selectSuggestionsList(map);
		System.out.println("매퍼 고 온 값 : " + myReceipeList);
		sqlSession.close();
		
		return myReceipeList;
	}


	/**
	 * <pre>
	 *   페이징 처리를 위한 나의 전체 레시피 게시물 수 조회용 메소드 
	 * </pre>
	 * @param loginUserIdx 
	 * @return 
	 */
	public int selectRecipeTotalCount(int loginUserIdx) {
		
		SqlSession sqlSession = getSqlSession();
		
		myPostMapper = sqlSession.getMapper(MyPostMapper.class);
		
		int result = myPostMapper.selectRecipeTotalCount(loginUserIdx);
		System.out.println("result > " + result);
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   페이징 처리를 위한 나의 전체 자유게시판 게시물 수 조회용 메소드 
	 * </pre>
	 * @param loginUserIdx 
	 * @return 
	 */
	public int selectPostTotalCount(int loginUserIdx) {
		
		SqlSession sqlSession = getSqlSession();
		
		myPostMapper = sqlSession.getMapper(MyPostMapper.class);
		
		int result = myPostMapper.selectPostTotalCount(loginUserIdx);
		System.out.println("result > " + result);
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   페이징 처리를 위한 나의 전체 건의사항 게시물 수 조회용 메소드 
	 * </pre>
	 * @param loginUserIdx 
	 * @return 
	 */
	public int selectSuggestionsTotalCount(int loginUserIdx) {
		
		SqlSession sqlSession = getSqlSession();
		
		myPostMapper = sqlSession.getMapper(MyPostMapper.class);
		
		int result = myPostMapper.selectSuggestionsTotalCount(loginUserIdx);
		System.out.println("result > " + result);
		sqlSession.close();
		
		return result;
	}









	
	
}
