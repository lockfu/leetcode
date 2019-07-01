package chap05;

public class DigitAtIndex {
	public static int digitAtIndex(int index){
		if(index < 0 ) return -1;
		int digit = 1;
		while(true){
			int numbers = countOfIntegers(digit);
			if(index < numbers * digit)
				return digitIndex(index, digit);
			index -= numbers*digit;
			digit++;
		}
	}
	
	public static int countOfIntegers(int digit){
		if(digit == 1)
			return 10;
		return (int)(9 * Math.pow(10, digit-1));
	}
	
	public static int digitIndex(int index, int digit){
		int beginnum = (digit == 1) ? 0 : (int)Math.pow(10, digit-1);
		int num = beginnum + index / digit;  // 定位到当前数
		int indexr = digit - index % digit;
		for(int i = 1; i< indexr; i++)
			num /= 10;
		return num % 10;
	}
	
	public static void main(String[] args) {
		int res = digitAtIndex(11);
		System.out.println(res);
	}
}
