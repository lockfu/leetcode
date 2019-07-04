package chap06;

public class MaxDiff {
	public static int maxDiff(int[] A){
		if(null == A || A.length < 2) return 0;
		int min = A[0];
		int maxdiff = A[1] - min;
		for(int i = 2; i<A.length; i++){
			if(A[i-1] < min)
				min = A[i-1];
			int curdiff = A[i] - min;
			if(curdiff > maxdiff)
				maxdiff = curdiff;
		}
		return maxdiff;
	}
	
	public static void main(String[] args) {
		int[] A = {9,11,8,5,7,12,16,14};
		int res = maxDiff(A);
		System.out.println(res);
	}
}
