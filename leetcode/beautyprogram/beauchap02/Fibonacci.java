package beauchap02;

public class Fibonacci {
	public int fib(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		return fib(n-1)+fib(n-2);
	}
	public int fib_sp(int n, int[] A){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		if(A[n] != 0) return A[n];
		A[n] = fib_sp(n-1, A) + fib_sp(n-2, A);
		return A[n];
	}
	
	public int fib_in(int n){
		if(n <= 0) return 0;
		if(n <= 2) return 1;
		int pre = 1;
		int next = 1;
		int res = 0;
		for(int i = 3; i <= n; i++){
			res = pre + next;
			pre = next;
			next = res;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();
		int n = 8;
		int res = fb.fib(n);
		System.out.println("res " + res);
		
		int[] A = new int[n+1];
		A[0] = 0;
		A[1] = 1;
		A[2] = 1;
		int res2 = fb.fib_sp(n, A);
		System.out.println("res2 " + res2);
		
		int res3 = fb.fib_in(n);
		System.out.println("res3 " + res3);
		
	}
}
