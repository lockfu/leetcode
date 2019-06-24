package beatifulprogram;

import java.util.Arrays;

public class Saobing {
	private static int mnMax;
	public void bestSort(int[] A){
		if(null == A || A.length <= 1) return;
		mnMax = A.length * 2;
		int[] swapArr = new int[mnMax + 1];
		int[] reverseSwap = new int[mnMax+1];
		solve(A, 0, swapArr, reverseSwap);
	}
	
	public void solve(int[] A, int t, int[] swapArr, int[] reverseSwap){
		int estimate = t + lowerBound(A);
		if(estimate > mnMax)
			return;
		if(isSorted(A)){
			if(t < mnMax){
				mnMax = t;
				for(int i = 0; i<mnMax; i++){
					swapArr[i] = reverseSwap[i];
					System.out.print(swapArr[i] + ", ");
				}
				System.out.println(" -----  ");
			}
			return;
		}
		for(int i = 1; i < A.length; i++){
			reverse(A, 0, i);
			reverseSwap[t] = i;
			solve(A, t+1,swapArr, reverseSwap);
			reverseSwap[t] = 0;
			reverse(A, 0, i);
		}
	}
	
	public int lowerBound(int[] A){
		int res = 0;
		for(int i = 1; i< A.length; i++){
			int t = A[i] - A[i-1];
			if(Math.abs(t) != 1)
				res++;
		}
		return res;
	}
	
	public void reverse(int[] A, int l, int r){
		for(int i = l, j = r; i < j; i++, j--){
			A[i] = A[i] ^ A[j];
			A[j] = A[i] ^ A[j];
			A[i] = A[i] ^ A[j];
		}
	}
	
	public boolean isSorted(int[] A){
		for(int i = 1; i<A.length; i++){
			if(A[i-1] > A[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Saobing sb = new Saobing();
		int[] A = {3,2,1,6,5,4,9,8,7,0};
		sb.bestSort(A);
		System.out.println(Arrays.toString(A));
	}
}
