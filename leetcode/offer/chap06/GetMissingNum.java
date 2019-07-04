package chap06;

public class GetMissingNum {
	// A: 0-n-1,   
	public static int getMissingNum(int[] A){
		if(null == A || A.length <= 0) return 0;
		int st = 0, ed = A.length-1;
		while(st <= ed){
			int mid = (st + ed) / 2;
			if(A[mid] == mid)
				st = mid + 1;
			else{
				if(mid == 0 || A[mid-1] == mid - 1)
					return mid;
				ed = mid - 1;
			}
		}
		if(st == A.length)
			return A.length;
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {0,2,3,4};
		int res = getMissingNum(A);
		System.out.println(res);
	}
}
