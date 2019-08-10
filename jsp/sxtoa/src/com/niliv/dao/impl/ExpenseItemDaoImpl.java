package com.niliv.dao.impl;

import com.niliv.dao.ExpenseItemDao;
import com.niliv.entity.ExpenseItem;
import com.niliv.util.DBUtil;
import com.niliv.util.DBUtil2;

public class ExpenseItemDaoImpl implements ExpenseItemDao {

	@Override
	public void save(ExpenseItem item) {
		String sql = "insert into expenseitem values(default,?,?,?,?)";
		Object [] params ={item.getExpId(),item.getType(),item.getAmount(),item.getItemDesc()};
		DBUtil2.executeUpdate(sql, params);
		
	}

}
