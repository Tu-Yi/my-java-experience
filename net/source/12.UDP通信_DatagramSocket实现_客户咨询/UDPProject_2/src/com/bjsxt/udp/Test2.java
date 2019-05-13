package com.bjsxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Test2 {
	//接收方
			/** 一收，
			 * 一发
			 * @throws IOException 
			 */
	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("客服人员");
		DatagramSocket ds=new DatagramSocket(9999);
		while(true){
			//准 备接收数据
			byte [] buf=new byte[1024];
			//准 备数据报接收
			DatagramPacket dp=new DatagramPacket(buf, buf.length);
			
			//接收
			ds.receive(dp);
			
			//查看接收到的数据
			String str=new String(dp.getData(),0,dp.getLength());
			System.out.println("客户说:"+str);
			
			String s=input.next();
			/**回复数据*/
			byte [] buf2=s.getBytes();
			DatagramPacket dp2=new DatagramPacket(buf2, buf2.length, dp.getAddress(), dp.getPort());
			ds.send(dp2);
			if("bye".equals(s)){
				break;
			}
		}
		//关闭
			
		ds.close();
		
			
	}
}
