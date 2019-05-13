package com.bjsxt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		//�򼯺���һ�������N���Ԫ��
		Collections.addAll(al, "hello","world","java");
		System.out.println(al);
		//����
		Collections.sort(al);//Ϊʲô����Ӣ����ĸ������������ΪString��߱��˱Ƚϴ�С������
		System.out.println(al);
		//��������
		System.out.println(Collections.binarySearch(al, "java"));//1
		System.out.println(Collections.binarySearch(al, "html"));//-2 -2= -(�����+1) ������������ 1
		ArrayList<String> al2=new ArrayList<String>();
		Collections.addAll(al2, "sql","sql","sql","sql4");
		//���Ͽ���ע��ĵط�:���Դ����.size()>Ŀ�꼯�ϵ�.size()   IndexOutOfBoundsException
		
		Collections.copy(al2, al); //��al������Ԫ�ؿ�����al2��
		System.out.println(al2);
		//�� ��
		Collections.fill(al2, "html");
		System.out.println(al2);
		//�������С
		System.out.println("���:"+Collections.max(al));
		System.out.println("��С:"+Collections.min(al));
	//����
		Collections.reverse(al);
		System.out.println(al);
		//�߳�ͬ��
		List<String> list=Collections.synchronizedList(al);
		
		
	}
}
