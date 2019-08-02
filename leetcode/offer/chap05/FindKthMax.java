package chap05;

import java.util.Arrays;

public class FindKthMax {
	
	public static int partition(int[] A, int x, int y){
		int i = x, j = y;
		int base = A[i];
		while(i<j){
			while(i<j && A[j] <= base) j--;
			while(i < j && A[i] >= base) i++;
			if(i < j){
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		A[x] = A[i];
		A[i] = base;
		return i;
	}
	
	public static void findKthMax_Par(int[] A, int k){
		if(null == A || A.length <= 0) return;
		int l = 0, r = A.length-1;
		int index = partition(A, l,r);
		while(index != k-1){
			if(index > k -1){
				r = index -1;
				index = partition(A, l, r);
			}else{
				l = index + 1;
				index = partition(A, l, r);
			}
		}
		for(int i = 0; i<k; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	
	public static int[] findKthMax_heap(int[] A, int k){
		if(null == A || A.length <= 0 || k <= 0) return null;
		if(k >= A.length) return A;
		int[] res = new int[k];
		for(int i = 0; i<k; i++){
			res[i] = A[i];
		}
		for(int i = k / 2; i >= 0; i--){
			siftdown(res,i);
		}
		for(int i = k; i<A.length; i++){
			if(A[i] < res[0]){
				res[0] = A[i];
				siftdown(res, 0);
			}
		}
		return res;
	}
	
	public static void siftup(int[] A, int i){
		int t = i, flag = 0;
		while(2 * i < A.length && flag == 0){
			if(A[i] > A[2 * i])
				t = 2 * i;
			if(2 * i + 1 < A.length)
				if(A[t] > A[2 * i + 1])
					t = 2 * i + 1;
			if(t != i){
				int temp = A[t];
				A[t] = A[i];
				A[i] = temp;
				i = t;
			}else
				flag = 1;
		}
	}
	
	public static void siftdown(int[] A, int i){
		int t = i, flag = 0;
		while(2 * i < A.length && flag == 0){
			if(A[i] < A[2 * i])
				t = 2 * i;
			if(2 * i + 1 < A.length)
				if(A[t] < A[2 * i + 1])
					t = 2 * i + 1;
			if(t != i){
				int temp = A[t];
				A[t] = A[i];
				A[i] = temp;
				i = t;
			}else
				flag = 1;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {4,5,1,6,2,7,3,8,9,10,12,13};
//		findKthMax_Par(A, 4);
		int[] res = findKthMax_heap(A, 4);
		System.out.println(Arrays.toString(res));
		
//		System.out.println(SubClass.val);
	}
}


class SuperClass{
	static{
		System.out.println("Super CLass");
	}
	
	public static int val = 11;
}

class SubClass extends SuperClass{
	static{
		System.out.println("Subclass");
	}
}


