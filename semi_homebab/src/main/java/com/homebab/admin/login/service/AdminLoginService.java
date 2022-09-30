package com.homebab.admin.login.service;

import static com.homebab.common.config.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.homebab.admin.login.model.dao.AdminLoginMapper;
import com.homebab.admin.login.model.dto.AdminDTO;

public class AdminLoginService {
	
	AdminLoginMapper adminMapper;

	public AdminDTO adminLogin(AdminDTO requestAdmin) {
		
		SqlSession sqlSession = getSqlSession();
		adminMapper = sqlSession.getMapper(AdminLoginMapper.class);
		
		AdminDTO adminLogin = null;
		
		String encPwd = adminMapper.selectEncryptPwd(requestAdmin);
		
		System.out.println("requestAdmin:" + requestAdmin.getUserPwd());
		System.out.println("encPwd:" + encPwd);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(requestAdmin.getUserPwd(), encPwd)) {
			
			adminLogin = adminMapper.adminLogin(requestAdmin);
		} else {
			System.out.println("requestAdmin:" + requestAdmin.getUserPwd());
			System.out.println("encPwd:" + encPwd);
		}
		
		System.out.println("service adminlogin :" + adminLogin);
		
		sqlSession.close();
		
		return adminLogin;
	}

}
