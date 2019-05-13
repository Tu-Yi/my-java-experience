package com.bjsxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Test2 {
	//一次双向通信
	/**一发
	 * 一收
	 * @throws IOException */
	public static void main(String[] args) throws IOException {
		System.out.println("咨询者");
		Scanner input=new Scanner(System.in);
		//创建DatagramSocket对象
		DatagramSocket ds=new DatagramSocket(8888);//本应用程序的端口
		while(true){
			//准备要发送的数据
			String s=input.next();
			byte[] buf=s.getBytes();
			//创建数据报对象
			                            //发送的数据，  发多少，发到哪台主机，主机程序使用的端口
			DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 9999);
			
			//发送
			ds.send(dp);
			
			/**接收数据*/
			byte [] buf2=new byte[1024];
			DatagramPacket dp2=new DatagramPacket(buf2, buf2.length);
			// 借助String的构造方法查看
			ds.receive(dp2);
			String str=new String(dp2.getData(),0,dp2.getLength());
			System.out.println("客服说:"+str);
			
			if("bye".equals(s)){
				break;
			}
		}
		ds.close();
	}
}
