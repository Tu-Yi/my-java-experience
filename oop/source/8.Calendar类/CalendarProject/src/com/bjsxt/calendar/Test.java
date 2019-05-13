package com.bjsxt.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一个日期:yyyy-MM-dd");
		String str=input.next();
		//创建DateFormat对象，用于将String转Date
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date d=df.parse(str);
		//Date对象所表示的时间设置到Calendar中
		Calendar cal=new GregorianCalendar();
		cal.setTime(d);
		
		//获取输入的日期中的date部分
		int nowDate=cal.get(Calendar.DAY_OF_MONTH);  //14
		
		//将日期设置为1号，设置成2030-2-1
		cal.set(Calendar.DAY_OF_MONTH, 1);
		//获取1号是星期几?
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int i=1;i<dayOfWeek;i++){
			System.out.print("\t");
		}
		//获取输入的月份的最后一天
		int maxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//System.out.println(maxDay);
		for(int i=1;i<=maxDay;i++){
			System.out.print(i);
			if(i==nowDate){
				System.out.print("*");
			}
			System.out.print("\t");
			if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
				System.out.println();
			}
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		
	}
}
