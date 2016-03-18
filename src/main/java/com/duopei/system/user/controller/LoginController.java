package com.duopei.system.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.duopei.system.user.model.Login;
import com.duopei.system.user.service.LoginService;
import com.duopei.util.MD5;

@Controller
@RequestMapping("/loginController")
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService = null;

	 
	@SuppressWarnings("rawtypes")
	@RequestMapping( value="/test" , method=RequestMethod.POST)
	public String Test(Map map,HttpServletRequest request,HttpServletResponse response) {
		logger.info("xxxxxxxxxxxxxxxx"+JSON.toJSONString(map));
		return "index";
	}
	
	@RequestMapping( value="/signin" , method=RequestMethod.POST)
	public String Signin(HttpServletRequest request) {
		String userCode = request.getParameter("inputEmail");
		String userPwd = MD5.digest(request.getParameter("inputPassword"));

		logger.info("userCode=" + userCode + " userPwd=" + userPwd);
		Login login = loginService.selectByLoginKey(userCode);
		// 无此用户
		if (null == login) {
			logger.info("无此用户");
			return "login";
		}
		// 密码错误
		if (!userPwd.equals(login.getUserPwd())) {
			logger.info("密码错误");
			return "login";
		}
		request.setAttribute("login", login);
		return "login";
	}

}
