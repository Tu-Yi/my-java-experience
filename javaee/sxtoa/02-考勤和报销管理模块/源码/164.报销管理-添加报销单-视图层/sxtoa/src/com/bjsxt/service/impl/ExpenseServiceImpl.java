package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.ExpenseDao;
import com.bjsxt.dao.ExpenseItemDao;
import com.bjsxt.dao.impl.ExpenseDaoImpl;
import com.bjsxt.dao.impl.ExpenseItemDaoImpl;
import com.bjsxt.entity.Expense;
import com.bjsxt.entity.ExpenseItem;
import com.bjsxt.service.ExpenseService;

public class ExpenseServiceImpl implements ExpenseService{
	/**
	 * 问题：如何知道报销单的编号（自增），因为报销单明细需要
	 * 
	 * 
	 */
	@Override
	public void add(Expense expense) {
		//获取序列的下一个值，
		ExpenseDao expDao = new ExpenseDaoImpl();
		int expId = expDao.nextVal();
		
		//添加一条报销单（主单）信息
		expense.setExpId(expId);
		expDao.save(expense);
				
		//添加多条报销单所属的明细的信息
		ExpenseItemDao itemDao = new ExpenseItemDaoImpl();
		List<ExpenseItem> itemList = expense.getItemList();
		for(int i=0;i<itemList.size();i++){
			ExpenseItem item = itemList.get(i);
			item.setExpId(expId);
			itemDao.save(item);
		}
		
	}

}
