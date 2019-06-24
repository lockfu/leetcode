package array;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length <=1)
			return;
		int countZeros = 0;
		for(int i : nums){
			if(i==0)
				countZeros++;
		}
		for(int i = 0; i<nums.length;){
			if(nums[i]==0){
				for(int j = i; j<nums.length-1;j++){
					nums[j] = nums[j+1];
				}
				nums[nums.length-1] = 0;
				countZeros--;
				if(countZeros == 0)
					break;
			}else{
				i++;
			}
		}
	}
	
	public void moveZeroes1(int[] nums){
		int index = 0;
		for(int i : nums){
			if(i != 0){
				nums[index++] = i;
			}
		}
		while(index <nums.length){
			nums[index++]=0;
		}
	}
	
	public void moveZeroes2(int[] nums){
		for(int last = 0, cur = 0; cur<nums.length; cur++){
			if(nums[cur] != 0){
				int temp = nums[cur];
				nums[cur] = nums[last];
				nums[last] = temp;
				last++;
			}
		}
	}
	
}
