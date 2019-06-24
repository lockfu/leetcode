package string;

import org.junit.Test;

public class LongestPalindrome {
	
	@Test
	public void test(){
		String s = "abba";
		String res = longestPalindrome2(s);
		System.out.println(res);
	}
	public String longestPalindrome2(String s) {
		if(s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for(int i = 0; i<s.length(); i++){
			int len1 = expandAroundCenter(s,i,i);
			int len2 = expandAroundCenter(s,i,i+1);
			int len = Math.max(len1, len2);
			if(len > end - start){
				start = i - (len-1)/2;
				end = i + len/2;
			}
		}
		return s.substring(start,end+1);
	}
	public int expandAroundCenter(String s, int left, int right){
		int l = left, r = right;
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
			l--;
			r++;
		}
		return r-l-1;
	}
	
	
	public String longestPalindrome1(String s) {
		if(s.length() == 1 || "".equals(s))
			return s;
		String ans = "";
		for(int i = 0; i<s.length()-1; i++){
			for(int j = s.length(); j>i; j--){
				String tmp = s.substring(i, j);
				System.out.println("tmp: " + tmp);
				if(isPalindrome(tmp)){
					if(tmp.length() > ans.length())
						ans = tmp;
					break;
				}
			}
		}
		return ans;
	}
	public String longestPalindrome(String s) {
		if(s.length() == 1 || "".equals(s))
			return s;
		String ans = "";
		for(int i = 0; i<s.length()-1; i++){
			for(int j = i+1; j<=s.length(); j++){
				String tmp = s.substring(i, j);
				System.out.println("tmp: " + tmp);
				if(isPalindrome(tmp)){
					if(tmp.length() > ans.length())
						ans = tmp;
				}
			}
		}
		return ans;
	}
	
	public boolean isPalindrome(String s){
		if("" == s || s.length() == 0 || s.length() == 1)
			return true;
		s = s.toLowerCase();
		char[] c = s.toCharArray();
		int l = 0, h = c.length-1;
		while(l<=h){
			char cl = c[l];
			char cr = c[h];
			if(cl == cr){
				l++;
				h--;
			}else{
				return false;
			}
		}
		return true;
	}
}
