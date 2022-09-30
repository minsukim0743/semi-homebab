package com.homebab.users.member.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import static com.homebab.common.config.Template.getSqlSession;

import com.homebab.users.member.model.dao.SignUpMapper;

public class SignUpService {
	
	private SignUpMapper signUpMapper;

	public int signUpRegist(Map<String, Object> hm) {
		
		int result1 = 0;
		int result2 = 0;
		
		SqlSession sqlSession = getSqlSession();
		signUpMapper = sqlSession.getMapper(SignUpMapper.class);
		
		result1 = signUpMapper.signUpUsers();
		
		if(result1 > 0) {
			result2 = signUpMapper.signUpRegist(hm);
			if(result2 > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result2;
	}
	
	
	
}
