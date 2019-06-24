package arrayANDstring;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target){
		if(null == nums || nums.length <= 0)
			return -1;
		int lo = 0, hi = nums.length-1;
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			if(nums[mid] == target)
				return mid;
			if(target > nums[nums.length-1]){
				if(nums[mid] < nums[nums.length-1] || nums[mid] > target)
					hi = mid -1;
				else
					lo = mid + 1;
			}else{
				if(nums[mid] > nums[nums.length-1] || nums[mid] < target)
					lo = mid + 1;
				else
					hi = mid-1;
			}
		}
		return -1;
	}
}
