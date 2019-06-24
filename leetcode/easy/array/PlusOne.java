package array;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0)
			return digits;
		for(int i = digits.length -1; i>=0; i--){
			int cur = digits[i];
			if(cur < 9){
				digits[i] = cur+1;
				return digits;
			}else{
				digits[i] = 0;
				if(i==0){
					int[] tmp = new int[digits.length+1];
					tmp[0] = 1;
					for(int j = 0; j<digits.length; j++){
						tmp[j+1] = digits[j];
					}
					return tmp;
				}
			}
		}
		return digits;
	}
}
