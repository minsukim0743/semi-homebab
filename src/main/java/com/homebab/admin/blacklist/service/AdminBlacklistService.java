package com.homebab.admin.blacklist.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.blacklist.model.dao.AdminBlacklistMapper;
import com.homebab.admin.blacklist.model.dto.MemberRcpBlacklistDTO;
import com.homebab.admin.common.pagin.SelectCriteria;

public class AdminBlacklistService {
	
	AdminBlacklistMapper adminblacklistMapper;

	public List<MemberRcpBlacklistDTO> blacklistSelect(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		adminblacklistMapper = sqlSession.getMapper(AdminBlacklistMapper.class);
		
		List<MemberRcpBlacklistDTO> adminblacklist = adminblacklistMapper.blacklistSelect(selectCriteria);
		
		sqlSession.close();
		
		return adminblacklist;
	}

	public int blacklistTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		
		adminblacklistMapper = sqlSession.getMapper(AdminBlacklistMapper.class);
		
		int totalCount = adminblacklistMapper.blacklistTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	public int blacklistUpdate(String number) {

		SqlSession sqlSession = getSqlSession();
		
		adminblacklistMapper = sqlSession.getMapper(AdminBlacklistMapper.class);
		
		int result = adminblacklistMapper.blacklistUpdate(number); //update
		int result1 = adminblacklistMapper.blacklistUpdate1(number); //insert
		
		System.out.println("service number : " + number);
		System.out.println("result : " + result);
		System.out.println("result1 : " + result1);
		
		
		if(result > 0 && result1 > 0) {
			
			sqlSession.commit();
			
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int blacklistUpdate2(String number) {

		SqlSession sqlSession = getSqlSession();
		
		adminblacklistMapper = sqlSession.getMapper(AdminBlacklistMapper.class);
		
		int result = adminblacklistMapper.blacklistUpdate2(number);
		int result1 = adminblacklistMapper.blacklistUpdate3(number);
		
		System.out.println("service number : " + number);
		System.out.println("result : " + result);
		System.out.println("result1 : " + result1);
		
		if(result > 0 && result1 > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

}
