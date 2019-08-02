package chap05;

import java.util.Arrays;

public class InversedPairs {
	
	private static int count = 0;
	public static int inversePair_start(int[] A){
		if(null == A || A.length <= 0) return 0;
		inversePair(A, 0, A.length-1);
		return count;
	}
	public static void inversePair(int[] A, int p, int r){
		if(p >= r) return;
		int q = (p + r) / 2;
		inversePair(A, p, q);
		inversePair(A, q+1, r);
		merge(A, p, q, r);
	}
	
	public static int inversePair_02(int[] A, int p, int r){
		if(null == A || A.length <= 0) return 0;
		int[] copy = Arrays.copyOf(A, A.length);
		return inversePairsCore(A, copy, 0, A.length-1);
	}
	
	public static int inversePairsCore(int[] A, int[] copy,int st, int ed){
		if(st == ed){
			copy[st] = A[st];
			return 0;
		}
		int len = (ed - st) / 2;
		int left = inversePairsCore(A, copy, st, st+len);
		int right = inversePairsCore(A, copy, st+len+1, ed);
		
		int i = st + len, j = ed, indexCopy = ed, count = 0;
		while(i > st && j >= st + len + 1){
			if(A[i] > A[j]){
				copy[indexCopy--] = A[i--];
				count += (j - st - len);
			}else{
				copy[indexCopy--] = A[j--];
			}
		}
		for(; i>=st; i--)
			copy[indexCopy--] = A[i];
		for(; j>=st+len+1; j--)
			copy[indexCopy--] = A[j];
		return left + right + count;
	}
	
	public static void merge(int[] A, int p, int q, int r){
		int n1 = q - p + 1, n2 = r - q;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		
		for(int i = 1; i < n1+1; i++ ){
			left[i] = A[p+i-1];
		}
		for(int i = 1; i < n2+1; i++ ){
			right[i] = A[q+i];
		}
		left[0] = Integer.MIN_VALUE;
		right[0] = Integer.MIN_VALUE;
		int ll = n1, rl = n2;
		for(int k = r; k >= p; k--){
			if(left[ll] > right[rl]){
				if(rl != 0)
					count += rl;
				A[k] = left[ll];
				ll--;
			}else{
				A[k] = right[rl];
				rl--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {7,5,6,4,2};
//		int res = inversePair(A,0,4);
//		System.out.println(res);
	}
}
