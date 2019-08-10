package com.niliv.dao;

import java.util.List;

import com.niliv.entity.Expense;

public interface ExpenseDao {
	/**
	 * 保存报销单
	 * @param expense
	 * @return 
	 */
	int save(Expense expense);

	int nextVal();

	List<Expense> findByAuditorId(String auditorId);
	Expense findById(int expId);
	void update(Expense expense);
}
