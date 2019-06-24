package arrayandstring2;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
	public String minWindow(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return "";
		Map<Character, Integer> tcs = new HashMap<>();
		for(int i = 0; i<t.length(); i++){
			char c = t.charAt(i);
			if(tcs.containsKey(c))
				tcs.put(c, tcs.get(c)+1);
			else
				tcs.put(c, 1);
		}
		
		int required = tcs.size(), l = 0, r = 0;
		int formed = 0;
		Map<Character, Integer> windowCounts = new HashMap<>();
		int[] ans = {-1, 0, 0};
		
		
		while(r < s.length()){
			char c = s.charAt(r);
			if(windowCounts.containsKey(c))
				windowCounts.put(c, tcs.get(c)+1);
			else
				windowCounts.put(c, 1);
			if(tcs.containsKey(c) && windowCounts.get(c).intValue() == tcs.get(c).intValue())
				formed++;
			
			while(l <= r && formed == required){
				c = s.charAt(l);
				if(ans[0] == -1 || r-l+1 < ans[0]){
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}
				windowCounts.put(c, windowCounts.get(c)-1);
				if(tcs.containsKey(c) && windowCounts.get(c).intValue() < tcs.get(c).intValue())
					formed--;
				l++;
			}
			r++;
		}
		
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
	}
	
	
	public String minWindow1(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return "";
		int[] tcs = new int[256];
		for(int i = 0; i<t.length(); i++){
			char c = t.charAt(i);
			tcs[c]++;
		}
		int required = t.length(), l = 0, r = 0;
		int formed = 0;
		Map<Character, Integer> windowCounts = new HashMap<>();
		int[] ans = {-1, 0, 0};
		
		
		while(r < s.length()){
			char c = s.charAt(r);
			if(windowCounts.containsKey(c))
				windowCounts.put(c, windowCounts.get(c)+1);
			else
				windowCounts.put(c, 1);
			if(tcs[c] != 0 && windowCounts.get(c).intValue() == tcs[c])
				formed++;
			
			while(l <= r && formed == required){
				c = s.charAt(l);
				if(ans[0] == -1 || r-l+1 < ans[0]){
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}
				windowCounts.put(c, windowCounts.get(c)-1);
				if(tcs[c] != 0 && windowCounts.get(c).intValue() < tcs[c])
					formed--;
				l++;
			}
			r++;
		}
		
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
	}
	public String minWindow2(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return "";
		int[] map = new int[256];
		char[] chs = s.toCharArray();
		char[] cht = t.toCharArray();
		for(char c : cht){
			map[c]++;
		}
		
		int counter = t.length(), minLen = Integer.MAX_VALUE, startIndex = 0;
		
		int j = 0;
		for(int i = 0; i<s.length(); i++){
			while(j<s.length() && counter > 0){
				if(map[chs[j++]]-- > 0)
					counter--;
			}
			if(counter == 0 && j - i < minLen){
				minLen = j - i;
				startIndex = i;
			}
			if(map[chs[i]]++ == 0)
				counter++;
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+minLen);
	}
}
