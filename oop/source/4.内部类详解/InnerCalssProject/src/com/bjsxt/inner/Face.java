package com.bjsxt.inner;

public class Face { //��
	private String shape="������";//˽������
	
	public class Nose{//����
		private String shape="�߱���";
		public void breath(){
			//���ڲ������ⲿ������ͬ������ʱ���ڷ����ⲿ�������ʱ����Ҫ�����ⲿ���  ����.this.����
			System.out.println("���ӳ�����"+Face.this.shape+"��״������");
			System.out.println(shape);
			System.out.println("��ʹ�ñ��Ӻ���!");
		}
	}
}
