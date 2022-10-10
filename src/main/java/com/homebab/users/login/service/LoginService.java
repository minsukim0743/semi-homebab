package com.homebab.users.login.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.homebab.common.config.Template.getSqlSession;

import com.homebab.users.login.model.dao.LoginMapper;
import com.homebab.users.login.model.dto.UsersMngDTO;

public class LoginService {
	
	private LoginMapper loginMapper;

	public UsersMngDTO loginUserSelect(Map<String, String> hm) {
		
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		String encPwd = loginMapper.userSelectEncryptedPwd(hm);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UsersMngDTO usersMngDTO = null;
		
		if(passwordEncoder.matches(hm.get("memberPwd"), encPwd)) {
			
			usersMngDTO = loginMapper.loginUserSelect(hm);
			
			System.out.println("userDTO : " + usersMngDTO);
		} 
		
		sqlSession.close();
		
		return usersMngDTO;
	}

	public int loginAdminSelect(Map<String, String> hm) {
		
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		String encPwd = loginMapper.selectEncryptedPwd(hm);
		
		System.out.println(encPwd);
		
		int rusult = 0;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(hm.get("memberPwd"), encPwd)) {
			
			rusult = loginMapper.loginAdminSelect(hm);
			
		}
		
		sqlSession.close();
		
		return rusult;
	}

	public int signUpIdCheck(String suId) {
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		int result = loginMapper.signUpIdCheck(suId);

		sqlSession.close();
		
		return result;
	}

	public int signUpNickNameCheck(String suNickName) {
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		int result = loginMapper.signUpNickNameCheck(suNickName);

		sqlSession.close();
		
		return result;
	}

	public UsersMngDTO findId(Map<String, String> hm) {
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		UsersMngDTO userDTO = loginMapper.findId(hm);
		
		sqlSession.close();
		
		return userDTO;
	}

	public String selectOneEamil(String pfId) {
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		String email = loginMapper.selectOneEamil(pfId);
		
		sqlSession.close();
		
		return email;
	}

	public int modRandomAuth(Map<String, Object> hm) {
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		int result = loginMapper.modRandomAuth(hm);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int authNumCheck(Map<String, Object> hm) {
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		int result = loginMapper.authNumCheck(hm);
		System.out.println("인증번호 확인 > " + result);
		sqlSession.close();
		
		return result;
	}

	public int passwordModify(Map<String, Object> hm) {
		SqlSession sqlSession = getSqlSession();
		loginMapper = sqlSession.getMapper(LoginMapper.class);
		
		String value = "";
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		value = passwordEncoder.encode((String)hm.get("pw"));
		
		System.out.println("수정될 비밀번호 > " + value);
		
		hm.put("value", value);
		
		int result = loginMapper.passwordModify(hm);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	
	
}
