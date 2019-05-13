package com.bjsxt.ticket;

public class Ticket2 implements Runnable{
	private int ticket=5;
	@Override
	public void run() {
		for(int i=0;i<100;i++){  //每个窗口排了100个人
			 //调用同步方法
			this.saleTicket();
		}
	}
	private synchronized void saleTicket(){  //无需指定同步监视器，同步监视器只能是当前对象this
		if(ticket>0){//有票
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"正在卖第"+(ticket--)+"张票");
		}
	}
}
