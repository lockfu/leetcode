package chap02;

public class BitCount {
	public static int countBit(int n){
		int count = 0;
		while(n != 0){
			++count;
			n = (n-1) & n;
		}
		return count;
	}
	
	public static int countBit_bit(int n){
		int count = 0;
		while(n != 0){
			count += n & 1;
			n >>= 1;
		}
		return count;
	}
	
	public static int countBit_divided(int n){
		int count = 0;
		while(n != 0){
			if(n % 2 == 1)
				count++;
			n >>= 1;
		}
		return count;
	}
	
	// 查表法： 将各个数字的1的位数存在数组中。可以在O(1)的时间查询出来
	
	public static void main(String[] args) {
//		int res = countBit(8);
//		System.out.println(res);
		
		double res = fib(15);
		System.out.println(res);
		
	}
	
	public static double fib(int n){
		double sum = 1;
		for(int i = 1; i<=n; i++){
			sum *= i;
		}
		return sum;
	}
}
