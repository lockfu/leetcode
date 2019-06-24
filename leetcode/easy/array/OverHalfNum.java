package array;

public class OverHalfNum {
	public static int overHalf(int[] A){
		if(A == null || A.length <= 0) return -1;
		int res = -1;
		for(int i = 0, tims = 0; i<A.length; i++){
			if(tims == 0){
				res = A[i];
				tims = 1;
			}else{
				if(res == A[i])
					tims++;
				else
					tims--;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] A = {2,4,1,4,5,6,7,4,4,4};
		int res = overHalf(A);
		System.out.println(res);
	}
}
