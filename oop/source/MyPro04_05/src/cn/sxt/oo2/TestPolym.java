package cn.sxt.oo2;

/**
 * ���Զ�̬
 * @author ���
 *
 */
public class TestPolym {
	public static void main(String[] args) {
		Animal   a = new Animal();
		animalCry(a); 
		
		Animal  d = new Dog();			//�Զ�����ת��
		animalCry(d);
		Animal   c = new Cat();
		animalCry(new Cat());
		
		Dog  d2 = (Dog) d;			//ǿ������ת��
		d2.seeDoor();
//		Dog   d3 = (Dog) c;
//		d3.seeDoor();
		
		//java300�������и���ϸ�Ľ��⡣
		
	}
	
	static  void  animalCry(Animal  a){
		a.shout();
	}
	
	/*static  void  animalCry(Dog  a){
		a.shout();
	}
	static  void  animalCry(Cat  a){
		a.shout();
	}*/
	
}

  class  Animal {
	
    public    void shout() {
        System.out.println("����һ����");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("��������");
    }
    
    public  void   seeDoor(){
    	System.out.println("���ţ�����");   
    }
    
}
class Cat extends Animal {
    public void shout() {
        System.out.println("����������");
    }
}

