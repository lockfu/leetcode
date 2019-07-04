package other;

public class Xor {
	
	/**
	 * 不用+号， 将两个数相加
	 * @param a
	 * @param b
	 * @return
	 */
	public static int twoSum(int a, int b){
		int aTmp = 0, bTmp = 0;
		while(b != 0){
			aTmp = a ^ b;         // a + b
			bTmp = (a & b) << 1; // 进行进位
			a = aTmp;
			b = bTmp;
		}
		return a;
	}
	
	public static void swap(int a, int b){
		System.out.println("a: " + a + " b:" + b);
		a ^= b;   // a = a ^ b
		b ^= a;   // b = a ^ b ^ a 
		a ^= b;   // a = a ^ a ^ b ^ a ^ b
		System.out.println("a: " + a + " b:" + b);
	}
	
	/**
	 * a 转成 b 需要改变多少位
	 * @param a
	 * @param b
	 * @return
	 */
	public static int coverA2BInt(int a, int b){
		int n = a ^ b;
		int count = 0;
		while(n != 0){
			n = n & (n-1);
			count++;
		}
		return count;
	}
	
	public static int findOne(int[] A){
		int res = 0;
		for(int item : A){
			res ^= item;
		}
		return res;
	}
	
	/**
	 * 一个数组中只有一个数出现一次， 其它数都出现三次
	 * @param A
	 * @return
	 */
	public static int singleNumInTreeA(int[] A){
		int[] f = new int[32];
		for(int item : A){
			int bitmask = 1;
			for(int i = 31; i>=0; i--){
				int bit = item & bitmask;
				if(bit != 0)
					f[i] += 1;
				bitmask <<= 1;
			}
		}
		int res = 0;
		for(int i = 0; i<32; i++){
			res <<= 1;
			res += f[i] % 3;
		}
		return res;
	}
	
	public static int singleNumInTreeA2(int[] A){
		int ones = 0, twos = 0;
		for(int item : A){
			// 3n + 1
			ones = (item ^ ones) & (~twos);
			// 3n + 2
			twos = (item ^ twos) & (~ones);
		}
		return ones;
	}
	
	
	public static void singleNumInTwo(int[] A){
		int diff = 0;
		for(int item : A){
			diff ^= item;
		}
		diff &= -diff;
		int i1=0, i2=0;
		for(int item : A){
			if((diff & item) == 0)
				i1 ^= item;
			else
				i2 ^= item;
		}
		System.out.println("i1: " + i1 + " i2: " + i2);
	}
	
	
	public static void main(String[] args) {
		int a = 2, b = 3;
//		int res = twoSum(a, b);
//		System.out.println(res);
//		swap(a, b);
		
//		int[] A = {2,2,2,7,3,3,3,4,4,4,5,5,5};
//		int res = singleNumInTreeA(A);
//		System.out.println(res);
		
//		String bstr = Integer.toBinaryString(-2);
//		System.out.println(bstr);
		int[] A = {2,2,3,4,5,6,5,6,3,7};
		singleNumInTwo(A);
		
	}
}
