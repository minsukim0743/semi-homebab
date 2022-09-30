package com.homebab.common.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	private String encodingType;
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		if("POST".equals(hrequest.getMethod())) {
			request.setCharacterEncoding(encodingType);
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		/* xml에 설정한 init-param의 key를 이용하여 fConfig에서 값을 꺼내온다. */
		encodingType = filterConfig.getInitParameter("encoding-type");
	}

}
