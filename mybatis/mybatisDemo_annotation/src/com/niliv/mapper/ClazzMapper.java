package com.niliv.mapper;

import org.apache.ibatis.annotations.Select;

import com.niliv.pojo.Clazz;

public interface ClazzMapper {
	
	@Select("select * from t_class where id=#{0}")
	Clazz selById(int id);
}
