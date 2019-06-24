package top100;

import java.util.Stack;

public class TrapRainWater {
	public static boolean trap = false;
	public static boolean endbool = false;
	public int trap(int[] height) {
		if(null == height || height.length <= 2)
			return 0;
		int start = 0, end = 1;
		int sum = 0;
		while(end < height.length){
			if(height[end] >= height[start]){
				sum += caculate(height,start, end);
				start = end;
				end++;
			}else{
				if(trap && (height[end] < height[end-1] )){
					sum += caculate(height,start, end-1);
					start=end-1;
				}else{
					if((end - start > 1) &&(height[end] < height[end-1])){
						trap = true;
					}
				}
				end++;
			}
		}
		if(!endbool){
			sum += caculate(height,start,height.length-1);
		}
		return sum;
	}
	public int caculate(int[] A, int start,int end){
		if(end >= A.length-1)
			endbool = true;
		trap = false;
		if(end - start <= 1)
			return 0;
		int res = 0;
		int hi = A[start] > A[end] ? A[end] : A[start];
		for(int i = start+1; i<= end; i++){
			if(A[i] < hi){
				res += hi-A[i];
			}
		}
//		System.out.println(start + " : " + end);
		return res;
	}
	
	
	
	
	
	
	
	
	// burte force
	public int trap_brute(int[] height){
		if(null == height || height.length <= 2)
			return 0;
		int ans = 0;
		int size = height.length;
		for(int i = 1; i<size - 1; i++){
			int max_left = 0, max_right = 0;
			for(int j = i; j>=0; j--){
				max_left = Math.max(max_left, height[j]);
			}
			for(int j = i; j<size; j++){
				max_right = Math.max(max_right, height[j]);
			}
			ans += Math.min(max_left, max_right)-height[i];
		}
		return ans;
	}
	
	// dy
	public int trap_dy(int[] height){
		if(null == height || height.length <= 2)
			return 0;
		int ans = 0;
		int size = height.length;
		int[] left_max = new int[size];
		int[] right_max = new int[size];
		left_max[0] = height[0];
		for(int i = 1; i<size; i++){
			left_max[i] = Math.max(left_max[i-1], height[i]);
		}
		right_max[size-1] = height[size-1];
		for(int i = size - 2; i>= 0; i--){
			right_max[i] = Math.max(right_max[i+1], height[i]);
		}
		for(int i = 1; i<size; i++){
			ans += Math.min(left_max[i], right_max[i]) - height[i];
		}
		return ans;
	}
	
	// two points
	public int trap_twopoints(int[] height){
		if(null == height || height.length <= 2)
			return 0;
		int res = 0;
		int l=0, r = height.length-1;
		while(l<r){
			int mn = Math.min(height[l], height[r]);
			if(height[l] == mn){
				++l;
				while(l<r && height[l]<mn)
					res += mn - height[l++];
			}else{
				--r;
				while(l<r && height[r] < mn)
					res += mn - height[r--];
			}
		}
		return res;
	}
	
	public int trap_twopoints2(int[] height){
		if(null == height || height.length <= 2)
			return 0;
		int res = 0;
		int l=0, r = height.length-1, level = 0;
		while(l<r){
			int lower = height[(height[l] < height[r]) ? l++ : r--];
			level = Math.max(level,lower);
			res += level - lower;
		}
		return res;
	}
	
	public int trap_stack(int[] height){
		if(null == height || height.length <= 2)
			return 0;
		Stack<Integer> s = new Stack<>();
		int res = 0;
		int i = 0, n = height.length;
		while(i<n){
			if(s.isEmpty() || height[i] <= height[s.peek()])
				s.push(i++);
			else{
				int t = s.pop();
				if(s.isEmpty()) continue;
				res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i-s.peek()-1);
			}
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		TrapRainWater t = new TrapRainWater();
		int[] height = {4,2,3};
		int res = t.trap_dy(height);
		System.out.println(res);
	}
}
