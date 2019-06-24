package array;

public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		int index = 0;
		int n = nums.length;
		for(int i = 1; i<nums.length; ){
			if(nums[i] == Integer.MIN_VALUE)
				break;
			if(nums[index] == nums[i]){
				for(int j = i; j<nums.length-1; j++){
					nums[j] = nums[j+1];
				}
				nums[n-1] = Integer.MIN_VALUE;
			}else{
				index++;
				i++;
			}
		}
		return index+1;
	}
	public static int removeDuplicates1(int[] nums) {
		if(nums == null || nums.length ==0)
			return 0;
		int index = 0;
		for(int i = 1; i<nums.length; i++){
			if(nums[i] == nums[i-1]){
				continue;
			}else{
				nums[index+1] = nums[i];
				index++;
			}
		}
		return index+1;
	}
	
	public static int removeDuplicate2(int[] nums){
		if(null == nums || nums.length == 0) return 0;
		int i = 0;
		for(int j = 1; j<nums.length; j++){
			if(nums[j] != nums[i]){
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,0,0,1,1,1,1,2,2,3,3,4,4,5,6,7,7,7,8,8};
		int res = removeDuplicates1(nums);
		System.out.println(res);
		for(int num : nums){
			System.out.print(num + " , ");
		}
	}
}
