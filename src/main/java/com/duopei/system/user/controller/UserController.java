package com.duopei.system.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	@RequestMapping("download")
	private ResponseEntity<byte[]> Download(HttpSession session) throws IOException {
		InputStream inputStream = session.getServletContext().getResourceAsStream("test.jsp");
		byte[] body = new byte[inputStream.available()];
		inputStream.read();
		HttpHeaders header = new HttpHeaders();
		String fileName = "test.jsp";
		header.add("Content-disposition", "attachment; filename=" + fileName); 
		return new ResponseEntity<byte[]>(body, header, HttpStatus.OK);
	}

	/**
	 * ResponseBody > 会把返回值返回给页面当做输出流
	 * produces = "text/plain; charset=utf-8" 解决>  IE报错=无法启动应用程序
	 * @param body
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "messageConvert", produces = "text/plain; charset=utf-8")
	public String MessageConvert(@RequestBody String body) {
		logger.info(">>>>>>>>>>>method >>>MessageConvert=" + body);
		return "hello world" + new Date();
	}

	@ResponseBody
	@RequestMapping(value = "json")
	private List<User> Json() {
		logger.info(">>>>>>>>>>>method=Show >>>Json >>> ");
		return userService.getUserLst(new User());
	}

	/**
	 * 上传图片
	 * @return
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	private String UploadFile(MultipartHttpServletRequest request, Map<String, String> map) {
		logger.info(">>>>>>>>>>>method >>>request=" + request.getFile("uploadFile"));
		MultipartFile file = (MultipartFile) request.getFile("uploadFile");
		String upload_file_suffix;
		String upload_path = "/item_desc/image/testdirectory/";
		String upload_file_path, upload_file_name;
		if (!file.isEmpty()) {
			// 扩展名格式
			if (file.getOriginalFilename().lastIndexOf(".") > 0) {
				upload_file_suffix = file.getOriginalFilename()
						.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
			} else {
				upload_file_suffix = "999";
			}
			try {
				FileUtils.forceMkdir(new File(upload_path));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				byte[] bytes = file.getBytes();
				upload_file_name = System.currentTimeMillis() + "." + upload_file_suffix;
				upload_file_path = upload_path + upload_file_name;
				FileOutputStream serverFile = new FileOutputStream(upload_file_path);
				serverFile.write(bytes);
				serverFile.close();
				map.put("filePath", upload_file_path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "user/show";
	}

	@RequestMapping(value = "convert")
	public String Conversion(@RequestParam(value = "user") User user) {
		userService.deleteUser(user);
		userService.insertUser(user);
		return "redirect:/user/show";
	}

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
		return "/user/show";
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
	public String New(@Valid User user, BindingResult result) {
		if (result.getErrorCount() > 0) {
			for (FieldError error : result.getFieldErrors()) {
				logger.info(">>>>>>>>>>>>出错了>>>>>>>>>>>>>" + error.getField() + " = " + error.getDefaultMessage());
			}
			// 如验证出错，则直接返回
			return "user/user";
		}
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
		map.put("users",
				userService.getUserLst(StringUtils.isEmpty(userNo) ? new User() : new User(Integer.parseInt(userNo))));
		return "user/show";
	}

}
