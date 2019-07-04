package chap06;

import java.util.Arrays;

public class IsContinuous {
	public static boolean isContinus(int[] A){
		if(null == A || A.length < 5) return false;
		Arrays.sort(A);
		int zerocount = 0;
		for(int i = 0; i<A.length; i++){
			if(A[i] == 0)
				zerocount++;
			if(A[i] != 0 && i < A.length-1 && A[i] == A[i+1])
				return false;
		}
		int gap = 0;
		for(int i = zerocount+1; i<A.length; i++){
			gap += A[i] - A[i-1] - 1;
		}
		System.out.println("zc: " + zerocount + " gap: " + gap);
		return gap > zerocount ? false : true;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,3,4,5};
		boolean res = isContinus(A);
		System.out.println(res);
	}
}
