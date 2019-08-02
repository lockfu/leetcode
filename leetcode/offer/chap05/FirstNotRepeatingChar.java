package chap05;


public class FirstNotRepeatingChar {
	public static char firstNotReChar(String str){
		if(null == str || str.length() <= 0) return '0';
		int[] ht = new int[256];
		for(char c : str.toCharArray()){
			ht[c]++;
		}
		for(char c : str.toCharArray()){
			if(ht[c] == 1) 
				return c;
		}
		return '0';
	}
	
	public static void main(String[] args) {
		String str = "abaccdeffbnde";
		char c = firstNotReChar(str);
	}
}
