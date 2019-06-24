package dynamic;

import java.util.Scanner;

public class MaxSubArr {
	public static int maxSub(int[] nums){
		if(null == nums || nums.length == 0)
			return -1;
		int max = nums[0];
		int sum = nums[0];
		for(int i = 1; i<nums.length; i++){
			if((sum + nums[i]) < sum && (sum + nums[i]) < 0)
				sum = 0;
			else{
				sum = sum + nums[i];
				if(sum > max)
					max = sum;
			}
		}
		return max;
	}
	
	public static int maxSub_1(int[] nums){
		if(null == nums || nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i<nums.length; i++){
			sum += nums[i];
			max = max > sum ? max : sum;
			sum = sum > 0 ? sum : 0;
		}
		return max;
	}
	public static int maxSub_dp(int[] nums){
		if(null == nums || nums.length == 0)
			return 0;
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = dp[0];
		for(int i = 1; i<n; i++){
			dp[i] = (dp[i-1] > 0 ? dp[i-1] : 0) + nums[i];
			max = dp[i] > max ? dp[i] : max;
		}
		return max;
	}
	public static void solve(int[] nums){
		int n = nums.length;
		int pain = n % 2 == 0 ? n/2 : n/2 + 1;
		int max = 0;
		for(int i = 0; i<pain; i++){
			max += nums[i];
		}
		int pre = nums[0];
		int tmp = max;
		for(int i = 1; i<n-1; i++){
			int ppain = i+pain-1;
			if(ppain > n-1)
				break;
			tmp = tmp - pre + nums[ppain];
			pre = nums[i];
			max = max > tmp ? max : tmp;
		}
		System.out.println(max);
	}
	public static void solve2(int t, int n, String s){
		for(int i=0;i<t;i++)
		{
			long l[]=new long[n];
			int l1=(n+1)/2;
		long sum=0;
		for(int j=0;j<n;j++)
			{l[j]=Character.getNumericValue(s.charAt(j));
				if(j<l1)
				sum=sum +l[j];}
			
			long tem=sum;
//			Character.getNumericValue(s.charAt(i));
			for(int j=l1;j<n;j++)
				 {tem = tem + l[j] - l[j-l1];
				sum=(sum>=tem)?sum:tem; }
			System.out.println("Case #"+(i+1)+": "+sum);
			
		}
	}
	
	public static void solve1(int[] nums){
		int n = nums.length;
		int pain = (n+1)/2;
		int max = 0;
		for(int i = 0; i<pain-1; i++){
			max += nums[i];
		}
		int ans = 0;
		for(int i = 0; i+pain<=n; i++){
			max += nums[i+pain-1];
			ans = Math.max(max,ans);
			max -= nums[i];
//			System.out.println("max: " + max);
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int[] nums = {1,3,3,2,2,5,7,6,4,5,8};
		solve1(nums);
		solve(nums);
		solve2(1, 11, "13322576458");
		System.out.println(Math.pow(10, 16)+"");
		System.out.println( Long.MAX_VALUE - Math.pow(10, 16));
	}
}
