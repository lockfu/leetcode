package backtrace;

import java.util.ArrayList;
import java.util.List;

public class Permute {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(null == nums || nums.length <= 0) return res;
		helperNoreplicated(nums, res, 0, nums.length);
		return res;
	}
	public void helper(int[] nums, List<List<Integer>> res, int idx, int len){
		if(idx == len -1 ){
			List<Integer> list = new ArrayList<>();
			for(int ns : nums)
				list.add(ns);
			res.add(list);
			return ;
		}else{
			for(int i = idx; i<len; i++){
				swap(nums, idx, i);
				helper(nums, res, idx+1, len);
				swap(nums, idx, i);
			}
		}
	}
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private boolean isSwap(int[] nums, int begin, int end){
		for(int i = begin; i < end; i++){
			if(nums[i] == nums[end])
				return false;
		}
		return true;
	}
	
	public void helperNoreplicated(int[] nums, List<List<Integer>> res, int idx, int len){
		if(idx == len -1 ){
			List<Integer> list = new ArrayList<>();
			for(int ns : nums)
				list.add(ns);
			res.add(list);
			return ;
		}else{
			for(int i = idx; i<len; i++){
				if(isSwap(nums, idx, i)){
					swap(nums, idx, i);
					helper(nums, res, idx+1, len);
					swap(nums, idx, i);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Permute p = new Permute();
		int[] nums = {1,2,2};
		List<List<Integer>> res = p.permute(nums);
		System.out.println(res);
	}
}
