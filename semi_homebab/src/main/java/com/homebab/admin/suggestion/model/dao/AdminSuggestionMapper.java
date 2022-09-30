package com.homebab.admin.suggestion.model.dao;

import java.util.List;

import com.homebab.admin.suggestion.model.dto.AdminSuggestionsDTO;

public interface AdminSuggestionMapper {

	List<AdminSuggestionsDTO> allSelectSuggestion();

	AdminSuggestionsDTO selectSuggestionDetail(int sgtIdx);

	int deleteSgtIdx(String dNum);


}
