package com.bjsxt.ticket;

public class Ticket2 implements Runnable{
	private int ticket=5;
	@Override
	public void run() {
		for(int i=0;i<100;i++){  //ÿ����������100����
			 //����ͬ������
			this.saleTicket();
		}
	}
	private synchronized void saleTicket(){  //����ָ��ͬ����������ͬ��������ֻ���ǵ�ǰ����this
		if(ticket>0){//��Ʊ
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"��������"+(ticket--)+"��Ʊ");
		}
	}
}
