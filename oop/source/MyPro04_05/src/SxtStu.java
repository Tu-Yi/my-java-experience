
public class SxtStu {
	
	//����fields
	int  id;
	String  sname;
	int  age;
	
	Computer  comp;  //�����
	
	//����
	void  study(){
		System.out.println("��������ѧϰ����,ʹ�õ��ԣ�"+comp.brand);
	}
	
	void  play(){
		System.out.println("��������Ϸ������ũҩ��"); 
	}
	
	//���췽�������ڴ��������Ķ����޲εĹ��췽��������ϵͳ�Զ�������
	SxtStu(){
		System.out.println("�������޲εĹ��췽����");
	}
	
	//����ִ�е���ڣ�����Ҫ��
	//javac  Sxtstu.java   ,   java Sxtstu
	public static void main(String[] args) {
		SxtStu  stu = new SxtStu();   //����һ������
		stu.id=1001;
		stu.sname= "���";
		stu.age = 18;
		
		Computer  c1 = new Computer();
		c1.brand = "����";
		
		stu.comp = c1;
		
		stu.play();
		stu.study();
		
	}
}

class  Computer {
	String  brand;
}


