package dy;

public class canJump {
	public boolean canJump(int[] nums) {
		if(null == nums || nums.length == 0)
			return true;
        int reach = 0;
        for(int i = 0; i<=reach && i<nums.length; i++){
        	reach = Math.max(nums[i]+i, reach);
        }
        return reach < nums.length - 1 ? false : true;
    }
}
