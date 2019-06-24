package string;


public class FirstUniqChar {
	public static int firstUniqChar(String s){
		if(s == null || s.length() == 0)
			return -1;
		if(s.length() == 1)
			return 0;
		for(int i = 0; i<s.length(); i++){
			String str = s.charAt(i)+"";
			if(s.indexOf(str) == s.lastIndexOf(str))
				return i;
		}
		return -1;
	}
	public static int firstUniqChar1(String s){
		int res = s.length();
		int idx = 0;
		for(char c = 'a'; c<='z'; c++){
			idx = s.indexOf(c);
			if(idx != -1 && idx == s.lastIndexOf(c))
				res = Math.min(idx, res);
		}
		return res == s.length() ? -1 : res;
	}
	public static int firstUniqChar2(String s){
		int[] count = new int[26];
		for(char c : s.toCharArray()) count[c - 'a']++;
		for(int i = 0; i<s.length(); i++){
			if(count[s.charAt(i)-'a'] == 1) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		int i = FirstUniqChar.firstUniqChar("cc");
		System.out.println(i);
	}
}
