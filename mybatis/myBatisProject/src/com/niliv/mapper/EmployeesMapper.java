package com.niliv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.experimental.theories.FromDataPoints;

import com.niliv.pojo.Employees;

public interface EmployeesMapper {
	
	int insertBatch(List<Employees> list);
	
	@Delete("delete from employees where id=#{0}")
	int delEmployees(int id);
	
	@Update("update employees set salary=#{1} where id=#{0}")
	int updateSalaryById(int id,int salary);
	
	@Update("update employees set did=#{did} where id=#{id}")
	int updateDidByid(Employees employees);
	
	@Select("select * from employees where salary between #{0} and #{1}")
	List<Employees> queryBySalary(int sSalary,int eSalary);
	
	@Select("select * from employees where did=#{0}")
	List<Employees> queryByDid(int did);
	
	@Select("SELECT * from employees where salary > (SELECT avg(salary) from employees)")
	List<Employees> queryThanAvgSalary();
}
