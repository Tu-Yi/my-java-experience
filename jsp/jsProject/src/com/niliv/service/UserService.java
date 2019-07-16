package com.niliv.service;

import com.niliv.pojo.User;

public interface UserService {

	User getUserInfoService(String uname, String pwd);

	int regUserInfoService(String uname, String pwd);

}
