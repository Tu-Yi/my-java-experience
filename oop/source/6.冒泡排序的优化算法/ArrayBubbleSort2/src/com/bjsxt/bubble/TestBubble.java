package com.bjsxt.bubble;

import java.util.Arrays;

public class TestBubble {
	public static void main(String[] args) {
		//����
		//int [] array={75,87,56,45,49};
		int [] array={1,2,3,4,5,6};
		System.out.println("����֮ǰ"+Arrays.toString(array));
		/**ð��������Ż��㷨*/
		boolean flag;
		int count=0;
		int temp;
		for(int i=0;i<array.length-1;i++){  //5��������4��  N-1
			flag=true;//Ĭ������
			count++;//ͳ�ƱȽϵ�����
			//ÿ�ֱȽϵĴ���
			for(int j=0;j<array.length-1-i;j++){  //����Ƚϵ���������ֻ��Ҫ�Ƚ��������в��ּ���
				//�������
				if(array[j]>array[j+1]){
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=false;//�����е�Ԫ�����򣬷����˽���
				}
			}
			if(flag){
				break;//�˳�ѭ����֤����������
			}
		}
		//����֮�������
		System.out.println("\n����֮��:"+Arrays.toString(array));
		System.out.println("һ���Ƚ���"+count+"��");
	}
}
