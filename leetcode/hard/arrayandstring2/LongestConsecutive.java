package arrayandstring2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class LongestConsecutive {
	public int longst(int[] nums){
		if(nums == null)
			return 0;
		if(nums.length == 0 || nums.length == 1)
			return nums.length;
		return longestC(nums,0);
	}
	public int longestC(int[] nums, int max) {
		if(nums.length == 0 || nums.length == 1)
			return nums.length;
		int min = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		for(int n : nums){
			if(n < min) min = n;
			set.add(n);
		}
		List<Integer> list = new LinkedList<>(set);
		int tmp = 0;
		int len = list.size();
		for(int i = min; i<min+len; i++){
			if(list.contains(i)){
				tmp++;
				list.remove((Integer)i);
			}
			else
				break;
		}
		max = Math.max(max, tmp);
		if(list.size() > tmp){
			int[] aa = new int[list.size()];
			int count = 0;
			for(int i : list)
				aa[count++] = i;
			return longestC(aa,  max);
		}else
			return max;
	}
	
	public int longestConsecutive(int[] nums){
		if(nums.length == 0 || nums.length == 1)
			return nums.length;
		Arrays.sort(nums);
		
		int tmp = 1;
		int max = 1;
		for(int i = 1; i<nums.length; i++){
			if(nums[i] != nums[i-1]){
				if(nums[i] == nums[i-1]+1){
					tmp++;
				}else{
					max = Math.max(max, tmp);
					tmp = 1;
				}
			}
		}
		return Math.max(max, tmp);
	}
	public int longestConsecutive1(int[] nums){
		Set<Integer> set = new HashSet<>();
		for(int n : nums){
			set.add(n);
		}
		int max = 0;
		for(int num : set){
			if(!set.contains(num-1)){
				int curNum = num;
				int tmp = 1;
				while(set.contains(curNum+1)){
					curNum += 1;
					tmp += 1;
				}
				max = Math.max(max, tmp);
			}
		}
		return max;
	}
	
	@Test
	public void test(){
		int[] nums = {1,2,100,200,300,3,4,5,6,11,12,13,14,15,16,17,18,19,20,21,22,23};
		int res = longestConsecutive(nums);
		System.out.println(res);
	}
}
