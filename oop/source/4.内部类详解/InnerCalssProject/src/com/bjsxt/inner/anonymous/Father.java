package com.bjsxt.inner.anonymous;

public abstract class Father {//父类
	public abstract void dream();//伟 大的梦想
}
class Son extends Father{  //子类是有名称的，子类的名称叫son

	@Override
	public void dream() {
		
	}
	
}
class Test{
	public static void main(String[] args) {
		//父类引用指向子类对象
		Father f=new Son();  //在名字的子类
		/**没有名字的子类*/
		Father f2=new Father()
				{  //没有名称的类
					@Override
					public void dream() {
						System.out.println("努力实现父亲的伟 大梦想，当兵光荣");
					}
				};
		f2.dream();
	}
}