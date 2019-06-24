package dynamic;

import java.sql.SQLTimeoutException;
import java.util.Set;

public class MaxProfit {
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		int minPrice = prices[0];
		int max = 0;
		for(int i = 1; i<prices.length; i++){
			if(prices[i] - minPrice > max){
				max = prices[i] - minPrice;
			}
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
		}
		return max;
    }
	
	public static void main(String[] args) {
		int[] prices = {2,4,1};
		int res = MaxProfit.maxProfit(prices);
		System.out.println(res);
	}
}
