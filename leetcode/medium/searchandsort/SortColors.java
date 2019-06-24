package searchandsort;

public class SortColors {
	 public void sortColors(int[] nums) {
	        if(null == nums || nums.length <= 1)
	            return;
	        int zindex = 0;
	        int sindex = nums.length - 1;
	        for(int i = 0; i<nums.length;){
	            int cur = nums[i];
	            if(cur == 0 && i != zindex){
	                nums[i] = nums[zindex];
	                nums[zindex++] = cur;
	            }else if(cur == 2 && sindex > i){
	                nums[i] = nums[sindex];
	                nums[sindex--] = cur;
	            }else{
	                i++;
	            }
	        }
	    }
}
