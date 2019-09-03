package com.bjsxt.service;

import com.bjsxt.pojo.Users;

public interface IUserService {
	//根据用户名查询用户信息
	Users selectByUsername(String username);
	//注册
	int insertUser(Users user);
}
