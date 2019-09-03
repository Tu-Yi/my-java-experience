package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Role;

public interface IRoleService {
	//根据用户查询所有角色
	List<Role> selByUser(long userid);
}
