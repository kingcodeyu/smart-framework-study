package com.kingcode.controller;

import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Result;

@Action
public class UserController {
	@Request.Get("/user/{id}")
	public Result addUser(Long id){
		System.out.println(id);
		return null;
	}
}
