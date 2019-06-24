package top100;

import java.util.ArrayList;
import java.util.List;

public class LongestSubStringWithK {
	public  int max = 0;
	public int longestSubstring(String s, int k) {
		if(null == s || s.length() < k ) return 0;
		int[] cs = new int[26];
		for(char c : s.toCharArray()){
			cs[c-'a']++;
		}
		boolean flag = false;
		int index = 0;
		for(int i = 0; i<cs.length; i++){
			if(cs[i] != 0 && cs[i] < k){
				flag = true;
				index = i;
				break;
			}
		}
		if(flag){
			String re = ((char)(index+'a'))+"";
			String[] ss = s.split(re);
			for(String item : ss){
				if(item.length() >= k){
					max = Math.max(max, longestSubstring(item, k));
				}
			}
		}else{
			return s.length();
		}
		return max;
	}
	 public int longestSubstring2(String s, int k) {
	        if (s == null || s.length() == 0) return 0;
	        char[] chars = new char[26];
	        // record the frequency of each character
	        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
	        boolean flag = true;
	        for (int i = 0; i < chars.length; i += 1) {
	            if (chars[i] < k && chars[i] > 0) flag = false;
	        }
	        // return the length of string if this string is a valid string
	        if (flag == true) return s.length();
	        int result = 0;
	        int start = 0, cur = 0;
	        // otherwise we use all the infrequent elements as splits
	        while (cur < s.length()) {
	            if (chars[s.charAt(cur) - 'a'] < k) {
	                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
	                start = cur + 1;
	            }
	            cur++;
	        }
	        result = Math.max(result, longestSubstring(s.substring(start), k));
	        return result;
	    }
	
	public static void main(String[] args) {
		String s = "weitong";
		int k = 2;
		int res = new LongestSubStringWithK().longestSubstring(s, k);
		System.out.println(res);
	}
}
