package com.kingcode.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Result;

import com.kingcodeyu.model.User;

@Action
public class UserController {
	@Request.Get("/user/addUser")
	public Result addUser(User user){
		System.out.println(ToStringBuilder.reflectionToString(user));
		return new Result(true).data(user);
	}
	@Request.Get("/user/{id}/{z}")
	public Result addUser(long id,int z){
		System.out.println(id);
		System.out.println(z);
		return new Result(true).data(id);
	}
}
