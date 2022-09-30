package com.homebab.admin.freeborad.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.freeborad.model.dao.FreeBoradMapper;
import com.homebab.admin.freeborad.model.dto.FreeBoradDTO;

public class FreeBoradService {

	private FreeBoradMapper freeBoradMapper;
	
	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession sqlSession = getSqlSession();
		freeBoradMapper = sqlSession.getMapper(FreeBoradMapper.class);
		
		int totalCount = freeBoradMapper.selectTotalCount(searchMap);
		//게시물 갯수 확인하려고
		sqlSession.close();
		
		return totalCount;
	}

	public List<FreeBoradDTO> selectBoardList(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		freeBoradMapper = sqlSession.getMapper(FreeBoradMapper.class);
		
		List<FreeBoradDTO> boardList = freeBoradMapper.selectBoardList(selectCriteria);
		
		sqlSession.close();
		
		return boardList;	
	}

	public int deletborad(String pbIdx) {
	
		SqlSession sqlSession = getSqlSession();
		freeBoradMapper = sqlSession.getMapper(FreeBoradMapper.class);
		
		int result = freeBoradMapper.deletborad(pbIdx);
		
		if (result > 0 ) { 
			sqlSession.commit();
			
		} else {
			sqlSession.rollback();
		}
			
			
		
		
		sqlSession.close();
		
		return result;
		
		
		
	}
	
	
	
}
