package chap06;

public class FindTwoSums {
	/**
	 * 在排序的数组中找到两个数和为s的值
	 */
	public static void findOrderedTwoSum(int[] A, int s){
		if(null == A || A.length <= 1) return;
		int n = A.length;
		int st = 0, ed = n-1;
		while(st < ed){
			int cursum = A[st] + A[ed];
			if(cursum == s){
				System.out.println("st: " + A[st] + " ed: " + A[ed]);
				return;
			}else if(cursum < s){
				st++;
			}else{
				ed--;
			}
		}
	}
	
	public static void findSequenceNumSum(int s){
		if(s < 3) return;
		int st = 1, ed = 2, mid = (1 + s ) / 2;
		int cursum = st + ed;
		while(st < mid){
			if(cursum == s){
				printSequence(st, ed);
			}
			while(cursum > s && st < mid){
				cursum -= st;
				st++;
				if(cursum == s)
					printSequence(st, ed);
			}
			ed++;
			cursum += ed;
		}
	}
	public static void printSequence(int st, int ed){
		for(int i = st; i<=ed; i++){
			System.out.print(i + ",");
		}
		System.out.println();
	}
	public static void main(String[] args) {
//		int[] A = {1,2,4,7,11,15};
//		findOrderedTwoSum(A, 11);
		
		findSequenceNumSum(18);
	}
}
