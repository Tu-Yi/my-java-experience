package com.bjsxt.service;

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

}
