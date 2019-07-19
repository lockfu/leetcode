package sort;

import java.util.Arrays;

public class _004_ShellSort {
	/**
	 * 针对有序序列在插入时采用交换法
	 * @param A
	 */
	public static void sort(int[] A){
		//增量gap，并逐步缩小增量
		for(int gap = A.length / 2; gap > 0; gap /= 2){
			//从第gap个元素，逐个对其所在组进行直接插入排序操作
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
