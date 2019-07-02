package chap05;

public class InversedPairs {
	
	private static int count = 0;
	public static int inversePair(int[] A, int p, int r){
		if(p < r){
			int q = (p + r) / 2;
			inversePair(A, p, q);
			inversePair(A, q+1, r);
			merge(A, p, q, r);
		}
		return count;
	}
	
	public static void merge1(int[] A, int p, int q, int r){
		int n1 = q - p + 1, n2 = r - q;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		for(int i = 0; i<n1; i++){
			left[i] = A[i + p];
		}
		for(int i = 0; i<n2; i++){
			right[i] = A[i+q+1];
		}
		int i = 0, j = 0;
		for(int k = p; k <= r; k++){
			if(left[i] <= right[j]){
				A[k] = left[i];
				i++;
			}else{
				A[k] = right[j];
				j++;
			}
		}
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
		int res = inversePair(A,0,4);
		System.out.println(res);
	}
}
