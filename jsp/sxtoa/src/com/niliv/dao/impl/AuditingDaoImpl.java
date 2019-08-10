package com.niliv.dao.impl;

import com.niliv.dao.AuditingDao;
import com.niliv.entity.Auditing;
import com.niliv.util.DBUtil2;

public class AuditingDaoImpl implements AuditingDao{

	@Override
	public void save(Auditing auditing) {
		String sql = "insert into auditing values(default,?,?,?,?,?)";
		Object [] params = {auditing.getExpId(),auditing.getAuditor().getEmpId(),
				auditing.getResult(),auditing.getAuditDesc(),
				new  java.sql.Timestamp(auditing.getAuditTime().getTime())};//Timestamp yyyyMMddhhmmss
		DBUtil2.executeUpdate(sql, params);
		
	}

}