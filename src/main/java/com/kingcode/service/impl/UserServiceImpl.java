package com.kingcode.service.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.smart4j.framework.tx.annotation.Service;

import com.kingcode.model.User;
import com.kingcode.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	public void addUser(User user) {
		System.out.println(ToStringBuilder.reflectionToString(user));
	}
	
}
