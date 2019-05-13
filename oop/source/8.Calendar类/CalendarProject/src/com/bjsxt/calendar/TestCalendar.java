package com.bjsxt.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String[] args) {
		//��������ָ���������
		Calendar cal=new GregorianCalendar();
		cal.set(2030, 1, 14);
		System.out.println("��"+cal.get(1));
		System.out.println("��:"+cal.get(Calendar.YEAR));
		//getTime(),��Calendarת����Date����
		Date d=cal.getTime();
		System.out.println(d);
		//setTime(Date) ��Date��������ʾ��ʱ�����õ�������
		Date date=new Date(1000L);
		cal.setTime(date);
		System.out.println("��:"+cal.get(Calendar.YEAR));
		System.out.println("��:"+cal.get(Calendar.MONTH));
		System.out.println("��:"+cal.get(Calendar.DAY_OF_MONTH));
		cal.add(Calendar.DAY_OF_MONTH, 10);
		
		System.out.println("��:"+cal.get(Calendar.DAY_OF_MONTH));
		cal.add(Calendar.DAY_OF_MONTH, -100);
		System.out.println("��:"+cal.get(Calendar.YEAR));
		System.out.println("��:"+cal.get(Calendar.MONTH));
		System.out.println("��:"+cal.get(Calendar.DAY_OF_MONTH));
		
		
	}
}
