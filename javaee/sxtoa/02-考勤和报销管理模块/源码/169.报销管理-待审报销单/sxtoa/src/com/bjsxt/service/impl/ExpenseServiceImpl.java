package com.bjsxt.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bjsxt.dao.ExpenseDao;
import com.bjsxt.dao.ExpenseItemDao;
import com.bjsxt.dao.impl.ExpenseDaoImpl;
import com.bjsxt.dao.impl.ExpenseItemDaoImpl;
import com.bjsxt.entity.Expense;
import com.bjsxt.entity.ExpenseItem;
import com.bjsxt.service.ExpenseService;
import com.bjsxt.util.DBUtil;
import com.bjsxt.util.DBUtil2;
import com.bjsxt.util.MyException;

public class ExpenseServiceImpl implements ExpenseService{
	/**
	 * 问题：如何知道报销单的编号（自增），因为报销单明细需要
	 * 	可以先获取序列的下一个值
	 *  select seq_exp.nextval from dual
	 *  
	 * 
	 * 问题2：报销单成功、明细不成功，只提交了部分数据，数据不完整
	 * 应该全部成功提交，或者一个也没有提交
	 * 原因：一个DML操作一个事务，事务在Dao层，是多个事务，而不是一个事务
	 * 
	 * 解决：将多个操作视为一个事务，此时事务要从DAO层提升到业务层
	 */
	@Override
	public void add(Expense expense) {
		//获取序列的下一个值，
		ExpenseDao expDao = new ExpenseDaoImpl();
		int expId = expDao.nextVal();
		//开启事务
		Connection conn = DBUtil2.getConnection();
		try {
			conn.setAutoCommit(false);//事务不再自动结束（提交，回滚），事务并没有在此开始
			//添加一条报销单（主单）信息
			expense.setExpId(expId);
			expDao.save(expense);//执行第一个DML操作，事务自动开始
					
			//添加多条报销单所属的明细的信息
			ExpenseItemDao itemDao = new ExpenseItemDaoImpl();
			List<ExpenseItem> itemList = expense.getItemList();
			for(int i=0;i<itemList.size();i++){
				ExpenseItem item = itemList.get(i);
				item.setExpId(expId);
				itemDao.save(item);
			}			
			//结束事务（提交或回滚）
			conn.commit();
		} catch (Exception e) {//!!! 所有异常，保存运行时异常，SQLSyntaxErrorException
			e.printStackTrace();			
			try {
				conn.rollback(); //回滚数据
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new MyException(e1.toString());
			}
			throw new MyException(e.toString());//向上一层抛出异常信息
			
		}finally{
			DBUtil2.closeAll(null, null, conn);
			
		}
		
	}

	@Override
	public List<Expense> getToAudit(String auditorId) {
		ExpenseDao expDao = new ExpenseDaoImpl();
		return expDao.findByAuditorId(auditorId);
	}

}
