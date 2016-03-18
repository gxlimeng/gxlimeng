package com.duopei.system.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginFilter implements Filter {

	Logger logger = Logger.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String URI = httpRequest.getRequestURI();
		logger.info(" request uri : " + URI);
		
		/* 过滤掉登录验证  */
		if (URI.contains("login") || URI.contains("aaa")) {
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void destroy() {

	}

}
