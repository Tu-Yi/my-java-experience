package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.IRoleMapper;
import com.bjsxt.pojo.Role;
import com.bjsxt.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private IRoleMapper roleMapper;
	@Override
	public List<Role> selByUser(long userid) {
		return roleMapper.selectByUserid(userid);
	}

}
