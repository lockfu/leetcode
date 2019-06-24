package sort;

import java.util.Arrays;

public class BubbleSort {
	/**
	 * √∞≈›≈≈–Ú
	 *  ±º‰∏¥‘”∂» O(n^2) Œ»∂®≈≈–Ú
	 * @param A
	 */
	public static void sort(int[] A){
		if(null == A || A.length < 2) return ;
		for(int i = 0; i<A.length-1; i++){
			for(int j = 0; j<A.length-i-1; j++){
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
