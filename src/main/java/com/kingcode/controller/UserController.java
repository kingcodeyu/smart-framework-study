package com.kingcode.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Result;

import com.kingcode.model.User;
import com.kingcode.service.UserService;

@Action
public class UserController {
	
	@Inject
	private UserService userService;
	
	@Request.Get("/user/addUser")
	public Result addUser(User user,HttpServletRequest req){
		System.out.println(req.getParameter("id"));
		System.out.println(ToStringBuilder.reflectionToString(user));
		userService.addUser(user);
		return new Result(true).data(user);
	}
	@Request.Get("/user/{id}/{z}")
	public Result addUser(long id,int z){
		System.out.println(id);
		System.out.println(z);
		return new Result(true).data(id);
	}
}
