package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.IMenuMapper;
import com.bjsxt.pojo.Menu;
import com.bjsxt.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	@Resource
	private IMenuMapper menuMapper;
	@Override
	public List<Menu> selByUserAndPid(long userid) {
		List<Menu> list = menuMapper.selectByUserid(userid, 0);
		for (Menu menu : list) {
			menu.setChildren(menuMapper.selectByUserid(userid, menu.getId()));
		}
		return list;
	}

}
