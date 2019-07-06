package chap02;

/**
 * 一个长度为n的数组， 数字在0-n-1之间 找出重复的数字
 * @author DELL
 *
 */

public class DuplicateArr_01 {
	public static int duplicate(int[] A){
		if(null == A || A.length <= 1)
			return -1;
		for(int item : A){  // 如果数字小于0或者大于n-1 则数组符合条件
			if(item < 0 || item > A.length-1)
				return -1;
		}
		for(int i = 0; i<A.length; i++){  // 为每个元素找到正确的位置
			while(A[i] != i){		    // 当前元素不在正确的位置则一直循环
				if(A[i] == A[A[i]])     // 如果i == A[i] 相等， 说明当前位置有元素了，即重复元素
					return A[i];
				int temp = A[i];        // 否则交换元素
				A[i] = A[temp];
				A[temp] = temp;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,1,0,2,5,3};
		int res = duplicate(A);
		System.out.println(res);
	}
}
