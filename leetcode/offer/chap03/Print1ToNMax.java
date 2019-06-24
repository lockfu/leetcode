package chap03;

public class Print1ToNMax {
	public static void print1Tomax(int n){
		if(n < 1) return;
		char[] num = new char[n];
		for(int i = 0; i<num.length; i++)
			num[i] = '0';
		while(increment(num)){
			printNum(num);;
		}
	}
	
	public static void print1Tomax_q(int n){
		if(n < 1) return;
		char[] num = new char[n];
		for(int i = 0; i<num.length; i++)
			num[i] = '0';
		for(int i = 0; i<10; i++){
			num[0] = (char)(i+'0');
			printRecure(num, n, 0);
		}
	}
	public static void printRecure(char[] num, int n, int index){
		if(index == n-1){
			printNum(num);
			return;
		}
		for(int i = 0; i<10; i++){
			num[index+1] = (char)(i+'0');
			printRecure(num, n, index+1);
		}
	}
	
	public static boolean increment(char[] num){
		int over = 0;
		int len = num.length;
		for(int i = len-1; i >= 0; i--){
			int cur = (num[i] - '0') + over;
			if(i == len - 1)
				cur++;
			if(cur >= 10){
				if(i == 0){
					return false;
				}
				over = 1;
				num[i] = (char)('0' + (cur-10));
			}else{
				num[i] = (char)('0'+cur);
				break;
			}
		}
		return true;
	}
	
	public static void printNum(char[] num){
		boolean begin0 = false;
		for(char c : num){
			if(c != '0')
				begin0 = true;
			if(begin0)
				System.out.print(c);
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
//		print1Tomax(4);
		print1Tomax_q(2);
	}
}
