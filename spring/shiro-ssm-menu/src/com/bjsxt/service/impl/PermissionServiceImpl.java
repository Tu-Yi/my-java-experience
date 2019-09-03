package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.IPermissionMapper;
import com.bjsxt.pojo.Permission;
import com.bjsxt.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {
	@Resource
	private IPermissionMapper permissionMapper;
	@Override
	public List<Permission> selByUser(long userid) {
		return permissionMapper.selectByUserid(userid);
	}

}
