package com.niliv.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;

import org.apache.commons.beanutils.BeanUtils;

import com.niliv.commons.JdbcUtil;
import com.niliv.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {

	@Override
	public int executeUpdate(String sql, Object[] param) {
		
		Connection conn=null;
		PreparedStatement statement=null;
		int rows = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			
			int count = statement.getParameterMetaData().getParameterCount();
			for (int i = 0; i < count; i++) {
				statement.setObject(i+1, param[i]);
			}
			
			rows = statement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		}finally {
			JdbcUtil.closeResource(statement, conn ,null);
		}
		return rows;
	}

	@Override
	public <T> List<T> find(String sql, Object[] param, Class<T> clazz) {
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs = null;
		List<T> deptList = new ArrayList<T>();
		try {
			conn = JdbcUtil.getConnection();
			statement = conn.prepareStatement(sql);
			int count = statement.getParameterMetaData().getParameterCount();
			for (int i = 0; i < count; i++) {
				statement.setObject(i+1, param[i]);
			}
			rs = statement.executeQuery();
			int rsCount = rs.getMetaData().getColumnCount();
			while(rs.next()) {
				T bean = clazz.newInstance();
				for (int i = 0; i < rsCount; i++) {
					String columnName = rs.getMetaData().getColumnName(i+1);
					Object value = rs.getObject(columnName);
					BeanUtils.setProperty(bean, columnName, value);
				}
				deptList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeResource(statement, conn ,null);
		}
		return deptList;
	}
	/**
	 * 批量操作
	 */
	@Override
	public int[] excuteBatch(String sql, List<Object[]> list) {
		
		Connection conn=null;
		PreparedStatement statement=null;
		int[] arr = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			int count = statement.getParameterMetaData().getParameterCount();
			for (int i = 0; i < list.size(); i++) {
				
				for (int j = 0; j < count; j++) {
					statement.setObject(j+1, list.get(i)[j]);
				}
				statement.addBatch();
			}
			arr = statement.executeBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		}finally {
			JdbcUtil.closeResource(statement, conn ,null);
		}
		return arr;
	}
}