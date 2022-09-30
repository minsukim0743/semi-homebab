package com.homebab.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MemberReqeustWrapper extends HttpServletRequestWrapper {

	public MemberReqeustWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key) {
		
		String value = "";
		
		if("suPw".equals(key) || "memberPwd".equals(key)) {
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key));
		} else {
			value = super.getParameter(key);
		}
		
		return value;
	}
	
	
}
