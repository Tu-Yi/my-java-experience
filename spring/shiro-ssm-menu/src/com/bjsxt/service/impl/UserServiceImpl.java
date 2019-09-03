package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.IUserMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.IMenuService;
import com.bjsxt.service.IPermissionService;
import com.bjsxt.service.IRoleService;
import com.bjsxt.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserMapper mapper;
	@Resource
	private IRoleService roleService;
	@Resource
	private IPermissionService permissionService;
	@Resource
	private IMenuService menuService;

	//根据用户名查询用户信息
	@Override
	public Users selectByUsername(String username) {
		Users user = mapper.selectByUsername(username);
		if(user != null){
			user.setRoles(roleService.selByUser(user.getId()));
			user.setPermissions(permissionService.selByUser(user.getId()));
			user.setMenus(menuService.selByUserAndPid(user.getId()));
		}
		return user;
	}
	
	
	

}
