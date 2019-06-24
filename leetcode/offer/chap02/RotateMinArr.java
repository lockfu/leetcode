package chap02;

public class RotateMinArr {
	// {3,4,5,6,1,2}
	public static int min(int[] A){
		if(null == A || A.length <= 0) return -1;
		int i1 = 0, i2 = A.length - 1, mid = 0;
		while(A[i1] >= A[i2]){
			if(i2-i1 == 1){
				mid = i2;
				break;
			}
			mid = (i1 + i2) / 2;
			if(A[mid] >= A[i1])
				i1 = mid;
			else if(A[mid] <= A[i2])
				i2 = mid;
		}
		return A[mid];
	}
	
	public static int min_same(int[] A){
		if(null == A || A.length <= 0) return -1;
		int i1 = 0, i2 = A.length - 1, mid = 0;
		while(A[i1] >= A[i2]){
			if(i2-i1 == 1){
				mid = i2;
				break;
			}
			mid = (i1 + i2) / 2;
			
			if(A[mid] == A[i1] && A[mid] == A[i2])
				return minInorder(A, i1, i2);
			if(A[mid] >= A[i1])
				i1 = mid;
			else if(A[mid] <= A[i2])
				i2 = mid;
		}
		return A[mid];
	}
	
	public static int minInorder(int[] A, int i1, int i2){
		int result = A[i1];
		for(int i = i1+1; i<=i2; i++){
			if(result > A[i])
				result = A[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {3,4,5,1,2};
		int res = min(A);
		System.out.println(res);
	}
}
