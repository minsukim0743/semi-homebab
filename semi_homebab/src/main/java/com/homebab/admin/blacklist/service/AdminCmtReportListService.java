package com.homebab.admin.blacklist.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.blacklist.model.dao.AdminCmtReportMapper;
import com.homebab.admin.blacklist.model.dto.AdminCmtReportListDTO;

public class AdminCmtReportListService {
	
	AdminCmtReportMapper cmtReportMapper;

	public List<AdminCmtReportListDTO> cmtReportSelect() {

		SqlSession sqlSession = getSqlSession();
		cmtReportMapper = sqlSession.getMapper(AdminCmtReportMapper.class);
		
		List<AdminCmtReportListDTO> cmtReportList = cmtReportMapper.cmtReportSelect();
		
		sqlSession.close();
		
		return cmtReportList;
	}

	public int cmtReportTotalCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		cmtReportMapper = sqlSession.getMapper(AdminCmtReportMapper.class);
		
		int totalCount = cmtReportMapper.cmtReportTotalCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	public int adminCommentsDelete(String memberIdx) {

		SqlSession sqlSession = getSqlSession();
		cmtReportMapper = sqlSession.getMapper(AdminCmtReportMapper.class);
		
		int result = cmtReportMapper.adminCommentsDelete(memberIdx);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		return result;
	}
	
}
