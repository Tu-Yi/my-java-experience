package com.bjsxt.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String[] args) {
		//父类引用指向子类对象
		Calendar cal=new GregorianCalendar();
		cal.set(2030, 1, 14);
		System.out.println("年"+cal.get(1));
		System.out.println("年:"+cal.get(Calendar.YEAR));
		//getTime(),将Calendar转换成Date对象
		Date d=cal.getTime();
		System.out.println(d);
		//setTime(Date) 将Date对象所表示的时间设置到日历中
		Date date=new Date(1000L);
		cal.setTime(date);
		System.out.println("年:"+cal.get(Calendar.YEAR));
		System.out.println("月:"+cal.get(Calendar.MONTH));
		System.out.println("日:"+cal.get(Calendar.DAY_OF_MONTH));
		cal.add(Calendar.DAY_OF_MONTH, 10);
		
		System.out.println("日:"+cal.get(Calendar.DAY_OF_MONTH));
		cal.add(Calendar.DAY_OF_MONTH, -100);
		System.out.println("年:"+cal.get(Calendar.YEAR));
		System.out.println("月:"+cal.get(Calendar.MONTH));
		System.out.println("日:"+cal.get(Calendar.DAY_OF_MONTH));
		
		
	}
}
