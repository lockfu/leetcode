package chap06;

public class FindNumsAppearOnce {
	public static int findOneNumAppearOne(int[] A){
		if(null == A || A.length <= 0) return -1;
		int res = A[0];
		for(int i = 1; i<A.length; i++){
			res ^= A[i];
		}
		return res;
	}
	
	public static int findTwoNumAppearOne(int[] A){
		if(null == A || A.length <= 0) return -1;
		int res = A[0];
		for(int i = 1; i<A.length; i++){
			res ^= A[i];
		}
		int index = findIndexOne(res);
		int i1 = 0, i2 = 0;
		for(int i = 0; i<A.length; i++){
			if(isBit(A[i], index)){
				i1 ^= A[i];
			}else{
				i2 ^= A[i];
			}
		}
		System.out.println("i1: " + i1 + " i2: " + i2);
		return res;
	}
	
	public static boolean isBit(int num, int index){
		num = num >> index;
		return (num & 1) == 1;
	}
	
	public static int findIndexOne(int num){
		int res = 0;
		while((num & 1) == 0){
			num = num >> 1;
			res++;
		}
		return res;
	}
	
	// -------------------------------
	// 数组中， 只有一个数字出现一次， 其它数字各出现三次
	public static int findThreeNumAppearOne(int[] A){
		if(null == A || A.length <= 4) return -1;
		int[] bitSum = new int[32];
		for(int item : A){
			int bitMask = 1;
			for(int j = 31; j>=0; j--){
				int bit = item & bitMask;
				if(bit != 0)
					bitSum[j] += 1;
				bitMask <<= 1;
			}
		}
		int result = 0;
		for(int i = 0; i<32; i++){
			result = result << 1;
			result += bitSum[i] % 3;
		}
		return result;
	}
	
	public static void main(String[] args) {
//		int res = findIndexOne(5);
//		System.out.println(res);
//		int[] A = {2,4,3,6,3,2,5,5};
//		findTwoNumAppearOne(A);
		int[] A = {2,2,2,7,3,3,3,4,4,4,5,5,5};
		int res = findThreeNumAppearOne(A);
		System.out.println(res);
	}
}
