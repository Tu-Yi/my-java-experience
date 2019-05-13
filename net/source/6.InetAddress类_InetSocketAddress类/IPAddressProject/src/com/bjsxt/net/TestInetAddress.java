package com.bjsxt.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		//(1)获取InetAddress的方式
		InetAddress ia=InetAddress.getLocalHost();  //本机
		System.out.println("获取主机IP地址:"+ia.getHostAddress());
		System.out.println("获取主机名称:"+ia.getHostName());
		
		//(2)根据域名得到InetAddress对象
		InetAddress ia2=InetAddress.getByName("www.jd.com");
		System.out.println("京东服务器的IP地址:"+ia2.getHostAddress());
		System.out.println("主机名称:"+ia2.getHostName());
		
		//(3)根据IP地址获取一个InetAddress对象
		InetAddress ia3=InetAddress.getByName("61.135.253.15");
		System.out.println("服务器主机IP:"+ia3.getHostAddress());
		System.out.println("主机名称:"+ia3.getHostName());
		//如果61.135.253.15IP地址不存在或者DNS（域名解析系统）不允许进行IP地址和域名的映射
	}
}
