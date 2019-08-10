package com.niliv.service;

import java.sql.Date;
import java.util.List;

import com.niliv.entity.Duty;

public interface DutyService {
	/**
	 * 完成签到操作
	 * @param empId
	 * @return
	 */
	int signin(String empId);
	/**
	 * 完成签退操作
	 * @param empId
	 * @return
	 */
	int signout(String empId);
	List<Duty> findDuty(String empId, int deptno, Date dtDate);

}
