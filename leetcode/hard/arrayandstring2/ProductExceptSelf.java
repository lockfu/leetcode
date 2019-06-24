package arrayandstring2;

import java.util.Arrays;

public class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int sum = 1;
		int count = 0;
		for(int n : nums){
			if(n==0){
				count++;
				continue;
			}
			sum *=n;
		}
		if(count > 1){  // �����а�������������ģ� ��ô���鴦���ȫ����
			Arrays.fill(nums, 0);
			return nums;
		}
		for(int i = 0; i<nums.length; i++){
			if(count == 1){
				if(nums[i] == 0)
					nums[i] = sum;
				else
					nums[i] = 0;
			}else{
				nums[i] = sum / nums[i];
			}
		}
		return nums;
	}
//	public int[] productExceptSelf1(int[] nums) {
//		int[] res = new int[nums.length];
//		int count = 0;
//		for(int i = 0; i<){
//			
//		}
//	}
}
