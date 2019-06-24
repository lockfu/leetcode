package arrayandstring2;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class MaxSlidingWindow {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0)
			return new int[0];
		int[] res = new int[nums.length-k+1];
		int count = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<k; i++){
			if(nums[i] > max) max = nums[i];
		}
		res[count++] = max;
		for(int i = k; i<nums.length; i++){
			max = Integer.MIN_VALUE;
			for(int j = i-k+1; j<i+1; j++){
				if(nums[j] > max) max = nums[j];
			}
			res[count++] = max;
		}
		return res;
	}
	
	public int[] maxSlidingWindow1(int[] nums, int k) {
		if(nums.length == 0)
			return new int[0];
		int[] lmax = new int[nums.length];
		int[] rmax = new int[nums.length];
		int[] res = new int[nums.length-k+1];
		lmax[0] = nums[0];
		for(int i = 1; i<nums.length; i++){
			lmax[i] = (i%k == 0) ? nums[i] : Math.max(lmax[i-1], nums[i]);
		}
		rmax[nums.length-1] = nums[nums.length-1];
		for(int i = nums.length-2; i>=0; i--){
			rmax[i] = (i%k == 0) ? nums[i] : Math.max(rmax[i+1], nums[i]);
		}
		for(int i = 0; i+k <= nums.length; i++){
			res[i] = Math.max(rmax[i], lmax[i+k-1]);
		}
		return res;
	}
	
	public int[] maxSlidingWindow2(int[] nums, int k) {
		if(nums.length == 0)
			return new int[0];
		LinkedList<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length-k+1];
		for(int i = 0; i<nums.length; i++){
			if(!deque.isEmpty() && deque.peekFirst() == (i-k)) deque.poll();
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
			deque.offerLast(i);
			if((i+1) >= k) res[i-k+1] = nums[deque.peek()];
		}
		return res;
	}
	@Test
	public void test(){
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = maxSlidingWindow1(nums, k);
		System.out.println(Arrays.toString(res));
		
		
	}
}
