package com.bjsxt.pro2;

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
				goods.set("С��ͷ", "����");//������Ʒ���ͬ������
			}else{
				goods.set("��Ȫˮ", "�޹���");
			}
			
		}
	}

}
