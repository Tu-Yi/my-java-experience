package com.bjsxt.throwsoo;

import java.io.File;
import java.io.IOException;

public class Father {
	public void show()throws Exception{
		
	}
	public void method() throws IOException{
		
	}
	public void fun(){
		
	}
}
class Son extends Father{
	@Override
	public void show()  {
		super.show(); 
	}
	@Override
	public void method() throws IOException {
		File f=new File("D:\\a.txt");
		
			f.createNewFile();
		
	}
	@Override
	public void fun()throws RuntimeException {
		// TODO Auto-generated method stub
		super.fun();
	}
}