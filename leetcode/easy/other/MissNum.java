package other;

public class MissNum {
	public int missingNumber(int[] nums) {
		if(null == nums || nums.length <= 0)
			return -1;
		int[] dp = new int[nums.length+1];
		for(int i = 0; i<dp.length; i++){
			dp[i] = -1;
		}
		for(int i : nums){
			dp[i] = 1;
		}
		for(int i = 0; i<dp.length; i++){
			if(dp[i] == -1)
				return i;
		}
		return -1;
	}
	
	public int missingNumber1(int[] nums) {
		int missing = nums.length;
		for(int i = 0; i<nums.length; i++){
			missing ^= i ^ nums[i];
		}
		return missing;
	}
	
	public int missingNumber2(int[] nums) {
		int len = nums.length;
		int exn = len*(len+1)/2;
		int sum = 0;
		for(int num : nums) sum += num;
		return exn - sum;
	}
}
