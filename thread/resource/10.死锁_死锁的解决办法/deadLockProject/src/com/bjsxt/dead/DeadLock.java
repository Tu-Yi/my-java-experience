package com.bjsxt.dead;

public class DeadLock extends Thread {
	private Object money;//Ǯ
	private Object water;//ˮ
	public boolean flag;//��ʶ���ж�����
	
	public DeadLock(Object money, Object water) {
		super();
		this.money = money;
		this.water = water;
	}

	@Override
	public void run() {
		if(flag){//trueʱ�����С�Ǯ������
			synchronized (money) {
				System.out.println("��Ǯ,��ˮ");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (water) {
					System.out.println("��ˮ����Ǯ");
				}
			}
		}else{
			synchronized (water) {
				System.out.println("��ˮ����Ǯ");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (money) {
					System.out.println("��Ǯ����ˮ");
				}
			}
			
		}
	}
}
