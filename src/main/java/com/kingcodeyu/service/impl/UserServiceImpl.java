package com.kingcodeyu.service.impl;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.kingcodeyu.model.User;
import com.kingcodeyu.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public void addUser(User user) {
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
	
}
