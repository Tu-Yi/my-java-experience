package com.bjsxt.interfacepro;

public interface InterfaceA {
	public void show();
}
interface InterfaceB {
	
}
interface InterfaceC extends InterfaceB,InterfaceA{
	
}
class Impl implements InterfaceC{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}


