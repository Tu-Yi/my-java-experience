package com.bjsxt.inner;

import com.bjsxt.inner.Face.Nose; //导包

public class TestFace {
	public static void main(String[] args) {
		//创建的是脸的对象
		Face f=new Face();
		//创建鼻子的对象
		Nose n=f.new Nose();
		//调用方法
		n.breath();
	}
}
