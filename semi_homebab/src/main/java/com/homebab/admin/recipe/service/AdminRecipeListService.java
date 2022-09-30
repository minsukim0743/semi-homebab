package com.homebab.admin.recipe.service;

import static com.homebab.common.config.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.homebab.admin.common.pagin.SelectCriteria;
import com.homebab.admin.recipe.model.dao.AdminRecipeMapper;
import com.homebab.admin.recipe.model.dto.AdminRecipeListDTO;

public class AdminRecipeListService {
	
	AdminRecipeMapper adminRecipeMapper;

	public int adminRecipeListCount(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		adminRecipeMapper = sqlSession.getMapper(AdminRecipeMapper.class);
		
		int totalCount = adminRecipeMapper.adminRecipeListCount(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}
	
	public int adminRecipeListCount2(Map<String, String> searchMap) {
		
		SqlSession sqlSession = getSqlSession();
		adminRecipeMapper = sqlSession.getMapper(AdminRecipeMapper.class);
		
		int totalCount = adminRecipeMapper.adminRecipeListCount2(searchMap);
		
		sqlSession.close();
		
		return totalCount;
	}

	public List<AdminRecipeListDTO> adminRecipeListSelect(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		adminRecipeMapper = sqlSession.getMapper(AdminRecipeMapper.class);
		
		List<AdminRecipeListDTO> adminRecipeList = adminRecipeMapper.adminRecipeListSelect(selectCriteria);
		
		sqlSession.close();
		
		return adminRecipeList;
	}
	
	public List<AdminRecipeListDTO> adminRecipeListSelect2(SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		adminRecipeMapper = sqlSession.getMapper(AdminRecipeMapper.class);
		
		List<AdminRecipeListDTO> adminRecipeList = adminRecipeMapper.adminRecipeListSelect2(selectCriteria);
		
		sqlSession.close();
		
		return adminRecipeList;
	}

	public int adminRecipeUpdate(String number) {
		
		SqlSession sqlSession = getSqlSession();
		adminRecipeMapper = sqlSession.getMapper(AdminRecipeMapper.class);
		
		int result = adminRecipeMapper.adminRecipeUpdate(number);
		
		if(result > 0) {
			
			sqlSession.commit();
			
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int adminRecipeUpdate2(String number) {
		
		SqlSession sqlSession = getSqlSession();
		adminRecipeMapper = sqlSession.getMapper(AdminRecipeMapper.class);
		
		int result = adminRecipeMapper.adminRecipeUpdate2(number);
		
		if(result > 0) {
			
			sqlSession.commit();
			
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int adminDelete(String number) {
		
		SqlSession sqlSession = getSqlSession();
		adminRecipeMapper = sqlSession.getMapper(AdminRecipeMapper.class);
		
		int result = adminRecipeMapper.adminDelete(number);
		
		if(result > 0) {
			
			sqlSession.commit();
		} else {
			
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	

}
