package chap02;

public class DuplicateArr_01 {
	public static int duplicate(int[] A){
		if(null == A || A.length <= 1)
			return -1;
		for(int item : A){
			if(item < 0 || item > A.length-1)
				return -1;
		}
		for(int i = 0; i<A.length; i++){
			while(A[i] != i){
				if(A[i] == A[A[i]])
					return A[i];
				int temp = A[i];
				A[i] = A[temp];
				A[temp] = temp;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,1,0,2,5,3};
		int res = duplicate(A);
		System.out.println(res);
	}
}
