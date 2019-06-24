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
	
	public static void main(String[] args) {
		int[] A = {2,3,4,6,7,9,12,5,1};
		reorder(A);
		System.out.println(Arrays.toString(A));
	}
}
