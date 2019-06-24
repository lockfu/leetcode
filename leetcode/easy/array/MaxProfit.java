package array;

import java.util.Arrays;

public class MaxProfit {
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1)
			return 0;
		int buy = -1;
		int maxProfix = 0;
		for(int i = 0; i<prices.length-1;){
			if(prices[i] < prices[i+1]){
				buy = i;
			}else{
				i++;
				continue;
			}
			if(buy == -1)
				return maxProfix;
			for(int j = buy+1; j<prices.length; j++){
				if(j == (prices.length-1)){ // 最后一次
					maxProfix += (prices[j] - prices[buy]);
					i = j;
					break;
				}
				if(prices[j+1] < prices[j]){
					int tmp = prices[j] - prices[buy];
					maxProfix += tmp;
					i = (j+1);
					break;
				}
			}
		}
		return maxProfix;
	}
	
	public static int maxProfit2(int[] prices) {
		int profit = 0;
		int i = 0;
		while(i<prices.length-1){
			while(i<prices.length-1 && prices[i] >= prices[i+1]) i++;
			int buyPrice = prices[i];
			while(i<prices.length-1 && prices[i+1] >= prices[i]) i++;
			profit += prices[i] - buyPrice;
		}
		return profit;
	}
	public int maxProfit4(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
	
	public static int maxProfit3(int[] prices) {
		return maxProfitRec(prices,0);
	}
	private static int maxProfitRec(int[] prices, int start){
		int last = prices.length - 1;
		while((start < last) && (prices[start] >= prices[start+1])){
			start++; // 买入
		}
		int end = start;
		while((end < last) && (prices[end] < prices[end+1])){
			end++;
		}
		if(start == end)
			return 0;
		int profit = prices[end] - prices[start];
		return profit + maxProfitRec(prices, end);
	}
	
	
	public static void main(String[] args) {
//		int[] nums = {7,1,5,3,6,4};
//		int[] nums = {1,2,3,4,5};
		int[] nums = {7,6,5,4,3,2,1};
		int max = MaxProfit.maxProfit(nums);
		System.out.println(max);
	}
}
