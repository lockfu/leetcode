package chap02;

/**
 * 不修改找出重复的数字
 * 长度为1+n的数组中的所有数组在1-n范围中。找到任意一个重复的数字
 * 使用二分查找的方法，对1-n的数字进行划分，查看每半边中的数在整个数组中的数量，
 * 如果大于的当前半边的值的话，那么这半边就有重复的数字。
 * @author DELL
 *
 */
public class DuplicateArrNoModify_02 {
	public static int getDupllicate(int[] A){
		if(null == A || A.length <= 1) return -1;
		int st = 1;
		int end = A.length-1;
		while(st <= end){
			int mid = st + (end - st) / 2;
			int count = countRange(A, st, mid);
			if(st == end){
				if(count > 1)
					return st;
				else
					break;
			}
			if(count > (mid - st + 1))
				end = mid;
			else
				st = mid+1;
		}
		return -1;
	}
	
	public static int countRange(int[] A, int st, int end){
		int count = 0;
		for(int i = 0; i<A.length; i++){
			if(A[i] >= st && A[i] <= end)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {2,3,5,4,3,2,6,7};
		int res = getDupllicate(A);
		System.out.println(res);
	}
}
