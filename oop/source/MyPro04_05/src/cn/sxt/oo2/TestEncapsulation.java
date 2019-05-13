package cn.sxt.oo2;

/**
 * 测试封装
 * @author 高淇
 *
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Human  h = new Human();
//		h.age = 13;
		h.name = "高淇";
		h.height = 230;
		
		Person4  p4 = new Person4();
//		p4.age = 14;
		p4.setAge(-14);
		System.out.println(p4.getAge());
	}
}


class   Boy  extends Human {
	public  void  sayHello(){
//		System.out.println(age);		//子类无法使用父类的私有属性和方法
	}
}