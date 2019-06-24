package arrayandstring2;

public class MaxArea {
	public int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<height.length-1; i++){
			for(int j = i+1; j<height.length; j++){
				int tmp = (j-i)*Math.min(height[i], height[j]);
				if(tmp > max) max = tmp;
			}
		}
		return max;
	}
	
	public int maxArea2(int[] height) {
		int max = Integer.MIN_VALUE, l = 0, r = height.length - 1;
		while(l < r){
			max = Math.max(max, (r-l) * Math.min(height[l], height[r]));
			if(height[l] < height[r]) l++;
			else r--;
		}
		return max;
	}
	
	public int maxArea3(int[] height) {
		int max = Integer.MIN_VALUE, l = 0, r = height.length - 1, min;
		while(l < r){
			min = Math.min(height[l], height[r]);
			max = Math.max(max, (r-l) * min);
			while(height[l] <= min && l < r) l++;
			while(height[r] <= min && l < r) r--;
		}
		return max;
	}
}
