package com.niliv.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.niliv.mapper.ClazzMapper;
import com.niliv.pojo.Clazz;
import com.niliv.pojo.Student;
import com.niliv.service.ClazzService;
import com.niliv.test.MyBatisUtil;


public class ClazzServiceImpl implements ClazzService {

	@Override
	public List<Clazz> selAll() {
		
		SqlSession session = MyBatisUtil.getSession();

		ClazzMapper cMapper = session.getMapper(ClazzMapper.class);
		List<Clazz> list = cMapper.selAll();
		
		session.close();
		return list;
	}

}
