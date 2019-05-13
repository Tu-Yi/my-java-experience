package com.bjsxt.inner;

public class Face { //脸
	private String shape="瓜子脸";//私有属性
	
	public class Nose{//鼻子
		private String shape="高鼻梁";
		public void breath(){
			//当内部类与外部类有相同的属性时，在访问外部类的属性时，需要加上外部类的  类名.this.属性
			System.out.println("鼻子长在了"+Face.this.shape+"形状的脸上");
			System.out.println(shape);
			System.out.println("有使用鼻子呼吸!");
		}
	}
}
