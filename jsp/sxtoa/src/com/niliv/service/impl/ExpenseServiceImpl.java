package com.niliv.service.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.niliv.dao.AuditingDao;
import com.niliv.dao.ExpenseDao;
import com.niliv.dao.ExpenseItemDao;
import com.niliv.dao.impl.AuditingDaoImpl;
import com.niliv.dao.impl.ExpenseDaoImpl;
import com.niliv.dao.impl.ExpenseItemDaoImpl;
import com.niliv.entity.Auditing;
import com.niliv.entity.Expense;
import com.niliv.entity.ExpenseItem;
import com.niliv.service.ExpenseService;
import com.niliv.util.Constants;
import com.niliv.util.DBUtil;
import com.niliv.util.DBUtil2;
import com.niliv.util.MyException;

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
		expId++;
		//开启事务
		Connection conn = DBUtil2.getConnection();
		try {
			
			conn.setAutoCommit(false);

			//添加一条报销单（主单）信息
			expDao.save(expense);
					
			//添加多条报销单所属的明细的信息
			ExpenseItemDao itemDao = new ExpenseItemDaoImpl();
			List<ExpenseItem> itemList = expense.getItemList();
			for(int i=0;i<itemList.size();i++){
				ExpenseItem item = itemList.get(i);
				item.setExpId(expId);
				itemDao.save(item);
			}
			
			//提交或回滚事务
			conn.commit();		
			
		} catch (Exception e) {			
			e.printStackTrace();			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new MyException(e1.toString());
			}
			throw new MyException(e.toString());
		}finally{
			DBUtil2.closeAll(null, null, conn);//连接要在这里关闭才可以；DAO层不能关闭
		}
		
	}

	@Override
	public List<Expense> getToAudit(String auditorId) {
		
		ExpenseDao expDao = new ExpenseDaoImpl();
		return expDao.findByAuditorId(auditorId);
	}

	@Override
	public void audit(Auditing auditing) {
		AuditingDao auditingDao = new AuditingDaoImpl();
		ExpenseDao expDao = new ExpenseDaoImpl();
		//开启事务
		Connection conn = DBUtil2.getConnection();
		try {
			conn.setAutoCommit(false);//事务不再自动结束（提交，回滚），事务并没有在此开始
			//审核通过吗
			String result = auditing.getResult();
			
			Expense exp = new Expense();
			exp.setExpId(auditing.getExpId());	
			exp.setLastResult(auditing.getResult());
			
			if("通过".equals(result)){//审核通过
				//是财务吗				
				if(auditing.getAuditor().getPosition().getPosId()==6){//是财务
					//添加支出记录
					
					//修改报销单状态	
					
				}else{					
					
					//金额大于2500吗  auditing.getExp().getTotalAmount()>2500  空指针异常
					//获取报销单的金额
					int expId = auditing.getExpId();
					Expense exp2 = expDao.findById(expId);
					if(exp2.getTotalAmount()>2500){//大于2500
						//当前审核人是总裁吗
						if(Constants.POSITION_CEOID.equals(auditing.getAuditor().getEmpId())){
							//添加审核记录							
							auditingDao.save(auditing);
							//修改报销单状态											
							exp.setStatus(Constants.EXPENSE_STATUS_PASS);
							exp.setNextAuditorId(Constants.POSITION_CFOID); //财务		
						}else{
							//添加审核记录
							auditingDao.save(auditing);
							//修改报销单状态												
							exp.setStatus(Constants.EXPENSE_STATUS_AUDITING);
							exp.setNextAuditorId(Constants.POSITION_CEOID); //总裁
							//exp.setNextAuditorId(auditing.getAuditor().getMgr().getEmpId());
							
						}
					}else{//小于等于2500
						//添加审核记录
						auditingDao.save(auditing);
						//修改报销单状态  下个处理人：财务  状态：审核通过
						exp.setStatus(Constants.EXPENSE_STATUS_PASS);
						exp.setNextAuditorId(Constants.POSITION_CFOID); //财务
					}					
				}
				
			}else{//不通过，拒绝或者打回
				//添加审核记录
				auditingDao.save(auditing);
				//修改报销单状态				
				if("打回".equals(auditing.getResult())){
					exp.setStatus(Constants.EXPENSE_STATUS_BACK);
				}else{
					exp.setStatus(Constants.EXPENSE_STATUS_REJECT);
				}				
				exp.setNextAuditorId(null); //拒绝 打回 没有下个审核人
				
			}
			
			expDao.update(exp);
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

}
