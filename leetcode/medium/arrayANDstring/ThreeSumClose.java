package arrayANDstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClose {
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 1000;
        for(int i = 0; i<nums.length - 2; i++){
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                int lo = i+1, hi = nums.length - 1, sum = target - nums[i];
                while(lo < hi){
                	int tmp = nums[lo] + nums[hi];
                    if(tmp == sum)
                        return tmp+nums[i];
                    else if(tmp < sum)
                        lo++;
                    else
                        hi--;
                    System.out.println(tmp+nums[i]);
                    min = Math.abs(min - target) > Math.abs(tmp+nums[i] - target) ? tmp+nums[i] : min;
                }
            }
        }
        return min;
    }
	
	
	
	
	
	
	
	public static int threeSumClosest2(int[] nums, int target) {
		int res = target;
		Arrays.sort(nums);
		int cha = 0;
		while(true){
			boolean find = false;
			if(cha == 0){
				find = tree(nums, target);
				if(find) break;
			}else{
				res = target + cha;
				find = tree(nums, res);
				if(find) break;
				res = target - cha;
				find = tree(nums, res);
				if(find) break;
			}
			cha++;
		}
		return res;
	}
	
	public static boolean tree(int[] nums, int target) {
		for(int i = 0; i<nums.length-2; i++){
			if(i == 0 || (i>0 && nums[i] != nums[i-1])){
				int lo = i+1, hi = nums.length-1, sum = target-nums[i];
				while(lo < hi){
					if((nums[lo] + nums[hi]) == sum){
						return true;
					}else if((nums[lo] + nums[hi]) < sum) lo++;
					else hi--;
				}
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = {-3,-2,-5,3,-4};
		int target = -1;
		int res = threeSumClosest( nums,  target);
		System.out.println(res);
	}
}
