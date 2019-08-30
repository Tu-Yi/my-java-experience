package com.bjsxt.dao;

import com.bjsxt.entity.Department;

public interface DepartmentDao {
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	public int save(Department dept);
	
	
}
