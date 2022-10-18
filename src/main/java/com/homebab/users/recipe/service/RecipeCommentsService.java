package com.homebab.users.recipe.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.users.recipe.model.dao.RecipeCommentsMapper;
import com.homebab.users.recipe.model.dto.RecipeCommentsDTO;

public class RecipeCommentsService {

	RecipeCommentsMapper commentsMapper;
	
	/**
	 * <pre>
	 *   게시물 댓글 등록
	 * </pre>
	 * @param commentInsert
	 * @return
	 */
	public int commentsInsert(Map<String, Object> commentInsert) {

		SqlSession sqlSession = getSqlSession();
		commentsMapper = sqlSession.getMapper(RecipeCommentsMapper.class);
		
		int result = commentsMapper.commentsInsert(commentInsert);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   게시물 댓글 삭제
	 * </pre>
	 * @param delete
	 * @return
	 */
	public int commentsDelete(Map<String, String> delete) {
		
		SqlSession sqlSession = getSqlSession();
		commentsMapper = sqlSession.getMapper(RecipeCommentsMapper.class);
		
		int result = commentsMapper.commentsDelete(delete);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/**
	 * <pre>
	 *   게시물 신고 기능
	 * </pre>
	 * @param siren
	 * @return
	 */
	public int insertSiren(Map<String, String> siren) {
		
		SqlSession sqlSession = getSqlSession();
		commentsMapper = sqlSession.getMapper(RecipeCommentsMapper.class);
		
		int result = commentsMapper.insertSiren(siren);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;

	}

}
