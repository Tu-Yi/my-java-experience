package com.bjsxt.pro;

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
				goods.setBrand("旺仔");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				goods.setName("小馒头");
			}else{
				goods.setBrand("娃哈哈");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				goods.setName("矿泉水");
			}
			System.out.println("生产者线程生产了"+goods.getBrand()+"--------------------"+goods.getName());
		}
	}

}
