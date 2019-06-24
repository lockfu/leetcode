package arrayANDstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foursum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == nums || nums.length <= 0) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n-3; i++){
        	if(i>0 && nums[i] == nums[i-1]) continue;
        	for(int j = i+1; j<n-2; j++){
        		if(j > i+1 && nums[j] == nums[j-1]) continue;
        		int lo = j+1, hi = n - 1;
        		while(lo < hi){
        			int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
        			if(sum == target){
        				res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
        				while((lo < hi) && (nums[lo] == nums[lo+1])) lo++;
        				while((lo < hi) && (nums[hi] == nums[hi-1])) hi--;
        				lo++;hi--;
        			}else if(sum < target) lo++;
        			else hi--;
        		}
        	}
        }
        return res;
    }
    
    public void tree(int[] nums,  int target){
    	Arrays.sort(nums);
    	for(int i = 0; i<nums.length-2; i++){
    		if(i==0 || (i>0&&nums[i]!=nums[i-1])){
    			int lo = i+1, hi = nums.length-1, sum = target-nums[i];
    			while(lo < hi){
    				if((nums[lo] + nums[hi]) == sum){
    					System.out.println();
    					while((lo<hi) && (nums[lo] == nums[lo+1]))lo++;
    					while((lo<hi) && (nums[hi] == nums[hi-1]))hi--;
    					lo++;
    					hi--;
    				}else if((nums[lo] + nums[hi]) < sum)lo++;
    				else hi--;
    			}
    		}
    	}
    }
    public static void main(String[] args) {
//    	Foursum fs = new Foursum();
//    	int[] nums = {1, 0, -1, 0, -2, 2};
//    	fs.fourSum(nums, 0);
    	
    	
	}
}
