package chap04;

public class IsPostOrder {
	public static boolean isPostOrder(int[] A){
		if(null == A || A.length <= 0) return false;
		return isPost(A, 0, A.length-1);
	}
	
	public static boolean isPost(int[] A, int st, int end){
		if(st == end) return true;
		int rootval = A[end];
		int i = st;
		for(; i<end; i++){
			if(A[i] > rootval)
				break;
		}
		for(int l = st; l<i; l++){
			if(A[l] > rootval)
				return false;
		}
		for(int r = i; r<end; r++){
			if(A[r] < rootval)
				return false;
		}
		boolean left = true;
		if(i>st)
			left = isPost(A, st, i-1);
		boolean right = true;
		if(i < end-1)
			right = isPost(A, i, end-1);
		return left && right;
	}
	
	public static void main(String[] args) {
//		int[] A = {5,7,6,9,11,10,8};
		int[] A = {7,4,6,5};
		boolean res = isPostOrder(A);
		System.out.println(res);
	}
}
