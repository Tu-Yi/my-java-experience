package cn.sxt.oo2;

/**
 * ���Է�װ
 * @author ���
 *
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Human  h = new Human();
//		h.age = 13;
		h.name = "���";
		h.height = 230;
		
		Person4  p4 = new Person4();
//		p4.age = 14;
		p4.setAge(-14);
		System.out.println(p4.getAge());
	}
}


class   Boy  extends Human {
	public  void  sayHello(){
//		System.out.println(age);		//�����޷�ʹ�ø����˽�����Ժͷ���
	}
}