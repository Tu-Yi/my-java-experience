package com.niliv.dao;

import com.niliv.entity.ExpenseItem;

public interface ExpenseItemDao {
	/**
	 * 保存报销单明细
	 * @param item
	 */
	void save(ExpenseItem item);

}
