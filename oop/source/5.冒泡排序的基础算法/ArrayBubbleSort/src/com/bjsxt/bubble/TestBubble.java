package com.bjsxt.bubble;

import java.util.Arrays;

public class TestBubble {
	public static void main(String[] args) {
		//����
		int [] array={75,87,56,45,49};
		System.out.println("����֮ǰ"+Arrays.toString(array));
		for(int i=0;i<array.length-1;i++){  //�Ƚϵ�����
			for(int j=0;j<array.length-1;j++){
				//����������Ƚ�
				if(array[j]>array[j+1]){
					//������������
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		//����֮�������
		System.out.println("\n����֮��:"+Arrays.toString(array));
	}
}
