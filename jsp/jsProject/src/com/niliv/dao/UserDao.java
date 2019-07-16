package com.niliv.dao;

import com.niliv.pojo.User;

public interface UserDao {

	User getUserInfoDao(String uname, String pwd);

	int regUserInfoDao(String uname, String pwd);

}
