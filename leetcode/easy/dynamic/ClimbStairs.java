package dynamic;

public class ClimbStairs {
	public int climbStairs(int n) {
		// if(n<=2)
		// return n;
		// return climbStairs(n-1) + climbStairs(n-2);

		if (n <= 2)
			return n;
		int pre = 1;
		int nxt = 2;
		int sum = 0;
		for (int i = 3; i <= n; i++) {
			sum = pre + nxt;
			pre = nxt;
			nxt = sum;
		}
		return sum;
	}
}
