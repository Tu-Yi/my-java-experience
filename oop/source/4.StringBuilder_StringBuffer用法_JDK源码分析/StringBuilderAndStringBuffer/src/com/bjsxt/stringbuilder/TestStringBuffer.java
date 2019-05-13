package com.bjsxt.stringbuilder;

public class TestStringBuffer {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		// 字符串的追加
		sb.append("hello");
		sb.append(true);
		sb.append('你');
		sb.append(100);
		System.out.println(sb.toString());

		sb.delete(3, 5);// 含头不含尾
		System.out.println(sb);
		sb.deleteCharAt(1);// 删除指定位置上的字符
		System.out.println(sb);

		sb.insert(2, '好');
		System.out.println(sb);
		System.out.println(sb.indexOf("t") + "\t" + sb.indexOf("k"));
	}
}
