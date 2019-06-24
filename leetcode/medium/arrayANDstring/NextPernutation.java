package arrayANDstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextPernutation {
	 public void nextPermutation(int[] nums) {
		 if(null == nums || nums.length <= 1) return;
	        int n = nums.length;
	        boolean flag = false;
	        for(int nx = n-1; nx >= 1; nx--){
	        	for(int f = nx - 1; f >=0; f--){
	        		if((nums[f]+"").compareTo(nums[nx]+"") < 0){
	                    int tmp = nums[f];
	                    nums[f] = nums[nx];
	                    nums[nx] = tmp;
	                    reverse(nums,f+1);
	                    flag = true;
	                    break;
	                }
	        	}
	            if(flag)
	                break;
	        }
	        if(!flag)
	        	reverse(nums,0);
	}
	 public void reverse(int[] nums, int st){
		 int l = st, r = nums.length-1;
		 while(l <= r){
			 int tmp = nums[l];
			 nums[l] = nums[r];
			 nums[r] = tmp;
			 l++;r--;
		 }
	 }
	public static void main(String[] args) {
		NextPernutation nx = new NextPernutation();
		int[] nums = {4,2,0,2,3,2,0};
		nx.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		
//		System.out.println("1".compareTo("3"));
		
	}
}
