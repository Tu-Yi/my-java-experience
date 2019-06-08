package com.niliv.service;

import java.util.List;

import com.niliv.pojo.Student;

public interface StudentService {
	List<Student> selAll();
	int insStu(Student student);
	int updStu(int id,int age);
	int delStu(int id);
	
	List<Student> sel();
}
