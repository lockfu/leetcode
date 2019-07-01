package chap05;

public class PrintMinNum {
	public static void printMinNum(int[] A){
		if(null == A || A.length <= 0) return;
		String s1 = A[0]+"";
		String s2 = "";
		for(int i = 1; i < A.length; i++){
			s2 = A[i]+"";
			int res = (s1+s2).compareTo(s2+s1);
			if(res > 0)
				s1 = s2+s1;
			else
				s1 = s1 + s2;
		}
		System.out.println(s1);
	}
	
	public static void main(String[] args) {
		int[] A = {15, 20, 5,2};
		printMinNum(A);
	}
}
