package com.homebab.admin.blacklist.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.admin.blacklist.model.dto.MemberRcpBlacklistDTO;
import com.homebab.admin.common.pagin.SelectCriteria;

public interface AdminBlacklistMapper {

	List<MemberRcpBlacklistDTO> blacklistSelect(SelectCriteria selectCriteria);

	int blacklistTotalCount(Map<String, String> searchMap);

	int blacklistUpdate(String number);

	int blacklistUpdate1(String number);

	int blacklistUpdate2(String number);

	int blacklistUpdate3(String number);

}
