package dy;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if(null == coins || coins.length <= 0)
            return -1;
        int[] dp = new int[amount+1];
        for(int i = 1; i<dp.length; i++){
            dp[i] = amount+1;
        }
        for(int i = 1; i<dp.length; i++){
            for(int j = 0; j<coins.length; j++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
	
	public int coinChange1(int[] coins, int amount) {
		if(null == coins || coins.length <= 0)
            return -1;
		int[] mem = new int[amount+1];
		for(int i = 1; i<mem.length; i++){
			mem[i] = Integer.MAX_VALUE;
        }
		return coinDfs(coins, amount, mem);
	}
	public int coinDfs(int[] coins, int amount, int[] mem){
		if(amount < 0) return -1;
		if(mem[amount] != Integer.MAX_VALUE) return mem[amount];
		for(int i = 0; i<coins.length; i++){
			int tmp = coinDfs(coins, amount - coins[i], mem);
			if(tmp >= 0) mem[amount] = Math.min(mem[amount], tmp+1);
		}
		return mem[amount] = (mem[amount] == Integer.MAX_VALUE) ? -1 : mem[amount];
	}
}
