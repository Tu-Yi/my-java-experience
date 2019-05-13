package com.bjsxt.runnable;

public class MyRunnable  implements Runnable{////具备了多线程操作的能力

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("MyRunnable.run()---->"+i);
		}
	}

}
