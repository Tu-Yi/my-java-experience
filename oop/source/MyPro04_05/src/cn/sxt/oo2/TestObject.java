package cn.sxt.oo2;

public class TestObject {
	public static void main(String[] args) {
//		Object obj;
		
		TestObject   to = new TestObject();
		System.out.println(to.toString());
		
		Person2  p2 = new Person2("ϣϣ", 6);
		System.out.println(p2.toString()); 
		
	}
	
	public String toString(){
		return  "����Object����";
	}
	
}


class Person2 {
    String name;
    int age;
    
    @Override
    public String toString() {
        return name+",���䣺"+age;
    }
    
    public Person2(String  name, int age) {
    	this.name = name;
    	this.age = age;
	}
    
    
}
