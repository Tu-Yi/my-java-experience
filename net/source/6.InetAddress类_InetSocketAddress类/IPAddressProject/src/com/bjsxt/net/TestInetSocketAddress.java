package com.bjsxt.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class TestInetSocketAddress {
	public static void main(String[] args) throws UnknownHostException {
		//��������
		InetSocketAddress tsa=new InetSocketAddress("localhost", 9999);
		InetSocketAddress tsa2=new InetSocketAddress("127.0.0.1", 9999);
		InetSocketAddress tsa3=new InetSocketAddress("192.168.31.113", 9999);
		
		InetAddress ia=InetAddress.getByName("192.168.31.113");//("localhost");
		InetSocketAddress tsa4=new InetSocketAddress(ia, 9999);
		System.out.println("��������:"+tsa4.getHostName());
		System.out.println("����IP��ַ:"+tsa4.getAddress());
		
	}
}
