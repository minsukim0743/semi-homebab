package com.homebab.users.mypage.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.users.mypage.model.dto.MyPostDTO;
import com.homebab.users.mypage.model.dto.MyRecipeDTO;
import com.homebab.users.mypage.model.dto.MySuggestionsDTO;

public interface MyPostMapper {

	List<MyRecipeDTO> selectRecipeList(Map<String, Object> map);

	List<MyPostDTO> selectPostList(Map<String, Object> map);

	List<MySuggestionsDTO> selectSuggestionsList(Map<String, Object> map);

	int selectRecipeTotalCount(int loginUserIdx);

	int selectPostTotalCount(int loginUserIdx);

	int selectSuggestionsTotalCount(int loginUserIdx);

}
