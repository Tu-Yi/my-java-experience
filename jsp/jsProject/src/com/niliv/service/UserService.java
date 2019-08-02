package com.niliv.service;

import java.util.List;

import com.niliv.pojo.Url;
import com.niliv.pojo.User;

public interface UserService {

	User getUserInfoService(String uname, String pwd);

	int regUserInfoService(String uname, String pwd);

	List<User> selUserInfoService();

	int delUserInfoService(String id);

	User valUserName(String name);

	List<Url> getUserUrlInfoService(int id);

}
