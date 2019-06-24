package math;

import java.util.HashSet;

public class HappyNum {
	private static HashSet<Integer> set = new HashSet<>();
	public static boolean isHappy(int n) {
		if(n == 0 || !set.add(n))
			return false;
		if(n == 1)
			return true;
		return isHappy(helper(n));
	}
	private static int helper(int n){
		int sum = 0;
		while(n!=0){
			int tmp = n%10;
			n = n / 10;
			sum = sum + (tmp * tmp);
		}
		System.out.print(sum + " , ");
		return sum;
	}
	
	public static boolean isHappy1(int n) {
		while(n!=1 && n!=4){
			int sum = 0;
			while(n!=0){
				sum += (n%10)*(n%10);
				n/=10;
			}
			n=sum;
		}
		return n == 1;
	}
	
	public static void main(String[] args) {
		int n = 1;
		boolean res = isHappy(n);
		System.out.println(res);
	}
}
