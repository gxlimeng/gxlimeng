package com.duopei.system.user.controller;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.duopei.system.user.model.User;

@Component
public class UserConverter implements Converter<String, User> {

	Logger logger = Logger.getLogger(UserConverter.class);

	@Override
	public User convert(String source) {
		if (null != source) {
			String[] splits = source.split("=");
			logger.info(">>>>>>>>>>>>>>UserConverter_splits=" + source);
			if (null != splits && splits.length == 8) {
				User user = new User(Integer.parseInt(splits[0]), splits[1], splits[2], splits[3], splits[4], splits[5],
						Integer.parseInt(splits[6]), splits[7]);
				return user;
			}
		}
		return null;
	}

}
