package chap05;

public class FindGreatestSumOfSubArr {
	public static int findMaxSubarrSum(int[] A){
		if(null == A || A.length <= 0) return 0;
		int max = A[0];
		int sum = A[0];
		for(int i = 1; i<A.length; i++){
			sum += A[i];
			if(sum < A[i]){
				sum = A[i];
			}
			if(sum > max)
				max = sum;
		}
		return max;
	}
	
	
	public static int findMaxSubarrSum_dy(int[] A){
		if(null == A || A.length <= 0) return 0;
		int max = A[0];
		for(int i = 1; i<A.length; i++){
			if(A[i-1] > 0) A[i] = A[i-1] + A[i];
			if(max < A[i]) max = A[i];
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] A = {1,-2,3,10,-4,7,-2, 2, 2, -5};
		int res = findMaxSubarrSum(A);
		System.out.println(res);
	}
}
