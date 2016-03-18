package com.duopei.system.test.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.duopei.system.test.model.Address;
import com.duopei.system.test.model.User;

@Controller
@RequestMapping("/testController")
//@SessionAttributes(value = { "user" }, types = { String.class })
public class TestController {

	Logger logger = Logger.getLogger(TestController.class);

	private final String SUCCESS = "index";

	@RequestMapping(value="testUpate")
	public String TestUpate(User user){
		logger.info("===========TestUpate"+JSON.toJSONString(user));
		return SUCCESS;
	}
	
	
	/**
	 * http://localhost:8080/gxlimeng/testController/testSessionAttributes.do
	 * 
	 * @SessionAttributes(value = { "user" }, types = { String.class }) 把user对象或value值为String类型  都放入至session中
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "testSessionAttributes")
	public String TestSessionAttributes(Map<String, Object> map) {
		User user = new User(111, "李盟", "111111", "123@163.com", new Address("隆昌路"));
		map.put("user", user);
		return SUCCESS;
	}

	/**
	 * http://localhost:8080/gxlimeng/testController/testMap.do
	 * 
	 * ${ requestScope.items }
	 * 
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "testMap")
	private String TestMapParam(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		logger.info("==========testMap  " + map.getClass().getName());
		map.put("items", Arrays.asList("羽毛球", "乒乓球", "篮球", "主球"));
		map.put("time", new Date());
		logger.info(map);
		return SUCCESS;
	}

	/**
	 * 目标方法返回值可以是ModelAndView对象
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "testModelAndView")
	public ModelAndView TestModelAndView(HttpServletRequest request, HttpServletResponse response) {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}

	/**
	 * http://localhost:8080/gxlimeng/testController/testWriter.do
	 * 
	 * @param writer
	 * @throws IOException
	 */
	@RequestMapping(value = "testWriter")
	public void TestWriter(Writer writer) throws IOException {
		logger.info("==========TestWriter  ");
		writer.write("hello >>>>>>>>>>>>>>>>>");
	}

	/**
	 * http://localhost:8080/gxlimeng/testController/testServletAPI.do
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "testServletAPI")
	public String TestServletAPI(HttpServletRequest request, HttpServletResponse response) {
		logger.info("==========TestServletAPI request ----->" + request + " response" + response);
		return SUCCESS;
	}

	/**
	 * http://localhost:8080/gxlimeng/testrest.jsp
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/testPojo")
	public String TestPojo(User user, HttpServletRequest request) {
		logger.info("==========TestPojo user ----->" + JSON.toJSONString(user));
		return SUCCESS;
	}

	/**
	 * 先模拟请求下，在浏览器中查看下cookie的value值，然后获取
	 * http://localhost:8080/gxlimeng/testrest.jsp
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/testCookieValue")
	public String TestCookieValue(@CookieValue(value = "JSESSIONID") String sessionId, HttpServletRequest request) {
		logger.info("==========TestCookieValue JSESSIONID=" + sessionId);
		return SUCCESS;
	}

	/**
	 * http://localhost:8080/gxlimeng/testController/testRequestParam.do?
	 * userName=1&age=20
	 * 
	 * @RequestParam 映射请求参数
	 * 
	 * @param userName
	 * @param age
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testRequestParam")
	public String TestRequestParam(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "age", required = false) Integer age, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("==========TestRequestParam  userName=" + userName + " age=" + age);
		return SUCCESS;
	}

	/**
	 * http://localhost:8080/gxlimeng/testController/testRequestHeader.do
	 * 
	 * @RequestParam 映射请求参数
	 * 
	 * @param userName
	 * @param age
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testRequestHeader")
	public String TestRequestHeader(@RequestHeader(value = "Accept-Language") String language,
			HttpServletRequest request) {
		logger.info("==========TestRequestHeader  =" + language);
		return SUCCESS;
	}

	/**
	 * succ:
	 * http://localhost:8080/gxlimeng/testController/testParamAndHeader.do?
	 * userName=1&age=20 error:
	 * http://localhost:8080/gxlimeng/testController/testParamAndHeader.do?
	 * userName=1&age=10
	 * http://localhost:8080/gxlimeng/testController/testParamAndHeader.do?age=
	 * 10
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testParamAndHeader", params = { "userName", "age!=10" })
	public String TestParamAndHeader(HttpServletRequest request, HttpServletResponse response) {
		logger.info("==========TestParamAndHeader");
		return SUCCESS;
	}

	/**
	 * succ:
	 * http://localhost:8080/gxlimeng/testController/TestAntPath/aaa/abc.do
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testAntPath/*/abc")
	public String TestAntPath(HttpServletRequest request, HttpServletResponse response) {
		logger.info("TestAntPath");
		return SUCCESS;
	}

	/**
	 * succ: http://localhost:8080/gxlimeng/testController/testPathVariable/1.do
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testPathVariable/{id}")
	public String TestPathVariable(@PathVariable("id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("==========TestPathVariable=" + id);
		return SUCCESS;
	}
}
