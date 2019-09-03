package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Permission;

public interface IPermissionService {
	//根据用户查询所有权限
	List<Permission> selByUser(long userid);
}
