package com.niliv.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil2 {
	//使用ThreadLocal可以存储某个变量的副本，让同一个线程中不同方法共用
	//将Connection放入TheadLocal可以实现不同层次、不同DML操作使用同一个Connection

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	static String driver;
	static String url;
	static String user;
	static String password;
	
	//读取属性文件properties并获取内容
	static{
		//准备一个空的map，没有key-value
		Properties prop = new Properties();
		
		//读取文件，并将文件键值对存入Properties对象
		//InputStream is = new FileInputStream(new File("C:\Users\Administrator\workspace\java_empmgr2\src\conn.properties"));
		InputStream is = DBUtil.class.getResourceAsStream("/jdbc.properties"); //classpath
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//从prop中根据key获取四个参数的值
		driver = prop.getProperty("driver");
		//driver = prop.get("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("username");
		password = prop.getProperty("password");
		
		//加载驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static  Connection getConnection(){
		
		
		Connection conn = null;
		
		//首先从ThreadLocal中获取，如果没有，就创建一个新的连接，然后赶快放入到threadLocal
		conn = threadLocal.get();
		if(conn == null){
			try{			
				//建立数据库连接			
				conn = DriverManager.getConnection(url, user, password);
			}catch(SQLException e){
				e.printStackTrace();
			}
			threadLocal.set(conn);
		}
		
		return conn;
		
	}
	
	/**
	 * 关闭数据库资源
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll(ResultSet rs ,Statement stmt,Connection conn){
		//关闭数据库资源
		try {
			if(rs!=null){
				rs.close();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt != null){
				stmt.close();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null){
				conn.close();
				//threadLocal.set(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DML:insert  update  delete
	 */
	public static int executeUpdate(String  sql,Object ... params) {
		Connection conn =  null;
		PreparedStatement pstmt = null;
		int n = 0;
		try{
			//获取数据库连接
			conn = getConnection();
			
			//使用手枪发送SQL命令并得到结果			
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}		
			n = pstmt.executeUpdate();
			
			
		}catch(SQLException e){
			//处理异常
			e.printStackTrace();
			//throw e;
			//抛出异常给上级（调用者）
			//throw new RuntimeException(e.toString());
			throw new MyException(e.toString());
		}finally{
			//关闭数据库资源
			//DBUtil.closeAll(null, pstmt, conn);
			DBUtil.closeAll(null, pstmt, null);//
		}
				
		//返回数据
		return n;
	}
	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println(conn);
	}
}
