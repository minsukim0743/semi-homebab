package com.homebab.admin.member.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.member.model.dao.AdminMemberMapper;
import com.homebab.admin.member.model.dto.AdminMemberDTO;

public class AdminMemberService {

	AdminMemberMapper adminMemberMapper;
	
	public int adminMemberTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		adminMemberMapper = sqlSession.getMapper(AdminMemberMapper.class);
		
		int totalCount = adminMemberMapper.adminMemberTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
		
	}

	public List<AdminMemberDTO> selectMemberList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		adminMemberMapper = sqlSession.getMapper(AdminMemberMapper.class);
		
		List<AdminMemberDTO> adminMemberList = adminMemberMapper.selectMemberList(selectCriteria);
		
		sqlSession.close();
		
		return adminMemberList;
	}

	public AdminMemberDTO adminMemberDetail(String number) {
		
		SqlSession sqlSession = getSqlSession();
		adminMemberMapper = sqlSession.getMapper(AdminMemberMapper.class);
		
		AdminMemberDTO memberDetailDTO = adminMemberMapper.adminMemberDetail(number);
		
		sqlSession.close();
		
		
		return memberDetailDTO;
	}
}
