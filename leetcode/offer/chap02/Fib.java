package chap02;

public class Fib {
	public static int fib_Re(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		return fib_Re(n-1) + fib_Re(n-2);
	}
	
	public static int fib(int n){
		if(n < 2) return n;
		int f_pre = 0;
		int f_nxt = 1;
		int f_n = 0;
		for(int i = 2; i<=n; i++){
			f_n = f_pre + f_nxt;
			f_pre = f_nxt;
			f_nxt = f_n;
		}
		return f_n;
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(fib_Re(n));
		System.out.println(fib(n));
	}
}
