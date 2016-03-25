package com.duopei.system.user.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.duopei.system.user.model.User;
import com.duopei.system.user.service.UserService;
import com.duopei.util.constant.BeanStateConstant;

@Controller
@RequestMapping("/user")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService = null;

	/*
	 * @ModelAttribute public void ModelAttribute(@RequestParam(required =
	 * false) Integer userNo, Map<String, Object> map) { logger.info(
	 * ">>>>>>>>>>>method=ModelAttribute >>>param=" +
	 * JSON.toJSONString(userNo)); if (null != userNo) { User user =
	 * userService.getUserById(new User(userNo)); if (null != user) {//
	 * 如为空，则为新增；不为空，则为修改 map.put("user", user); } } }
	 */

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.PUT)
	public String Save(@ModelAttribute(value = "user") User user) {
		logger.info(">>>>>>>>>>>method=Save_put >>>param=" + JSON.toJSONString(user));
		userService.updateByPrimaryKey(user);
		return "redirect:/user/show";
	}

	/**
	 * 编辑用户信息 (跳转)
	 * @param userNo
	 * @param map
	 * @return
	 * @see 访问/user/edit{userNo}时，GET请求
	 */
	@RequestMapping(value = "edit/{userNo}", method = RequestMethod.GET)
	public String Edit(@PathVariable("userNo") Integer userNo, Map<String, Object> map) {
		logger.info(">>>>>>>>>>>method=Edit_GET >>>param=" + JSON.toJSONString(userNo));
		User user = userService.getUserById(new User(userNo));
		user.setType(BeanStateConstant._PUT);
		map.put("user", user);
		return "user/user";
	}

	/**
	 * 删除用户信息 
	 * @param userNo
	 * @return
	 */
	@RequestMapping(value = "delete/{userNo}", method = RequestMethod.DELETE)
	public String Delete(@PathVariable Integer userNo) {
		logger.info(">>>>>>>>>>>method=Delete_DELETE>>>param=" + JSON.toJSONString(userNo));
		userService.deleteUser(new User(userNo));
		return "redirect:/user/show";
	}

	/**
	 * 添加新用户（跳转）
	 * @param map
	 * @return
	 * @see 访问/user/new时，GET请求就执行New(Map map)方法，POST请求就执行New(User user)方法
	 */
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String New(Map<String, Object> map) {
		logger.info(">>>>>>>>>>>method=New_GET >>>param=" + JSON.toJSONString(map));
		map.put("user", new User());
		return "user/user";
	}

	/**
	 * 添加新用户（新增）
	 * @param user
	 * @return
	 * @see 访问/user/new时，GET请求就执行New(Map map)方法，POST请求就执行New(User user)方法
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String New(User user) {
		logger.info(">>>>>>>>>>>method=New_POST >>>param=" + JSON.toJSONString(user));
		userService.insertUser(user);
		return "redirect:/user/show";
	}

	/**
	 *  查询用户信息
	 * @param map
	 * @return
	 * @see 访问/user/new时，GET请求就执行New(Map map)方法，POST请求就执行New(User user)方法
	 */
	@RequestMapping("/show")
	public String Show(@RequestParam(required = false) String userNo, Map<String, Object> map) {
		logger.info(">>>>>>>>>>>method=Show >>>param=" + JSON.toJSONString(map) + " = userNo=" + userNo);
		map.put("users", userService.getUserLst(StringUtils.isEmpty(userNo) ? new User() : new User(Integer.parseInt(userNo))));
		return "user/show";
	}

}
