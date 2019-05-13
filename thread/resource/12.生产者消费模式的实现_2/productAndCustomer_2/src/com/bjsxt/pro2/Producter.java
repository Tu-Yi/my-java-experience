package com.bjsxt.pro2;

public class Producter implements Runnable{
	private Goods goods;
	public Producter(Goods goods){
		this.goods=goods;
	}
	@Override
	public void run() {
		//生产商品
		for(int i=0;i<10;i++){
			if(i%2!=0){//奇数
				goods.set("小馒头", "旺仔");//调用商品类的同步方法
			}else{
				goods.set("矿泉水", "娃哈哈");
			}
			
		}
	}

}
