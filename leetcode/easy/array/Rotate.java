package array;

public class Rotate {
	public static void rotate(int[] nums, int k) {
		for(int i = 1; i<=k; i++){
			int temp = nums[nums.length-1];
			for(int j = nums.length-1; j>0; j--){
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
		}
	}
	public static void rotate1(int[] nums, int k) {
		k %= nums.length;
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
	}
	private static void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};
		Rotate.rotate1(nums, 3);
		
		for(int i : nums){
			System.out.print(i + ", ");
		}
	}
}
