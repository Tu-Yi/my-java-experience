package com.bjsxt.dateformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestDateFommat {
	public static void main(String[] args) throws ParseException {
		DateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		/**Date-->String    format(Date d)
		 * String-->Date    parse(String s)*/
		Date date=new Date(12318231233123L);
		System.out.println(date);
		String strDate=d.format(date);
		System.out.println(strDate);
		
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一个时间:yyyy-MM-dd HH:mm:ss.SSS");
		String str=input.nextLine();
		Date d2=d.parse(str);
		
		System.out.println(d2);
	}
}
