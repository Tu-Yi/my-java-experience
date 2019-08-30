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
 * JDBC的公共类
 * 
 * @author Administrator
 * 
 */
public class DBUtil {

	
	/**
	 * 创建一个连接	 * 
	 * @return
	 */
	public static Connection getConnection() {		
		Connection conn = null;
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 获取连接
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
	 * 关闭数据库资源
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
	 * 执行insert、update、delete 三个DML操作
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
			//在该层次处理异常
			e.printStackTrace();		
			//如果需要，可以再抛给上一层
			throw e;
		}
		return n;
	}
}
