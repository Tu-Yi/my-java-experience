package com.bjsxt.enumpro;

public class TestGender {
	public static void main(String[] args) {
		Gender sex=Gender.女;
		//
		//Gender g=new Gender();//错误的，因为枚举不是类，不能有构造方法
		sex.setName("张三");
		//System.out.println(sex.getName());
		/**枚举与String类型之间的转换*/
		String str=sex.toString();
		System.out.println(str);
		/**枚举-->String  toString()方法
		 * String -->枚举*/
		Gender g=Enum.valueOf(Gender.class, "男");
		System.out.println(g);
		/**枚举在switch中的使用*/
		switch(g){
		case 男:
			System.out.println("男----------");
			break;
		case 女:
			System.out.println("女---------------");
			break;
		}
		/**枚举在自定义类中的使用*/
		Person p=new Person("marry", 20, Gender.女);
	}
}
