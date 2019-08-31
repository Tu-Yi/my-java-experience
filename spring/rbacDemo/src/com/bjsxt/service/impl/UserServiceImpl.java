package com.bjsxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.exception.UsersException;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UsersMapper usersMapper;
	
	/**
	 * 用户登录
	 */
	@Override
	public Users userLogin(String username, String userpwd) {
		Users users = this.usersMapper.selectUserByName(username);
		if(users == null){
			//用户不存在
			throw new UsersException("用户不存在或密码有误");
		}else if(!users.getUserpwd().equals(userpwd)){
			//密码有误
			throw new UsersException("用户不存在或密码有误");
		}
		return users;
	}
}
