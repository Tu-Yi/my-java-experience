package com.bjsxt.pro;

public class Customer implements Runnable {
	private Goods goods;
	public Customer(Goods goods){
		this.goods=goods;
	}
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("-----消费者线程取了"+goods.getBrand()+"----------------"+goods.getName());
		}
		
	};
}
