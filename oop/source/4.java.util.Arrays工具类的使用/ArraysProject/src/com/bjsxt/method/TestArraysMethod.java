package com.bjsxt.method;

import java.util.Arrays;
import java.util.Comparator;

public class TestArraysMethod {
	public static void main(String[] args) {
		//������һ��һά����
		int [] arrA={23,34,345,234};
		int [] arrB={23,34,345,234};
		//(1)Arrays.toString(������),���ٵı�������Ԫ��
		System.out.println(Arrays.toString(arrA));
		System.out.println("arrA==arrB:"+(arrA==arrB)); //false
		//������������ͬ��˳�������ͬ��Ԫ��
		System.out.println(Arrays.equals(arrA, arrB));//true
		//(2)Arrays.equals(...)��Object�е�equals������ʲô��ͬ��
		System.out.println(arrA.equals(arrB));//false ,ֱ�ӵ�����Object�е�equals���������ڱȽ�����������ڴ��ַ(����)�Ƿ����
		
		//(3)copyOf(...)
		
		int [] arrC=new int[5];//Ĭ��ֵ0
		System.out.println("ǰ"+arrC);
		
		//arrC=Arrays.copyOf(arrA, 10);//Ŀ�����鳤�Ȳ��� �����������´���arrC����,������arrC������
		arrC=Arrays.copyOf(arrA, 5);  //���¿��ٿռ�
		System.out.println("��"+arrC);
		System.out.println(Arrays.toString(arrC));
		//(4)�� ��
		//Arrays.fill(arrC, 99);
		for(int i=0;i<arrC.length;i++){
			arrC[i]=99;
		}
		System.out.println(Arrays.toString(arrC));
		
		//��arrA�����������-->����
		Arrays.sort(arrA);
		System.out.println(Arrays.toString(arrA));
		
		//����һ��Person���͵����飬���ڴ洢3��Person���͵Ķ���
		Person [] pers=new Person[3];
		pers[0]=new Person("marry", 20, "Ů");
		pers[1]=new Person("jack", 22, "��");
		pers[2]=new Person("rose", 19, "Ů");
		//����sort��������Person���� �������������
		Arrays.sort(pers);  //ClassCastException�쳣��Person����ת����Comparable�ӿ�����
		//��������
		for(Person p:pers){
			System.out.println(p);
		}
		/**ϣ��������������*/
		Arrays.sort(pers, 
				new Comparator()
		{

			@Override
			public int compare(Object o1, Object o2) {
				Person p1=(Person)o1;
				Person p2=(Person)o2;
				//�������ַ����бȽϴ�С�ķ���
				return p1.getName().compareTo(p2.getName());
			}
			
		});
		System.out.println("\n��������ȥ����");
		//��������
		for(Person p:pers){
			System.out.println(p);
		}
	}
}
class Person implements Comparable<Person>{
	private String name;
	private int age;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"\t"+age+"\t"+gender;
	}
	@Override
	public int compareTo(Person o) {  //���� ������С�ڸ���������0
	
		return this.age-o.age;
	}
}
