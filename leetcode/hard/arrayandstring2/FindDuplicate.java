package arrayandstring2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int n : nums){
			if(!set.add(n))
				return n;
		}
		return -1;
	}
	
	public int findDuplicate1(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
		int p1 = nums[0];
		int p2 = slow;
		while(p1 != p2){
			p1 = nums[p1];
			p2 = nums[p2];
		}
		return p1;
	}
	 public int findDuplicate2(int[] nums) {
	        for (int i = 0; i < nums.length; i++) {
	            int temp = Math.abs(nums[i]);
	            if(nums[temp-1]<0)
	                return temp;
	            else{
	                nums[temp-1] = -nums[temp-1];
	            }
	        }

	        return -1;
	    }
	
	@Test
	public void test(){
		int[] nums = {1,4,6,6,6,2,3};
		findDuplicate1(nums);
	}
	
}
