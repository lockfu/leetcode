package sort;

import java.util.Arrays;

public class InsertSort {
	// 插入排序
	// 外圈： 遍历每一个元素（从第二个元素开始）
	// 内圈： 遍历排序的元素，从尾部开始，然后选择合适位置插入
	// time: O(n^2) space: O(1) 
	// In-place  稳定排序： 排序前后两个相等的数相对位置不变，则算法稳定
	// 堆排序、快速排序、希尔排序、直接选择排序不是稳定的排序算法；
	// 基数排序、冒泡排序、直接插入排序、折半插入排序、归并排序是稳定的排序算法
	/**
	 * 插入排序
	 * 时间复杂度: O(n^2) 空间: O(1)
	 * 稳定排序
	 * @param A
	 */
	public static void sort(int[] A){
		if(null == A || A.length < 2) return;
		for(int i = 1; i<A.length; i++){
			int key = A[i];   // 当前待排序的数
			int j = i-1;      // 从0到j为已排序的数
			while(j >= 0 && A[j] > key){
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,4,6,1,3};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
}
