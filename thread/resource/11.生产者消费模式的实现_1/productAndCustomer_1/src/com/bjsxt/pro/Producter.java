package com.bjsxt.pro;

public class Producter implements Runnable{
	private Goods goods;
	public Producter(Goods goods){
		this.goods=goods;
	}
	@Override
	public void run() {
		//������Ʒ
		for(int i=0;i<10;i++){
			if(i%2!=0){//����
				goods.setBrand("����");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				goods.setName("С��ͷ");
			}else{
				goods.setBrand("�޹���");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				goods.setName("��Ȫˮ");
			}
			System.out.println("�������߳�������"+goods.getBrand()+"--------------------"+goods.getName());
		}
	}

}
