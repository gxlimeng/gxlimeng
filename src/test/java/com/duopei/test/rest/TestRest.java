package com.duopei.test.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.duopei.core.model.user.User;
import com.duopei.other.rest.service.TRestUserService;

@RunWith(SpringJUnit4ClassRunner.class) // equals extends
										// SpringJUnit4ClassRunner
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestRest {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private TRestUserService trestUserService;

	@Test
	public void showAll() throws Exception {
		List<User> userList = trestUserService.selectUsers(new User());
		for (User user : userList) {
			logger.info(">>>>>>>>"+JSON.toJSON(user));
		}
	}
}
