package searchandsort;

import java.util.Arrays;

public class FindKthLargest {
	public int findKthLargest(int[] nums, int k) {
        if(null == nums || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
	public int findKthLargest1(int[] nums, int k){
		return quickSort(nums, 0, nums.length-1, k);
	}
	public int quickSort(int[] nums, int left, int right, int k){
		if(left >= right)
			return nums[left];
		int cur = nums[left];
		int i = left;
		int j = right;
		while(left <= right){
			while(left <= right && nums[right] > cur) right--;
			while(left <= right && nums[left] < cur) left++;
			if(left <= right){
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
				left++;
				right--;
			}
		}
		nums[i] = nums[left];
		nums[left] = cur;
		if((nums.length-k) == left )
			return nums[left];
		if((nums.length-k) < left)
			return quickSort(nums, i,  left-1, k);
		else
			return quickSort(nums, left+1, j, k);
	}
	
	public void quickSort1(int[] nums, int left, int right){
		if(left > right)
			return;
		int cur = nums[left];
		int i = left;
		int j = right;
		while(left < right){
			while(left < right && nums[right] >= cur) right--;
			while(left < right && nums[left] <= cur) left++;
			if(left < right){
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
			}
		}
		nums[i] = nums[left];
		nums[left] = cur;
		quickSort1(nums, i,  left-1);
		quickSort1(nums, left+1, j);
	}
	
	public int quickSort2(int[] nums, int left, int right){
		int pivot = nums[left], l = left+1, r = right;
		while(l <= r){
			if(nums[l] < pivot && nums[r] > pivot){
				swap(nums, l, r);
			}
			if(nums[l] >= pivot) ++l;
			if(nums[r] <= pivot) --r;
		}
		swap(nums, left, r);
		return r;
	}
	public void swap(int[] nums, int l, int r){
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
	
	public int findKeht(int[] nums, int k){
		int left = 0, right = nums.length - 1;
		while(true){
			int pos = quickSort2(nums, left, right);
			if(pos == k-1) return nums[pos];
			else if (pos > k-1 ) right = pos - 1;
			else left = pos + 1;
		}
	}
	
	
	public static void main(String[] args) {
		FindKthLargest f = new FindKthLargest();
		int[] nums = {3,2,1,5,6,4};
//		f.quickSort1(nums, 0, nums.length-1);
//		for(int n : nums)
//			System.out.print(n + ", ");
		int i = f.findKeht(nums, 1);
		System.out.println(i);
	}
}
