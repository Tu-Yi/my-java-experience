package com.niliv.dao;

import java.util.List;

import com.niliv.pojo.User;

public interface UserDao {

	User getUserInfoDao(String uname, String pwd);

	int regUserInfoDao(String uname, String pwd);

	List<User> selUserInfoDao();

	int delUserInfoDao(String id);

	User valUserName(String name);

}
