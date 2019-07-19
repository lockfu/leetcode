package sort;

public class _007_HeapSort {
	
	/**
	 * ∂—≈≈–Ú   O(nlogn) ≤ªŒ»∂®
	 * @param A
	 */
	public static void heapsort(int[] A){
		if(null == A || A.length <= 0) return;
		int n = A.length;
		for(int i = n/2-1; i>=0; i--){
			siftdownmax(A,i,n);
		}
		while(n>=0){
			int res = deleteMin(A, n);
			n--;
			System.out.println(res+ " ");
		}
		
	}
	
	public static int deleteMin(int[] A, int n){
		int t = A[0];
		if(n == 0) return t;
		A[0] = A[n-1];
		n--;
		siftdown(A, 0, n);
		return t;
	}
	
	public static void deleteMax(int[] A, int n){
		while(n >= 0){
			swap(A, 0, n-1);
			n--;
			siftdownmax(A, 0, n);
		}
	}
	
	public static void siftdown(int[] A, int i, int n){
		int t = i, flag = 0;
		while(2*i < n && flag == 0){
			if(A[i] > A[2*i])
				t = 2*i;
			if(2*i+1 < n){
				if(A[t] > A[2*i+1])
					t = 2*i+1;
			}
			if(t!=i){
				swap(A, t, i);
				i = t;
			}else
				flag = 1;
		}
	}
	
	public static void siftdownmax(int[] A, int i, int n){
		int t = i, flag = 0;
		while(2*i < n && flag == 0){
			if(A[i] < A[2*i])
				t = 2*i;
			if(2*i+1 < n){
				if(A[t] < A[2*i+1])
					t = 2*i+1;
			}
			if(t!=i){
				swap(A, t, i);
				i = t;
			}else
				flag = 1;
		}
	}
	
	
	public static void swap(int[] A, int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
	
	public static void main(String[] args) {
//		int[] A = {99,5,36,7,22,17,46,12,2,19,25,28,1,92};
//		heapsort(A);
		
		
		Par pp = new Sub();
		Sub ss = (Sub)pp;
	}
	
	
}	




class Par{
	public Par(){
		System.out.println("par...");
	}
	
}

class Sub extends Par{
	public Sub(){
		System.out.println("sub...");
	}
}



