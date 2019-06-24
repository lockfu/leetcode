package backtrace;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(null == nums || nums.length <= 0) return res;
		List<Integer> tmp = new ArrayList<>();
		res.add(tmp);
		
		List<List<Integer>> ress = new ArrayList<>();
		for(int i : nums){
			ress = new ArrayList<>(res);
			for(int j = 0; j<res.size(); j++){
				tmp = new ArrayList<>(res.get(j));
				tmp.add(i);
				ress.add(tmp);
			}
			res = ress;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = subsets(nums);
		System.out.println(res);
	}
}
