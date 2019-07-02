package chap05;

public class UglyNum {
	public static int getUlgyNum(int index){
		if(index <= 0) return 0;
		int num = 0, count = 0;
		while(count < index){
			++num;
			if(isUlgy(num))
				count++;
		}
		return num;
	}
	public static boolean isUlgy(int num){
		while(num % 2 == 0) num /= 2;
		while(num % 3 == 0) num /= 3;
		while(num % 5 == 0) num /= 5;
		return num == 1;
	}
	
	public static int getUlgyNum2(int index){
		if(index <= 0) return 0;
		int[] ulgyNums = new int[index];
		ulgyNums[0] = 1;
		int u2 = 0, u3 = 0, u5 = 0, ulgynext = 1;
		while(ulgynext < index){
			int min = Math.min(Math.min(ulgyNums[u2] * 2, ulgyNums[u3] * 3), ulgyNums[u5] * 5);
			ulgyNums[ulgynext] = min;
			while(ulgyNums[u2] * 2 <= ulgyNums[ulgynext])
				u2++;
			while(ulgyNums[u3] * 3 <= ulgyNums[ulgynext])
				u3++;
			while(ulgyNums[u5] * 5 <= ulgyNums[ulgynext])
				u5++;
			ulgynext++;
		}
		return ulgyNums[index-1];
	}
	
	
	public static void main(String[] args) {
		int res  = getUlgyNum(10);
		int res2 = getUlgyNum2(10);
		System.out.println(res + "  " + res2);
		
	}
	
	
}
