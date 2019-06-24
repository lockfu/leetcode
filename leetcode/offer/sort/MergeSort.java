package sort;

import java.util.Arrays;

public class MergeSort {

	
	/**
	 * 归并排序
	 * 时间复杂度： O(nlogn)  稳定排序
	 * @param A
	 * @param p
	 * @param r
	 */
	public static void mergeSort(int[] A, int p, int r){
		if(p < r){
			int q = (p+r)/2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void merge(int[] A, int p, int q, int r){
		//n1 左边数组长度， n2右边数组的长度
		int n1 = q - p + 1, n2 = r - q;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		// 赋值左边数组
		for(int i = 0; i<n1; i++){
			left[i] = A[p+i];
		}
		// 赋值右边数组
		for(int i = 0; i<n2; i++){
			right[i] = A[q+i+1];
		}
		//哨兵节点
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		// 排序
		int i = 0, j = 0;
		for(int k = p; k<=r; k++){
			if(left[i] <= right[j]){
				A[k] = left[i];
				i++;
			}else{
				A[k] = right[j];
				j++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] A = {2,3,1,6,4,9,8,7,5,10};
		mergeSort(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
	}
}
