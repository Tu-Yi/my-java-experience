package com.bjsxt.testdate;

import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(System.currentTimeMillis());//1970-1-1 00:00:00
		
		Date d2=new Date(1000L);
		System.out.println(d2.toGMTString());
		System.out.println(d.getTime());
		
		System.out.println(d.before(d2)); //false
		System.out.println(d.after(d2)); //true
		
		System.out.println(d.getTime()<d2.getTime());
		System.out.println(d.getTime()>d2.getTime()); //
		System.out.println(d2.toString());
		
		/**java.util.Date类的子类*/
		java.sql.Date  sqlDate=new java.sql.Date(1000L);
		System.out.println(sqlDate);
		
		java.sql.Time sqlTime=new java.sql.Time(1000L);
		System.out.println(sqlTime.toGMTString());
		
		java.sql.Timestamp timestamp=new java.sql.Timestamp(1001L);
		System.out.println(timestamp);
	}
}
