package other;

import java.util.HashMap;
import java.util.Map;

public class Majority {
	public int majorityElement(int[] nums) {
		if(null == nums || nums.length <= 0)
			return -1;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;
		for(int n : nums){
			if(!map.containsKey(n)){
				map.put(n, 1);
			}else{
				int tmp = map.get(n)+1;
				if(tmp > max)
					max = tmp;
				map.put(n, map.get(n)+1);
			}
			if(max > nums.length / 2)
				return n;
		}
//		for(Map.Entry<Integer, Integer> item : map.entrySet()){
//			int key = item.getKey();
//			int val = item.getValue();
//			if(val > nums.length/2)
//				return key;
//		}
		return -1;
	}
	
	public int majorityElement1(int[] nums) {
		int major = nums[0];
		int count = 1;
		for(int i = 1; i<nums.length; i++){
			if(nums[i] == major){
				count++;
			}else if(count == 0){
				major = nums[i];
				count++;
			}else{
				count--;
			}
		}
		return major;
	}
	
	public int majorityElement2(int[] nums) {
		int major = 0;
		int count = 0;
		for(int n : nums){
			if(count == 0)
				major = n;
			count += (n == major) ? 1 : -1;
		}
		return major;
	}
}
