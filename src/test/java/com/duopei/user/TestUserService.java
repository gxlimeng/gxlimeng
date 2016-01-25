package com.duopei.user;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.duopei.user.model.User;
import com.duopei.user.service.UserService;

public class TestUserService {

	Logger logger = Logger.getLogger("TestUserService");

	UserService service = null;

	@Before
	public void init() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[] { "classpath:spring.xml", "classpath:spring-mybatis.xml" });
		assertNotNull(ctx);
		UserService service = (UserService) ctx.getBean("userService");
		this.service = service;
	}

	@Test
	public void testInsertAccount() {
		// 创建一个帐户
		User user = new User();
		user.setSno(103108);
		user.setSname("123456");

		// 将创建的帐户插入到数据库中
		// service.insertUser(user);
		// logger.debug("account id: " + account.getAccountId());

		// 从数据库获取刚才插入的帐户
		User userFromDb = service.getUserById(user);
		assertNotNull(userFromDb);
		logger.info("name=" + userFromDb.getSname());
		// assertEquals(account.getAccountId(), accountFromDb.getAccountId());

	}
}
