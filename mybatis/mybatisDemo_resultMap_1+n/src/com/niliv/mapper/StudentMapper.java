package com.niliv.mapper;

import java.util.List;

import com.niliv.pojo.Student;

public interface StudentMapper {
	List<Student> selByCid(int cid);
}
