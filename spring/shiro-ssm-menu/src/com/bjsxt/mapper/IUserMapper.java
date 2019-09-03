package com.bjsxt.mapper;

import com.bjsxt.pojo.Users;

public interface IUserMapper {
	//根据用户名查询用户信息
	Users selectByUsername(String username);
	

}
