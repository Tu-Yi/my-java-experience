package com.bjsxt.ticket;

public class TestTicket1 {
	public static void main(String[] args) {
		Ticket1 ticket=new Ticket1();
		//����Thread��
		Thread t1=new Thread(ticket, "A����");
		Thread t2=new Thread(ticket,"B����");
		Thread t3=new Thread(ticket,"C����");
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
	}
}
