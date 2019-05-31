package com.niliv.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
/**
 * JDBC工具类
 * @author Administrator
 * @Date 2019-05-30 16:53:10
 * @Description 
 *
 */
public class JdbcUtil {
	
	private static String driver;
	private static String jdbcUrl;
	private static String username;
	private static String userpassword;
	/**
	 * 初始化参数
	 */
	static {
		
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("driver");
		jdbcUrl = bundle.getString("jdbcUrl");
		username = bundle.getString("username");
		userpassword = bundle.getString("userpassword");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取connection
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(jdbcUrl,username,userpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭Statement
	 * @param statement
	 */
	public static void closeStatement(Statement statement) {
		try {
			if(statement!=null) {
				statement.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 关闭Connection
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 关闭ResultSet
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 关闭所有资源
	 * @param statement
	 * @param conn
	 * @param rs
	 */
	public static void closeResource(Statement statement,Connection conn, ResultSet rs) {
		closeStatement(statement);
		closeConnection(conn);
		closeResultSet(rs);
	}
	/**
	 * rollback
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			if(conn!=null) {
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
