package sort;

import java.util.Arrays;

public class _008_CountingSort {
	public static void sort(int[] A){
		int maxValue = getMaxValue(A);
		countingSort(A, maxValue);
	}
	private static int getMaxValue(int[] A){
		int max = A[0];
		for(int val : A){
			if(max < val)
				max = val;
		}
		return max;
	}
	
	private static void countingSort(int[] A, int max){
		int bucketLen = max + 1;
		int[] bucket = new int[bucketLen];
		for(int val : A){
			bucket[val]++;
		}
		int index = 0;
		for(int i = 0; i<bucketLen; i++){
			while(bucket[i] > 0){
				A[index++] = i;
				bucket[i]--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,4,6,1,3,10,8,7};
		sort(A);
		System.out.println(Arrays.toString(A));
	}
}
