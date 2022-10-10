package com.homebab.admin.freeborad.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.freeborad.model.dto.FreeBoradDTO;

public interface FreeBoradMapper {

	int selectTotalCount(Map<String, String> searchMap);

	List<FreeBoradDTO> selectBoardList(SelectCriteria selectCriteria);

	int deletborad(String pbIdx);


}
