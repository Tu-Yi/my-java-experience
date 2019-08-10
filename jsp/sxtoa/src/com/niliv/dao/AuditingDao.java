package com.niliv.dao;

import com.niliv.entity.Auditing;

public interface AuditingDao {
	/**
	 *  添加审核记录
	 * @param auditing
	 */
	public void save(Auditing auditing);
}
