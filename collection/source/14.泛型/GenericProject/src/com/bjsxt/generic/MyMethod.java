package com.bjsxt.generic;

public class MyMethod<T> {//������
	public void show(T t){  //�ڴ���MyMethod��Ķ���ʱ����
		System.out.println(t);
	}
	public <Q> void method(Q q){ //�ڵ���method�������ʱ��ȷ
		System.out.println(q);
	}
	public <K>void fun(K...k){ //�ɱ�����ķ��ͷ���
		for (int i = 0; i < k.length; i++) {
			System.out.println(k[i]);
		}
	}
}
