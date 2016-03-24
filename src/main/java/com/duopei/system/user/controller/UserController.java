package com.duopei.system.user.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.duopei.system.user.model.User;
import com.duopei.system.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService = null;

	@ModelAttribute
	public void ModelAttribute(@RequestParam(required = false) Integer userNo, Map<String, Object> map) {
		logger.info(">>>>>>>>>>>method=ModelAttribute >>>param=" + JSON.toJSONString(userNo));
		if (null != userNo) {
			User user = userService.getUserById(new User(userNo));
			if (null != user) {// 如为空，则为新增；不为空，则为修改
				map.put("user", user);
			}
		}
	}

	/**
	 * 添加用户 保存 后 跳转至 列表页面
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveUser", method = RequestMethod.PUT)
	public String StoreUser(@ModelAttribute(value = "user") User user) {
		logger.info(">>>>>>>>>>>method=StoreUser >>>param=" + JSON.toJSONString(user));
		userService.updateByPrimaryKey(user);
		return "redirect:/user/show";
	}

	/**
	 * 修改用户 保存前 跳转至 修改页面
	 * 
	 * @param userNo
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "editUser/{userNo}", method = RequestMethod.GET)
	public String EditUser(@PathVariable("userNo") Integer userNo, Map<String, Object> map) {
		logger.info(">>>>>>>>>>>method=EditUser >>>param=" + JSON.toJSONString(userNo));
		map.put("user", userService.getUserById(new User(userNo)));
		return "user/adduser";
	}

	/**
	 * 删除用户 保存后 跳转至 列表页面
	 * 
	 * @param userNo
	 * @return
	 */
	@RequestMapping(value = "deleteUser/{userNo}", method = RequestMethod.DELETE)
	public String DeleteUser(@PathVariable Integer userNo) {
		logger.info(">>>>>>>>>>>method=DeleteUser >>>param=" + JSON.toJSONString(userNo));
		userService.deleteUser(new User(userNo));
		return "redirect:/user/show";
	}

	/**
	 * 添加用户 保存 后 跳转至 列表页面
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String SaveUser(User user) {
		logger.info(">>>>>>>>>>>method=SaveUser >>>param=" + JSON.toJSONString(user));
		userService.insertUser(user);
		return "redirect:/user/show";
	}

	/**
	 * 添加用户 请求
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public String AddUser(Map<String, Object> map) {
		logger.info(">>>>>>>>>>>method=AddUser >>>param=" + JSON.toJSONString(map));
		map.put("user", new User());
		return "user/adduser";
	}

	/**
	 * 列表请求处理
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/show")
	public String ShowUsers(Map<String, Object> map) {
		logger.info(">>>>>>>>>>>method=ShowUsers >>>param=" + JSON.toJSONString(map));
		map.put("users", userService.getUserLst(null));
		return "user/show";
	}

}
