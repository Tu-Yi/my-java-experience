package com.niliv.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory factory=null;
	
	static {
		
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static SqlSession getSession() {
		SqlSession session=null;
		if(factory!=null) {
			session = factory.openSession(true); //true 打开自动提交
		}
		return session;
	}
}
