package com.bjsxt.generic;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		//�������϶���ͬʱ��ȷ�˼��������洢�Ķ��������ֻ����Person����
		ArrayList<Person> al=new ArrayList<Person>();
		//����Person���͵Ķ�����ӵ�������
		Person p1=new Person("marry", 20);
		Person p2=new Person("lili",29);
		Person p3=new Person("jack",18);
		//����Լ�����
		al.add(p1);
		al.add(p2);
		al.add(p3);
		//��������
		print(al);
		
		
		
		//����һ�����϶������ڴ洢Student���͵Ķ���
		ArrayList<Student> al2=new ArrayList<Student>();
		Student stu1=new Student("sean", 20, "sxt1001");
		Student stu2=new Student("nico",19,"sxt1002");
		//��ӵ�������
		al2.add(stu1);
		al2.add(stu2);
		//��Ҫ��������
		print(al2);
		
		//����show����
		System.out.println("\n---------------------------\n");
		show(al);
		show(al2);
		ArrayList<Object> alObject=new ArrayList<Object>();
		Object ob1=new Object();
		Object obj2=new Object();
		alObject.add(ob1);
		alObject.add(obj2);
		
		show(alObject);
	}
	//Person��Person������
	public static void print(ArrayList<? extends Person> al){ //�൱��ArrayList<Person> al=new ArrayList<Student>();��ƥ��
		for (Person p : al) {
			System.out.println(p);
		}
	}
	public static void show(ArrayList<? super Student> al){
		for (Object obj : al) {
			System.out.println(obj);
		}
	}
}
