package com.bjsxt.stringbuilder;

public class TestStringBuffer {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		// �ַ�����׷��
		sb.append("hello");
		sb.append(true);
		sb.append('��');
		sb.append(100);
		System.out.println(sb.toString());

		sb.delete(3, 5);// ��ͷ����β
		System.out.println(sb);
		sb.deleteCharAt(1);// ɾ��ָ��λ���ϵ��ַ�
		System.out.println(sb);

		sb.insert(2, '��');
		System.out.println(sb);
		System.out.println(sb.indexOf("t") + "\t" + sb.indexOf("k"));
	}
}
