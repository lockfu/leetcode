package chap02;

import java.util.Arrays;

public class QuickSortPartition {
	public static int partiton(int[] A, int start, int end){
		if(null == A || A.length <= 0 || start < 0 || end >= A.length)
			throw new IllegalArgumentException("Illegal Augument!!!");
		int base = A[start];
		int i = start, j = end;
		while(i < j){
			while(i < j && A[j] >= base) j--;
			while(i < j && A[i] <= base) i++;
			if(i<j){
				A[i] = A[i] ^ A[j];
				A[j] = A[i] ^ A[j];
				A[i] = A[i] ^ A[j];
			}
		}
		A[start] = A[i];
		A[i] = base;
		return i;
	}
	
	public static void main(String[] args) {
//		int[] A = {5,2,4,6,1,3,10,8,7};
		int[] A = {2,3,4,2,5,3,3,4,3,3,3};
		int res = partiton(A, 0, A.length-1);
		System.out.println("res: " + res);
		System.out.println(Arrays.toString(A));
	}
}
