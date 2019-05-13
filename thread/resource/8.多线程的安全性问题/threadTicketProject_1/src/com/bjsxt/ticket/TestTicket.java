package com.bjsxt.ticket;

public class TestTicket {
	public static void main(String[] args) {
		Ticket ticket=new Ticket();
		//创建Thread类
		Thread t1=new Thread(ticket, "A窗口");
		Thread t2=new Thread(ticket,"B窗口");
		Thread t3=new Thread(ticket,"C窗口");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}
