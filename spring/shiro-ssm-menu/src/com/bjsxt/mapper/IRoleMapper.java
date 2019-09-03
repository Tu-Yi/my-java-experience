package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Role;

//角色操作
public interface IRoleMapper {
	//根据用户id查询对应的角色
	@Select("select * from role where id in (select rid from role_users where uid=#{0})")
	List<Role> selectByUserid(long userid);
	
	//查询所有角色
	@Select("select * from role")
	List<Role> selectAll();
}
