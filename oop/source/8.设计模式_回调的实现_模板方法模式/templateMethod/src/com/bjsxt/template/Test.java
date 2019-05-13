package com.bjsxt.template;

public class Test {
	public static void main(String[] args) {
		//父类new 子类对象
		
		BankTemplateMethod saveMoney=new SaveMoney();
		saveMoney.process();
		
		//内部类实现
		BankTemplateMethod btm1=new BankTemplateMethod() {
			
			@Override
			public void transant() {
				System.out.println("转账业务");
				
			}
		};
		System.out.println("\n----------------------------\n");
		btm1.process();
		System.out.println("\n-------------------------------");
		//存款
		BankTemplateMethod btm2=new BankTemplateMethod() {
			
			@Override
			public void transant() {
				System.out.println("取款操作...............");
			}
		};
		btm2.process();
	}
}
