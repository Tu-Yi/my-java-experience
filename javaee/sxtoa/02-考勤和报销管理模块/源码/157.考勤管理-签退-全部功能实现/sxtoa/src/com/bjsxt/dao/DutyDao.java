package com.bjsxt.dao;

import com.bjsxt.entity.Duty;

public interface DutyDao {
	/**
	 * 查询考勤信息
	 * @param empId 员工编号
	 * @param today  考勤日期
	 * @return
	 */
	boolean find(String empId, java.sql.Date today);
	/**
	 * 添加考勤信息
	 * @param duty
	 * @return
	 */
	int save(Duty duty);
	/**
	 * 更新考勤数据
	 * @param duty
	 * @return
	 */
	int update(Duty duty);

}
