package chap06;

public class ReverseSentenceLeft {
	public static String reverseSenLeft(String str, int n){
		if(null == str || str.length() <= 0 || n <= 0 || n > str.length()) return str;
		char[] cs = str.toCharArray();
		reverse(cs, 0, n-1);
		reverse(cs, 0, str.length()-1);
		reverse(cs, 0, str.length() - n - 1);
		String res = new String(cs);
		System.out.println(res);
		return res;
	}
	
	public static void reverse(char[] cs, int left, int right){
		while(left < right){
			char tmp = cs[left];
			cs[left] = cs[right];
			cs[right] = tmp;
			left++; right--;
		}
	}
	
	public static void main(String[] args) {
		String str = "abcdefg";
		reverseSenLeft(str, 2);
	}
}
