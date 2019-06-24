package array;

import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length < 2)
			return false;
		Set<Integer> set = new HashSet<>();
		for(int i : nums){
			set.add(i);
		}
		System.out.println("set: " + set.size());
		if(set.size() == nums.length)
			return false;
		return true;
	}
	public static boolean containsDuplicate1(int[] nums) {
		if(nums == null || nums.length < 2)
			return false;
		for(int i = 1; i<nums.length; i++){
			for(int j = i-1; j>=0; j--){
				if(nums[i] > nums[j]) break;
				if(nums[i] == nums[j]) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		ContainsDuplicate.containsDuplicate(nums);
	}
}
