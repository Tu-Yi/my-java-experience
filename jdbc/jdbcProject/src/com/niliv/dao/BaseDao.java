package com.niliv.dao;

import java.util.List;

public interface BaseDao {
	
	public int executeUpdate(String sql,Object[] param);
	public <T> List<T> find(String sql,Object[] param,Class<T> clazz);
}
