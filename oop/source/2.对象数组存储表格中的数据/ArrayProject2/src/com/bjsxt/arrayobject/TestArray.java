package com.bjsxt.arrayobject;

public class TestArray {
	public static void main(String[] args) {
		//����һ��Person���͵����飬���ڴ洢3��Person���͵Ķ���
		Person [] pers=new Person[3];
		//����Person���͵Ķ���
		Person p1=new Person("����", 19, "��");
		//��p1����洢��Person���͵�������
		pers[0]=p1;
		
		pers[1]=new Person("����", 20, "Ů");
		pers[2]=new Person("����",28,"��");
		
		for(int i=0;i<pers.length;i++){
			System.out.println(pers[i]);
		}
		//���������д洢���Ƕ�������ã��ڴ��ַ��
	}
}
