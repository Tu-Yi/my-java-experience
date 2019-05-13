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
		System.out.println("������һ������:yyyy-MM-dd");
		String str=input.next();
		//����DateFormat�������ڽ�StringתDate
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date d=df.parse(str);
		//Date��������ʾ��ʱ�����õ�Calendar��
		Calendar cal=new GregorianCalendar();
		cal.setTime(d);
		
		//��ȡ����������е�date����
		int nowDate=cal.get(Calendar.DAY_OF_MONTH);  //14
		
		//����������Ϊ1�ţ����ó�2030-2-1
		cal.set(Calendar.DAY_OF_MONTH, 1);
		//��ȡ1�������ڼ�?
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for(int i=1;i<dayOfWeek;i++){
			System.out.print("\t");
		}
		//��ȡ������·ݵ����һ��
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
