package beauchap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FindLargestK {
	
	public static int getPartition(int[] A, int left, int right){
		int l = left, r = right;
		int base = A[l];
		while(l < r){
			while(l < r && A[r] <= base) r--;
			while(l < r && A[l] >= base) l++;
			if(l < r){
				int temp = A[l];
				A[l] = A[r];
				A[r] = temp;
			}
		}
		A[left] = A[l]; 
		A[l] = base;
		return l;
	}
	
	
	public static List<Integer> getLargestK_par(int[] A, int k){
		if(null == A || A.length <= 0 || k<=0 || A.length <= k) return null;
		List<Integer> res = new ArrayList<>();
		int index = getPartition(A, 0, A.length-1);
		while(index != k-1){
			if(index > k-1)
				index = getPartition(A, 0, index-1);
			else
				index = getPartition(A, index+1, A.length-1);
		}
		System.out.println(index);
		return res;
	}
	
	
	public static void findLargestK_Set(int[] A, int k){
		if(null == A || A.length <= 0 || k<=0 || A.length <= k) return ;
		TreeSet<Integer> set = new TreeSet<>();
		for(int i =0; i<A.length; i++){
			if(set.size() < k)
				set.add(A[i]);
			else{
				if(set.first() < A[i]){
					set.remove(set.first());
					set.add(A[i]);
				}
			}
		}
		System.out.println(set.toString());
	}
	
	public static void findLargestK_Heap(int[] A, int k){
		if(null == A || A.length <= 0 || k<=0 || A.length <= k) return ;
		int[] HEAP = Arrays.copyOf(A, k);
		for(int i = HEAP.length/2; i>=0; i--){
			siftDown(HEAP, i);
		}
		System.out.println(Arrays.toString(HEAP));
		for(int i = k; i<A.length; i++){
			if(A[i] > HEAP[0]){
				HEAP[0] = A[i];
				siftDown(HEAP, 0);
			}
		}
		System.out.println(Arrays.toString(HEAP));
	}
	
	public static void siftDown(int[] A, int i){
		int t = i, flag = 0;
		while(2 * i < A.length && flag == 0){
			if(A[i] > A[2*i])
				t = 2 * i;
			if(2*i+1 < A.length){
				if(A[t] > A[2*i+1])
					t = 2 * i + 1;
			}
			if(t != i){
				swap(A, i, t);
				i = t;
			}else{
				flag = 1;
			}
		}
	}
	
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {9,10,1,2,3,4,5,6,7};
		findLargestK_Heap(A, 3);
//		System.out.println(Arrays.toString(A));
	}
	
}
