package chap03;

import java.util.Arrays;

public class ReorderOddEven {
	public static void reorder(int[] A){
		if(null == A || A.length < 2) return;
		int st = 0, ed = A.length-1;
		while(st < ed){
			while(st < ed && (A[st] % 2 != 0))st++;
			while(st < ed && (A[ed] % 2 == 0))ed--;
			if(st < ed){
				int temp = A[st];
				A[st] = A[ed];
				A[ed] = temp;
			}
		}
	}
	
	// 保持奇数和奇数的顺序不变， 偶数和偶数的顺序不变。
	 public void reOrderArray(int [] array) {
	        if(null == array || array.length <= 1) return;
	        int l = 0, r = array.length-1;
	        for(int i = 0; i<=r; i++){
	            if(array[i] % 2 != 0){
	                int temp = array[i];
	                int j = i;
	                while(j > 0 && array[j-1] % 2 == 0){
	                    array[j] = array[j-1];
	                    j--;
	                }
	                array[j] = temp;
	            }
	        }
	    }
	
	public static void main(String[] args) {
//		int[] A = {2,3,4,6,7,9,12,5,1};
		
		int[] A = {1,2,3,4,5,6,7};
		reorder(A);
		System.out.println(Arrays.toString(A));
	}
}
