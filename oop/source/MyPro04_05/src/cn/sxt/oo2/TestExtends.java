package cn.sxt.oo2;

/**
 * ���Լ̳�
 * @author ���
 *
 */
public class TestExtends {
	public static void main(String[] args) {
		Student   stu  =  new Student();
		stu.name="���";
		stu.height = 172;
		stu.rest();
		
		Student  stu2 = new Student("ϣϣ",6,"�ھ��רҵ");
		
		System.out.println(stu2   instanceof  Student);
		System.out.println(stu2   instanceof   Person ); 
		System.out.println(stu2   instanceof   Object ); 
		System.out.println(new Person()   instanceof   Student ); 
		
	}
}


class  Person   /*extends  Object*/ {
	String  name;
	int   height;
	
	public void  rest(){
		System.out.println("��Ϣһ�ᣡ");
	}
}

class  Student   extends  Person  {
	String   major;
	
	public   void   study(){
		System.out.println("ѧϰ��Сʱ��");
	}
	
	public  Student(String name,int height, String  major){
		this.name = name;
		this.height = height;
		this.major = major;
	}
	
	public Student(){
	}
	
	
}