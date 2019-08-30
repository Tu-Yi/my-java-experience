package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Expense;

public interface ExpenseDao {
	/**
	 * 获取序列的下一个值
	 * @return
	 */
	int nextVal();
	/**
	 * 保存报销单
	 * @param expense
	 */
	void save(Expense expense);
	/**
	 * 查询指定审核人要审核的报销单
	 * @param auditorId
	 * @return
	 */
	List<Expense> findByAuditorId(String auditorId);

}
