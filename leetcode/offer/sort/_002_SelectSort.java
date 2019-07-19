package sort;

import java.util.Arrays;

public class _002_SelectSort {
	
	/**
	 * 选择排序 
	 * 时间复杂度 O(n^2) 不稳定排序
	 * @param A
	 */
	public static void sort(int[] A){
		for(int i = 0; i<A.length-1; i++){
			int min = i;
			for(int j = i+1; j < A.length; j++){
				if(A[j] < A[min])
					min = j;
			}
			if(i != min){
				swap(A,i,min);
			}
		}
	}
	private static void swap(int[] A, int i, int min){
		int tmp = A[i];
		A[i] = A[min];
		A[min] = tmp;
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,4,6,1,3,10,8,7};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
}
