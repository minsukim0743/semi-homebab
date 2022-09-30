package com.homebab.admin.member.model.dao;

import java.util.List;
import java.util.Map;

import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.member.model.dto.AdminMemberDTO;

public interface AdminMemberMapper {

	int adminMemberTotalCount(Map<String, String> searchMap);

	List<AdminMemberDTO> selectMemberList(SelectCriteria selectCriteria);

	AdminMemberDTO adminMemberDetail(String number);

}
