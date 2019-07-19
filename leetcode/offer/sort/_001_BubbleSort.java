package sort;

import java.util.Arrays;

public class _001_BubbleSort {
	/**
	 * 冒泡排序
	 * 时间复杂度 O(n^2) 稳定排序
	 * @param A
	 */
	public static void sort(int[] A){
		if(null == A || A.length < 2) return ;
		for(int i = 0; i<A.length-1; i++){    // 外圈是一共要进行len-1次循环
			for(int j = 0; j<A.length-i-1; j++){  // 内圈是每一次都得从头开始进行比较
				if(A[j] > A[j+1]){
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,4,6,1,3,10,8,7};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
}
