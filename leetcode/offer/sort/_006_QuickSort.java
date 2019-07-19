package sort;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _006_QuickSort {
	
	/**
	 * 快速排序
	 * 时间复杂度： O(n*logn) 不稳定排序
	 * @param A
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] A, int left, int right){
		if(left > right) return;
		int base = A[left];
		int i = left, j = right;
		while(i!=j){
			while(j > i && A[j] >= base) j--;
			while(i < j && A[i] <= base) i++;
			if(i<j){
				A[i] = A[i] ^ A[j];
				A[j] = A[i] ^ A[j];
				A[i] = A[i] ^ A[j];
			}
		}
		A[left] = A[i];
		A[i] = base;
		quickSort(A,left, i-1);
		quickSort(A, i+1, right);
	}
	
	public static int partition(int[] A, int start, int end){
		if(start > end) return -1;
		int base = A[start];
		int i = start, j = end;
		while(i!=j){
			while(j > i && A[j] >= base) j--;
			while(i < j && A[i] <= base) i++;
			if(i<j){
				A[i] = A[i] ^ A[j];
				A[j] = A[i] ^ A[j];
				A[i] = A[i] ^ A[j];
			}
		}
		A[start] = A[i];
		A[i] = base;
		return i;
	}
	
	public static void quicksort2(int[] A, int left, int right){
		if(left == right) return;
		int index = partition(A, 0, right);
		if(index == -1) return;
		if(index > left)
			quicksort2(A, left, index-1);
		if(index > left && index < right)
			quicksort2(A, index+1, right);
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,4,6,1,3,10,8,7};
//		quickSort(A,0,A.length-1);
		quicksort2(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
	}
	
}
