package com.bjsxt.template;

public class Test {
	public static void main(String[] args) {
		//����new �������
		
		BankTemplateMethod saveMoney=new SaveMoney();
		saveMoney.process();
		
		//�ڲ���ʵ��
		BankTemplateMethod btm1=new BankTemplateMethod() {
			
			@Override
			public void transant() {
				System.out.println("ת��ҵ��");
				
			}
		};
		System.out.println("\n----------------------------\n");
		btm1.process();
		System.out.println("\n-------------------------------");
		//���
		BankTemplateMethod btm2=new BankTemplateMethod() {
			
			@Override
			public void transant() {
				System.out.println("ȡ�����...............");
			}
		};
		btm2.process();
	}
}
