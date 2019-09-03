package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Menu;

public interface IMenuMapper {
	//根据用户id查询对应的所有菜单
	@Select("select * from menu where id in"
			+ "(select mid from permission_menu where pid in"
			+ "(select id from permission where id in "
			+ "(select pid from role_permission where rid in"
			+ "(select id from role where id in"
			+ "(select rid from role_users where uid=#{0})))))and pid=#{1}")
	List<Menu> selectByUserid(long userid,long pid)  ;
}
