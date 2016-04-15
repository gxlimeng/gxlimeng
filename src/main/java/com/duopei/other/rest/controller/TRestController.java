package com.duopei.other.rest.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duopei.core.model.user.User;
import com.duopei.core.utill.constant.BeanStateConstant;
import com.duopei.other.ConstantTest;
import com.duopei.other.rest.service.TRestUserService;

@Controller
@RequestMapping(value = "trest")
public class TRestController {

	Logger logger = Logger.getLogger(TRestController.class);

	@Autowired
	private TRestUserService trestUserService;

	/**
	 * 列表
	 * 		列表界面controller入口-->跳转页面至 /test/rest/users.jsp 页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/users")
	public String listAllUsers(Map<String, Object> map) {
		map.put("users", trestUserService.selectUsers(new User()));
		return ConstantTest.FORWARD_TEST_USERS_LIST_PAGE;
	}

	/**
	 * 删除用户操作
	 * 		删除成功后重定向到controller/users，最后跳转至列表页面
	 * @param no
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/duser/{no}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("no") Integer no, Map<String, Object> map) {
		trestUserService.delete(new User(no));
		return ConstantTest.REDIRECT_TEST_USERS_LIST_PAGE;
	}

	/**
	 * 创建用户(前)
	 * 		创建用户前跳转至/test/rest/user.jsp页面,并创建空对象
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/cuser", method = RequestMethod.GET)
	public String createBefore(/*Map<String, Object> map*/ ModelMap map) {
		User user = new User();
		map.addAttribute("user",user );
		return ConstantTest.FORWARD_TEST_USER_PAGE;
	}

	/**
	 * 创建用户(保存)
	 * 		创建用户保存时，如出现错误，则跳转至/test/rest/user.jsp页面，并重新修改后提交
	 * 									  如成功，则重定向到controller/users，最后跳转至列表页面
	 * @param user
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult result, Map<String, Object> map) {
		if (result.getErrorCount() > 0) {
			return ConstantTest.FORWARD_TEST_USER_PAGE;
		}
		trestUserService.insert(user);
		return ConstantTest.REDIRECT_TEST_USERS_LIST_PAGE;
	}

	/**
	 * 更新用户(前)
	 * 		更新用户前跳转至/test/rest/user.jsp页面,并获取用户对象至
	 * 		user.set_method(BeanStateConstant._PUT)  区分新增和修改  rest风格请求
	 * @param no
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/uuser/{no}")
	public String updateBefore(@PathVariable("no") Integer no, Map<String, Object> map) {
		List<User> usersList = trestUserService.selectUsers(new User(no));
		User user = (usersList.isEmpty() || usersList.size() <= 0 ? new User() : usersList.get(0));
		user.set_method(BeanStateConstant._PUT);
		map.put("user", user);
		return ConstantTest.FORWARD_TEST_USER_PAGE;
	}

	/**
	 * 更新用户(保存)
	 * 		更新用户保存时，如出现错误，则跳转至/test/rest/user.jsp页面，并重新修改后提交
	 * 									  如更新成功，则重定向到controller/users，最后跳转至列表页面
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute(value = "user") User user, BindingResult result) {
		if (result.getErrorCount() > 0) {
			user.set_method(BeanStateConstant._PUT);
			return ConstantTest.FORWARD_TEST_USER_PAGE;
		}
		trestUserService.updateByPrimaryKey(user);
		return ConstantTest.REDIRECT_TEST_USERS_LIST_PAGE;
	}
}
