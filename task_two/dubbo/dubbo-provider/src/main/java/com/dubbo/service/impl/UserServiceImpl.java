package com.dubbo.service.impl;

import com.dubbo.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public String getName(String userId) {
		return "lxj"+userId;
	}
}
