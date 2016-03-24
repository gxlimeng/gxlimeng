package com.duopei.system.user.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duopei.system.user.model.User;
import com.duopei.system.user.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService = null;

	@RequestMapping(value = "deleteUser/{userNo}", method = RequestMethod.DELETE)
	public String DeleteUser(@PathVariable Integer userNo) {
		userService.deleteUser(new User(userNo));
		return "redirect:/userController/show.do";
	}

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(User user) {
		userService.insertUser(user);
		return "redirect:/userController/show.do";
	}

	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public String AddUser(Map<String, Object> map) {
		map.put("user", new User());
		return "user/adduser";
	}

	@RequestMapping("/show")
	public String showUsers(Map<String, Object> map) {
		map.put("users", userService.getUserLst(null));
		return "user/show";
	}

}
