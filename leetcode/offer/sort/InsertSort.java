package sort;

import java.util.Arrays;

public class InsertSort {
	// ��������
	// ��Ȧ�� ����ÿһ��Ԫ�أ��ӵڶ���Ԫ�ؿ�ʼ��
	// ��Ȧ�� ���������Ԫ�أ���β����ʼ��Ȼ��ѡ�����λ�ò���
	// time: O(n^2) space: O(1) 
	// In-place  �ȶ����� ����ǰ��������ȵ������λ�ò��䣬���㷨�ȶ�
	// �����򡢿�������ϣ������ֱ��ѡ���������ȶ��������㷨��
	// ��������ð������ֱ�Ӳ��������۰�������򡢹鲢�������ȶ��������㷨
	/**
	 * ��������
	 * ʱ�临�Ӷ�: O(n^2) �ռ�: O(1)
	 * �ȶ�����
	 * @param A
	 */
	public static void sort(int[] A){
		if(null == A || A.length < 2) return;
		for(int i = 1; i<A.length; i++){
			int key = A[i];   // ��ǰ���������
			int j = i-1;      // ��0��jΪ���������
			while(j >= 0 && A[j] > key){
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,4,6,1,3};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
}
