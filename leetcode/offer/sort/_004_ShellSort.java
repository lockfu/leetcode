package sort;

import java.util.Arrays;

public class _004_ShellSort {
	/**
	 * ������������ڲ���ʱ���ý�����
	 * @param A
	 */
	public static void sort(int[] A){
		//����gap��������С����
		for(int gap = A.length / 2; gap > 0; gap /= 2){
			//�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
			for(int i = gap; i<A.length; i++){
				int j = i;
				while(j - gap >= 0 && A[j] < A[j-gap]){
					swap(A, j, j-gap);
					j-=gap;
				}
			}
		}
	}
	
	private static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,4,6,1,3,10,8,7};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
}
