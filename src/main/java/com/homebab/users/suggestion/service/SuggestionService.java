package com.homebab.users.suggestion.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.common.pagin.SelectCriteria;
import com.homebab.users.suggestion.model.dao.SuggestionMapper;
import com.homebab.users.suggestion.model.dto.SuggestionDTO;




public class SuggestionService {

	private SuggestionMapper suggestionMapper;

	public List<SuggestionDTO> selectAllSuggestionList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		suggestionMapper = sqlSession.getMapper(SuggestionMapper.class);
		List<SuggestionDTO> suggestionList = suggestionMapper.selectAllSuggestionList(selectCriteria);
		
		System.out.println("=>>>>>>>>>>>>>>" + suggestionList);
		
		sqlSession.close();
		
		return suggestionList;
		
	}

	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		suggestionMapper = sqlSession.getMapper(SuggestionMapper.class);
		
		int totalCount = suggestionMapper.selectTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;	
	}

	public int insertSuggestion(SuggestionDTO suggestion) {
		
		SqlSession sqlSession = getSqlSession();
		suggestionMapper = sqlSession.getMapper(SuggestionMapper.class);
		
		int result = suggestionMapper.insertSuggestion(suggestion);
		
		System.out.println("result" + result);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	public SuggestionDTO selectSuggestionDetail(int sgtIdx) {

		SqlSession sqlSession = getSqlSession();
		suggestionMapper = sqlSession.getMapper(SuggestionMapper.class);
		
		SuggestionDTO suggestionDetail = suggestionMapper.selectSuggestionDetail(sgtIdx);
		
		System.out.println("suggestionDetailsuggestionDetailsuggestionDetail"+ suggestionDetail);
		
		sqlSession.close();

		return suggestionDetail;

	}

	public int suggestionUpdate(SuggestionDTO suggestion) {
		
		SqlSession sqlSession = getSqlSession();
		suggestionMapper = sqlSession.getMapper(SuggestionMapper.class);
		
		int result = suggestionMapper.suggestionUpdate(suggestion);
		
		System.out.println("result" + result);
		
		if(result > 0) {
			
			sqlSession.commit();
		}else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int suggestionDelete(int sgtIdx) {
		
		SqlSession sqlSession = getSqlSession();
		suggestionMapper = sqlSession.getMapper(SuggestionMapper.class);
		
		int result = suggestionMapper.suggestionDelete(sgtIdx);
		
		System.out.println("HTTP 상태 405 – 허용되지 않는 메소드" + result);
		
		if (result > 0) {

			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}

		sqlSession.close();

		return result;
	}

}
