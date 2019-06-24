package dy;

public class LenOfLIS {
	public static int lengthOfLIS(int[] nums) {
		if(null == nums || nums.length <= 0)
			return 0;
		int max = 1;
		int[] dp = new int[nums.length];
		dp[nums.length-1] = 1;
		for(int i = nums.length-2; i>=0; i--){
			int inmax = 0;
			for(int j = i+1; j<nums.length; j++){
				if(nums[i] < nums[j]){
					inmax = Math.max(dp[j], inmax);
				}
			}
			dp[i] = inmax+1;
			max = Math.max(dp[i], max);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] nums = {2,2};
		int res = lengthOfLIS( nums);
		System.out.println(res);
	}
}
