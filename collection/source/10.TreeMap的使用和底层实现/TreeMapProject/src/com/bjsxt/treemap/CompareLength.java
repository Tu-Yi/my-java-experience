package com.bjsxt.treemap;

import java.util.Comparator;
//��дһ���ⲿ�Ƚ�����ʵ���࣬����ʵ�ָ���Ӣ����ĸ�ĸ�����������Ƚ�
public class CompareLength implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		//��������ת��
		String s1=(String)o1;
		String s2=(String)o2;
		return s1.length()-s2.length();
	}

}
