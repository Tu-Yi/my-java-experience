package com.bjsxt.treemap;

import java.util.Comparator;
//编写一个外部比较器的实现类，用于实现根据英文字母的个数进行升序比较
public class CompareLength implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		//向下类型转换
		String s1=(String)o1;
		String s2=(String)o2;
		return s1.length()-s2.length();
	}

}
