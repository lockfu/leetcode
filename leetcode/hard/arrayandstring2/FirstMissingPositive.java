package arrayandstring2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length ==0)
			return 1;
		List<Integer> list = new ArrayList<>();
		for(int i : nums){
			list.add(i);
		}
		for(int i = 1; i<=list.size(); i++){
			if(!list.contains(i))
				return i;
		}
		return list.size()+1;
	}
	@Test
	public void test(){
		int[] nums = {1};
		int res = firstMissingPositive(nums);
		System.out.println(res);
	}
}
