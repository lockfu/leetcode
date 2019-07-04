package chap06;

public class MulMatrix {
	public static void mulMatrix(int[] A){
		if(null == A || A.length <= 0) return;
		int[] B = new int[A.length];
		B[0] = 1;
		for(int i = 1; i<A.length; i++){
			B[i] = B[i-1] * A[i-1];
		}
		
		double tmp = 1;
		for(int i = A.length-2; i>=0; i--){
			tmp *= A[i+1];
			B[i] *= tmp;
		}
	}
}
