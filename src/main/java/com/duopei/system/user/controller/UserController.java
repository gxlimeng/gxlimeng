package com.duopei.system.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duopei.system.user.model.User;
import com.duopei.system.user.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService = null;

	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request) {
		User userR = new User(123456, "test", "测试", "123456", "test", "test", 0, "测试账号");
		User user = userService.getUserById(userR);
		request.setAttribute("user", user);
		return "showUser";
	}

}
