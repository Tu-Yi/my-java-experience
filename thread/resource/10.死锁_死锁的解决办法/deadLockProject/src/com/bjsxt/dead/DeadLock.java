package com.bjsxt.dead;

public class DeadLock extends Thread {
	private Object money;//钱
	private Object water;//水
	public boolean flag;//标识持有对象锁
	
	public DeadLock(Object money, Object water) {
		super();
		this.money = money;
		this.water = water;
	}

	@Override
	public void run() {
		if(flag){//true时，持有“钱”的锁
			synchronized (money) {
				System.out.println("有钱,等水");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (water) {
					System.out.println("有水，等钱");
				}
			}
		}else{
			synchronized (water) {
				System.out.println("有水，等钱");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (money) {
					System.out.println("有钱，等水");
				}
			}
			
		}
	}
}
