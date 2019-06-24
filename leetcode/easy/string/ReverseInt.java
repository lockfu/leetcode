package string;

public class ReverseInt {
	public static int reverse(int x){
		if(x == 0)
			return x;
		double res = 0;
		while(x != 0){
			res = res * 10 + x % 10;
			x = x / 10;
		}
		
		return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int)res;
	}
	public static void main(String[] args) {
		System.out.println(ReverseInt.reverse(120));
	}
}
