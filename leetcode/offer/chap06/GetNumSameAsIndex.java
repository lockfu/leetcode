package chap06;

public class GetNumSameAsIndex {
	public static int getNumSameAsIndex(int[] A){
		if(null == A || A.length <= 0) return -1;
		int st = 0, ed = A.length - 1;
		while(st <= ed){
			int mid = (st + ed) / 2;
			if(A[mid] == mid)
				return mid;
			else if(A[mid] > mid){
				ed = mid - 1;
			}else st = mid + 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {-3,-1,0,3,5,6};
		int res = getNumSameAsIndex(A);
		System.out.println(res);
	}
}
