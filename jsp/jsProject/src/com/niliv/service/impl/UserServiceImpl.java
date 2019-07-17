package com.niliv.service.impl;

import java.util.List;

import com.niliv.dao.UserDao;
import com.niliv.dao.impl.UserDaoImpl;
import com.niliv.pojo.User;
import com.niliv.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao ud = new UserDaoImpl();
	
	@Override
	public User getUserInfoService(String uname, String pwd) {
		
		return ud.getUserInfoDao(uname,pwd);
	}

	@Override
	public int regUserInfoService(String uname, String pwd) {
		
		return ud.regUserInfoDao(uname,pwd);
	}

	@Override
	public List<User> selUserInfoService() {
		
		return ud.selUserInfoDao();
	}



}
