package com.bjsxt.inner.anonymous;

public abstract class Father {//����
	public abstract void dream();//ΰ �������
}
class Son extends Father{  //�����������Ƶģ���������ƽ�son

	@Override
	public void dream() {
		
	}
	
}
class Test{
	public static void main(String[] args) {
		//��������ָ���������
		Father f=new Son();  //�����ֵ�����
		/**û�����ֵ�����*/
		Father f2=new Father()
				{  //û�����Ƶ���
					@Override
					public void dream() {
						System.out.println("Ŭ��ʵ�ָ��׵�ΰ �����룬��������");
					}
				};
		f2.dream();
	}
}