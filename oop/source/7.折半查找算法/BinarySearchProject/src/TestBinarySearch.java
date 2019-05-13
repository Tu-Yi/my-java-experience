import java.util.Arrays;

public class TestBinarySearch {
	public static void main(String[] args) {
		
		int [] arr={5,13,19,21,37,56,64,75,80,88,92};
		System.out.println(Arrays.binarySearch(arr, 21));//����
		System.out.println(Arrays.binarySearch(arr, 85)); //-10  -�����-1
		
		int low=0;  //��ʼλ��
		int high=arr.length-1;//����λ��
		int key=85;
		boolean flag=false;
		while(low<high){
			//���м��λ�ã�������
			int mid=(low+high)/2;
			if(arr[mid]>key){
				high=mid-1;
			}else if(arr[mid]<key){
				low=mid+1;
			}else{
				//return mid;  //key find
				System.out.println(mid);
				flag=true;
				break;
			}
		}
		if(!flag){
			System.out.println(-low-1);
		}
		
	}
}
