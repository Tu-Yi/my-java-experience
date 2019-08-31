package com.bjsxt.mapper;

import com.bjsxt.pojo.Users;

public interface UsersMapper {

	Users selectUserByName(String username);
}
