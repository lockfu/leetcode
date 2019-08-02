package chap05;

import java.util.ArrayList;
import java.util.Arrays;

public class MoreThanHalfNum {
	public static int moreHalfNum(int[] A){
		if(null == A || A.length <= 1) return -1;
		int times = 0;
		int candidate = -1;
		for(int i = 0; i < A.length; i++){
			if(times == 0){
				candidate = A[i];
				times++;
			}else{
				if(candidate == A[i])
					times++;
				else
					times--;
			}
		}
		return candidate;
	}
	
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
	
	public static int morehalf(int[] A){
		int middle = A.length >> 1;
		int l = 0, r = A.length-1;
		int index = partiton(A, l, r);
		while(index != middle){
			if(index > middle){
				r = index - 1;
				index = partiton(A, l, r);
			}else{
				l = index + 1;
				index = partiton(A, l, r);
			}
		}
		return A[middle];
	}
	
	
	public static void main(String[] args) {
		int[] A = {2,3,4,2,5,3,3,4,3,3,3};
		new ArrayList<>(Arrays.asList(A));
		int res = morehalf(A);
		System.out.println(res);
	}
}
