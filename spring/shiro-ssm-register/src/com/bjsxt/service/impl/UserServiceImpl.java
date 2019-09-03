package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.IUserMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserMapper mapper;
	
	//根据用户名查询用户信息
	@Override
	public Users selectByUsername(String username) {
		return mapper.selectByUsername(username);
	}

	@Override
	public int insertUser(Users user) {
		
		Md5Hash newPassword = new Md5Hash(user.getPassword(), user.getUsername(), 2);
		user.setPassword(newPassword.toString());
		user.setPassword_salt(user.getUsername());
		return mapper.insertUser(user);
	}

}
