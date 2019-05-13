package com.bjsxt.ticket;

public class Ticket1 implements Runnable{
	private int ticket=5;
	@Override
	public void run() {
		for(int i=0;i<100;i++){  //每个窗口排了100个人
			synchronized (this) {  //同步代码块
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
	}
}
