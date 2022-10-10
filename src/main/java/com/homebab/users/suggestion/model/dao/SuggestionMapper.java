package com.homebab.users.suggestion.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.common.pagin.SelectCriteria;
import com.homebab.users.suggestion.model.dto.SuggestionDTO;

public interface SuggestionMapper {


	int selectTotalCount(Map<String, String> searchMap);

	List<SuggestionDTO> selectAllSuggestionList(SelectCriteria selectCriteria);

	SuggestionDTO selectSuggestionDetail(int sgtIdx);
	
	int insertSuggestion(SuggestionDTO suggestion);

	int suggestionUpdate(SuggestionDTO suggestion);

	int suggestionDelete(int sgtIdx);




}
