package com.duopei.system.user;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duopei.system.user.model.User;
import com.duopei.system.user.service.UserService;

public class TestUserService {

	Logger logger = Logger.getLogger(getClass());

	UserService service = null;

	@Before
	public void init() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(new String[] { "classpath:spring.xml", "classpath:spring-mybatis.xml" });
		assertNotNull(ctx);
		UserService service = (UserService) ctx.getBean("userService");
		this.service = service;
	}

	@Test
	public void testInsertAccount() {
		User user = new User(123456, "test", "测试", "123456", "test", "test", 0, "测试账号");

		service.checkUser(user);
		user = new User(234567, "test123", "测试123", "234567", "test", "test", 0, "测试账号123");
		service.checkUser2(user);

		List<User> userFromDb = service.getUserLst(null);
		assertNotNull(userFromDb);
		logger.info("USER-->>" + JSON.toJSONStringWithDateFormat(userFromDb, "yyyy/MM/dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat));

	}
}
