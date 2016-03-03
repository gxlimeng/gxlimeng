package com.duopei.system.user;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.duopei.system.user.model.User;
import com.duopei.system.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) // equals extends
										// SpringJUnit4ClassRunner
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestUserServiceBySpringTest {

	Logger logger = Logger.getLogger(TestUserServiceBySpringTest.class);

	@Autowired
	UserService service = null;

	@Test
	public void testInsertAccount() {
		User user = new User(123456, "test", "测试", "123456", "test", "test", 0, "测试账号");

		if (null != service.getUserById(user)) {
			service.deleteUser(user);
		}
		service.insertUser(user);

		List<User> userFromDb = service.getUserLst(null);
		assertNotNull(userFromDb);
		logger.info("USER-->>" + JSON.toJSONStringWithDateFormat(userFromDb, "yyyy/MM/dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat));

	}
}
