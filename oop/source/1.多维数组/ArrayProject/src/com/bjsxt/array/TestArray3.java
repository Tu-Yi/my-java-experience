package com.bjsxt.array;

public class TestArray3 {
	public static void main(String[] args) {
		//��ά����
		int [] intA[] ={{1,2},{2,3,4},{3,4,5,6}};
		//(1)��ͨforѭ��
		for(int i=0;i<intA.length;i++){ //0,1,2
			for(int j=0;j<intA[i].length;j++){ //ÿһ��һά����ĳ���
				System.out.print(intA[i][j]+"\t");
			}
			System.out.println();
		}
		//(2)��ǿforѭ��
		System.out.println("\n=========================");
		for(int[] arr:intA){  //int[]��ά������Ԫ�ص�����, arr��������, intA��ά�������
			for(int i:arr){ //int��һά������Ԫ�ص����ͣ�i,��������,arr��һά���������
				System.out.print(i+"\t");
			}
			System.out.println();
		}
		//(3)��ͨ���ǿforѭ���Ļ��
		System.out.println("\n-------------------------");
		for(int [] arr:intA){//��ǿfor
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+"\t");
			}
			System.out.println();
		}
		System.out.println("\n--------------------------");
		for(int i=0;i<intA.length;i++){
			for(int j:intA[i]){//��ǿfor
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}
}
