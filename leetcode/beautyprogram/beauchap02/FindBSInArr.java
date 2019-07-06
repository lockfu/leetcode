package beauchap02;

import java.util.Arrays;
import java.util.concurrent.FutureTask;

public class FindBSInArr {
	public static int[] bigSmal(int[] A){
		if(null == A || A.length <= 0) return null;
		int max = A[0], min = A[0];
		for(int i = 1; i<A.length; i++){
			if(A[i] > max)
				max = A[i];
			if(A[i] < min)
				min = A[i];
		}
		return new int[]{max, min};
	}
	public static int[] bigSmal_onehalf(int[] A){
		if(null == A || A.length <= 0) return null;
		if(A.length == 1) return new int[]{A[0], A[0]};
		
		for(int i = 0; i<A.length; i+=2){
			if(i+1 < A.length && A[i] < A[i+1]){
				int tmp = A[i];
				A[i] = A[i+1];
				A[i+1] = tmp;
			}
		}
		int max = A[0], min = A[1];
		for(int i = 2, j = 3; i < A.length && j < A.length; i+=2, j+=2){
			if(A[i] > max)
				max = A[i];
			if(A[j] < min)
				min = A[j];
		}	
		return new int[]{max, min};
	}
	
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,10,7,9};
		int[] res = bigSmal(A);
		System.out.println(Arrays.toString(res));
		
	}
}
