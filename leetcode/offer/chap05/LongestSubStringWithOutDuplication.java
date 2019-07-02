package chap05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithOutDuplication {
	
	public static int solution1(String str){
		if(null == str || str.length() <= 0) return 0;
		int ans = 0;
		for(int i = 0; i<str.length(); i++){
			for(int j = i + 1; j <= str.length(); j++){
				if(unique(str, i, j)) ans = Math.max(ans, j - i);
			}
		}
		return ans;
	}
	
	public static boolean unique(String str, int i , int j){
		Set<Character> set = new HashSet<>();
		for(int s = i; s < j; s++){
			Character c = str.charAt(s);
			if(set.contains(c)) return false;
			set.add(c);
		}
		return false;
	}
	
	public static int solution2_slibingwin(String str){
		if(null == str || str.length() <= 0) return 0;
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0, n = str.length();
		while(i < n && j < n){
			if(!set.contains(str.charAt(j))){
				set.add(str.charAt(j++));
				ans = Math.max(ans, j - i);
			}else{
				set.remove(str.charAt(i++));
			}
		}
		return ans;
	}
	
	public static int solution2_slibingwin_you(String str){
		if(null == str || str.length() <= 0) return 0;
		int n = str.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int j = 0, i = 0; j<n; j++){
			if(map.containsKey(str.charAt(j))){
				i = Math.max(map.get(str.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(str.charAt(j), j+1);
		}
		return ans;
	}
	
	public static int longestSubStr(String str){
		if(null == str || str.length() <= 0) return 0;
		int ans = 0;
		int[] index = new int[128];
		for(int i = 0, j = 0; i<str.length(); i++){
			j = Math.max(index[str.charAt(i)], j);
			ans = Math.max(ans, i - j + 1);
			index[str.charAt(i)] = i + 1; 
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String str = "arabcacfr";
		int res = longestSubStr(str);
		System.out.println(res);
	}
}
