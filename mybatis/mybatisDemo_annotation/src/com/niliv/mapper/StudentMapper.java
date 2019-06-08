package com.niliv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.niliv.pojo.Student;

public interface StudentMapper {
	
	
	@Select("select * from t_student")
	List<Student> selAll();
	
	@Insert("insert into t_student values(default,#{name},#{age},#{gender},#{cid})")
	int insStu(Student student);
	
	@Update("update t_student set age=#{1} where id=#{0}")
	int updStu(int id, int age);
	
	@Delete("delete from t_student where id=#{0}")
	int delStu(int id);
	
	@Select("select * from t_student")
	@Results(value= {
		@Result(column="id",property="id",id=true),
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="gender",property="gender"),
		@Result(column="cid",property="cid"),
		@Result(property="clazz",one=@One(select="com.niliv.mapper.ClazzMapper.selById"),column="cid")
	})
	List<Student> sel();
}

