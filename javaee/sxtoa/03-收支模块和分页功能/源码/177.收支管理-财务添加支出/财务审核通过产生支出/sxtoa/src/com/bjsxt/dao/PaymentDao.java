package com.bjsxt.dao;

import com.bjsxt.entity.Payment;

public interface PaymentDao {
	/**
	 * 添加支付记录
	 * @param pm
	 */
	public void save(Payment pm);
}
