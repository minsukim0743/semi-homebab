package com.homebab.admin.suggestion.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.suggestion.model.dao.AdminSuggestionMapper;
import com.homebab.admin.suggestion.model.dto.AdminSuggestionsDTO;

public class AdminSuggestionListService {

	private AdminSuggestionMapper adminSuggestionMapper;
	
	public List<AdminSuggestionsDTO> allSelectSuggestion() {
		
		SqlSession sqlSession = getSqlSession();
		adminSuggestionMapper = sqlSession.getMapper(AdminSuggestionMapper.class);

		List<AdminSuggestionsDTO> aaList = adminSuggestionMapper.allSelectSuggestion();
		
		sqlSession.close();
		
		return aaList;
	}

	public AdminSuggestionsDTO selectSuggestionDetail(int sgtIdx) {
		SqlSession sqlSession = getSqlSession();
		adminSuggestionMapper = sqlSession.getMapper(AdminSuggestionMapper.class);
		
		AdminSuggestionsDTO suggestionDetail = adminSuggestionMapper.selectSuggestionDetail(sgtIdx);
		
		sqlSession.close();

		return suggestionDetail;

	}

	public int deleteSgtIdx(String dNum) {
		SqlSession sqlSession = getSqlSession();
		adminSuggestionMapper = sqlSession.getMapper(AdminSuggestionMapper.class);
		
		int result = adminSuggestionMapper.deleteSgtIdx(dNum);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}


	

}
