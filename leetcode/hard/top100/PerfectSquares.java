package top100;

import java.util.Arrays;

public class PerfectSquares {
	/**
	 * 四平方和定理：
	 * 根据四平方和定理，任意一个正整数均可表示为4个整数的平方和，其实是可以表示为4个以内的平方数之和，那么就是说返回结果只有1,2,3或4其中的一个
	 * 由于一个数如果含有因子4，那么我们可以把4都去掉，并不影响结果
	 * 如果一个数除以8余7的话，那么肯定是由4个完全平方数组成
	 * @param n
	 * @return
	 */
	public int numSquares(int n) {
		while(n % 4 == 0) n = n/4;
		if(n % 8 == 7) return 4;
		for(int a = 0; a*a <= n; ++a){
			int b = (int) Math.sqrt(n-a*a);
			if((a*a + b*b) == n){
				if(a!=0 && b != 0)
					return 2;
				else
					return 1;
			}
		}
        return 3;
    }
	
	
	public int numSquares_dp(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, n+1);
		dp[0] = 0;
		for(int i = 0; i<=n; i++){
			for(int j = 1; i+j*j <= n; j++){
				dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
			}
		}
		return dp[n];
    }
}
