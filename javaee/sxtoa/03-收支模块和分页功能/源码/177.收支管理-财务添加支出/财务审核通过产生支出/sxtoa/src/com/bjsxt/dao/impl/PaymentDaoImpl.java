package com.bjsxt.dao.impl;

import com.bjsxt.dao.PaymentDao;
import com.bjsxt.entity.Payment;
import com.bjsxt.util.DBUtil2;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public void save(Payment pm) {
		String sql = "insert into payment values (seq_payment.nextval,?,?,?,?,?)";
		Object params  [] = {pm.getPayEmpId(),pm.getAmount(),
				new java.sql.Timestamp(pm.getPayTime().getTime()),pm.getExpId(),pm.getExpEmpId()};
		DBUtil2.executeUpdate(sql, params);
		
	}

}
