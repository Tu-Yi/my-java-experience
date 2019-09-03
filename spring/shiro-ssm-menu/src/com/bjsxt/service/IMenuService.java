package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Menu;

public interface IMenuService {
	//根据用户id查询某一级菜单
	List<Menu> selByUserAndPid(long userid);
}
