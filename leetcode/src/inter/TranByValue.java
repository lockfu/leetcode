package inter;

public class TranByValue {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		swap(num1, num2);
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
	}
	public static void swap(int a, int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
