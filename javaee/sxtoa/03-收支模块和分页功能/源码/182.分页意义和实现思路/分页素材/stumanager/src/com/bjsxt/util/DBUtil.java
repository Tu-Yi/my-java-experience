package com.bjsxt.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * JDBC�Ĺ�����
 * 
 * @author Administrator
 * 
 */
public class DBUtil {

	
	/**
	 * ����һ������	 * 
	 * @return
	 */
	public static Connection getConnection() {		
		Connection conn = null;
		try {
			// ��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ��ȡ����
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "bjsxt", "bjsxt");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	/**
	 * �ر����ݿ���Դ
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * ִ��insert��update��delete ����DML����
	 * @param sql
	 * @param prams
	 * @return
	 * @throws SQLException 
	 */
	public static int executeUpdate(String sql, Object[] prams) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				pstmt.setObject(i + 1, prams[i]);
			}
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			//�ڸò�δ����쳣
			e.printStackTrace();		
			//�����Ҫ���������׸���һ��
			throw e;
		}
		return n;
	}
}
