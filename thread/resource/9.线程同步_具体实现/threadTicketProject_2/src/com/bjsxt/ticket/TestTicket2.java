package com.bjsxt.ticket;

public class TestTicket2 {
	public static void main(String[] args) {
		Ticket2 ticket=new Ticket2();
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
