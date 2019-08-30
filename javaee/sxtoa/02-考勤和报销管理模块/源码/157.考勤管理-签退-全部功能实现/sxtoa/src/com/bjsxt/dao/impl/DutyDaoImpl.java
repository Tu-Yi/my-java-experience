package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjsxt.dao.DutyDao;
import com.bjsxt.entity.Department;
import com.bjsxt.entity.Duty;
import com.bjsxt.util.DBUtil;

public class DutyDaoImpl implements DutyDao {

	@Override
	public boolean find(String empId, Date today) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Department dept = null;
		boolean flag = false;//没有签到
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select * from duty  where empid = ? and dtdate = ?");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）		
			pstmt.setString(1, empId);
			pstmt.setDate(2, today);
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			if(rs.next()){
				flag  = true;//已经签到
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return flag;
	}

	@Override
	public int save(Duty duty) {
		String sql = "insert into duty values(seq_duty.nextval,?,?,?,null)";
		Object [] params = {duty.getEmpId(),duty.getDtDate(),duty.getSigninTime()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public int update(Duty duty) {
		String sql = "update duty set signouttime = ? where empid = ? and dtdate = ?";
		Object [] params = {duty.getSignoutTime(),duty.getEmpId(),duty.getDtDate()};
		return DBUtil.executeUpdate(sql, params);
	}

}
