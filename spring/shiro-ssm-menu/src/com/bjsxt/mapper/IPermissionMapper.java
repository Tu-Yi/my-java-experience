package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Permission;

public interface IPermissionMapper {
	//根据用户id查询对应的所有权限
	@Select("select * from permission where id in"
			+ "(select pid from role_permission where rid in"
			+ "(select id from role where id in"
			+ "(select rid from role_users where uid = #{0})))")
	List<Permission> selectByUserid(long userid);
}
