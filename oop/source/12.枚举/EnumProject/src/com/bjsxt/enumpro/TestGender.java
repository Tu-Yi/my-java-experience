package com.bjsxt.enumpro;

public class TestGender {
	public static void main(String[] args) {
		Gender sex=Gender.Ů;
		//
		//Gender g=new Gender();//����ģ���Ϊö�ٲ����࣬�����й��췽��
		sex.setName("����");
		//System.out.println(sex.getName());
		/**ö����String����֮���ת��*/
		String str=sex.toString();
		System.out.println(str);
		/**ö��-->String  toString()����
		 * String -->ö��*/
		Gender g=Enum.valueOf(Gender.class, "��");
		System.out.println(g);
		/**ö����switch�е�ʹ��*/
		switch(g){
		case ��:
			System.out.println("��----------");
			break;
		case Ů:
			System.out.println("Ů---------------");
			break;
		}
		/**ö�����Զ������е�ʹ��*/
		Person p=new Person("marry", 20, Gender.Ů);
	}
}
