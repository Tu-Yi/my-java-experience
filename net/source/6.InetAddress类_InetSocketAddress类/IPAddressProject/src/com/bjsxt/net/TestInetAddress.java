package com.bjsxt.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		//(1)��ȡInetAddress�ķ�ʽ
		InetAddress ia=InetAddress.getLocalHost();  //����
		System.out.println("��ȡ����IP��ַ:"+ia.getHostAddress());
		System.out.println("��ȡ��������:"+ia.getHostName());
		
		//(2)���������õ�InetAddress����
		InetAddress ia2=InetAddress.getByName("www.jd.com");
		System.out.println("������������IP��ַ:"+ia2.getHostAddress());
		System.out.println("��������:"+ia2.getHostName());
		
		//(3)����IP��ַ��ȡһ��InetAddress����
		InetAddress ia3=InetAddress.getByName("61.135.253.15");
		System.out.println("����������IP:"+ia3.getHostAddress());
		System.out.println("��������:"+ia3.getHostName());
		//���61.135.253.15IP��ַ�����ڻ���DNS����������ϵͳ�����������IP��ַ��������ӳ��
	}
}
