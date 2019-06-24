package searchandsort;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if(null == nums || nums.length == 0){
			return -1;
		}
		if(nums.length == 1)
			return 0;
		int pre = Integer.MIN_VALUE;
		for(int i = 0; i<nums.length; i++){
			int cur = nums[i];
			int nxt = 0;
			if(i+1 >= nums.length)
				nxt = Integer.MIN_VALUE;
			else
				nxt = nums[i+1];
			if(cur > pre && cur > nxt)
				return i;
			pre = nums[i];
		}
		return -1;
	}
	public int findPeakElement1(int[] nums) {
		for(int i = 0; i<nums.length-1; i++){
			if(nums[i] > nums[i+1])
				return i;
		}
		return nums.length - 1;
	}
	public int findPeakElement2(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}
	public int search(int[] nums, int l, int r){
		if(l == r)
			return l;
		int mid = (l+r)/2;
		if(nums[mid] > nums[mid+1])
			return search(nums, 1, mid);
		return search(nums, mid + 1, r);
	}
	public static void main(String[] args) {
		FindPeakElement f = new FindPeakElement();
		int[] nums = {1,1,2,1};
		int res = f.findPeakElement(nums);
		System.out.println(res);
	}
}
