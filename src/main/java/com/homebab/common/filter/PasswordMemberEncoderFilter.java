package com.homebab.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.homebab.common.wrapper.MemberReqeustWrapper;

@WebFilter("/member/*")
public class PasswordMemberEncoderFilter implements Filter {

	public PasswordMemberEncoderFilter() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hrequest = (HttpServletRequest) request;
		MemberReqeustWrapper wrapper = new MemberReqeustWrapper(hrequest);
	
		chain.doFilter(wrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {}

}
