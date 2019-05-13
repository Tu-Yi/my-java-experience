package com.bjsxt.pro3;

public class Customer implements Runnable {
	private Goods goods;
	public Customer(Goods goods){
		this.goods=goods;
	}
	public void run() {
		for(int i=0;i<10;i++){
			goods.get();//调用商品类中的取值的方法
		}
		
	};
}
