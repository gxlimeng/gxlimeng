package com.duopei.system.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/testRestController")
public class TestRestController {

	private final String SUCCESS = "index";
	
	/**
	 * REST 风格 URL 
	 *  新增 - testRestController/testRest/1	post		insert?object
	 *  修改 - testRestController/testRest/1	put			update?object
	 *  删除 - testRestController/testRest/1	delete		delete?id=1
	 *  查询 - testRestController/testRest/1	get			get?id=1
	 *  
	 *  如何发送put和delete请求：
	 *  	1>配置HiddenHttpMethodFilter过滤器
	 *  	2>发送post请求
	 *  	3>添加hidden隐藏域 name="_method" value="PUT/DELETE"
	 *  */

	
	Logger logger = Logger.getLogger(TestRestController.class);

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String TestRestGet(@PathVariable("id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("=========TestRestGet =" + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.POST)
	public String TestRestPost(@PathVariable("id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("=========TestRestPost =" + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String TestRestDelete(@PathVariable("id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("=========TestRestDelete =" + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String TestRestPut(@PathVariable("id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("=========TestRestPut =" + id);
		return SUCCESS;
	}

}
