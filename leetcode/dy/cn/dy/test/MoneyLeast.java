package cn.dy.test;

public class MoneyLeast {
	public int solution(int[] ms, int tar){
		int[] dp = new int[tar+1];
		dp[0] = 0;
		for(int i = 1; i<dp.length; i++){
			dp[i] = tar+1;
		}
		for(int i = 1; i<= tar; i++){
			for(int j = 0; j<ms.length; j++){
				if(ms[j] <= i){
					dp[i] = Math.min(dp[i], dp[i-ms[j]]+1);
				}
			}
		}
		return dp[tar] > tar ? -1 : dp[tar];
	}
	
	public int solution1(int[] ms, int tar){
		int[] dp = new int[tar+1];
		dp[0] = 0;
		for(int i = 1; i<dp.length; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		return coinChangeDFS(ms, tar, dp);
	}
	private int coinChangeDFS(int[] conis, int target, int[] dp){
		if(target < 0) return -1;
		if(dp[target] != Integer.MAX_VALUE) return dp[target];
		for(int i = 0; i<conis.length; i++){
			int tmp = coinChangeDFS(conis, (target-conis[i]), dp);
			if(tmp >= 0) dp[target] = Math.max(dp[target], tmp+1);
		}
		return dp[target] = (dp[target] == Integer.MAX_VALUE) ? -1 : dp[target];
	}
}
