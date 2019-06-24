package arrayANDstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length < 3)
			return res;
		if(nums.length == 3){
			if((nums[0] + nums[1] + nums[2]) == 0){
				List<Integer> list = new ArrayList<>();
				list.add(nums[0]);
				list.add(nums[1]);
				list.add(nums[2]);
				res.add(list);
				return res;
			}
		}
		Set<String> strList = new HashSet<>();
		for(int i = 0; i<nums.length-1; i++){
			for(int j = i+1; j<nums.length; j++){
				int tSum = nums[i]+nums[j];
				int c = -tSum;
				for(int k = 0; k<nums.length; k++){
					if(k == i || k == j || nums[k] != c)
						continue;
					else{
						int[] tmpA = {nums[i],nums[j],nums[k]};
						Arrays.sort(tmpA);
						String s = tmpA[0]+","+tmpA[1]+","+tmpA[2];
						strList.add(s);
						break;
					}
				}
			}
		}
		for(String s : strList){
			List<Integer> tmp = new ArrayList<>();
			String[] ss = s.split(",");
			tmp.add(Integer.parseInt(ss[0]));
			tmp.add(Integer.parseInt(ss[1]));
			tmp.add(Integer.parseInt(ss[2]));
			res.add(tmp);
		}
		return res;
	}
	
	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length < 3)
			return res;
		Arrays.sort(nums);
		for(int i = 0; i<nums.length-2; i++){
			if(i == 0 || (i>0 && nums[i] != nums[i-1])){
				int lo = i+1, hi = nums.length-1, sum = -nums[i];
				while(lo < hi){
					if((nums[lo] + nums[hi]) == sum){
						res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
						while((lo < hi) && (nums[lo] == nums[lo+1])) lo++; 
						while((lo < hi) && (nums[hi] == nums[hi-1])) hi--;
						lo++;
						hi--;
					}else if((nums[lo] + nums[hi]) < sum) lo++;
					else hi--;
				}
			}
		}
		return res;
	}
	
	@Test
	public void test(){
		int[] nums = {0,0,0,0};
		
		List<List<Integer>> res = ThreeSum.threeSum(nums);
		
		System.out.println(res);
	}
}
