package com.duopei.user;

import static org.junit.Assert.assertNotNull;

import java.util.List;

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
		User user = new User(123456, "test", "测试", "123456", "test", "test", 0, "测试账号");

		if(null != service.getUserById(user)){
			service.deleteUser(user);
		}
		service.insertUser(user);

		List<User> userFromDb = service.getUserLst(null);
		assertNotNull(userFromDb);
		logger.info("USER-->>" + userFromDb);
		//assertEquals(account.getAccountId(), accountFromDb.getAccountId());

	}
}
