package searchandsort;

public class SearchRotatedArr {
	public static int search(int[] nums, int target) {
		if(null == nums || nums.length <= 0)
			return -1;
		int lo = 0, hi = nums.length-1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(nums[mid] == target){
				return mid;
			}
			if(target > nums[nums.length - 1]){  // left
				if(nums[mid] < nums[nums.length-1])
					hi = mid - 1;
				else if(nums[mid] > target){
					hi = mid -1;
				}else
					lo = mid + 1;
			}else{
				if(nums[mid] > nums[nums.length-1])
					lo = mid + 1;
				else if(nums[mid] > target)
					hi = mid -1;
				else
					lo = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		
		int res = search(nums, 90);
		System.out.println(res);
	}
}
