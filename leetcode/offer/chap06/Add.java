package chap06;

public class Add {
	public static int add(int a, int b){
		int sum = 0, carry = 0;
		while(b != 0){
			sum = a ^ b;
			carry = (a & b) << 1;
			a = sum;
			b = carry;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int res = add(2,-3);
		System.out.println(res);
	}
}
