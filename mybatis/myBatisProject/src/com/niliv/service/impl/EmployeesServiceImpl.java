package com.niliv.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.niliv.common.MyBatisUtil;
import com.niliv.mapper.EmployeesMapper;
import com.niliv.pojo.Employees;
import com.niliv.service.EmployeesService;

public class EmployeesServiceImpl implements EmployeesService {

	@Override
	public int insertBatch(List<Employees> list) {
		SqlSession session = MyBatisUtil.getSession();

		EmployeesMapper eMapper = session.getMapper(EmployeesMapper.class);
		int flag = eMapper.insertBatch(list);
		return flag;
	}

	@Override
	public int delEmployees(int id) {
		SqlSession session = MyBatisUtil.getSession();

		EmployeesMapper eMapper = session.getMapper(EmployeesMapper.class);
		int flag = eMapper.delEmployees(id);
		return flag;
	}

	@Override
	public int updateSalaryById(int id, int salary) {
		SqlSession session = MyBatisUtil.getSession();

		EmployeesMapper eMapper = session.getMapper(EmployeesMapper.class);
		int flag = eMapper.updateSalaryById(id, salary);
		return flag;
	}

	@Override
	public int updateDidByid(Employees employees) {
		SqlSession session = MyBatisUtil.getSession();

		EmployeesMapper eMapper = session.getMapper(EmployeesMapper.class);
		int flag = eMapper.updateDidByid(employees);
		return flag;
	}

	@Override
	public List<Employees> queryBySalary(int sSalary, int eSalary) {
		SqlSession session = MyBatisUtil.getSession();

		EmployeesMapper eMapper = session.getMapper(EmployeesMapper.class);
		List<Employees> list = eMapper.queryBySalary(sSalary, eSalary);
		return list;
	}

	@Override
	public List<Employees> queryByDid(int did) {
		SqlSession session = MyBatisUtil.getSession();

		EmployeesMapper eMapper = session.getMapper(EmployeesMapper.class);
		List<Employees> list = eMapper.queryByDid(did);
		return list;
	}

	@Override
	public List<Employees> queryThanAvgSalary() {
		SqlSession session = MyBatisUtil.getSession();

		EmployeesMapper eMapper = session.getMapper(EmployeesMapper.class);
		List<Employees> list = eMapper.queryThanAvgSalary();
		return list;
	}

}
